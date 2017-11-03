package id.co.zisal.dmt_component.ui.handler.logut;

/**
 * Created on 10/8/2015 : 10:08 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ILogout {

    /**
     * Doing logout from application,
     * start from web service, on post updating user data
     * then exit from application
     */
    void doLogout();

    void detectLoginStatus();
}
