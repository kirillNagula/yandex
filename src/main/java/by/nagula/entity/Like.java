package by.nagula.entity;


public class Like {
    private long id;
    private long userId;
    private long postId;

    public Like(long userId, long postId) {
        this.userId = userId;
        this.postId = postId;
    }

    public Like(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

}
