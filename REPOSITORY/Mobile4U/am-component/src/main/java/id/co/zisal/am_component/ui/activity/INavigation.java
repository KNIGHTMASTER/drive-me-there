package id.co.zisal.am_component.ui.activity;


/**
 * Created by Achmad Fauzi on 5/7/2015 : 4:53 PM.
 * mailto : achmad.fauzi@sigma.co.id
 *
 * This base navigation can be used both in Activity and Fragment
 */
public interface INavigation {

    /**
     * This method is used to access main key from current active Context
     * @param extraKey String
     * @param extraContent String
     */
    void goToMainView(String extraKey, String extraContent);

    /**
     * This method is used to exit Application from active Context
     */
    void exitApplication();

}
