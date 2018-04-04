package backend.controller;

import backend.entity.User;
import backend.entity.request.AddUserRequest;
import backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(path = "/users")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping(path="")
    public @ResponseBody boolean addNewUser(@RequestBody User user){

        if(user.getUsername().isEmpty()){
            return false;//"User Parameter is missing";
        }

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        userRepository.save(user);
        return true;
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody String deleteMessageById(@PathVariable(value="id") long id) {
        User user = new User();
        user = userRepository.findOne(id);

        if(user != null){
            userRepository.delete(user);
            return user.getGivenname() + " is deleted";
        }

        return "User cannot deleted!";
    }

    @PutMapping(path="/{id}")
    public @ResponseBody User updateUser (@PathVariable(value="id") long id, @RequestBody User updatedUser, Long user){
        User savedUser = userRepository.findOne(id);

        if (savedUser != null){
            savedUser.setAddress(updatedUser.getAddress());
            savedUser.setSurename(updatedUser.getSurename());
            savedUser.setGivenname(updatedUser.getGivenname());
            savedUser.setSquads(updatedUser.getSquads());
            userRepository.save(savedUser);
            return savedUser;
        } else {
            return null;
        }
    }

    @GetMapping(path="")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    User getParameterDetails (@PathVariable(value="id") long id) {
        return userRepository.findOne(id);
    }


}
