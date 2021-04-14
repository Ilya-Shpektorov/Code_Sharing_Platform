package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    private Code code = new Code(CodeDictionary.CODE.getCode(), LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

    @GetMapping(path = "/code")
    public String getHtmlCode(HttpServletResponse response) {
        response.addHeader("Content-Type", "text/html");
        return HtmlPages.getCodeHtml(code);
    }

    @GetMapping(path = "api/code")
    @ResponseBody
    public Code getApiCode(HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");
        return code;
    }

    @GetMapping(path = "/code/new")
    public String changeCode(HttpServletResponse response) {
        response.addHeader("Content-Type", "text/html");
        return HtmlPages.getAddNewCodeHtml();
    }

    @PostMapping(path = "/api/code/new")
    public String changeCodeApi(@RequestBody Map<String, String> code) {
        this.code.setCode(code.get("code"));
        this.code.setDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return "{}";
    }

}
