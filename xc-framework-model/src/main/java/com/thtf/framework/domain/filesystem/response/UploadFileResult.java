package com.thtf.framework.domain.filesystem.response;

import com.thtf.framework.model.response.ResponseResult;
import com.thtf.framework.model.response.ResultCode;
import com.thtf.framework.domain.filesystem.FileSystem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * Created by admin on 2018/3/5.
 */
@Data
@ToString
public class UploadFileResult extends ResponseResult {
    @ApiModelProperty(value = "文件信息", example = "true", required = true)
    FileSystem fileSystem;
    public UploadFileResult(ResultCode resultCode, FileSystem fileSystem) {
        super(resultCode);
        this.fileSystem = fileSystem;
    }

}
