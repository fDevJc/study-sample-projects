package com.jc.rediscachesample.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jc.rediscachesample.domain.Post;
import com.jc.rediscachesample.dto.RequestAddPost;
import com.jc.rediscachesample.dto.ResponsePost;
import com.jc.rediscachesample.repository.PostRepository;

@Service
public class PostService {
	private final PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public void addPost(RequestAddPost requestAddPost) {
		Post post = Post.create(requestAddPost.getTitle(), requestAddPost.getContent());
		postRepository.save(post);
	}

	@Cacheable(key = "#pageable.getPageNumber()", value = "post")
	public List<ResponsePost> findAllPosts(Pageable pageable) {
		return postRepository.findAll(pageable)
			.stream()
			.map(post -> ResponsePost.of(post))
			.collect(Collectors.toList());
	}
}
