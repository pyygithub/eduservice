package com.xuecheng.manage_cms_client.dao;

import com.thtf.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：pyy
 * Date：2019/7/1
 * Time：10:02
 * Version: v1.0
 * ========================
 */
public interface CmsPageRepository extends MongoRepository<CmsPage, String> {
}
