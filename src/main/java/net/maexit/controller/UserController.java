package net.maexit.controller;

import net.maexit.entity.User;
import net.maexit.exceptions.UserException;
import net.maexit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by arusov on 08.03.2018.
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{email}")
    @ResponseBody
    User findByEmail(@PathVariable ("email") String email) {
        return userService.findByEmail(email);
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    User insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    User login(@RequestBody User user) {
        return userService.insert(user);
    }


    @ExceptionHandler({UserException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
