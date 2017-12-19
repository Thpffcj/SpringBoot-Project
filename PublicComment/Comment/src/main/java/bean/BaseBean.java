package bean;

/**
 * Created by Thpffcj on 2017/8/30.
 */
public class BaseBean {

    private Page page;

    public BaseBean() {
        this.page = new Page();
    }

    public Page getPage() {
        return page;
    }
    public void setPage(Page page) {
        this.page = page;
    }
}