package id.co.zisal.dmt.fragment.profile;

import android.widget.ListView;

import butterknife.Bind;
import id.co.zisal.dmt.R;
import id.co.zisal.dmt_component.ui.fragment.impl.ABaseFragment;

/**
 * Created on 4/27/2016 : 7:55 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentProfileFollowers extends ABaseFragment {

    @Bind(R.id.listProfileFollowers)
    ListView listView;

    private ProfileFollowersAdapter profileFollowersAdapter;

    @Override
    public String getFragmentTitle() {
        return "Fragment Profile Followers";
    }

    @Override
    public void initWidget() {
        profileFollowersAdapter = new ProfileFollowersAdapter(getActivity());
        listView.setAdapter(profileFollowersAdapter);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_profile_followers;
    }
}
