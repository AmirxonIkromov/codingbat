package uz.pdp.codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.UserDTO;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserControllerImpl implements UserController{



    @Override
    public ApiResult add(UserDTO userDTO) {
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
        return null;
    }

    @Override
    public UserDTO get(String username) {
        return null;
    }

    @Override
    public ApiResult edit(String username, UserDTO userDTO) {
        return null;
    }

    @Override
    public ApiResult delete(String username) {
        return null;
    }
}
