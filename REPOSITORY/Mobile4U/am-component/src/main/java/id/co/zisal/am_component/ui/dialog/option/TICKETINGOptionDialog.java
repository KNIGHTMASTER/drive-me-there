package id.co.zisal.am_component.ui.dialog.option;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import id.co.zisal.am_common.component.ITicketingComponent;

/**
 * Created by Achmad Fauzi on 6/4/2015 : 10:03 PM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class TICKETINGOptionDialog implements ITICKETINGOption, ITicketingComponent<Activity> {

    private Activity activity;

    public void buildAndShow(String message, String title, String positiveButton, String negativeButton){
        AlertDialog.Builder builder = new AlertDialog.Builder(getParameter());
        builder.setMessage(message)
                .setTitle(title);
        builder.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                onClickPositive();
            }
        });
        builder.setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                onClickNegative();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void setParameter(Activity _param) {
        this.activity = _param;
    }

    @Override
    public Activity getParameter() {
        return activity;
    }
}
