package id.co.zisal.am_component.ui.handler.login;

/**
 * Created on 10/5/2015 : 11:04 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ILogin {
    /**
     * Doing login to another screen
     * require getTxtUserName and getTxtPassword
     */
    void doLogin();

    /**
     * Handling event to display or not typed password
     * @param isChecked boolean
     */
    void onChecked(boolean isChecked);
}
