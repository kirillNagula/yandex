package by.nagula.entity;


public class Post {
    private long id;
    private String title;
    private String description;
    private String text;
    private long userId;

    public Post(long id, String title, String description, String text, long userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.text = text;
        this.userId = userId;
    }

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", text='" + text + '\'' +
                ", userId=" + userId +
                '}';
    }
}
