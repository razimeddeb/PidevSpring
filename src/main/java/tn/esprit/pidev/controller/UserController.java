package tn.esprit.pidev.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pidev.Dto.LoginDTO;
import tn.esprit.pidev.Dto.UserDTO;

import tn.esprit.pidev.response.LoginResponse;
import tn.esprit.pidev.serviceIterface.IUserService;
import tn.esprit.pidev.serviceIterface.*;
@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
    IUserService iUserService;

    @PostMapping("/addUser")
    public String addAdmin(@RequestBody UserDTO userDTO ) {
        String id = iUserService.addUser(userDTO);
        return id ;
    }



    @PostMapping("/Login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {


        LoginResponse loginResponse = iUserService.login(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }


}
