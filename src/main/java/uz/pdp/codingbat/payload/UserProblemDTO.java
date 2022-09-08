package uz.pdp.codingbat.payload;

import lombok.Data;
import uz.pdp.codingbat.entity.Problem;
import uz.pdp.codingbat.entity.User;

@Data
public class UserProblemDTO {

    private Integer id;

    private User user;

    private Problem problem;

    private String solution;

    private boolean solved;
}
