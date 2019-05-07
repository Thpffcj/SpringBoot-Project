package cn.edu.nju.vo;

import cn.edu.nju.constant.FeedbackType;
import com.google.common.base.Enums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户评论
 * Created by thpffcj on 2019-05-07.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    // 用户 id
    private Long userId;

    // 评论类型
    private String type;

    // PassTemplate RowKey，如果是 app 类型的评论，则没有
    private String templateId;

    // 评论内容
    private String comment;

    public boolean validate() {

        FeedbackType feedbackType = Enums.getIfPresent(
                FeedbackType.class, this.type.toUpperCase()
        ).orNull();

        return !(null == feedbackType || null == comment);
    }
}
