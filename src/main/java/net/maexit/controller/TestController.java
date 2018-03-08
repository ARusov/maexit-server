package net.maexit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by arusov on 08.03.2018.
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    String test() {
        return "Hello World from Maexit!";
    }
}
