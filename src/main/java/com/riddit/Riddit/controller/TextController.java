package com.riddit.Riddit.controller;

import com.riddit.Riddit.model.Text;
import com.riddit.Riddit.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TextController {

    @Autowired
    private TextService textService;

    /* TODO: order by: post date (Descending)
                       votes (Ascending or Descending)
                       comment number (Descending) */
    @RequestMapping("/texts")
    public List<Text> getAllTexts() {
        return textService.getAllTexts();
    }

    // TODO: Add option to fetch comments
    @RequestMapping("/texts/{id}")
    public Text getText(@PathVariable Long id) {
        return textService.getText(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/texts")
    public void addText(@RequestBody Text text) {
        textService.addText(text);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/texts/{id}")
    public void deleteText(@PathVariable Long id) {
        textService.deleteText(id);
    }

    // TODO: Add method to vote
}
