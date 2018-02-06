package cn.edu.nju;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Thpffcj on 2018/2/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Value("${author}")
    private String author;

    @Test
    public void contextLoads() {
        assertEquals("thpffcj", author);
    }

}