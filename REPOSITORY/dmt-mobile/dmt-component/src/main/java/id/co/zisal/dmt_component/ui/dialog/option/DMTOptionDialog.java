package id.co.zisal.dmt_component.ui.dialog.option;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import id.co.zisal.dmt_common.component.IDMTComponent;

/**
 * <p>
 *     A Utility to display Option Dialog within a fragment or activity
 * </p>
 *
 * Created by Achmad Fauzi on 6/4/2015 : 10:03 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class DMTOptionDialog implements IDMTOption, IDMTComponent<Activity> {

    private Activity activity;

    /**
     * <p>
     *      Generate and display Option Dialog within a <code>Fragment</code> or <code>Activit</code>c
     * </p>
     *
     * @param p_Message message to display
     * @param p_Title title to display
     * @param p_PositiveButton generated positive Button
     * @param p_NegativeButton generated negative Button
     */
    public void buildAndShow(String p_Message, String p_Title, String p_PositiveButton, String p_NegativeButton){
        AlertDialog.Builder builder = new AlertDialog.Builder(getParameter());
        builder.setMessage(p_Message)
                .setTitle(p_Title);
        builder.setPositiveButton(p_PositiveButton, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                onClickPositive();
            }
        });
        builder.setNegativeButton(p_NegativeButton, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                onClickNegative();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void setParameter(Activity p_Param) {
        this.activity = p_Param;
    }

    @Override
    public Activity getParameter() {
        return activity;
    }
}
