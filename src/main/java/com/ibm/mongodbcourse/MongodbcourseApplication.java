package com.ibm.mongodbcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbcourseApplication {

    public static void main(String[] args) {
        System.out.println("INÍCIO!");
        SpringApplication.run(MongodbcourseApplication.class, args);
        System.out.println("FIM!");
    }

}
