package cn.edu.nju.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 消息转换器
 * Created by thpffcj on 2019/8/25.
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {

        converters.clear();
        // 将Java对象转换为JSON对象
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
