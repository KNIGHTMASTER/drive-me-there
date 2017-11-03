package id.co.zisal.dmt_component.ui.handler.login;

import android.content.Context;
import android.widget.EditText;

/**
 * Created on 9/30/2015 : 5:42 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * Handling login screen
 * @param <SUCCESS>
 */
public interface ILoginHandler<SUCCESS> extends ILogin{

    /**
     * Getting context from Login Activity
     * @return Context
     */
    Context getContext();

    /**
     * Getting EditText for user name
     * @return EditText
     */
    EditText getTxtUserName();

    /**
     * Getting EditText for password
     * @return EditText
     */
    EditText getTxtPassword();

    Class<SUCCESS> getSuccessClass();
}
