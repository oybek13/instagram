package ok.team.dto.request;

import lombok.Builder;
import lombok.Data;
import ok.team.annotations.PasswordMatches;
import ok.team.annotations.ValidEmail;
import ok.team.entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by Oybek Karimjanov
 * Date : 5.20.2022
 * Project Name : instazoo
 */
@Data
@PasswordMatches
public class SignupRequest {

    @Email(message = "It should have email format")
    @NotBlank(message = "User email is required!")
    @ValidEmail
    private String email;
    @NotEmpty(message = "Please enter your name!")
    private String firstname;
    @NotEmpty(message = "Please enter your lastname!")
    private String lastname;
    @NotEmpty(message = "Please enter your username!")
    private String username;
    @NotEmpty(message = "Password is required!")
    @Size(min = 6)
    private String password;
    private String confirmPassword;


}
