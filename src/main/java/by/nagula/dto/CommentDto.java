package by.nagula.dto;

public class CommentDto {
    private String text;

    public CommentDto(String text){
        this.text = text;
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
