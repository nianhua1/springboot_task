package com.teng.task;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {
	@Autowired
	JavaMailSender javaMailSender;

	@Test
	public void contextLoads() {
        //1、创建一个简单的消息邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("测试");
        message.setText("测试内容");
        message.setTo("XXXXX@qq.com");
        message.setFrom("XXXX@qq.com");
        javaMailSender.send(message);
	}

    @Test
    public void test2() throws  Exception{
        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("通知-今晚开会");
        helper.setText("<b style='color:red'>今天 7:30 开会</b>",true);

        helper.setTo("XXXXX@163.com");
        helper.setFrom("XXXXX@qq.com");

        //上传文件
        helper.addAttachment("1.jpg",new File("1.jpg"));
        helper.addAttachment("2.jpg",new File("2.jpg"));

        javaMailSender.send(mimeMessage);
    }
}
