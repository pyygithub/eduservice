package com.xuecheng.manage_cms.web.controller;


import com.thtf.framework.domain.cms.CmsPage;
import com.thtf.framework.domain.cms.request.QueryPageRequest;
import com.thtf.framework.domain.cms.response.CmsPageResult;
import com.thtf.framework.exception.CustomException;
import com.thtf.framework.model.response.CommonCode;
import com.thtf.framework.model.response.QueryResponseResult;
import com.thtf.framework.model.response.ResponseResult;
import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.manage_cms.service.CmsPageService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：pyy
 * Date：2019/6/4
 * Time：14:21
 * Version: v1.0
 * ========================
 */
@RestController
@RequestMapping("/cms")
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    private CmsPageService cmsPageService;

    /**
     * 页面列表分页查询
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    @Override
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="query",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="query",dataType="int")
    })
    @GetMapping("/pages")
    public QueryResponseResult findList(@RequestParam("page") int page, @RequestParam("size") int size, QueryPageRequest queryPageRequest) {
        return cmsPageService.findList(page, size, queryPageRequest);
    }

    /**
     * 页面添加
     * @param cmsPage
     * @return
     */
    @Override
    @PostMapping("/page")
    public CmsPageResult add(@RequestBody CmsPage cmsPage) {
        return cmsPageService.add(cmsPage);
    }

    /**
     * 根据id查询页面信息
     * @param id
     * @return
     */
    @Override
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "页面ID",required=true,paramType="path",dataType="String"),
    })
    @GetMapping("/page/{id}")
    public CmsPageResult findById(@PathVariable("id") String id) {
        return cmsPageService.getById(id);
    }

    /**
     * 修改页面信息
     * @param id
     * @param cmsPage
     * @return
     */
    @Override
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "页面ID",required=true,paramType="path",dataType="String"),
    })
    @PutMapping("/page/{id}")//这里使用put方法，http 方法中put表示更新
    public CmsPageResult edit(@PathVariable("id") String id, @RequestBody CmsPage cmsPage) {
        return cmsPageService.update(id,cmsPage);
    }

    /**
     * 删除页面信息
     * @param id
     * @return
     */
    @Override
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "页面ID",required=true,paramType="path",dataType="String"),
    })
    @DeleteMapping("/page/{id}") //使用http的delete方法完成岗位操作
    public ResponseResult delete(@PathVariable("id") String id) {
        return cmsPageService.delete(id);
    }

}
