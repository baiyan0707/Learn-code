package blog.baiyan.github.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bai
 * @Description
 * @Date 2020/7/16 1:02 PM
 * @github https://github.com/baiyan0707
 */
@RestController
public class SecurityController {

    @GetMapping("/hello")
    public String securityTest(){
        return "Hello Spring-Boot-Security";
    }
}
