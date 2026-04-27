package engComp.dynamometerApp_server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import engComp.dynamometerApp_server.entities.User;
import engComp.dynamometerApp_server.repositories.UserRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.Logger;

import java.util.logging.Logger;

@Service
public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository userRepository;

    //GET request methods
    public Optional<User> getUserById(int userId){
        logger.info("Getting the user by Id: " + userId);

        return userRepository.findById(userId);
    }

    public Optional<User> getUserByEmail(String email){
        logger.info("Getting the user by email: "+email);

        return userRepository.findByEmail(email);
    }

    //POST request methods
    public User createUser(String name, String username,int age, String email, String password,double peso, String genero){
        User user = new User();
        user.setName(name);
        user.setUserName(username);
        user.setAge(age);
        user.setEmail(email);
        user.setPassword(password);
        user.setPeso(peso);
        user.setGenero(genero);

        return userRepository.save(user);
    }
}
