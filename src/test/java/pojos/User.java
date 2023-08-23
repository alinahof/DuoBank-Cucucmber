package pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class User {
    private String username;
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String createdAt;
    private String signUpDate;

}
