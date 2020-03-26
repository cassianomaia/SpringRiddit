package com.riddit.Riddit.controller;

import com.riddit.Riddit.model.Comment;
import com.riddit.Riddit.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    // TODO: Only the comments of the logged user should be returned
    @RequestMapping("/comment")
    public List<Comment> gettAllComments() {
        return commentService.getAllComments();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/comment")
    public void addComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
    }

}
