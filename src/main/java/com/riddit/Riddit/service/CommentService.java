package com.riddit.Riddit.service;

import com.riddit.Riddit.model.Comment;
import com.riddit.Riddit.model.User;
import com.riddit.Riddit.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<>();
        commentRepository.findAll().forEach(comments::add);
        return comments;
    }

    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

}
