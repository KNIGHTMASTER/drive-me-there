package id.co.zisal.am_common.constant;

import android.os.Environment;

/**
 * Created on 9/22/2015 : 4:19 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface GeneralConstant {

    interface Punctuation {
        String SPACE 					= " ";
        String COLON 					= ":";
        String SEMI_COLON 				= ";";
        String COMMA 					= ",";
        String QUESTION 				= "?";
        String UNDERSCORE 				= "_";
        String HYPHEN 					= "-";
        String SLASH 					= "/";
        String DOUBLE_SLASH 			= "//";
        String EMPTY 					= "";
        String PIPE 					= "|";
    }

    interface ApplicationProperty{
        String VENDOR_NAME              = "Telkomsigma";
        String TENANT_NAME 				= "Jasa Raharja";
        String PROPERTY_FILE_NAME 		= "property.telkomsigma";
        String APP_TARGET_DEFAULT_PATH 	= Environment.getExternalStorageDirectory().getPath()
                .concat(Punctuation.SLASH)
                .concat(VENDOR_NAME)
                .concat(Punctuation.SLASH)
                .concat(TENANT_NAME);
    }

    interface Network{
        public String TYPE_WIFI 			= "1";
        String TYPE_MOBILE 					= "2";
        String TYPE_NOT_CONNECTED 			= "0";
        String WIFI_ENABLED 				= "Wifi enabled";
        String MOBILE_DATA_ENABLED 			= "Mobile data enabled";
        String NOT_CONNECTED_TO_INTERNET	= "Not connected to Internet";
        String WIFI 						= "WIFI";
    }

    interface PhoneState{
        String PHONE_STATE_IDLE 		= "IDLE";
        String PHONE_STATE_OFF_HOOK 	= "OFF HOOK";
        String PHONE_STATE_RINGING 		= "RINGING";
    }

    interface BatteryState{
        String BATTERY_INTENT_HEALTH_EXTRA_KEY 	= "health";
        String BATTERY_DEAD 					= "Dead";
        String BATTERY_OVER_VOLTAGE 			= "Over Voltage";
        String BATTERY_OVER_HEAT 				= "Over Heat";
        String BATTERY_FAILURE 					= "Failure";
        String BATTERY_GOOD 					= "Good";
        String UNKNOWN 							= "Unknown";
    }

    interface BroadcastMessage{
        String RESTART_SERVICE 			= "restart_service";
    }

    interface BundleMessage{
        String LATENCY_TCP_WORKER 		= "latency_tcp_worker";
        String GET_TICKET               = "get_ticket";
        String BOOKING_CODE             = "booking_code";
        String TICKET_CODE              = "ticket_code";
    }

    interface BinaryValue{
        int MINUS_ONE 			= -1;
        int ZERO 				= 0;
        int ONE 				= 1;
        String MINUS_ONE_STRING	= "-1";
        String ZERO_STRING 		= "0";
        String ONE_STRING 		= "1";
    }

    interface WebServiceCode{
        String SUCCESS 			= "200";
        String HTTP 			= "http";
        String HTTPS 			= "https";
    }
}
