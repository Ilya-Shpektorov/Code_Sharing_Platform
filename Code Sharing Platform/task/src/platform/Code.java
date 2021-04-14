package platform;

import java.time.LocalDateTime;

public class Code {

    private String code;
    private LocalDateTime date;

    public Code (String code, LocalDateTime date){
        this.code = code;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Code{" +
                "code='" + code + '\'' +
                ", date=" + date +
                '}';
    }
}
