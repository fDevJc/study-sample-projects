package com.jc.rediscachesample.dto;

import java.io.Serializable;

import com.jc.rediscachesample.domain.Post;

public class ResponsePost implements Serializable {
	private Long id;
	private String title;
	private String content;

	public ResponsePost() {

	}

	private ResponsePost(Long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public static ResponsePost of(Post post) {
		return new ResponsePost(post.getId(), post.getTitle(), post.getContent());
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
}
