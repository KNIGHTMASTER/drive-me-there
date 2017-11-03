package id.co.zisal.dmt.fragment.notification;

import android.app.Dialog;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.OnClick;
import id.co.zisal.dmt.R;
import id.co.zisal.dmt_component.ui.fragment.impl.ABaseFragment;

import butterknife.BindString;

/**
 * Created on 3/5/2016 : 3:33 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentWorkshopPosts extends ABaseFragment {

    @BindString(R.string.posts) String strPosts;

    @Override
    public String getFragmentTitle() {
        return strPosts;
    }

    @Override
    public void initWidget() {

    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_workshop_posts;
    }

    @OnClick(R.id.txtPosts)
    public void sign(){
/*        LinearLayout linearLayout = (LinearLayout) getActivity().findViewById(R.id.socialMediaBlock);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_sign);
                dialog.setTitle("Please Sign In...");
            }
        });*/
    }
}
