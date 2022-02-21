package com.springboot.blog.controller;

import com.springboot.blog.interfaces.IPostService;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD REST APIs cho bài viết")
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private IPostService iPostService;

    @Autowired
    public PostController(IPostService iPostService) {
        this.iPostService = iPostService;
    }

    // get all posts / api
    @ApiOperation(value = "REST API lấy tất cả bài viết trên blog")
    @GetMapping
    public PostResponse getAllPost(
            @RequestParam(value = "pageIndex", defaultValue = "0", required = false) int pageIndex,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ){
        return iPostService.getAllPost(pageIndex, pageSize, sortBy, sortDir);
    }

    @ApiOperation(value = "REST API tạo bài viết mới")
    @PreAuthorize("hasRole('ADMIN')")
    // create post blog
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        return new ResponseEntity<>(iPostService.createPost(postDto), HttpStatus.CREATED);
    }

    // get post by id
    @ApiOperation(value = "REST API lấy bài viết trên blog theo id")
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(iPostService.getPostById(id));
    }

    // update post by id
    @ApiOperation(value = "REST API cập nhật bài viết trên blog theo id")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto,@PathVariable(name="id") Long id){
        PostDto res = iPostService.updatePost(postDto, id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // delete post by id
    @ApiOperation(value = "REST API xóa bài viết trên blog theo id")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") Long id){
        iPostService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }
}
