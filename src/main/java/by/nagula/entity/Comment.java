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
    private Date date;
    @Min(1)
    private long idPost;
    @Min(1)
    private long idUser;


    public Comment(@NotEmpty @NotBlank String text, Date date, @Min(1) long idPost, long idUser) {
        this.text = text;
        this.date = date;
        this.idPost = idPost;
        this.idUser = idUser;
    }

    public Comment() {
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
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
                ", date=" + date +
                ", idPost=" + idPost +
                ", idUser=" + idUser +
                '}';
    }
}
