package by.nagula.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class PostDto {
    @NotBlank
    @NotEmpty
    private String title;

    @NotBlank
    @NotEmpty
    private String description;

    @NotBlank
    @NotEmpty
    private String text;

    public PostDto(String title, String description, String text) {
        this.title = title;
        this.description = description;
        this.text = text;
    }

    public PostDto() {
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
}
