package id.co.zisal.am.fragment.about;

import id.co.zisal.am.R;
import id.co.zisal.am_common.constant.ApplicationConstant;
import id.co.zisal.am_component.ui.fragment.impl.ANavigationDrawerFragment;

/**
 * Created on 9/28/2015 : 9:17 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentAbout extends ANavigationDrawerFragment{

    @Override
    public String getFragmentTitle() {
        return ApplicationConstant.FragmentInfo.Title.ABOUT;
    }

    @Override
    public void initWidget() {

    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_about;
    }

}
