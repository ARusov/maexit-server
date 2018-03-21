package net.maexit.controller;

import net.maexit.entity.User;
import net.maexit.exceptions.UserException;
import net.maexit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public User findByEmail(@PathVariable("email") String email)
    {
        return userService.findByEmail(email);
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody User user) {
        User loginUser = userService.findByEmailAndPwd(user);
         if (loginUser==null){
             throw new UserException("No user with provided email and password");
         }
        return loginUser;
    }

    @ExceptionHandler({UserException.class})
    public void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    }

}
