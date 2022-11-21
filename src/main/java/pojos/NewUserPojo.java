package pojos;

import lombok.Data;

import java.util.List;

@Data
public class NewUserPojo {
    private String userID;
    private String username;
    private List books;

}
