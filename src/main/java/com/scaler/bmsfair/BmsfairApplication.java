package com.scaler.bmsfair;

import com.scaler.bmsfair.models.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BmsfairApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmsfairApplication.class, args);

        //parking lot set is not required
        //spring will do it by using annotations

    }

}
