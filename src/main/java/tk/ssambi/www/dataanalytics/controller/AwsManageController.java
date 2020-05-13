package tk.ssambi.www.dataanalytics.controller;

import com.amazonaws.services.s3.AmazonS3;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tk.ssambi.www.dataanalytics.dto.PostRequest;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AwsManageController {
    public static final String BUCKET_WALL_CONTENT = "test-bucket";

    private final AmazonS3 amazonS3;

    @GetMapping("/start")
    public String startInitS3() throws IOException {
        System.out.println(amazonS3.getS3AccountOwner());
        System.out.println(amazonS3.listBuckets());

        try{
            amazonS3.createBucket("sdtest01");
        }catch(Exception e){
            System.out.println("Exception: "+e.getMessage());
        }

        //return String.join("", IOUtils.readLines(amazonS3.getObject(BUCKET_WALL_CONTENT, id).getObjectContent(), Charset.defaultCharset()));
        return "Create Bucket()!!";
    }

    @PostMapping("/wall/{id}")
    public String post(@PathVariable String id, @RequestBody PostRequest postRequest) {
        System.out.println("post() Method");
        return amazonS3.putObject(BUCKET_WALL_CONTENT, id, postRequest.getContent()).getContentMd5();
    }
}
