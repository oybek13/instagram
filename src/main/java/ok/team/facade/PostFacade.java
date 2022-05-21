package ok.team.facade;

import ok.team.dto.request.PostDto;
import ok.team.entity.Post;
import org.springframework.stereotype.Component;

/**
 * Created by Oybek Karimjanov
 * Date : 5.20.2022
 * Project Name : instazoo
 */
@Component
public class PostFacade {

    public PostDto postToPostDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setUsername(post.getUser().getUsername());
        postDto.setId(post.getId());
        postDto.setCaption(post.getCaption());
        postDto.setLikes(post.getLikes());
        postDto.setUserLiked(post.getLikedUsers());
        postDto.setLocation(post.getLocation());
        postDto.setTitle(post.getTitle());

        return postDto;
    }

}
