package uz.pdp.codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.User;
import uz.pdp.codingbat.exception.InputDataExistsException;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SignDTO;
import uz.pdp.codingbat.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public ApiResult register(SignDTO signDTO) {
        if (userRepository.existsByUsername(signDTO.getUsername()))
            throw new InputDataExistsException("Bunday UserName mavjud!");
        userRepository.save(mapUserToUserDto(new User(), signDTO));
        return new ApiResult(true, "OK");
    }
    private User mapUserToUserDto(User user, SignDTO signDTO) {
        user.setUsername(signDTO.getUsername());
        user.setPassword(signDTO.getPassword());

        return user;
    }
}
