package com.springboot.blog.payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Setter
@Getter
@ApiModel(value = "Post Information")
public class PostDto {
    @ApiModelProperty(value = "ID của bài viết")
    private Long id;
    // title not null and min length 2 characters

    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    @ApiModelProperty(value = "Tiêu đề của bài viết")
    private String title;

    // description not null and min length 10 characters
    @NotEmpty
    @ApiModelProperty(value = "Mô tả bài viết")
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

    // content not null/empty
    @NotEmpty
    @ApiModelProperty(value = "Nội dung của bài viết")
    private String content;

    @ApiModelProperty(value = "Bình luận của bài viết")
    private Set<CommentDto> commentSet;
}
