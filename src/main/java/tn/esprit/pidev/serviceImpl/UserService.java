package tn.esprit.pidev.serviceImpl;

import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.Dto.LoginDTO;
import tn.esprit.pidev.Dto.UserDTO;
import tn.esprit.pidev.entity.User;
import tn.esprit.pidev.repository.UserRepository;
import tn.esprit.pidev.response.LoginResponse;
import tn.esprit.pidev.serviceIterface.IUserService;
@Service
@Table(name="User")
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder ;


    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(); // Initialize the user variable

        user.setIdUser(userDTO.getIdUser());
        user.setUserName(userDTO.getUserName());
        user.setRole(userDTO.getRole());
        user.setAddress(userDTO.getAddress());
        user.setMail(userDTO.getMail());
        user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));

        userRepository.save(user);
        return user.getUserName();
    }

    @Override
    public LoginResponse login(LoginDTO loginDTO) {
        try {
            User user = userRepository.findByEmail(loginDTO.getEmail());
            if (user != null) {
                String password = loginDTO.getPassword();
                String encodedPassword = user.getPassword();
                Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
                if (isPwdRight) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Password Not Match", false);
                }
            } else {
                return new LoginResponse("Email does not exist", false);
            }
        } catch (Exception e) {
            return new LoginResponse("An error occurred during login", false);
        }
    }




}
