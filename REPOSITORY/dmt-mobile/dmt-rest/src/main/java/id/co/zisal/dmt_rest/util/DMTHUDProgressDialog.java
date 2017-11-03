package id.co.zisal.dmt_rest.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.zisal.dmt_common.constant.GeneralConstant;
import id.co.zisal.dmt_rest.R;

/**
 * Created on 10/7/2015 : 4:04 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DMTHUDProgressDialog extends Dialog {

    public DMTHUDProgressDialog(Context p_Context) {
        super(p_Context);
    }

    public DMTHUDProgressDialog(Context p_Context, int p_Theme) {
        super(p_Context, p_Theme);
    }

    public void onWindowFocusChanged(boolean hasFocus){
        ImageView imageView = (ImageView) findViewById(R.id.spinnerImageView);
        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
        spinner.start();
    }

    public void setMessage(CharSequence p_Message) {
        if(p_Message != null && p_Message.length() > 0) {
            findViewById(R.id.message).setVisibility(View.VISIBLE);
            TextView txt = (TextView)findViewById(R.id.message);
            txt.setText(p_Message);
            txt.invalidate();
        }
    }

    public static DMTHUDProgressDialog show(Context p_Context, CharSequence p_Message, boolean p_Cancelable, OnCancelListener p_CancelListener) {
        DMTHUDProgressDialog dialog = new DMTHUDProgressDialog(p_Context,R.style.ProgressHUD);
        dialog.setTitle(GeneralConstant.Punctuation.EMPTY);
        dialog.setContentView(R.layout.progress_hud);
        if(p_Message == null || p_Message.length() == 0) {
            dialog.findViewById(R.id.message).setVisibility(View.GONE);
        } else {
            TextView txt = (TextView)dialog.findViewById(R.id.message);
            txt.setText(p_Message);
        }
        dialog.setCancelable(p_Cancelable);
        dialog.setOnCancelListener(p_CancelListener);
        dialog.getWindow().getAttributes().gravity= Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount=0.2f;
        dialog.getWindow().setAttributes(lp);
        /*dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);*/
        return dialog;
    }
}
