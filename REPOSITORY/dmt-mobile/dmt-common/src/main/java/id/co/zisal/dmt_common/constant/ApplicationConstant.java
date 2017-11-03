package id.co.zisal.dmt_common.constant;

/**
 * <p>
 *      A Bunch of interfaces to represent <b>Constant</b> values in the Application
 * </p>
 *
 * Created on 9/22/2015 : 4:58 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ApplicationConstant {

    /**
     * <p>
     *     Logging Levels
     * </p>
     */
    interface LogTag {
        String DMT_INFO         = "DMT INFO";
        String DMT_ERROR        = "DMT ERROR";
        String DMT_WARNING      = "DMT WARNING";
        String DMT_DEBUG        = "DMT DEBUG";
        String DMT_VERBOSE      = "DMT VERBOSE";
    }

    /**
     * <p>
     *     Anything about <code>RESTFull</code> protocol communication here
     * </p>
     */
    interface Rest {
        String INIT_HOST                = "melsa.esy.es";
        int INIT_PORT                   = 80;

        /*String INIT_HOST = "127.0.0.1";
        int INIT_PORT = 8081;*/
        String HOST_PROD                = "180.250.115.49";

        String BASE_URL_DEV             = "http://10.210.9.84:8080";
        String BASE_URL_PROD            = "http://180.250.115.49:8080";

        String AUTHORIZATION            = "Authorization";
        String BASIC                    = "Basic";
        String ACCEPT                   = "Accept";
        String CONTENT_TYPE             = "Content-Type";
        String APPLICATION_JSON         = "application/json";
        String APPLICATION_XML          = "application/xml";
        String WS_CONTEXT               = "public/api/v1/";
        String MULTIPART                = "multipart/form-data";
        int READ_TIMEOUT                = 30;
        int CONNECT_TIMEOUT             = 30;

        interface Status{
            int SUCCESS					= 200;
        }

        interface EndPoints{
            String LOCATION             = "/load/location/";
            String LOGIN 				= "/security/user/login";
            String LOGIN2				= "?command=100004";
            String REGISTER             = "/user/register";
            String LOAD_USER 			= "/user/load";
            String LOGOUT 				= "/logout/";
            String OADV 				= "/validation/val001";
            String UPLOAD 				= "/upload";
            String BASE_TICKETING_INQUIRY = "/rqid={rqid}&app={app}&action={action}&book_code={book_code}";
            String CHECK_TICKET         = BASE_TICKETING_INQUIRY;
            String GET_TICKET           = BASE_TICKETING_INQUIRY;
            String DUMMY_IMAGE          = "http://javatechig.com/?json=get_recent_posts&count=45";
        }

        /**
         * <p>
         *     Data Transfer Object keys
         * </p>
         */
        interface DTO{
            interface Request{
                String USER_CODE 		= "user_code";
                String POI_CODE 		= "poi_code";
                interface Login{
                    String SAMPLE_USER 	= "ADMIN";
                    String SAMPLE_ROLE 	= "ROLE_ADMIN";
                }
            }
            interface Response{
                interface Base{
                    String RESPONSE_CODE 		= "ErrorCode";
                    String RESPONSE_MESSAGE 	= "message";
                    String RESPONSE_DESCRIPTION = "description";
                }
                interface Login{
                    String USER_DATAS 			= "userDatas";
                    interface UserData{
                        String ID 				= "id";
                        String USER_NAME 		= "username";
                        String ENABLED 			= "enabled";
                        String EXPIRED_DATE 	= "expiredDate";
                        String NON_LOCKED 		= "nonLocked";
                        String AUTH 			= "auth";
                        String STATUS 			= "status";
                        String REMARKS 			= "remarks";
                        String ROLE_DATA 		= "roleData";
                        interface RoleData{
                            String CODE 		= "code";
                        }
                    }
                }

                interface BaseTicketing{
                    String RQID                 = "rqid";
                    String APP                  = "app";
                    String ACTION               = "action";
                    String BOOK_CODE            = "book_code";
                }

                interface CheckTicket{
                    String ORIGINATION          = "org";
                    String DESTINATION          = "des";
                    String DEPARTURE_DATE       = "dep_date";
                    String TRAIN_NUMBER         = "train_no";
                    String BOOKING_CODE         = "book_code";
                    String CHANNEL              = "channel";
                    String PASSENGER_NUMBER     = "pax_num";
                    String PASSENGER_NAME       = "pax_name";
                    String SEAT                 = "seat";
                    String NORMAL_SALES         = "normal_sales";
                    String EXTRA_FEE            = "extra_fee";
                    String BOOK_BALANCE         = "book_balance";
                }

                interface GetTicket{
                    String DEPARTURE_DATE       = "dep_date";
                    String ETA                  = "eta";
                    String ARRIVAL_DATE         = "arv_date";
                    String ERROR_CODE           = "err_code";
                    String PAYMENT_TYPE         = "pay_type";
                    String ETD                  = "etd";
                    String CITY_FROM            = "city_from";
                    String RESERVATION_DATE     = "resv_date";
                    String ORIGINATION          = "org";
                    String TICKETS              = "tickets";
                    String PASSENGER_NUMBER     = "pax_num";

                }
                String VALIDATION_RESULT 		= "validation_result";
            }
        }
    }

    /**
     * <p>
     *     Keys for any of transfer data among objects in application
     * </p>
     */
    interface TransferKeys{
        String TRIPOIN_PREFERENCE		= "tripoin_preference";
        String USER_LOGIN 				= "user_login";
    }

    interface UserType{
        int USER                     = 0;
        int WORKSHOP                 = 1;
    }

    interface Database {
        String TENANT_NAME 				= "DMT";
        String DATABASE_NAME 			= "tripoin_".concat(TENANT_NAME);
        int DB_VERSION 					= 1;
        String ID 						= "id";
        String INIT_USER 				= "UNREGISTERED_USER";

        interface TableUser {
            String TABLE_NAME 			= "tsm_user";
            String USER_NAME 			= "user_name";
            String USER_CODE 			= "user_code";
            String LOGIN_STATUS 		= "login_status";
            String IS_ACTIVE 			= "is_active";
            String CHIPPER_AUTH 		= "chipper_auth";
        }

        interface TableCustomer {
            String TABLE_NAME 			= "tsm_customer";
            String CUSTOMER_NAME 		= "customer_name";
            String CUSTOMER_ADDRESS 	= "customer_address";
        }

        interface TableTestConfiguration {
            String TABLE_NAME 			= "dynamic_configuration";
            String SCHEDULER_INTERVAL 	= "scheduler_interval";
            String HOST 				= "host";
            String PORT 				= "port";
            String START_WORKING_HOUR 	= "start_working_hour";
            String STOP_WORKING_HOUR 	= "stop_working_hour";
        }
    }

    interface Status {
        interface Process {
            String PASS 				= "P";
            String FAILED 				= "F";
        }

        interface Config {
            String ACTIVE 				= "A";
            String DEACTIVE 			= "D";
        }
    }

    interface ViewController{
        int SPLASH_SCREEN_DELAY_TIME = 3000; //in ms
    }

    /**
     * <p>
     *     Name for any tracer thread
     * </p>
     */
    interface ThreadName {
        String BGP_LOGIN 				= "bgp login";
    }

}
