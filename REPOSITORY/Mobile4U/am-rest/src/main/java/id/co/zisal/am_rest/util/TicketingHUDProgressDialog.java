package id.co.zisal.am_rest.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.zisal.am_common.constant.GeneralConstant;
import id.co.zisal.am_rest.R;

/**
 * Created on 10/7/2015 : 4:04 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TicketingHUDProgressDialog extends Dialog {

    public TicketingHUDProgressDialog(Context context) {
        super(context);
    }

    public TicketingHUDProgressDialog(Context context, int theme) {
        super(context, theme);
    }


    public void onWindowFocusChanged(boolean hasFocus){
        ImageView imageView = (ImageView) findViewById(R.id.spinnerImageView);
        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
        spinner.start();
    }

    public void setMessage(CharSequence message) {
        if(message != null && message.length() > 0) {
            findViewById(R.id.message).setVisibility(View.VISIBLE);
            TextView txt = (TextView)findViewById(R.id.message);
            txt.setText(message);
            txt.invalidate();
        }
    }

    public static TicketingHUDProgressDialog show(Context context, CharSequence message, boolean cancelable, OnCancelListener cancelListener) {
        TicketingHUDProgressDialog dialog = new TicketingHUDProgressDialog(context,R.style.ProgressHUD);
        dialog.setTitle(GeneralConstant.Punctuation.EMPTY);
        dialog.setContentView(R.layout.progress_hud);
        if(message == null || message.length() == 0) {
            dialog.findViewById(R.id.message).setVisibility(View.GONE);
        } else {
            TextView txt = (TextView)dialog.findViewById(R.id.message);
            txt.setText(message);
        }
        dialog.setCancelable(cancelable);
        dialog.setOnCancelListener(cancelListener);
        dialog.getWindow().getAttributes().gravity= Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount=0.2f;
        dialog.getWindow().setAttributes(lp);
        /*dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);*/
        return dialog;
    }
}
