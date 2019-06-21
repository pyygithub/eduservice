package com.xuecheng.api.cms;

import com.thtf.framework.domain.cms.CmsPage;
import com.thtf.framework.domain.cms.request.QueryPageRequest;
import com.thtf.framework.domain.cms.response.CmsPageResult;
import com.thtf.framework.model.response.QueryResponseResult;
import com.thtf.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：pyy
 * Date：2019/6/4
 * Time：8:43
 * Version: v1.0
 * ========================
 */
@Api(value="cms页面管理接口",description = "cms页面管理接口，提供页面的增、删、改、查")
public interface CmsPageControllerApi {

    @ApiOperation("分页查询页面列表")
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) ;

    @ApiOperation("添加页面")
    public CmsPageResult add(CmsPage cmsPage);

    @ApiOperation("通过ID查询页面")
    public CmsPageResult findById(String id);

    @ApiOperation("修改页面")
    public CmsPageResult edit(String id,CmsPage cmsPage);

    @ApiOperation("通过ID删除页面")
    public ResponseResult delete(String id);
}
