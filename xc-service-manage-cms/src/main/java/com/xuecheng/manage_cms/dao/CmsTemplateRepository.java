package com.xuecheng.manage_cms.dao;

import com.thtf.framework.domain.cms.CmsConfig;
import com.thtf.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：pyy
 * Date：2019/6/24
 * Time：9:33
 * Version: v1.0
 * ========================
 */
public interface CmsTemplateRepository extends MongoRepository<CmsTemplate, String> {
}
