package com.maciej.spring5didemo;

import com.maciej.spring5didemo.controllers.ConstructorInjectedController;
import com.maciej.spring5didemo.controllers.MyController;
import com.maciej.spring5didemo.controllers.PropertyInjectedController;
import com.maciej.spring5didemo.controllers.SetterInjectedController;
import com.maciej.spring5didemo.examplebeans.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring5diDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Spring5diDemoApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");

        FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUser());

    }
}
