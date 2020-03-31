package com.riddit.Riddit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Entity(name="text")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Text {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private Date date;
    private int votes;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy="text", cascade = CascadeType.ALL)
    private Set<Comment> commentList;
    @ElementCollection
    @MapKeyColumn(name = "email")
    @Column(name = "vote")
    private Map<String, Boolean> voteList;

    public Text() {

    }

    public Text(String title, String body, User user, Date date) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.date = date;
        this.votes = 0;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes() {
        votes = 0;
        voteList.forEach((u, v) -> {
            if(v){
                votes++;
            } else {
                votes--;
            }
        });
    }

    public Set<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(Set<Comment> commentList) {
        this.commentList = commentList;
    }

    public Map<String, Boolean> getVoteList() {
        return voteList;
    }

    public void setVoteList(Map<String, Boolean> voteList) {
        this.voteList = voteList;
    }
}
