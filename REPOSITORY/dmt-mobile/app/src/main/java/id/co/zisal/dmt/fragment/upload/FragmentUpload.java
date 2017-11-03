package id.co.zisal.dmt.fragment.upload;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import id.co.zisal.dmt.R;
import id.co.zisal.dmt_common.constant.GeneralConstant;
import id.co.zisal.dmt_component.ui.fragment.impl.ABaseFragment;

import butterknife.Bind;

/**
 * Created on 9/28/2015 : 9:17 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentUpload extends ABaseFragment {

    @Bind(R.id.toolbarUpload)
    Toolbar toolbarUpload;

    @Override
    public String getFragmentTitle() {
        return GeneralConstant.Punctuation.EMPTY;
    }

    @Override
    public void initWidget() {
        toolbarUpload.setTitle(GeneralConstant.Punctuation.EMPTY);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbarUpload);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_upload;
    }

}
