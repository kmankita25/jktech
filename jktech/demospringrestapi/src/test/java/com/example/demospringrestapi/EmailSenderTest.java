package com.example.demospringrestapi;

import com.example.demospringrestapi.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.tools.FileObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
public class EmailSenderTest {
    @Autowired
    private EmailService emailService;
    @Test
    void emailSendTest(){
        System.out.println("sending email test");
        emailService.sendEmail("vr5522ankita@gmail.com","Hi Govid","this is email sender app");
    }
    @Test
    void sendHtmlInEmail(){
        String html=""+"<h1 style='color:red'>hi learn code with durgesh</h1>"+"";
        emailService.sendEmailWithHtml("vr5522ankita@gmail.com","123",html);
    }

    @Test
    void sendFileInEmail(){
        emailService.sendEmailWithFile("vr5522ankita@gmail.com","Email send with file","this is email send app",new File("C:\\Users\\Ankita Verma\\Downloads\\RestApiSpringBoot-main\\demospringrestapi\\src\\main\\resources\\img.webp"));
    }

    @Test
    void sendInputStreamFileInEmail() throws FileNotFoundException {
        File file=new  File("C:\\Users\\Ankita Verma\\Downloads\\RestApiSpringBoot-main\\demospringrestapi\\src\\main\\resources\\img.webp");
        InputStream inputStream=new FileInputStream(file);
        emailService.sendInputStreamFileInEmail("vr5522ankita@gmail.com","Email send with file","this is email send app",inputStream);
    }

    //Receiveing email test
    @Test
    void getInbox(){
        emailService.getInboxMessages();

    }
}
