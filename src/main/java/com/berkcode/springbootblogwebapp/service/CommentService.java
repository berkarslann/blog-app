package com.berkcode.springbootblogwebapp.service;

import com.berkcode.springbootblogwebapp.dto.CommentDto;

import java.util.List;

public interface CommentService {
    void createComment(String postUrl, CommentDto commentDto);

    List<CommentDto> findAllComments();

    void deleteComment(Long commentId);
}
