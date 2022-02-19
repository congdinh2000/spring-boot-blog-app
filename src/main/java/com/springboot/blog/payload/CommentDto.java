package com.springboot.blog.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CommentDto {

    private Long id;
    @NotNull(message = "Name should be not null or empty")
    private String name;
    @NotEmpty(message = "Email should be not null or empty")
    @Email
    private String email;

    @NotEmpty
    @Size(min = 10, message = "Comment body must be at minimum 10 characters")
    private String body;
}
