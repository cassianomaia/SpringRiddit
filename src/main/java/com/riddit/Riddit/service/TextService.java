package com.riddit.Riddit.service;

import com.riddit.Riddit.model.Text;
import com.riddit.Riddit.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TextService {

    @Autowired
    private TextRepository textRepository;

    public List<Text> getAllTexts() {
        List<Text> texts = new ArrayList<>();
        textRepository.findAll().forEach(texts::add);
        return texts;
    }

    public Text getText(String id) {
        return textRepository.findById(id).orElse(null);
    }

    public void addText(Text text) {
        textRepository.save(text);
    }

    public void updateText(Text text) {
        textRepository.save(text);
    }

    public void deleteText(String id) {
        textRepository.deleteById(id);
    }
}
