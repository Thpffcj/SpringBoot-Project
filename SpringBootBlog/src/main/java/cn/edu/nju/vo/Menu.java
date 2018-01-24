package cn.edu.nju.vo;

import java.io.Serializable;

/**
 * Created by Thpffcj on 2017/10/26.
 * 菜单值对象.
 */
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String url;

    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
