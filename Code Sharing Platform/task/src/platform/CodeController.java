package platform;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class CodeController {

    private List<Code> codeList = new ArrayList<>();

    private Code getCodeById(int id) {
        return codeList.stream().filter(e -> e.getId() == id).findFirst().get();
    }

    private List<Code> getLastTen() {
        return codeList.stream().filter(e -> e.getId() >= Code.getMaxId() - 10).sorted().collect(Collectors.toList());
    }

    @GetMapping(path = "api/code/{id}")
    @ResponseBody
    public Code getApiCodeById(@PathVariable int id, HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");
        return getCodeById(id);
    }

    @GetMapping(path = "/code/{id}")
    public String getHtmlCodeById(@PathVariable int id, HttpServletResponse response) {
        response.addHeader("Content-Type", "text/html");
        return HtmlPages.getCodeHtml(getCodeById(id));
    }

    @PostMapping(path = "/api/code/new")
    public String addNewCodeApi(@RequestBody Map<String, String> code) {
        Code newCode = new Code(code.get("code"), LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        codeList.add(newCode);
        return String.format("{\"id\":\"%s\"}", newCode.getId());
    }

    @GetMapping(path = "/code/new")
    public String changeCode(HttpServletResponse response) {
        response.addHeader("Content-Type", "text/html");
        return HtmlPages.getAddNewCodeHtml();
    }

    @GetMapping(path = "api/code/latest")
    @ResponseBody
    public List<Code> getLastTenCodesApi(HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");
        return getLastTen();
    }

    @GetMapping(path = "/code/latest")
    public String getHtmlLatestCode(HttpServletResponse response) {
        response.addHeader("Content-Type", "text/html");
        List<Code> lastCode = getLastTen();
        StringBuilder codeBlock = new StringBuilder();
        for (Code code : lastCode) {
            codeBlock.append(HtmlPages.getFormHtmlForLatestCode(code));
        }
        return HtmlPages.getLatestCodeHtml(codeBlock.toString());
    }
}
