package com.riddit.Riddit.repository;

import com.riddit.Riddit.model.Text;
import org.springframework.data.repository.CrudRepository;

public interface TextRepository extends CrudRepository<Text, String> {
}
