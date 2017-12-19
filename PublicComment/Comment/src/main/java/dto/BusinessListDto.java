package dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thpffcj on 2017/9/26.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessListDto {

    private boolean hasMore;
    private List<BusinessDto> data;

    public BusinessListDto() {
        this.data = new ArrayList<>();
    }

    public boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<BusinessDto> getData() {
        return data;
    }

    public void setData(List<BusinessDto> data) {
        this.data = data;
    }
}
