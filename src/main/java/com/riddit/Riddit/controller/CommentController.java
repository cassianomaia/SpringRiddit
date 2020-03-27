package com.riddit.Riddit.controller;

import com.riddit.Riddit.model.Comment;
import com.riddit.Riddit.service.CommentService;
import com.riddit.Riddit.service.TextService;
import com.riddit.Riddit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private TextService textService;

    @Autowired
    private UserService userService;

    // TODO: Only the comments of the logged user should be returned
    @RequestMapping("/comment")
    public List<Comment> gettAllComments() {
        return commentService.getAllComments();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/comment")
    public void addComment(@RequestBody Comment comment, @RequestParam String userId, @RequestParam Long textId) {
        comment.setUser(userService.getUser(userId));
        comment.setText(textService.getText(textId));
        commentService.addComment(comment);
    }

}
