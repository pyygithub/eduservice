package com.xuecheng.manage_cms.web.controller;

import com.thtf.framework.domain.cms.CmsConfig;
import com.xuecheng.api.cms.CmsConfigControllerApi;
import com.xuecheng.manage_cms.service.CmsConfigService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：pyy
 * Date：2019/6/24
 * Time：9:36
 * Version: v1.0
 * ========================
 */
@RestController
@RequestMapping("/cms/template")
public class CmsTemplateController implements CmsConfigControllerApi {


    @Override
    public CmsConfig getmodel(String id) {
        return null;
    }
}
