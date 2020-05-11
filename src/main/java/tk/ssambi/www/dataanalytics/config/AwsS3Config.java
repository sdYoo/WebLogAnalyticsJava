package tk.ssambi.www.dataanalytics.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsS3Config {

    @Bean
    public AmazonS3 connectS3Bucket() {

        System.out.println("Start to AmazonS3ClientBuilder()!");

        return AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://192.168.70.128:4572", "ap-northeast-2"))
                //.withRegion(Regions.AP_NORTHEAST_2)
                .build();
    }

    @Bean
    public AmazonS3 createS3Bucket() {

        System.out.println("Start to AmazonS3ClientBuilder()!");

        return AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://192.168.70.128:4572", "ap-northeast-2"))
                //.withRegion(Regions.AP_NORTHEAST_2)
                .build();
    }
}