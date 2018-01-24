package cn.edu.nju.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Thpffcj on 2017/10/23.
 */
@Document(indexName = "blog", type = "blog")
public class Blog implements Serializable {

    @Id
    private String id;
    private String title;
    private String summary;
    private String content;

    protected Blog() {
    }

    public Blog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, title='%s', content='%s']",
                id, title, content);
    }
}
