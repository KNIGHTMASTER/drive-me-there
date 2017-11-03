package id.co.zisal.dmt.fragment.notification;

import id.co.zisal.dmt.R;
import id.co.zisal.dmt_component.ui.fragment.impl.ABaseFragment;

import butterknife.BindString;

/**
 * Created on 3/5/2016 : 3:33 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentWorkshopDetail extends ABaseFragment {

    @BindString(R.string.detail) String strDetail;

    @Override
    public String getFragmentTitle() {
        return strDetail;
    }

    @Override
    public void initWidget() {

    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_workshop_detail;
    }
}
