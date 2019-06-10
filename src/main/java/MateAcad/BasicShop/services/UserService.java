package MateAcad.BasicShop.services;

import MateAcad.BasicShop.Entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    List<User> getAllUsers();

    User getByUserName(String username);

    void saveUser(User user);
}
