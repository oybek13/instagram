package ok.team.repository.validations;

import ok.team.annotations.PasswordMatches;
import ok.team.dto.request.SignupRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Oybek Karimjanov
 * Date : 5.20.2022
 * Project Name : instazoo
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>{

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        SignupRequest signupRequest = (SignupRequest) o;
        return signupRequest.getPassword().equals(signupRequest.getConfirmPassword());
    }
}
