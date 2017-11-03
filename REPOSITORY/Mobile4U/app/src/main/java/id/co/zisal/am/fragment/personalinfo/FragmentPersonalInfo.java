package id.co.zisal.am.fragment.personalinfo;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.zisal.am_common.constant.ApplicationConstant;
import id.co.zisal.am_component.ui.fragment.impl.ANavigationDrawerFragment;
import id.co.zisal.am_component.ui.util.TextViewManipulator;
import id.co.zisal.am_dao.impl.DAOUser;
import id.co.zisal.am_model.ModelUser;
import id.co.zisal.am.R;

import butterknife.InjectView;

/**
 * Created on 9/28/2015 : 9:17 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentPersonalInfo extends ANavigationDrawerFragment {

    @InjectView(R.id.imgSalesPersonal)
    ImageView imgSalesPersonal;

    @InjectView(R.id.txtMyName)
    EditText txtMyName;

    @InjectView(R.id.txtMyNickName)
    EditText txtMyNickName;

    @InjectView(R.id.txtMyMachine)
    EditText txtMyMachine;

    @Override
    public String getFragmentTitle() {
        return ApplicationConstant.FragmentInfo.Title.PERSONAL_INFO;
    }

    @Override
    public void initWidget() {
        this.imgSalesPersonal.setImageResource(id.co.zisal.am_component.R.mipmap.ic_no_user);
        DAOUser daoUser = new DAOUser(getActivity());
        ModelUser modelUser = (ModelUser) daoUser.getAllData().get(0);
        txtMyName.setText(modelUser.getUserName());
        txtMyNickName.setText("Fauzi");
        txtMyMachine.setText("ABC123");
        TextViewManipulator textViewManipulator = new TextViewManipulator();
        textViewManipulator.setEnableTextView(new TextView[]{txtMyName, txtMyNickName, txtMyMachine}, false);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_personal_info;
    }

}
