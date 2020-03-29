package com.ylf.demo.kafka.springAPI;


import com.ylf.demo.kafka.kafkaAPI.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: leifeng.ye
 * @date: 2020-01-20
 * @desc:
 */
@RestController
public class Producer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping("/send")
    @Transactional
    public String send(@RequestBody Student student){
        ListenableFuture res=kafkaTemplate.send("ylf","stu",student);
        return "success";
    }
}
