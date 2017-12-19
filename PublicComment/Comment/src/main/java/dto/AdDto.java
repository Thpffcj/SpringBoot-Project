package dto;

import bean.Ad;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Thpffcj on 2017/9/2.
 */
public class AdDto extends Ad {

    private String img;

    private MultipartFile imgFile;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }
}
