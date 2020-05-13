package tk.ssambi.www.dataanalytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DataAnalyticsApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DataAnalyticsApplication.class, args);
        System.out.print("Hello World!");
    }
}
