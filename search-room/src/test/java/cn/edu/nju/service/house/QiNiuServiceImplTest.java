package cn.edu.nju.service.house;

import cn.edu.nju.ApplicationTests;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Thpffcj on 2018/1/28.
 */
public class QiNiuServiceImplTest extends ApplicationTests {

    @Autowired
    IQiNiuService qiNiuService;

    @Test
    public void uploadFile() {
        String fileName = "E:/image/github.jpg";
        File file = new File(fileName);

        Assert.assertTrue(file.exists());
        try {
            Response response = qiNiuService.uploadFile(file);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void delete() {
        String key = "Fh30NjHWGnVv4AgVtBZYdepGXelB";
        try {
            Response response = qiNiuService.delete(key);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
}