package id.co.zisal.dmt.fragment.about;

import butterknife.BindString;
import id.co.zisal.dmt.R;
import id.co.zisal.dmt_component.ui.fragment.impl.ABaseFragment;

/**
 * Created on 9/28/2015 : 9:17 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentAbout extends ABaseFragment {

    @BindString(R.string.about)
    String titleFragmentAbout;

    @Override
    public String getFragmentTitle() {
        return titleFragmentAbout;
    }

    @Override
    public void initWidget() {

    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_about;
    }

}
