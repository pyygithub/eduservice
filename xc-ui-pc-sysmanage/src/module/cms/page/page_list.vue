<template>
  <div>
      <!-- 面包屑导航  -->
      <el-col :span="24" class="breadcrumb-container" style="margin-bottom:15px">
        <el-breadcrumb separator="/" >
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>{{$route.meta.parentName}}</el-breadcrumb-item>
          <el-breadcrumb-item>{{$route.name}}</el-breadcrumb-item>
        </el-breadcrumb>
      </el-col>
      <!--查询表单-->
      <el-form :model="params" style="margin-bottom: 15px;">
        <!--添加页面-->
        <el-button  type="primary" icon="el-icon-plus" @click="add('addPage')">添加</el-button>
        <add-page ref="addPage" v-if="addPageVisible" @query="query" :visible.sync="addPageVisible"></add-page>

        <!--修改页面-->
        <edit-page ref="editPage" v-if="editPageVisible" @query="query" :pageUpdateId="pageUpdateId" :visible.sync="editPageVisible"></edit-page>

        <!-- 查询条件-->
        <el-select v-model="params.siteId" placeholder="请选择站点">
          <el-option
            v-for="item in siteList"
            :key="item.siteId"
            :label="item.siteName"
            :value="item.siteId">
          </el-option>
        </el-select>
        <el-input v-model="params.pageAliase"  placeholder="请输入页面别名" style="width: 200px"></el-input>
        <el-button type="primary" v-on:click="query" icon="el-icon-search">查询</el-button>
      </el-form>

      <!--列表-->
      <el-table :data="list" highlight-current-row v-loading="listLoading" style="width: 100%;">
        <el-table-column type="index" width="60">
        </el-table-column>
        <el-table-column prop="pageName" label="页面名称" >
        </el-table-column>
        <el-table-column prop="pageAliase" label="别名" >
        </el-table-column>
        <el-table-column prop="pageType" label="类型（静态、动态）" width="170" :formatter="formatStatus">
        </el-table-column>
        <el-table-column prop="pageWebPath" label="访问路径" >
        </el-table-column>
        <el-table-column prop="pagePhysicalPath" label="物理路径">
        </el-table-column>
        <el-table-column prop="pageCreateTime" label="创建时间" :formatter="formatCreatetime">
        </el-table-column>
        <el-table-column label="操作" width="240">
          <template slot-scope="scope">
            <el-button type="primary"
                       size="small"
                       icon="el-icon-edit"
                       @click="edit(scope.row.pageId)">
            </el-button>

            <el-button size="small"
                       icon="el-icon-delete"
                       type="danger"
                       @click="del(scope.$index, scope.row)">
            </el-button>

            <el-button size="small"
                       icon="el-icon-share"
                       type="primary"
                       @click="preview(scope.$index, scope.row)">预览
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    <!--分页-->
    <el-col :span="24" class="toolbar">

      <el-pagination background layout="total, prev, pager, next" @current-change="changePage" :page-size="this.pager.size"
                     :total="total" :current-page="this.pager.page"
                     style="float:left;">
      </el-pagination>
    </el-col>
  </div>
</template>
<script>
  import * as cmsApi from '../api/cms'
  import utilApi from '@/common/utils';
  import pageAdd from '@/module/cms/page/page_add.vue'
  import pageEdit from '@/module/cms/page/page_edit.vue'
  let url = "http://manage.leyou.com"

  export default{
    data(){
      return {
        pager: {
          page:1,//页码
          size:8,//每页显示个数
        },
        params:{
          siteId:'',//站点id
          pageAliase: ''
        },
        listLoading:false,
        list:[],
        total:0,

        siteList:[],//站点列表,
        addPageVisible: false,
        editPageVisible: false,
        pageUpdateId: '',
      }
    },
    components: {
      'add-page': pageAdd,
      'edit-page': pageEdit
    },
    methods:{
      formatCreatetime(row, column){
        var createTime = new Date(row.pageCreateTime);
        if (createTime) {
          return utilApi.formatDate(createTime, 'yyyy-MM-dd hh:mm:ss');
        }
      },
      formatStatus(row, column) {
        var pageType = row.pageType;
        if (pageType == '1') {
          return "静态";
        } else  if (pageType == '0') {
          return "动态";
        }
      },
      // 添加页面
      add(refForm){
        if(this.$refs[refForm]){
          //this.$refs[refForm].initForm();
        }
        this.addPageVisible= true;
      },
      //页面预览
      preview(pageId){
        window.open(url + "/cms/preview/"+pageId)
      },
      //发布
      postPage (id) {
        this.$confirm('确认发布该页面吗?', '提示', {
        }).then(() => {
          this.listLoading = true;
          cmsApi.page_postPage(id).then((res) => {
            if(res.success){
              console.log('发布页面id='+id);
              this.listLoading = false;
              this.$message.success('发布成功，请稍后查看结果');
            }else{
              this.$message.error('发布失败');
            }
          });
        }).catch(() => {

        });
      },
      //修改页面
      edit(pageId){
        this.editPageVisible= true;
        this.pageUpdateId = pageId;
      },
      //删除
      del (index, row) {
        this.$confirm('确认删除该记录吗?', '提示', {
          type: 'warning'
        }).then(() => {
          this.listLoading = true;
          let pageId = row.pageId;
          cmsApi.page_del(pageId).then((res) => {
            this.listLoading = false;
            if(res.success){
              this.$message.success("删除成功")
              this.query();
            }else{
              this.$message.error('删除失败');
            }

          });
        }).catch(() => {

        });
      },
      //分页
      changePage(page){
        this.pager.page = page;
        this.query()
      },
      //查询
      query(){
        cmsApi.page_list(this.pager.page,this.pager.size,this.params).then((res)=>{
          console.log(res)
          this.total = res.queryResult.total
          this.list = res.queryResult.list
        })
      }
    },
    created(){
        //存储 请求参数
      this.pager.page = Number.parseInt(this.$route.query.page||1);
      this.params.siteId = this.$route.query.siteId||'';
    },
    mounted() {
      //默认查询页面
      this.query()
      //初始化站点列表
      this.siteList = [
        {
          siteId:'5a751fab6abb5044e0d19ea1',
          siteName:'门户主站'
        },
        {
          siteId:'102',
          siteName:'测试站'
        }
      ]
    }
  }
</script>
<style scoped>

</style>
