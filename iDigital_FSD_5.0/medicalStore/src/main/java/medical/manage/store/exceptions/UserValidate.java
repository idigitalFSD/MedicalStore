package medical.manage.store.exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * This method for Validating userId,Password
 * @author Nimitha
 */
public class UserValidate {
	
//This method for checking userId on regex
public boolean validateUser(String userId)
{
	String regex = "^[A-Za-z]\\w{1,30}$"; 
    Pattern p = Pattern.compile(regex); 
    if (userId == null) { 
        return false; 
    } 
    Matcher m = p.matcher(userId); 
    return m.matches();
	
}
//This method for checking Password on regex
public boolean validatePassword(String password)
{
	 String regex = "^(?=.*[0-9])"
             + "(?=.*[a-z])(?=.*[A-Z])"
             + "(?=.*[@#$%^&+=])"
             + "(?=\\S+).{8,20}$"; 
	 Pattern p = Pattern.compile(regex); 
	    if (password == null) { 
	        return false; 
	    } 
	    Matcher m = p.matcher(password); 
	    return m.matches();}
}
