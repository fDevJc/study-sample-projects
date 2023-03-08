package com.jc.rediscachesample.api;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jc.rediscachesample.dto.RequestAddPost;
import com.jc.rediscachesample.dto.ResponsePost;
import com.jc.rediscachesample.service.PostService;

@RestController
public class PostController {
	private final PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	@PostMapping("/posts")
	public ResponseEntity addPost(@RequestBody RequestAddPost requestAddPost) {
		postService.addPost(requestAddPost);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/posts")
	public ResponseEntity<List<ResponsePost>> findAllPosts(
		@PageableDefault Pageable pageable
	) {
		return ResponseEntity.ok(postService.findAllPosts(pageable));
	}
}
