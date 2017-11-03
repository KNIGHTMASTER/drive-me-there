package id.co.zisal.dmt_component.ui.fragment;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * <p>
 *     An interface for <code>Fragment</code> Base component
 *     Used as common functions within a <code>Fragment</code>
 * </p>
 *
 * Created by Achmad Fauzi on 11/24/2014.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public interface IFragment extends INavigationFragment {

    /**
     * <p>
     *     This method is used to initiate the active Activity widgets include variables
     * </p>
     */
    void initWidget();

    /**
     * <p>
     *     Retrieve layout id
     * </p>
     *
     * @return int layout id
     */
    int getViewLayoutId();

    /**
     * <p>
     *     Collecting <code>TextVIew</code> within a content group into an <code>Activity</code>
     * </p>
     * @return List<TextView>
     */
    List<TextView> getTextViews();

    /**
     * <p>
     *     Collecting <code>EditText</code> within an <code>Activity</code>
     * </p>
     * @return List<EditText>
     */
    List<EditText> getEditTexts();

    /**
     * <p>
     *     Collecting <code>Button</code> within an <code>Activity</code>
     * </p>
     * @return List<Button>
     */
    List<Button> getButtons();

    /**
     * @return String[] Name of default Font Assets for Application
     */
    String[] initAssetName();

}
