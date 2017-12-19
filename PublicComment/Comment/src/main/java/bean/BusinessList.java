package bean;

import java.util.List;

/**
 * Created by Thpffcj on 2017/8/31.
 */
public class BusinessList {

    private boolean hasMore;

    private List<Business> data;

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<Business> getData() {
        return data;
    }

    public void setData(List<Business> data) {
        this.data = data;
    }
}
