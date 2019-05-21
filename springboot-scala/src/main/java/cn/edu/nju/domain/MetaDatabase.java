package cn.edu.nju.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 数据库元数据
 * Created by thpffcj on 2019-05-21.
 */
@Entity
@Table
public class MetaDatabase {

    // 数据集 id
    private Integer id;

    // 数据库名称
    private String name;

    // 数据库存放的文件系统地址
    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
