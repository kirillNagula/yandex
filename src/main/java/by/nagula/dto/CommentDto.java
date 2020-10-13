package by.nagula.dto;

public class CommentDto {
    private String text;
    private long postId;

    public CommentDto(String text, long postId) {
        this.text = text;
        this.postId = postId;
    }

    public CommentDto() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
