package com.springboot.blog.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Setter
@Getter
public class PostDto {
    private Long id;
    // title not null and min length 2 characters
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;

    // description not null and min length 10 characters
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

    // content not null/empty
    @NotEmpty
    private String content;
    private Set<CommentDto> commentSet;
}
