package id.co.zisal.dmt.action.register.impl;

import android.app.Activity;

import org.parceler.Parcel;

import id.co.zisal.dmt_rest.dto.request.register.DTORequestRegister;

/**
 * Created on 4/5/2016 : 12:33 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class ParamRegister {
    Activity activity;
    DTORequestRegister dtoRequestRegister;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public DTORequestRegister getDtoRequestRegister() {
        return dtoRequestRegister;
    }

    public void setDtoRequestRegister(DTORequestRegister dtoRequestRegister) {
        this.dtoRequestRegister = dtoRequestRegister;
    }

    @Override
    public String toString() {
        return "ParamRegisterUser{" +
                "activity=" + activity +
                ", dtoRequestRegister=" + dtoRequestRegister +
                '}';
    }
}
