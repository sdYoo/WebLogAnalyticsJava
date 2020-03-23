package tk.ssambi.www.dataanalytics.controller;

import com.amazonaws.services.s3.AmazonS3;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.Charset;

@RestController
@RequiredArgsConstructor
public class WallController {

    public static final String BUCKET_WALL_CONTENT = "wall-bucket";

    private final AmazonS3 amazonS3;

    @GetMapping("/wall/{id}")
    public String get(@PathVariable String id) throws IOException {
        System.out.println("get() Method");
        System.out.println(amazonS3.getRegion());
        return String.join("", IOUtils.readLines(amazonS3.getObject(BUCKET_WALL_CONTENT, id).getObjectContent(), Charset.defaultCharset()));
    }

    @PostMapping("/wall/{id}")
    public String post(@PathVariable String id, @RequestBody PostRequest postRequest) {
        System.out.println("post() Method");
        return amazonS3.putObject(BUCKET_WALL_CONTENT, id, postRequest.getContent()).getContentMd5();
    }
}
