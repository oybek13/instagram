package ok.team.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created by Oybek Karimjanov
 * Date : 5.20.2022
 * Project Name : instazoo
 */
@Data
public class CommentDto {

    private Long id;
    @NotEmpty
    private String message;
    private String username;

}
