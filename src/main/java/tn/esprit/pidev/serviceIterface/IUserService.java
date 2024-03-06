package tn.esprit.pidev.serviceIterface;

import tn.esprit.pidev.Dto.LoginDTO;
import tn.esprit.pidev.Dto.UserDTO;
import tn.esprit.pidev.response.LoginResponse;

public interface IUserService {
    String addUser(UserDTO  userDTO);
    LoginResponse login(LoginDTO loginDTO);
}
