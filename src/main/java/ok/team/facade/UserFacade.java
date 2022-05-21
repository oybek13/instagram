package ok.team.facade;

import ok.team.dto.request.UserDto;
import ok.team.entity.User;
import org.springframework.stereotype.Component;

/**
 * Created by Oybek Karimjanov
 * Date : 5.20.2022
 * Project Name : instazoo
 */
@Component
public class UserFacade {

    public UserDto userToUserDTO(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstname(user.getName());
        userDto.setLastname(user.getLastname());
        userDto.setUsername(user.getUsername());
        userDto.setBio(user.getBio());
        return userDto;
    }
}
