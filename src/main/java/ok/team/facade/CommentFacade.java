package ok.team.facade;

import lombok.Data;
import ok.team.dto.request.CommentDto;
import ok.team.entity.Comment;
import org.springframework.stereotype.Component;

/**
 * Created by Oybek Karimjanov
 * Date : 5.20.2022
 * Project Name : instazoo
 */
@Component
public class CommentFacade {

    public CommentDto commentToCommentDTO(Comment comment) {
        CommentDto CommentDto = new CommentDto();
        CommentDto.setId(comment.getId());
        CommentDto.setUsername(comment.getUsername());
        CommentDto.setMessage(comment.getMessage());

        return CommentDto;
    }
}
