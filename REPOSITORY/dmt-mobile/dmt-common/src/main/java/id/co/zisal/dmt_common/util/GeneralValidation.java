package id.co.zisal.dmt_common.util;

import android.widget.EditText;

import id.co.zisal.dmt_common.dto.DTOPasswordValidMessenger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * <p>
 *     Validating input from user to appropriate format
 * </p>
 * Created on 10/1/2014.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public class GeneralValidation {

    /**
     * <p>
     *     Validating password with requirements :
     *     <ol>
     *         <li>Must contains at least one digit from 0-9</li>
     *         <li>Must contains at least one lowercase characters</li>
     *         <li>Must contains at least one uppercase characters</li>
     *         <li>Must contains at least one special symbols in the list "@#$%"</li>
     *         <li>Match anything with previous condition checking</li>
     *         <li>Length at least 6 characters and maximum of 20</li>
     *     </ol>
     * </p>
     * @param p_PasswordToValidate String
     * @return boolean
     */
    public boolean isValidPasswordBundle(String p_PasswordToValidate){
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(p_PasswordToValidate);
        return matcher.matches();
    }

    /**
     * <p>
     *     Validating password with requirements :
     *     <ol>
     *         <li>Must contains at least one digit from 0-9</li>
     *         <li>Must contains at least one lowercase characters</li>
     *         <li>Must contains at least one uppercase characters</li>
     *         <li>Must contains at least one special symbols in the list "@#$%"</li>
     *         <li>Match anything with previous condition checking</li>
     *         <li>Length at least 6 characters and maximum of 20</li>
     *     </ol>
     * @param p_PasswordToValidate String
     * @return DTOPasswordValidMessenger an Object result
     */
    public DTOPasswordValidMessenger isValidPasswordPerMessage(String p_PasswordToValidate){
        DTOPasswordValidMessenger dtoPasswordValidMessenger = new DTOPasswordValidMessenger();
        if( isContainNumber( p_PasswordToValidate ) ){
            dtoPasswordValidMessenger.setResult(true);
            if( isContainLowerCase( p_PasswordToValidate )){
                dtoPasswordValidMessenger.setResult(true);
                if( isContainUpperCase( p_PasswordToValidate )){
                    dtoPasswordValidMessenger.setResult(true);
                    if( isContainSpecialSymbols( p_PasswordToValidate ) ){
                        dtoPasswordValidMessenger.setResult(true);
                        if( isInDeterminedLength( p_PasswordToValidate )){
                            dtoPasswordValidMessenger.setResult(true);
                        }else{
                            dtoPasswordValidMessenger.setResult(false);
                            dtoPasswordValidMessenger.setMessage("Password length min 8 max 20");
                        }
                    }else{
                        dtoPasswordValidMessenger.setResult(false);
                        dtoPasswordValidMessenger.setMessage("Password should contain special symbols @#$%");
                    }
                }else{
                    dtoPasswordValidMessenger.setResult(false);
                    dtoPasswordValidMessenger.setMessage("Password should contain upper case");
                }
            }else{
                dtoPasswordValidMessenger.setResult(false);
                dtoPasswordValidMessenger.setMessage("Password should contain lower case");
            }
        }else{
            dtoPasswordValidMessenger.setResult(false);
            dtoPasswordValidMessenger.setMessage("Password should contain number");
        }
        return dtoPasswordValidMessenger;
    }

    /**
     * <p>
     *     Validating IP Address
     * </p>
     * @param p_IPAddress String
     * @return boolean
     */
    public boolean isValidIpAddress(String p_IPAddress){
        String ipPattern = "(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";
        boolean result;
        p_IPAddress = p_IPAddress.trim();
        result = p_IPAddress.matches(ipPattern) && p_IPAddress.length() > 0;
        return result;
    }

    /**
     * <p>
     *     Validating EditText whether empty or not
     * </p>
     * true = not empty
     * false = empty
     * @param p_EditTextToValidate EditText
     * @return boolean
     */
    public boolean isEmptyEditText(EditText p_EditTextToValidate){
        return !(p_EditTextToValidate.getText() != null && p_EditTextToValidate.getText().toString().length() > 0);
    }


    /**
     * <p>
     *     Validating Scheduler to work at working day and hour only
     * </p>
     * Working day = MONDAY to FRIDAY
     * @param p_StartWorkingHour int
     * @param p_StopWorkingHour int
     * @return boolean
     */
    public boolean isWorkingHour( int p_StartWorkingHour, int p_StopWorkingHour ){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get( Calendar.DAY_OF_WEEK );
        boolean result;
        /*if( (day> Calendar.SUNDAY) && (day< Calendar.SATURDAY) ){*/
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        result = (currentHour >= p_StartWorkingHour) && (currentHour < p_StopWorkingHour);
        /*}else{
            result = false;
        }*/
        return result;
    }

    /**
     * <p>
     *     Validating a String only contains a number in specific 45 characters range
     * </p>
     * @param p_StringToValidate
     * @return boolean
     */
    public boolean isOnlyNumbersLimited45( String p_StringToValidate ){
        String pattern = "^[0-9]{1,45}$";
        boolean result;
        p_StringToValidate = p_StringToValidate.trim();
        result = p_StringToValidate.matches( pattern );
        return result;
    }

    /**
     * <p>
     *     Validate if birthdate is valid
     * </p>
     * @param p_BirthDate String
     * @param p_ValidAge int
     * @return boolean
     */
    public boolean isValidAge( String p_BirthDate, int p_ValidAge ){
        boolean result;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar bdCal = Calendar.getInstance();
        try {
            bdCal.setTime( df.parse( p_BirthDate ) );
            if( getAge( bdCal.get(Calendar.YEAR), bdCal.get(Calendar.YEAR), bdCal.get(Calendar.YEAR) ) >= p_ValidAge  ){
                result = true;
            }else{
                result = false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }


    /**
     * <p>
     *     Get age
     * </p>
     * @param p_Year int
     * @param p_Month int
     * @param p_Day int
     * @return int
     */
    public int getAge(int p_Year, int p_Month, int p_Day) {
        /*Date now = new Date();
        int nowMonth = now.getMonth()+1;
        int nowYear = now.getYear()+1900;
        int result = nowYear - year;

        if (month > nowMonth) {
            result--;
        }
        else if (month == nowMonth) {
            int nowDay = now.getDate();

            if (day > nowDay) {
                result--;
            }
        }*/
        return 0;
    }

    /**
     * <p>
     *     Validating Email
     * </p>
     * @param p_EmailToValidate String
     * @return boolean
     */
    public boolean isValidEmail(String p_EmailToValidate){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        boolean result;
        p_EmailToValidate = p_EmailToValidate.trim();
        result = p_EmailToValidate.matches(emailPattern) && p_EmailToValidate.length() > 0;
        return result;
    }

    /**
     * Validate if a String is a Phone Number
     * @param phoneNumber String
     * @return boolean
     */
    public boolean isValidPhoneNumber(String phoneNumber){
        String phoneNumberPattern = "^([0-9\\(\\)\\/\\+ \\-]*)$";
        boolean result;
        phoneNumber = phoneNumber.trim();
        result = phoneNumber.matches( phoneNumberPattern ) && phoneNumber.length() > 0;
        return result;
    }

    /**
     * <p>
     *     Validate if a String contains at Least 1 UpperCase
     * </p>
     * @param p_StringToValidate String
     * @return boolean
     */
    public boolean isContainUpperCase(String p_StringToValidate){
        String pattern = ".*[A-Z].*";
        boolean result;
        p_StringToValidate = p_StringToValidate.trim();
        result = p_StringToValidate.matches( pattern );
        return result;
    }

    /**
     * <p>
     *     Validate if a String contain at least one LowerCase
     * </p>
     * @param p_StringToValidate String
     * @return boolean
     */
    public boolean isContainLowerCase(String p_StringToValidate){
        String pattern = ".*[a-z].*";
        boolean result;
        p_StringToValidate = p_StringToValidate.trim();
        result = p_StringToValidate.matches( pattern );
        return result;
    }

    /**
     * <p>
     *     Validate if a String contain at Least one Numeric
     * </p>
     * @param p_StringToValidate String
     * @return boolean
     */
    public boolean isContainNumber(String p_StringToValidate){
        String pattern = ".*\\d.*";
        boolean result;
        p_StringToValidate = p_StringToValidate.trim();
        result = p_StringToValidate.matches( pattern );
        return result;
    }

    /**
     * <p>
     *     Validate if a String contain at Least one Special Symbols ( @#$% )
     * </p>
     * @param p_StringToValidate String
     * @return boolean
     */
    public boolean isContainSpecialSymbols(String p_StringToValidate){
        String pattern = ".*[@*$!].*";
        boolean result;
        p_StringToValidate = p_StringToValidate.trim();
        result = p_StringToValidate.matches(pattern);
        return result;
    }

    /**
     * <p>
     *     Validate if a String length is min 8 max 20
     * </p>
     * @param p_StringToValidate String
     * @return boolean
     */
    public boolean isInDeterminedLength(String p_StringToValidate){
        String pattern = ".{8,20}";
        boolean result;
        p_StringToValidate = p_StringToValidate.trim();
        result = p_StringToValidate.matches( pattern );
        return result;
    }
    
    /**
     * Validate Numeric input
     * @param value String
     * @return boolean
     */
    public boolean isValidNumeric(String value){
        String numericPattern = "[0-9]+?";
        boolean result;
        value = value.trim();
        result = value.matches(numericPattern) && value.length() > 0;
        return result;
    }

}
