package co.com.sofka.usecase.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {
    public boolean isValid(String name)
    {
        String regex = "^[A-Za-z]\\w{1,29}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);
        return m.matches();
    }

}
