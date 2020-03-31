package com.riddit.Riddit.service;

import com.riddit.Riddit.model.Text;
import com.riddit.Riddit.model.User;
import com.riddit.Riddit.repository.TextRepository;
import com.riddit.Riddit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TextService {

    @Autowired
    private TextRepository textRepository;

    @Autowired
    private UserRepository userRepository;

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

    public void updateTextVotes(Long id, String userId, Boolean vote) {
        Text text = textRepository.findById(id).orElse(null);
        User user = userRepository. findById(userId).orElse(null);
        if(text != null && user != null) {
            Map<String, Boolean> updatedVoteList = text.getVoteList();
            if(updatedVoteList.containsKey(userId) && updatedVoteList.get(userId) == vote) {
                updatedVoteList.remove(userId);
            } else {
                updatedVoteList.put(userId, vote);
            }
            text.setVoteList(updatedVoteList);
            text.setVotes();
            textRepository.save(text);
        }
    }
}
