package uz.pdp.codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.User;
import uz.pdp.codingbat.exception.InputDataExistsException;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.UserDTO;
import uz.pdp.codingbat.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ApiResult add(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername()))
            throw new InputDataExistsException("Bunday UserName mavjud!");
        userRepository.save(mapUserToUserDto(new User(), userDTO));
        return new ApiResult(true, "OK");
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDTO(user.getUsername(),
                        user.getPassword()))
                .toList();
    }

    @Override
    public UserDTO get(Integer id) {
        Optional<User> byId = userRepository.findById(id);
        if (!byId.isPresent()) throw new InputDataExistsException("Bunday User Mavjud emas!");

        User user = byId.get();

        return new UserDTO(user.getUsername(), user.getPassword());
    }

    @Override
    public ApiResult edit(Integer id, UserDTO userDTO) {
        Optional<User> byId = userRepository.findById(id);
        if (!byId.isPresent()) throw new InputDataExistsException("Bunday User Mavjud emas!");

        userRepository.save(mapUserToUserDto(byId.get(), userDTO));

        return new ApiResult(true, "OK");
    }

    @Override
    public ApiResult delete(Integer id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) throw new InputDataExistsException("Bunday User Mavjud emas!");

        userRepository.delete(byId.get());
        return new ApiResult(true, "OK");
    }

    private User mapUserToUserDto(User user, UserDTO userDTO) {
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        return user;
    }
}
