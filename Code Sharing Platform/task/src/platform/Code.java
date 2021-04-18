package platform;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public class Code implements Comparable<Code> {

    private String code;
    private LocalDateTime date;
    private final int id = maxId;
    private static int maxId = 1;

    public Code(String code, LocalDateTime date) {
        this.code = code;
        this.date = date;
        ++maxId;
    }

    @JsonIgnore
    public int getId() {
        return id;
    }

    public static int getMaxId() {
        return maxId;
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
                "id=" + id +
                ", code='" + code + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public int compareTo(Code code) {
        return Integer.compare(code.id, id);
    }
}
