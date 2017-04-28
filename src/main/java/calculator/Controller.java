package calculator;/*
 * Created by Michał Konieczny on 2017-04-28.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired Calculator calculator;

    @ResponseBody
    @GetMapping("/")
    public String form() {

        return "<form method=\"POST\" enctype=\"multipart/form-data\">" +
                "<div>input file: <input type=\"file\" name=\"in\" /></div>" +
                "<div>output file: <input type=\"file\" name=\"out\" /></div>" +
                "<div><input type=\"submit\" value=\"send\"/></div>" +
                "</form>";
    }

    @ResponseBody
    @PostMapping("/")
    public String result(@RequestParam("in") MultipartFile in, @RequestParam("out") MultipartFile out) throws Exception {

        return calculator.calculate(in, out);
    }
}
