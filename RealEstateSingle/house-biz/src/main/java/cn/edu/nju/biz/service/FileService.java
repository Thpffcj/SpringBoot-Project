package cn.edu.nju.biz.service;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

/**
 * Created by Thpffcj on 2018/5/2.
 */
@Service
public class FileService {

    @Value("${file.path:}")
    private String filePath;

    public List<String> getImgPaths(List<MultipartFile> files) {
        if (Strings.isNullOrEmpty(filePath)) {
            filePath = getResourcePath();
        }
        List<String> paths = Lists.newArrayList();
        files.forEach(file -> {
            File localFile = null;
            if (!file.isEmpty()) {
                try {
                    localFile = saveToLocal(file, filePath);
                    // 解决windows路径问题
                    String path = StringUtils.substringAfterLast(StringUtils.replace(
                            localFile.getAbsolutePath(), "\\", "/"), filePath);
//                    System.out.println("localFile.getAbsolutePath()" + localFile.getAbsolutePath());
//                    System.out.println("path" + path);
                    paths.add(path);
                } catch (IOException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        return paths;
    }

    public static String getResourcePath() {
        File file = new File(".");
        String absolutePath = file.getAbsolutePath();
        return absolutePath;
    }

    private File saveToLocal(MultipartFile file, String filePath2) throws IOException {
        File newFile = new File(filePath + "/" + Instant.now().getEpochSecond() + "/" + file.getOriginalFilename());
        if (!newFile.exists()) {
            newFile.getParentFile().mkdirs();
            newFile.createNewFile();
        }
        Files.write(file.getBytes(), newFile);
        return newFile;
    }
}
