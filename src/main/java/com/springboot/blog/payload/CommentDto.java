package com.springboot.blog.payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ApiModel(value = "Comment Information")
public class CommentDto {

    @ApiModelProperty(value = "ID của bình luận")
    private Long id;

    @ApiModelProperty(value = "Tên người bình luận")
    @NotNull(message = "Name should be not null or empty")
    private String name;

    @ApiModelProperty(value = "Email người bình luận")
    @NotEmpty(message = "Email should be not null or empty")
    @Email
    private String email;

    @ApiModelProperty(value = "Nội dung bình luận")
    @NotEmpty
    @Size(min = 10, message = "Comment body must be at minimum 10 characters")
    private String body;
}
