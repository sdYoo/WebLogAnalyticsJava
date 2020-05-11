package tk.ssambi.www.dataanalytics;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.ssambi.www.dataanalytics.config.AwsS3Config;

import java.io.IOException;

@SpringBootApplication
public class DataAnalyticsApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DataAnalyticsApplication.class, args);
        System.out.print("Hello World!");

        AwsS3Config awsS3Config = new AwsS3Config();
        AmazonS3 amazonS3 = awsS3Config.createS3Bucket();

        System.out.println(amazonS3.listBuckets());
    }
}
