package id.co.zisal.dmt_common.util;

import android.util.Base64;

import id.co.zisal.dmt_common.constant.GeneralConstant;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <p>
 *     A bunch of method to convert some values for an appropriate result
 * </p>
 *
 * Created on 9/30/2014.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public class GeneralConverter {

    private SimpleDateFormat simpleDateFormat;

    /**
     *<p>
     *     Retrieve main url from given url of a <code>String</code>
     *     <code>
     *         <a href ="http://www.google.com">Google</a>
     *     </code>
     *     will result main url as google.com
     *</p>
     *
     * @param p_CompleteURl complete url value
     * @return extracted main url
     */
    public String getMainUrl( String p_CompleteURl ){
        String result = p_CompleteURl.substring( 7, p_CompleteURl.length() );
        result  = removeLastChar( result );
        return result ;
    }

    /**
     * <p>
     *     Rounding up a value with N decimal places
     * </p>
     *
     * @param p_Value a rounded value
     * @param p_DecimalPlaces number of decimal place after proc
     * @return double converted value
     */
    public double roundingUp(double p_Value, int p_DecimalPlaces){
        BigDecimal bd = new BigDecimal( p_Value );
        bd = bd.setScale( p_DecimalPlaces, BigDecimal.ROUND_UP);
        p_Value = bd.doubleValue();
        return p_Value;
    }

    /**
     * <p>
     *     Convert from Mbps To Kbps
     * </p>
     *
     * @param p_Value mbps value
     * @return double converted value
     */
    public double mbpsToKbps(double p_Value){
        return p_Value * 1024;
    }

    /**
     * <p>
     *     Convert string with first letter upper case
     * </p>
     * @param p_StringToCapitalize
     * @return String
     */
    public String capitalize(String p_StringToCapitalize) {
        if (p_StringToCapitalize == null || p_StringToCapitalize.length() == 0) {
            return "";
        }
        char first = p_StringToCapitalize.charAt(0);
        if (Character.isUpperCase(first)) {
            return p_StringToCapitalize;
        } else {
            return Character.toUpperCase(first) + p_StringToCapitalize.substring(1);
        }
    }

    /**
     * <p>
     *     Convert <code>Date</code> into Time format (hh:mm:ss )
     * </p>
     * @param p_DateToFormat
     * @return String
     */
    public String getDateToFormatTime(Date p_DateToFormat){
        simpleDateFormat = new SimpleDateFormat( "hh:mm:ss" );
        return simpleDateFormat.format( p_DateToFormat );
    }

    /**
     * <p>
     *     Convert certain <code>Date</code> into format ("yyyy:MM:dd")
     * </p>
     * @param p_DateToFormat
     * @return String
     */
    public String getDateToFormatDateColonSeparator(Date p_DateToFormat){
        simpleDateFormat = new SimpleDateFormat( "yyyy:MM:dd" );
        return simpleDateFormat.format( p_DateToFormat );
    }

    /**
     * <p>
     *     Convert <code>Date</code> into format ("dd-MM-yyyy")
     * </p>
     * @param p_DateToFormat
     * @return String
     */
    public String getDateToFormatDateHyphenSeparator(Date p_DateToFormat){
        simpleDateFormat = new SimpleDateFormat( "dd-MM-yyyy" );
        return simpleDateFormat.format( p_DateToFormat );
    }


    /**
     * <p>
     *     Convert <code>Date</code> into Time format ( hh:mm:ss )
     * </p>
     * @param p_DateToFormat
     * @return Date
     */
    public Date getDateToFormatTimeAsDate(Date p_DateToFormat){
        simpleDateFormat = new SimpleDateFormat( "HH:mm:ss", Locale.ENGLISH );
        String result = simpleDateFormat.format( p_DateToFormat );
        Date _result = null;
        try {
            _result = simpleDateFormat.parse(String.valueOf(result));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return _result;
    }

    /**
     * <p>
     *     Converting <p>Date</p> to proper format
     *     for Web service specification ("yyyy-MM-dd HH:mm:ss.SSS")
     * </p>
     * @param p_DateToFormat
     * @return
     */
    public String getDateToFormatDateWS(Date p_DateToFormat){
        simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS"  );
        return simpleDateFormat.format( p_DateToFormat );
    }

    /**
     * <p>
     *     Converting Date to proper format
     *     for Web service specification ("yyyy-MM-dd HH:mm:ss.SSS")
     * </p>
     * @param p_DateToFormat
     * @return
     */
    public Date getDateToComparator(String p_DateToFormat){
        simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" );
        Date result = null;
        try {
            result = simpleDateFormat.parse( p_DateToFormat );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * <p>
     *     Converting <code>Date</code> to format ( "yyyyMMddHHmmss"  )
     * </p>
     * @param p_DateToFormat
     * @return
     */
    public String getDateToFormatTestId(Date p_DateToFormat){
        simpleDateFormat = new SimpleDateFormat( "yyyyMMddHHmmss"  );
        return simpleDateFormat.format(p_DateToFormat);
    }

    /**
     * <p>
     *     Converting <code>Date</code> to format ("dd-MM-yyyy")
     * </p>
     * @param date
     * @return String result
     */
    public String getDateStandardFormatInString(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat standardFormat = new SimpleDateFormat("dd-MM-yyyy");
        if(date != null){
            Date oldFormat = null;
            try {
                oldFormat = simpleDateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return standardFormat.format(oldFormat);
        }else{
            return standardFormat.format(new Date());
        }
    }


    /**
     * <p>
     *     Convert from seconds to Minutes as <code>double</code>
     * </p>
     * @param p_Seconds
     * @return double
     */
    public double secondToMinute(int p_Seconds){
        double secondsDouble = Double.valueOf(p_Seconds);
        return roundingUp(secondsDouble / 60, 2);
    }

    /**
     * <p>
     *     Convert from Minutes to seconds as <code>int</code>
     * </p>
     * @param p_Minute
     * @return double
     */
    public int minuteToSeconds(int p_Minute){
        return p_Minute * 60;
    }

    /**
     * <p>
     *     Utility to remove last char of a String
     *     ( usually for URLBuilder in Web Service with GET method)
     * </p>
     * @param p_StringToFormat
     * @return
     */
    public String removeLastChar(String p_StringToFormat){
        if ( p_StringToFormat!= null && p_StringToFormat!= "" ){
            return p_StringToFormat.substring( 0 , p_StringToFormat.length()-1 );
        }else{
            return "";
        }
    }

    /**
     * <p>
     *     Removing special character used within web service data
     * </p>
     * @param p_StringToFormat
     * @return
     */
    public String removeSpecialChar(String p_StringToFormat){
        try{
            return p_StringToFormat.replaceAll("[^\\w\\s\\-_]", "");
        }catch (Exception e){
            return GeneralConstant.Punctuation.HYPHEN;
        }
    }

    /**
     * <p>
     *     Get Time in Seconds from ISO8601 Format
     * </p>
     * @param p_Data String
     * @return Integer
     */
    public Integer getDurationIso8601(String p_Data){
        String result = p_Data.substring( 2, p_Data.length() );
        Integer intResult = null;
        Integer mResult = 0 ;
        Integer sResult;
        if ( result.contains("M")){
            mResult = minuteToSeconds( Integer.valueOf(result.substring(0, result.indexOf("M"))) );
            sResult = Integer.valueOf(result.substring(result.indexOf("M") + 1, result.indexOf("S")));
        }else{
            sResult = Integer.valueOf(result.substring(0, result.indexOf("S")));
        }
        intResult = mResult + sResult;
        return intResult;
    }

    /**
     * <p>
     *     Format a String into Base64 Format
     * </p>
     * @param p_StringToFormat
     * @return
     */
    public String encodeToBase64(String p_StringToFormat){
        return Base64.encodeToString(p_StringToFormat.getBytes(), Base64.NO_WRAP);
    }

    /**
     * <p>
     *     To convert BER ( Bit Error Rate ) into Signal Quality
     * </p>
     *
     * @param p_Ber bit error rate
     * @return String converted value
     */
    public String berToSignalQualityTelkomselBased(int p_Ber){
        String result = "";
        if ( p_Ber <= 0.2 ){
            result = "5";
        }else if ( p_Ber > 0.2 && p_Ber <= 0.4 ){
            result = "4";
        }else if ( p_Ber > 0.4 && p_Ber <= 0.8 ){
            result = "3";
        }else if( p_Ber > 0.81 && p_Ber <= 1.6 ){
            result = "2";
        }else if ( p_Ber > 1.6 && p_Ber <= 3.2 ){
            result = "1";
        }else if ( p_Ber > 3.2 ){
            result = "0";
        }
        return result;
    }

    /**
     * <p>
     *     To convert BER ( Bit Error Rate ) into Signal Quality
     * </p>
     *
     * @param p_Ber bit error rate
     * @return String converted value
     */
    public String berToSignalQuality(int p_Ber){
        String result = "";
        if ( p_Ber <= 0.2){
            result = "0";
        }else if ( p_Ber > 0.2 && p_Ber <= 0.4 ){
            result = "1";
        }else if ( p_Ber > 0.4 && p_Ber <= 0.8 ){
            result = "2";
        }else if( p_Ber > 0.81 && p_Ber <= 1.6 ){
            result = "3";
        }else if ( p_Ber > 1.6 && p_Ber <= 3.2 ){
            result = "4";
        }else if ( p_Ber > 3.2 && p_Ber <= 6.4 ){
            result = "5";
        }else if ( p_Ber > 6.4 && p_Ber <= 12.8){
            result = "6";
        }else if ( p_Ber > 12.8){
            result = "7";
        }
        return result;
    }

    /**
     *
     * @param p_CharSequence paramRequest
     * @return built String from CharSequence
     */
    public String charSequenceToString(CharSequence p_CharSequence){
        final StringBuilder sb = new StringBuilder(p_CharSequence.length());
        sb.append(p_CharSequence);
        return sb.toString();
    }
}
