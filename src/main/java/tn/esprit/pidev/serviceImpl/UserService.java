package tn.esprit.pidev.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.entity.User;
import tn.esprit.pidev.repository.UserRepository;
import tn.esprit.pidev.serviceIterface.IUserService;
@Service
@AllArgsConstructor
public class UserService implements IUserService {
    UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
