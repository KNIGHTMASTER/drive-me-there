package id.co.zisal.dmt.fragment.profile;

import id.co.zisal.dmt.R;
import id.co.zisal.dmt_component.ui.fragment.impl.ABaseFragment;

/**
 * Created on 4/27/2016 : 7:55 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentProfileFollowing extends ABaseFragment {

    @Override
    public String getFragmentTitle() {
        return "Fragment Profile Following";
    }

    @Override
    public void initWidget() {

    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_profile_following;
    }
}
