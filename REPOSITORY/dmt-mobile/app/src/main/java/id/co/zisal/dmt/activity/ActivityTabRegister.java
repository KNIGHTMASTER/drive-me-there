package id.co.zisal.dmt.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.BindString;
import id.co.zisal.dmt.R;

import id.co.zisal.dmt.fragment.register.FragmentRegisterUser;
import id.co.zisal.dmt.fragment.register.FragmentRegisterWorkshop;
import id.co.zisal.dmt_common.constant.GeneralConstant;
import id.co.zisal.dmt_component.ui.activity.base.ABaseActivity;
import id.co.zisal.dmt_component.ui.adapter.TabPagerItem;
import id.co.zisal.dmt_component.ui.adapter.ViewPagerAdapter;

/**
 * Created on 3/25/2016 : 10:53 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ActivityTabRegister extends ABaseActivity{

    @Bind(R.id.toolbarActTabRegister)
    Toolbar toolbar;

    @Bind(R.id.tabsRegister)
    TabLayout tabLayout;

    @Bind(R.id.viewpagerRegister)
    ViewPager viewPager;

    @BindString(R.string.registration)
    String registrationWord;

    @BindString(R.string.workshop_upper)
    String workshopWord;

    @BindString(R.string.user_upper)
    String userWord;

    @BindColor(R.color.white)
    ColorStateList white;


    @Override
    public void initWidget() {
        toolbar.setTitle(registrationWord);
        setupToolBar();
    }

    private void setupToolBar(){
        toolbar.setTitle(GeneralConstant.Punctuation.EMPTY);
        setSupportActionBar(toolbar);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(white);
    }

    private void setupViewPager(ViewPager viewPager) {
        List<TabPagerItem> tabPagerItems = new ArrayList<>();
        tabPagerItems.add(new TabPagerItem(userWord, new FragmentRegisterUser()));
        tabPagerItems.add(new TabPagerItem(workshopWord, new FragmentRegisterWorkshop()));
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), tabPagerItems);
        viewPager.setAdapter(adapter);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.activity_tab_register;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try{
            if (data.getAction().equals("workshop")){
                viewPager.setCurrentItem(1);
            }
        }catch (Exception ignored){
        }
    }
}
