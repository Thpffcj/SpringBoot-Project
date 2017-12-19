package dao;

import bean.Dic;

import java.util.List;

/**
 * Created by Thpffcj on 2017/9/25.
 */
public interface DicDao {
    List<Dic> select(Dic dic);
}
