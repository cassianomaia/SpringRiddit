package com.riddit.Riddit.service;

import com.riddit.Riddit.model.Text;
import com.riddit.Riddit.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TextService {

    @Autowired
    private TextRepository textRepository;

    public List<Text> getAllTexts() {
        List<Text> texts = new ArrayList<>();
        textRepository.findAll().forEach(texts::add);
        return texts;
    }

    public Text getText(Long id) {
        return textRepository.findById(id).orElse(null);
    }

    public void addText(Text text) {
        textRepository.save(text);
    }

    public void updateText(Text text) {
        textRepository.save(text);
    }

    public void deleteText(Long id) {
        textRepository.deleteById(id);
    }
}
