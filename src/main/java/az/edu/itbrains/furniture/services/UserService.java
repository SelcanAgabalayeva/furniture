package az.edu.itbrains.furniture.services;

import az.edu.itbrains.furniture.dtos.RegisterDto;
import az.edu.itbrains.furniture.models.User;

public interface UserService {
    boolean registerUser(RegisterDto registerDto);
    User findUser(String email);
}
