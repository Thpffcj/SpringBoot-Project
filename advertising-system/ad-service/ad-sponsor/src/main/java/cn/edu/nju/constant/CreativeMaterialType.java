package cn.edu.nju.constant;

import lombok.Getter;

/**
 * 创意物料类型
 * Created by thpffcj on 2019/8/26.
 */
@Getter
public enum  CreativeMaterialType {

    JPG(1, "jpg"),
    BMP(2, "bmp"),

    MP4(3, "mp4"),
    AVI(4, "avi"),

    TXT(5, "txt");

    private int type;
    private String desc;

    CreativeMaterialType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
