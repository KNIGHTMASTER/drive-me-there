package id.co.zisal.dmt_component.ui.adapter;

import android.support.v4.app.Fragment;

/**
 * <p>
 *     Paging Tab View
 * </p>
 */
public class TabPagerItem {

    private final CharSequence mTitle;
    private final Fragment mFragment;

    public TabPagerItem(CharSequence p_Title, Fragment p_Fragment) {
        this.mTitle = p_Title;
        this.mFragment = p_Fragment;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public CharSequence getTitle() {
        return mTitle;
    }
}
