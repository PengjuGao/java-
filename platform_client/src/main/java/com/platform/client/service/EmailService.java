package com.platform.client.service;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by gaopengju on 2016/12/28.
 * 发送邮件service
 */
@Service
public class EmailService {

    @Autowired
    JavaMailSender mailSender;
    private static final String mailFrom = "javacoder_top@163.com";
    private static final String subject = "www.javacoder.top";
    /**
     * 发送文本
     * @param to
     * @param text
     */
    public void sendTextMail(String to,String text){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(mailFrom);
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setSentDate(new Date());// 邮件发送时间
        mail.setText("您的验证码是： "+text);
        mailSender.send(mail);
    }

    /**
     * 发送html
     * @param to
     * @param html
     * @throws Exception
     */
    public void sendHtmlMail(String to,String html) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 设置utf-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        messageHelper.setFrom(mailFrom);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(html, true);
        mailSender.send(mimeMessage);
    }

    /**
     * 发送文件
     * @param to
     * @param html
     * @param contentId
     * @param resource
     * @throws Exception
     */
    public void sendFileMail(String to,String html,String contentId,Resource resource) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 设置utf-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        messageHelper.setFrom(mailFrom);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(html, true);
        //FileSystemResource img = new FileSystemResource(new File("c:/350.jpg"));
        messageHelper.addInline(contentId, resource);
        // 发送
        mailSender.send(mimeMessage);
    }


}
