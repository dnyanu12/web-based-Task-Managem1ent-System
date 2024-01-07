package com.exampleMyWebApp.MyWebApp.userservice;

import com.exampleMyWebApp.MyWebApp.user.User;
import com.exampleMyWebApp.MyWebApp.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public User saveDetail(User user)
    {
        return  repo.save(user);
    }
    public  List<User> getAllDetails()
    {
        return repo.findAll();
    }
    public User updateDetails(User user)
    {
        User updateUser=repo.findById(user.getId()).orElse(null);
        if (updateUser!=null)
        {
            updateUser.setEmail(user.getEmail());
            updateUser.setPassword(user.getPassword());
            updateUser.setFirstName(user.getFirstName());
            updateUser.setLastName(user.getLastName());
            repo.save(updateUser);
            return updateUser;
        }
        return null;
    }
    public String deletesUser(int id)
    {
        repo.deleteById(id);
        return "deleted"+id;
    }

}