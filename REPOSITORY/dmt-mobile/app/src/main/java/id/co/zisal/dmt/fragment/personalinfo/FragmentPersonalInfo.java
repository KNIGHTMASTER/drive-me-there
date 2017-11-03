package id.co.zisal.dmt.fragment.personalinfo;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindString;
import id.co.zisal.dmt.R;
import id.co.zisal.dmt_component.ui.fragment.impl.ABaseFragment;

import butterknife.Bind;
import id.co.zisal.dmt_component.ui.util.TextViewManipulator;
import id.co.zisal.dmt_dao.impl.DAOUser;
import id.co.zisal.dmt_model.ModelUser;

/**
 * Created on 9/28/2015 : 9:17 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentPersonalInfo extends ABaseFragment {

    @Bind(R.id.imgSalesPersonal)
    ImageView imgSalesPersonal;

    @Bind(R.id.txtMyName)
    EditText txtMyName;

    @Bind(R.id.txtMyNickName)
    EditText txtMyNickName;

    @Bind(R.id.txtMyMachine)
    EditText txtMyMachine;

    @BindString(R.string.fragment_personal_info_title)
    String titleFragmetPersonalInfo;

    @Override
    public String getFragmentTitle() {
        return titleFragmetPersonalInfo;
    }

    @Override
    public void initWidget() {
        this.imgSalesPersonal.setImageResource(R.drawable.ic_user);
        DAOUser daoUser = new DAOUser(getActivity());
        ModelUser modelUser = (ModelUser) daoUser.getAllData().get(0);
        txtMyName.setText(modelUser.getUserName());
        txtMyNickName.setText(titleFragmetPersonalInfo);
        txtMyMachine.setText(titleFragmetPersonalInfo);
        TextViewManipulator textViewManipulator = new TextViewManipulator();
        textViewManipulator.setEnableTextView(new TextView[]{txtMyName, txtMyNickName, txtMyMachine}, false);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_personal_info;
    }

}
