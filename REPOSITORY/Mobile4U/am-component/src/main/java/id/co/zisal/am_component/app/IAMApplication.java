package id.co.zisal.am_component.app;

import android.content.Context;

/**
 * Created on 9/28/2015 : 7:54 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IAMApplication {

    Context getContext();

    void initBaseApplicationComponents();

    void initDefaultUser();
    
}
