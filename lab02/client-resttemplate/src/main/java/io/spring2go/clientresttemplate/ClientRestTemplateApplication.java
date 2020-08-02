package io.spring2go.clientresttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
public class ClientRestTemplateApplication implements ServletContextInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ClientRestTemplateApplication.class, args);
    }

    @Override
    public void onStartup(ServletContext context) throws ServletException {
        // 重命名 session 名字，这样不容易与其他 session 名重复
        context.getSessionCookieConfig().setName("client-session");
    }

}
