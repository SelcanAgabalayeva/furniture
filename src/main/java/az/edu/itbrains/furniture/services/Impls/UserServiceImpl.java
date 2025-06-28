package az.edu.itbrains.furniture.services.Impls;

import az.edu.itbrains.furniture.dtos.RegisterDto;
import az.edu.itbrains.furniture.models.User;
import az.edu.itbrains.furniture.repositories.UserRepository;
import az.edu.itbrains.furniture.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public boolean registerUser(RegisterDto registerDto) {
        User findUser=userRepository.findByUsername(registerDto.getUsername());
        if(findUser !=null){
            return false;
        }

        User user=new User();

        user.setEmail(registerDto.getEmail());
        user.setUsername(registerDto.getUsername());


        String password=passwordEncoder.encode(registerDto.getPassword());
        user.setPassword(password);
        userRepository.save(user);
        return true;
    }

    @Override
    public User findUser(String email) {
        return userRepository.findByUsername(email);
    }
}
