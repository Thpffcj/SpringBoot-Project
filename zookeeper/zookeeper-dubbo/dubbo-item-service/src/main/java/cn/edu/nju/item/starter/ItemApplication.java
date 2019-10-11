package cn.edu.nju.item.starter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Thpffcj on 2018/4/29.
 */
public class ItemApplication {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:spring/spring-context.xml"});
        context.start();
        // press any key to exit
        System.in.read();
    }
}
