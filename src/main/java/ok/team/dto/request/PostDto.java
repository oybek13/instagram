package ok.team.dto.request;

import lombok.Data;

import java.util.Set;

/**
 * Created by Oybek Karimjanov
 * Date : 5.20.2022
 * Project Name : instazoo
 */
@Data
public class PostDto {

    private Long id;
    private String title;
    private String caption;
    private String location;
    private String username;
    private Integer likes;
    private Set<String> userLiked;

}
