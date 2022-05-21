package ok.team.service;

import lombok.RequiredArgsConstructor;
import ok.team.dto.request.SignupRequest;
import ok.team.dto.request.UserDto;
import ok.team.entity.User;
import ok.team.entity.enums.ERole;
import ok.team.exceptions.UserExistException;
import ok.team.repository.UserRepository;
import ok.team.security.JWTTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * Created by Oybek Karimjanov
 * Date : 5.20.2022
 * Project Name : instazoo
 */
@Service
@RequiredArgsConstructor
public class UserService {

    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(SignupRequest userIn){
        User user = new User();
        user.setEmail(userIn.getEmail());
        user.setName(userIn.getFirstname());
        user.setLastname(userIn.getLastname());
        user.setUsername(userIn.getUsername());
        user.setPassword(passwordEncoder.encode(userIn.getPassword()));
        user.getRoles().add(ERole.ROLE_USER);

        try {
            LOG.info("Saving User {}", userIn.getEmail());
            return userRepository.save(user);
        } catch (Exception e) {
            LOG.error("Error during registration. {}", e.getMessage());
            throw new UserExistException("The user " + user.getUsername() + "already exist. Please check credentials");
        }
    }

    public User updateUser(UserDto userDto, Principal principal){
        User user = getUserByPrincipal(principal);
        user.setName(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setBio(userDto.getBio());

        return userRepository.save(user);

    }

    public User getCurrentUser(Principal principal){
        return getUserByPrincipal(principal);
    }

    private User getUserByPrincipal(Principal principal){
        String username = principal.getName();
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username no found with username " + username));
    }


    public User getUserById(Long id) {
       return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
