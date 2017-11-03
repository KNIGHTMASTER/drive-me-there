package id.co.zisal.dmt_component.ui.activity;

/**
 * <p>
 *     This interface is used as common functions for Activity
 * </p>
 *
 * Created by Achmad Fauzi on 11/19/2014.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IActivity extends INavigationActivity {

    /**
     * <p>
     *     This method is used to initiate current active activity's widgets
     * </p>
     */
    void initWidget();

    /**
     * <p>
     *     This method is used to setup TypeFace for widgets within current active Activity
     * </p>
     */
    void setupTypeFace();

    /**
     * <p>
     *     This method used to get view id that will be set into activity
     * </p>
     * @return int id of view layout
     */
    int getViewLayoutId();

    /**
     * <p>
     *     Font assets initiation :
     *     <ol>
     *         <li>1 : TextView</li>
     *         <li>2 : EditText</li>
     *         <li>3 : Button</li>
     *     </ol>
     * </p>
     * @return String[] array of font assets
     */
    String[] initFontAssets();

    /**
     * <p>
     *     to hide status bar. Using AppCompatActivity
     * </p>
     */
    void hideStatusBar();

    /**
     * <p>
     *     to setup Orientation before OnCreatedView
     * </p>
     */
    void setupOrientation();
}
