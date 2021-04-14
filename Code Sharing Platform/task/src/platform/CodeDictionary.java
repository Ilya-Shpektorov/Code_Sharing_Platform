package platform;

public enum CodeDictionary {

    CODE("public static void main(String[] args) {\n" +
            "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
            "}");

    CodeDictionary(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }
}
