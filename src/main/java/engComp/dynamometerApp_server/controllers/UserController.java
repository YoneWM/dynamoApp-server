package engComp.dynamometerApp_server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import engComp.dynamometerApp_server.entities.User;
import engComp.dynamometerApp_server.services.UserService;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> getUserByEmail(@RequestParam String email){
        logger.info("Getting user by email: "+ email);
        Optional<User> userOptional = userService.getUserByEmail(email);

        if(userOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else{
            return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String email, @RequestParam String password){
        logger.info("User login");

        //user with said email exists?
        Optional<User> userOptional = userService.getUserByEmail(email);

        if(userOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //password check
        if(!password.equals(userOptional.get().getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        logger.info("Creating New User");

        User newUser = userService.createUser(
                user.getName(),
                user.getUserName(),
                user.getAge(),
                user.getEmail(),
                user.getPassword(),
                user.getPeso(),
                user.getGenero()
        );

        return ResponseEntity.status(HttpStatus.OK).body(newUser);
    }
}
