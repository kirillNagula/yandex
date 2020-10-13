package by.nagula.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;


public class Comment {
    private long id;
    @NotEmpty
    @NotBlank
    private String text;
    @Min(1)
    private long user;
    private Date date;
    @Min(1)
    private long idPost;

    public Comment(String text, long user, Date date, long idPost) {
        this.text = text;
        this.user = user;
        this.date = date;
        this.idPost = idPost;
    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long idPost) {
        this.idPost = idPost;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", date=" + date +
                ", idPost=" + idPost +
                '}';
    }
}
