package controller.validator;

import java.util.List;

public class UserNameValidator {
    public static List<String> checkUserName(String username, List<String> errors) {
        if (username.trim().length() > 20) {
            errors.add("Length of username is not valid. Need les than 20 symbols.");
        }
        return errors;
    }
}
