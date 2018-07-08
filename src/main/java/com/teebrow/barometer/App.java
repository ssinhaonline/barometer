package com.teebrow.barometer;

/**
 * Created by dsinha003c
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class App 
{
    static {
        String homeDir = System.getProperty("HOME_DIR");
        if(StringUtils.isEmpty(homeDir)) {
            System.setProperty("HOME_DIR", ".");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
