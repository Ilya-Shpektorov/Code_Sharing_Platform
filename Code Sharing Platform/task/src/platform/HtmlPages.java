package platform;

public class HtmlPages {

    public static String getCodeHtml(Code code) {
        return String.format("<html>\n" +
                "<head>\n" +
                "    <title>Code</title>\n" +
                "    <style>.code_element {\n" +
                "          background-color: lightgrey;\n" +
                "          width: fit-content;\n" +
                "          border: 1px solid;\n" +
                "          margin-top: 10px;\n" +
                "          padding: 10px;\n" +
                "              }</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<span id = \"load_date\"> %s </span>\n" +
                "    <div class = \"code_element\">\n" +
                "    <pre id = \"code_snippet\">\n" +
                "%s</pre>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>", code.getDate(), code.getCode());
    }

    public static String getAddNewCodeHtml() {
        return "<html>\n" +
                "<head>\n" +
                "    <title>Create</title>\n" +
                "    <style>\n" +
                "    textarea {\n" +
                "       width: 100%;\n" +
                "       height: 150px;\n" +
                "       padding: 12px 20px;\n" +
                "       box-sizing: border-box;\n" +
                "       border: 2px solid #ccc;\n" +
                "       border-radius: 4px;\n" +
                "       background-color: #f8f8f8;\n" +
                "       resize: none;\n" +
                "       }\n" +
                "    </style>\n" +
                "    <script>\n" +
                "    function send() {\n" +
                "       let object = {\n" +
                "           \"code\": document.getElementById(\"code_snippet\").value\n" +
                "       };\n" +
                "        \n" +
                "       let json = JSON.stringify(object);\n" +
                "       \n" +
                "       let xhr = new XMLHttpRequest();\n" +
                "        xhr.open(\"POST\", '/api/code/new', false)\n" +
                "       xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');\n" +
                "       xhr.send(json);\n" +
                "       \n" +
                "        if (xhr.status == 200) {\n" +
                "         alert(\"Success!\");\n" +
                "       }\n" +
                "   }\n" +
                "    </script>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class> " +
                "   <form>\n" +
                "       <p><textarea id=\"code_snippet\">// write your code here</textarea></p>\n" +
                "       <button id=\"send_snippet\" type=\"submit\" onclick=\"send()\">Submit</button>\n" +
                "   </form>" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
    }
}
