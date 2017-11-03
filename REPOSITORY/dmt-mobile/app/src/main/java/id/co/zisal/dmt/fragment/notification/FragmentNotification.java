package id.co.zisal.dmt.fragment.notification;

import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindColor;
import id.co.zisal.dmt.R;
import id.co.zisal.dmt_common.constant.GeneralConstant;
import id.co.zisal.dmt_component.ui.adapter.TabPagerItem;
import id.co.zisal.dmt_component.ui.adapter.ViewPagerAdapter;
import id.co.zisal.dmt_component.ui.fragment.impl.ABaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindString;

/**
 * Created on 9/28/2015 : 9:17 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentNotification extends ABaseFragment {

    @BindString(R.string.posts) String strSumPosting;
    @BindString(R.string.location) String strLocation;
    @BindString(R.string.route) String strRoute;
    @BindString(R.string.detail) String strDetail;

    @BindColor(R.color.white) ColorStateList white;

    @Bind(R.id.toolbarNotification) Toolbar toolbarNotification;
    @Bind(R.id.tabsNotification) TabLayout tabLayout;
    @Bind(R.id.viewpagerNotification) ViewPager viewPager;

    @Override
    public String getFragmentTitle() {
        return GeneralConstant.Punctuation.EMPTY;
    }

    @Override
    public void initWidget() {
        setupToolBar();
    }

    private void setupViewPager(ViewPager viewPager) {
        List<TabPagerItem> tabPagerItems = new ArrayList<>();
        tabPagerItems.add(new TabPagerItem(strSumPosting, new FragmentWorkshopPosts()));
        tabPagerItems.add(new TabPagerItem(strDetail, new FragmentWorkshopDetail()));
        tabPagerItems.add(new TabPagerItem(strLocation, new FragmentWorkshopLocation()));
        tabPagerItems.add(new TabPagerItem(strRoute, new FragmentWorkshopRoute()));
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager(), tabPagerItems);
        viewPager.setAdapter(adapter);
    }

    private void setupToolBar(){
        toolbarNotification.setTitle(GeneralConstant.Punctuation.EMPTY);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbarNotification);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(white);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_notification;
    }


}
