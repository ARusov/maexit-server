package net.maexit.controller;

import net.maexit.entity.User;
import net.maexit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arusov on 08.03.2018.
 */
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
    @ResponseBody
    User insert(@ModelAttribute  User user) {
        return userService.insert(user);
    }
}
