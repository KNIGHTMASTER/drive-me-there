package id.co.zisal.dmt_component.ui.activity;


/**
 * <p>
 *      This base navigation can be used both in Activity and Fragment
 * </p>
 *
 * Created by Achmad Fauzi on 5/7/2015 : 4:53 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <LOGIN_VIEW>
 */
public interface INavigation<LOGIN_VIEW> {

    /**
     * <p>
     *     This method is used to access main key from current active Context
     * </p>
     * @param p_ExtraKey String
     * @param p_ExtraContent String
     */
    void goToMainView(String p_ExtraKey, String p_ExtraContent);

    /**
     * <p>
     *     This method is used to access Login View
     * </p>
     * @param p_ExtraKey String
     * @param p_ExtraContent String
     */
    void goToLoginView(Class<LOGIN_VIEW> p_LoginViewClass, String p_ExtraKey, String p_ExtraContent);

    /**
     * <p>
     *     This method is used to exit Application from active Context
     * </p>
     */
    void exitApplication();

}
