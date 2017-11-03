package id.co.zisal.am_component.ui.util;

import android.widget.TextView;

/**
 * Created on 10/11/2015 : 8:17 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TextViewManipulator {

    public void setEnableTextView(TextView[] textViews, boolean enabled){
        for(TextView textView: textViews){
            textView.setEnabled(enabled);
        }
    }
}
