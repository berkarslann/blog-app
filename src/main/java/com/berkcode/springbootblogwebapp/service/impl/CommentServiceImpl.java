package com.berkcode.springbootblogwebapp.service.impl;

import com.berkcode.springbootblogwebapp.dto.CommentDto;
import com.berkcode.springbootblogwebapp.entity.Comment;
import com.berkcode.springbootblogwebapp.entity.Post;
import com.berkcode.springbootblogwebapp.mapper.CommentMapper;
import com.berkcode.springbootblogwebapp.repository.CommentRepository;
import com.berkcode.springbootblogwebapp.repository.PostRepository;
import com.berkcode.springbootblogwebapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void createComment(String postUrl, CommentDto commentDto) {
        Post post = postRepository.findByUrl(postUrl).get();
        Comment comment = CommentMapper.mapToComment(commentDto);
        comment.setPost(post);
        commentRepository.save(comment);
    }

    @Override
    public List<CommentDto> findAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(CommentMapper::mapToCommentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
