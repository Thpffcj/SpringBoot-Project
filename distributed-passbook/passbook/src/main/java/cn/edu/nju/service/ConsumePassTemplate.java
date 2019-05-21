package cn.edu.nju.service;

import cn.edu.nju.constant.Constants;
import cn.edu.nju.vo.PassTemplate;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 消费 Kafka 中的 PassTemplate
 * Created by thpffcj on 2019-05-07.
 */
@Slf4j
@Component
public class ConsumePassTemplate {

    // pass 相关的 HBase 服务
    private final IHBasePassService passService;

    @Autowired
    public ConsumePassTemplate(IHBasePassService passService) {
        this.passService = passService;
    }

    @KafkaListener(topics = {Constants.TEMPLATE_TOPIC})
    public void receive(@Payload String passTemplate,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {

        log.info("Consumer Receive PassTemplate: {}", passTemplate);

        PassTemplate pt = null;

        try {
            pt = JSON.parseObject(passTemplate, PassTemplate.class);
        } catch (Exception ex) {
            log.error("Parse PassTemplate Error: {}", ex.getMessage());
        }

        log.info("DropPassTemplateToHBase: {}", passService.dropPassTemplateToHBase(pt));
    }
}
