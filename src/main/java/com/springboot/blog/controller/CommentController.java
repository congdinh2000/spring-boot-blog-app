package com.springboot.blog.controller;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.interfaces.ICommentService;
import com.springboot.blog.payload.CommentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CommentController {
    private ICommentService _commentService;

    public CommentController(ICommentService _commentService) {
        this._commentService = _commentService;
    }

    @PostMapping("posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(name="postId") Long id,@Valid @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(_commentService.createComment(id, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(name="postId") Long postId){
        return _commentService.getCommentsByPostId(postId);
    }

    @GetMapping("posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(name="postId") Long postId,@PathVariable(name="commentId") Long commentId){
        CommentDto commentDto = _commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PutMapping("posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateComment(
                                            @PathVariable(name="postId") Long postId,
                                            @PathVariable(name="commentId") Long commentId,
                                            @Valid @RequestBody CommentDto comment)
    {
        CommentDto response = _commentService.updateComment(postId, commentId, comment);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(
            @PathVariable(name="postId") Long postId,
            @PathVariable(name="commentId") Long commentId)
    {
        _commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}
