package by.nagula.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Like {
    private long id;
    private User user;

    public Like(User user) {
        this.user = user;
    }
}
