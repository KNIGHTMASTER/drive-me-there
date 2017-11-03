package id.co.zisal.dmt.fragment.register;

import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.nispok.snackbar.Snackbar;

import butterknife.Bind;
import butterknife.OnClick;
import id.co.zisal.dmt.R;
import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_common.constant.GeneralConstant.Punctuation;
import id.co.zisal.dmt_common.util.GeneralConverter;
import id.co.zisal.dmt_common.util.GeneralValidation;
import id.co.zisal.dmt_component.ui.fragment.impl.ABaseFragment;
import id.co.zisal.dmt_component.ui.view.FloatLabeledEditText;
import id.co.zisal.dmt_rest.dto.request.register.DTORequestRegister;
import id.co.zisal.dmt.action.register.IRegister;
import id.co.zisal.dmt.action.register.impl.ParamRegister;
import id.co.zisal.dmt.action.register.impl.RegisterWorkshop;
import id.co.zisal.dmt_util.network.NetworkComponent;

/**
 * Created on 3/25/2016 : 10:56 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FragmentRegisterWorkshop extends ABaseFragment {

    private static final int PLACE_PICKER_REQUEST = 1;

    private static final LatLngBounds BOUNDS_CERTAIN_LOCATION = new LatLngBounds(
            new LatLng(37.398160, -122.180831), new LatLng(37.430610, -121.972090));

    @Bind(R.id.txtUserName)
    FloatLabeledEditText txtUserName;

    @Bind(R.id.txtPassword)
    FloatLabeledEditText txtPassword;

    @Bind(R.id.txtEmail)
    FloatLabeledEditText txtEmail;

    @Bind(R.id.txtWorkshopLocation)
    FloatLabeledEditText txtWorkshopLocation;

    GeneralValidation generalValidation;
    GeneralConverter generalConverter;

    IRegister iRegister;

    @Override
    public String getFragmentTitle() {
        return Punctuation.EMPTY;
    }

    @Override
    public void initWidget() {
        generalValidation = new GeneralValidation();
        generalConverter = new GeneralConverter();
        iRegister = new RegisterWorkshop();
        txtWorkshopLocation.setEnabled(false);
        txtWorkshopLocation.getEditText().setEnabled(false);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_register_workshop;
    }

    @OnClick(R.id.btSelectWorkshopLocation)
    public void selectWorkshopLocation(){
        try {
            PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
            intentBuilder.setLatLngBounds(BOUNDS_CERTAIN_LOCATION);
            Intent intent = intentBuilder.build(getActivity());
            startActivityForResult(intent, PLACE_PICKER_REQUEST);

        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        data.setAction("workshop");
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(ApplicationConstant.LogTag.DMT_INFO, "Request Code : " + requestCode);
        Log.i(ApplicationConstant.LogTag.DMT_INFO, "Result Code : "+resultCode);
        Log.i(ApplicationConstant.LogTag.DMT_INFO, "Intent Action : "+data.getAction());
        if (requestCode == PLACE_PICKER_REQUEST
                && resultCode == Activity.RESULT_OK) {

            final Place place = PlacePicker.getPlace(getActivity(), data);
            final CharSequence name = place.getName();
            final CharSequence address = place.getAddress();
            String attributions = (String) place.getAttributions();
            if (attributions == null) {
                attributions = "";
            }
            Log.i(ApplicationConstant.LogTag.DMT_INFO, "Name : ".concat(generalConverter.charSequenceToString(name)));
            Log.i(ApplicationConstant.LogTag.DMT_INFO, "Address : ".concat(generalConverter.charSequenceToString(address)));
            String location = name.toString().concat(Punctuation.EMPTY).concat(address.toString().concat(Punctuation.EMPTY).concat(Html.fromHtml(attributions).toString()));
            Log.i(ApplicationConstant.LogTag.DMT_INFO, "Location : ".concat(location));
            txtWorkshopLocation.setText(location);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
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
        dtoRequestRegister.setUserType(ApplicationConstant.UserType.WORKSHOP);

        paramRegister.setActivity(getActivity());
        paramRegister.setDtoRequestRegister(dtoRequestRegister);

        iRegister.setParam(paramRegister);

        if (networkComponent.provideNetworkConnectivity().isConnected()){
            iRegister.doRegister();
        }else {
            Snackbar.with(getActivity()).text(R.string.simple_internet_unavailable).show(getActivity());
        }iRegister.doRegister();
    }
}

