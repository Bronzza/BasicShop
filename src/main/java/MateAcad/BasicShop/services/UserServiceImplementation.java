package MateAcad.BasicShop.services;


import MateAcad.BasicShop.Entities.User;
import MateAcad.BasicShop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save((User)user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
