package id.co.zisal.dmt.fragment.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.nhaarman.listviewanimations.appearance.StickyListHeadersAdapterDecorator;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.util.StickyListHeadersListViewWrapper;

import butterknife.Bind;
import butterknife.ButterKnife;
import id.co.zisal.dmt.R;
import id.co.zisal.dmt_component.app.base.ADMTApplication;
import id.co.zisal.dmt_component.ui.fragment.impl.ABaseFragment;
import id.co.zisal.dmt_component.ui.fragment.impl.NavigatorFragment;
import id.co.zisal.dmt_component.ui.util.DummyContent;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created on 4/27/2016 : 7:55 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentProfilePost extends ABaseFragment {

    @Bind(R.id.activity_stickylistheaders_listview)
    StickyListHeadersListView listView;

    @Override
    public String getFragmentTitle() {
        return "Fragment Profile Post";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try{
            LinearLayout wrapper = new LinearLayout(getActivity());
            rootView = inflater.inflate( getViewLayoutId(), wrapper, true );
        }catch ( Exception e ){
            if ( container != null ){
                container.removeView( rootView );
            }
            try{
                rootView = inflater.inflate(getViewLayoutId(), container, false);
            }catch (InflateException ie){
                e.printStackTrace();
            }
        }
        getActivity().setTitle(getFragmentTitle());
        ButterKnife.bind(this, rootView);

        networkComponent = ((ADMTApplication)getActivity().getApplication()).getNetworkComponent();
        injectNetworkComponent(networkComponent);
        daoComponent = ((ADMTApplication)getActivity().getApplication()).getDaoComponent();
        injectDAOComponent(daoComponent);

        navigatorFragment = new NavigatorFragment() {
            @Override
            public FragmentActivity getFragmentActivity() {
                return getActivity();
            }
        };

        super.initializeFragment();

        rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT ));
        return rootView;
    }

    @Override
    public void initWidget() {
        listView.setFitsSystemWindows(true);

        AlphaInAnimationAdapter animationAdapter;
        UserPostHeaderAdapter adapterSocial = new UserPostHeaderAdapter(
                getActivity(), DummyContent.getDummyModelList());
        animationAdapter = new AlphaInAnimationAdapter(adapterSocial);
        StickyListHeadersAdapterDecorator stickyListHeadersAdapterDecorator = new StickyListHeadersAdapterDecorator(
                animationAdapter);
        stickyListHeadersAdapterDecorator
                .setListViewWrapper(new StickyListHeadersListViewWrapper(
                        listView));
        assert animationAdapter.getViewAnimator() != null;
        animationAdapter.getViewAnimator().setInitialDelayMillis(500);
        assert stickyListHeadersAdapterDecorator.getViewAnimator() != null;
        stickyListHeadersAdapterDecorator.getViewAnimator()
                .setInitialDelayMillis(500);
        listView.setAdapter(stickyListHeadersAdapterDecorator);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_profile_post;
    }
}
