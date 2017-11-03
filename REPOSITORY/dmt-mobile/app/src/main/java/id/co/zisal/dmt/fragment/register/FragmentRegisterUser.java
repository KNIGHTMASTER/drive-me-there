package id.co.zisal.dmt.fragment.register;

import android.widget.Toast;

import com.nispok.snackbar.Snackbar;

import butterknife.Bind;
import butterknife.OnClick;
import id.co.zisal.dmt.R;
import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_common.constant.GeneralConstant;
import id.co.zisal.dmt_common.util.GeneralValidation;
import id.co.zisal.dmt_component.ui.fragment.impl.ABaseFragment;
import id.co.zisal.dmt_component.ui.view.FloatLabeledEditText;
import id.co.zisal.dmt_rest.dto.request.register.DTORequestRegister;
import id.co.zisal.dmt.action.register.IRegister;
import id.co.zisal.dmt.action.register.impl.ParamRegister;
import id.co.zisal.dmt.action.register.impl.RegisterUser;
import id.co.zisal.dmt_util.network.NetworkComponent;

/**
 * Created on 3/25/2016 : 10:56 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentRegisterUser extends ABaseFragment {

    @Bind(R.id.txtUserName)
    FloatLabeledEditText txtUserName;

    @Bind(R.id.txtPassword)
    FloatLabeledEditText txtPassword;

    @Bind(R.id.txtEmail)
    FloatLabeledEditText txtEmail;

    GeneralValidation generalValidation;

    IRegister iRegister;

    @Override
    public String getFragmentTitle() {
        return GeneralConstant.Punctuation.EMPTY;
    }

    @Override
    public void initWidget() {
        generalValidation = new GeneralValidation();
        iRegister = new RegisterUser();
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_register_user;
    }

    @OnClick(R.id.lblRegister)
    public void doRegisterUser(){
        String userName;
        String password;
        String email;
        if (!generalValidation.isEmptyEditText(txtUserName.getEditText())){
            userName = txtUserName.getEditText().getText().toString().trim();
            if (!generalValidation.isEmptyEditText(txtPassword.getEditText())){
                password = txtPassword.getEditText().getText().toString().trim();
                if (!generalValidation.isEmptyEditText(txtEmail.getEditText())){
                    String rawEmail = txtEmail.getEditText().getText().toString().trim();
                    if (generalValidation.isValidEmail(rawEmail)){
                        email = rawEmail;
                        registerProcess(userName, password, email);
                    }else {
                        Toast.makeText(getContext(), R.string.email_format_not_valid, Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getContext(), R.string.email_empty, Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getContext(), R.string.password_empty, Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getContext(), R.string.user_name_empty, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void injectNetworkComponent(NetworkComponent p_NetworkComponent) {
        p_NetworkComponent.inject(getActivity().getApplicationContext());
    }

    private void registerProcess(String p_UserName, String p_Password, String p_Email){
        ParamRegister paramRegister = new ParamRegister();

        DTORequestRegister dtoRequestRegister = new DTORequestRegister();
        dtoRequestRegister.setUserName(p_UserName);
        dtoRequestRegister.setPassword(p_Password);
        dtoRequestRegister.setEmail(p_Email);
        dtoRequestRegister.setUserType(ApplicationConstant.UserType.USER);

        paramRegister.setActivity(getActivity());
        paramRegister.setDtoRequestRegister(dtoRequestRegister);

        iRegister.setParam(paramRegister);
        if (networkComponent.provideNetworkConnectivity().isConnected()){
            iRegister.doRegister();
        }else {
            Snackbar.with(getActivity()).text(R.string.simple_internet_unavailable).show(getActivity());
        }
    }
}

