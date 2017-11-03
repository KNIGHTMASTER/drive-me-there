package id.co.zisal.dmt_rest.util;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created on 10/7/2015 : 10:49 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CommonProgressDialog extends ProgressDialog {

    public CommonProgressDialog(Context context, String title, String message, boolean cancellable) {
        super(context);
        display(title, message, cancellable);
    }

    public void display(String title, String message, boolean cancellable){
        this.setTitle(title);
        this.setMessage(message);
        this.setCancelable(cancellable);
    }
}
