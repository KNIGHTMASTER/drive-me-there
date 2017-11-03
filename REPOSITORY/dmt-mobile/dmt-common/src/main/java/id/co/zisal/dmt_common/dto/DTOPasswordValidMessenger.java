package id.co.zisal.dmt_common.dto;

import org.parceler.Parcel;

/**
 * <p>
 *     Common Data Transfer Object to handle password validation in lower level
 * </p>
 *
 * Created on 1/19/2015.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class DTOPasswordValidMessenger{

    private String message;

    private boolean result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String p_Message) {
        this.message = p_Message;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean p_Result) {
        this.result = p_Result;
    }
}
