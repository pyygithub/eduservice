package com.xuecheng.manage_cms_client.dao;

import com.thtf.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：pyy
 * Date：2019/7/1
 * Time：10:03
 * Version: v1.0
 * ========================
 */
public interface CmsSiteRepository extends MongoRepository<CmsSite, String> {
}
