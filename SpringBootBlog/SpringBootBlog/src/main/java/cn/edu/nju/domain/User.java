package cn.edu.nju.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Thpffcj on 2017/10/22.
 * User 实体
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 自增长策略
    private long id; // 用户的唯一标识
    private String name;
    private int age;

    // JPA 的规范要求无参构造函数；设为 protected 防止直接使用
    protected User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, name='%s', age='%d']",
                id, name, age);
    }
}
