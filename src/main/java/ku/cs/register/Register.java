//Podjanin Wachirawittayakul 6510450691
package ku.cs.register;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Register {

    public boolean nameCheck(User user){
        if (user.getName() == null || user.getName().trim().equals("")) {
            throw new IllegalArgumentException("Name should not empty");
        }else if ( !user.getName().matches("[a-zA-Z]+")){
            throw new IllegalArgumentException("Name is wrong format");
        }else {
            return true;
        }
    }

    public boolean emailCheck(User user){
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern validEmailPattern = Pattern.compile(EMAIL_PATTERN);
        List<String> notAllowDomains = Arrays.asList("dom1.cc","dom2.cc", "dom3.cc");
        if (user.getEmail() == null || user.getEmail().trim().equals("")) {
            throw new IllegalArgumentException("Email should not empty");
        } else if(!validEmailPattern.matcher(user.getEmail()).matches()){
            throw new IllegalArgumentException("Email is wrong format");
        } else if(notAllowDomains.contains(user.getEmail().split("@")[1])){
            throw new IllegalArgumentException("Domain Email is not allow");
        } else{
            return true;
        }
    }
    public boolean ageCheck(User user){
        if(user.getAge() < 20){
            throw new IllegalArgumentException("Age should more than 20 years");
        }
        return true;
    }

    public boolean register(User user){
        if(nameCheck(user) && emailCheck(user) && ageCheck(user)){
            return true;
        }
        return false;
    }
}
