package br.com.emsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"br.com.emsbackend.security"})
public class Main {
    public static void main(String[] args) {

        //SpringApplication.run(Main.class, args);

        try
        {
            SpringApplication.run(Main.class, args);
        }
        catch (Throwable throwable)
        {
            System.out.println(throwable.toString());
            throwable.printStackTrace();
        }
    }
}