package com.zp.service.impl;

import com.zp.service.MailService;
import com.zp.vo.MailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;

@Service
public class MailServiceImpl implements MailService {

    private Logger logger = LoggerFactory.getLogger(getClass()); //提供日志

    @Autowired
    private JavaMailSenderImpl mailSender; //注入邮件工具类

    @Override
    public MailVo sendMail(MailVo mailVo) {
        try {
            checkMail(mailVo);//检测邮件
            return null;
        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public void checkMail(MailVo mailVo) {
        if (StringUtils.isEmpty(mailVo.getTo())) {
            throw new RuntimeException("邮件收信人不能为空");
        }
        if (StringUtils.isEmpty(mailVo.getSubject())) {
            throw new RuntimeException("邮件主题不能为空");
        }
        if (StringUtils.isEmpty(mailVo.getText())) {
            throw new RuntimeException("邮件内容不能为空");
        }

    }

    @Override
    public void sendMimeMail(MailVo mailVo) {
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailSender.createMimeMessage(), true);//true表示支持复杂类型

            mailVo.setFrom(getMailSendFrom());//邮件发信人从配置项读取
            messageHelper.setFrom(mailVo.getFrom());//邮件发信人
            messageHelper.setTo(mailVo.getTo().split(","));//邮件收信人
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }

    @Override
    public MailVo saveMail(MailVo mailVo) {
        return null;
    }

    @Override
    public String getMailSendFrom() {
        return null;
    }
}
