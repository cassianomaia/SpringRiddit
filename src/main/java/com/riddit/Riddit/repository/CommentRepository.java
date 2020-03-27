package com.riddit.Riddit.repository;

import com.riddit.Riddit.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
