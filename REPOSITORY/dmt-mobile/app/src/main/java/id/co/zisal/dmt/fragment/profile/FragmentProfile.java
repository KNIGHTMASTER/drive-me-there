package id.co.zisal.dmt.fragment.profile;

import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.OnClick;
import id.co.zisal.dmt.R;
import id.co.zisal.dmt.activity.ActivityLogin;
import id.co.zisal.dmt_component.ui.adapter.TabPagerItem;
import id.co.zisal.dmt_component.ui.adapter.ViewPagerAdapter;
import id.co.zisal.dmt_component.ui.fragment.impl.ABaseFragment;
import id.co.zisal.dmt_component.ui.handler.logut.LogoutHandler;

/**
 * Created on 9/28/2015 : 9:17 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentProfile extends ABaseFragment {

    @Bind(R.id.tabsProfile) TabLayout tabLayout;
    @Bind(R.id.viewpagerProfile) ViewPager viewPager;

    @BindColor(R.color.white) ColorStateList white;

    @BindString(R.string.profile) String titleFragmentProfile;
    @BindString(R.string.post) String postWord;
    @BindString(R.string.following) String followingWord;
    @BindString(R.string.follower) String followerWord;

    /*@Bind(R.id.toolbarMainProfile)
    Toolbar toolbarProfile;*/

    @Override
    public String getFragmentTitle() {
        return titleFragmentProfile;
    }

    @Override
    public void initWidget() {
        /*toolbarProfile.setTitle(GeneralConstant.Punctuation.EMPTY);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbarProfile);*/

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(white);
    }

    private void setupViewPager(ViewPager viewPager) {
        List<TabPagerItem> tabPagerItems = new ArrayList<>();
        tabPagerItems.add(new TabPagerItem(postWord, new FragmentProfilePost()));
        tabPagerItems.add(new TabPagerItem(followingWord, new FragmentProfileFollowing()));
        tabPagerItems.add(new TabPagerItem(followerWord, new FragmentProfileFollowers()));
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), tabPagerItems);
        viewPager.setAdapter(adapter);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_profile;
    }

    @OnClick(R.id.btSignOut)
    public void signOut(){
        new LogoutHandler(
                getActivity(),
                navigatorFragment,
                ActivityLogin.class
        ).doLogOut();
    }

}
