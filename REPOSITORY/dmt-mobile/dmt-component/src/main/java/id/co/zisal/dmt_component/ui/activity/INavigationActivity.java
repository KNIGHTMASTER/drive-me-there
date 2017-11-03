package id.co.zisal.dmt_component.ui.activity;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * <p>
 *     Navigating between <code>Activity</code>
 * </p>
 *
 * @param <TARGET_CLASS>
 *
 * Created by Achmad Fauzi on 4/28/2015 : 12:48 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface INavigationActivity<TARGET_CLASS> extends INavigation {

    /**
     * <p>
     *     This method is used to initiate next Activity from current active Activity
     * </p>
     * @param p_Clazz Class
     * @param p_ExtraKey String
     * @param p_ExtraContent String
     */
    void gotoNextActivity(Class<TARGET_CLASS> p_Clazz, String p_ExtraKey, String p_ExtraContent);

    /**
     * <p>
     *     This method is used to initiate next Activity from current active Activity
     * </p>
     * @param p_Clazz Class
     * @param p_ExtraKey String
     * @param p_ExtraContent Serializable
     */
    void gotoNextActivity(Class<TARGET_CLASS> p_Clazz, String p_ExtraKey, Serializable p_ExtraContent);


    /**
     * <p>
     *     This method is used to initiate next Activity from current active Activity
     * </p>
     * @param p_Clazz Class
     * @param p_ExtraKey String
     * @param p_ExtraContent Parcel
     */
    void gotoNextActivity(Class<TARGET_CLASS> p_Clazz, String p_ExtraKey, Parcelable p_ExtraContent);

}
