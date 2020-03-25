package com.riddit.Riddit.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name="text")
public class Text {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private Date date;
    private int votes;
    @ManyToOne
    @JoinColumn
    private User user;
    // TODO: Add: VoteList: Map<User, Boolean> and CommentList: OneToMany List<Comment>

    public Text() {

    }

    public Text(String title, String body, User user, Date date, int votes) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.date = date;
        this.votes = votes;
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

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Text{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", user=" + user +
                ", date=" + date +
                ", votes=" + votes +
                '}';
    }
}
