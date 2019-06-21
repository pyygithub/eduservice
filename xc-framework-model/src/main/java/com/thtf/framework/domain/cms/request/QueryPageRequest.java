package com.thtf.framework.domain.cms.request;

import com.thtf.framework.model.request.RequestData;
import lombok.Data;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：pyy
 * Date：2019/6/4
 * Time：8:38
 * Version: v1.0
 * ========================
 */
@Data
public class QueryPageRequest extends RequestData {
    //站点id
    private String siteId;
    //页面ID
    private String pageId;
    //页面名称
    private String pageName;
    //别名
    private String pageAliase;
    //模版id
    private String templateId;
}
