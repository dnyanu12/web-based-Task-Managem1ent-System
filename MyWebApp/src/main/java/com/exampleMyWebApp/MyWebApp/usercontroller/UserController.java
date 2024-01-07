package com.exampleMyWebApp.MyWebApp.usercontroller;

import com.exampleMyWebApp.MyWebApp.user.User;
import com.exampleMyWebApp.MyWebApp.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping("/addUser")
   public User postdetails(@RequestBody User user)
   {
      return service.saveDetail(user);
   }
   @GetMapping("/getUser")
   public List<User> getDetails()
   {
       return service.getAllDetails();
   }
   @PutMapping("/updateUser")
    public User updateUserDetails(@RequestBody User user)
   {
       return service.updateDetails(user);
   }
   @DeleteMapping("/deleteUser/{id}")
   public String deletefunction(@PathVariable int id)
   {
       return service.deletesUser(id);
   }

}