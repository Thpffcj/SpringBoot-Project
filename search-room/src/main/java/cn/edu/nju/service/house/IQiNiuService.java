package cn.edu.nju.service.house;

import java.io.File;
import java.io.InputStream;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

/**
 * Created by Thpffcj on 2018/1/28.
 * 七牛云服务
 */
public interface IQiNiuService {

    Response uploadFile(File file) throws QiniuException;

    Response uploadFile(InputStream inputStream) throws QiniuException;

    Response delete(String key) throws QiniuException;
}
