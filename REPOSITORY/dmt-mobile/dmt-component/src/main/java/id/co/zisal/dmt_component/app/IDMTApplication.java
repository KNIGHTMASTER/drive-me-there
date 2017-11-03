package id.co.zisal.dmt_component.app;

import android.content.Context;

/**
 * <P>
 *     Initiating Base Application <code>Context</code>
 * </P>
 *
 * Created on 9/28/2015 : 7:54 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IDMTApplication {

    /**
     * <p>
     *     Retrieve Base
     * </p>
     * @return Context Base <code>Context</code> of Application
     */
    Context getContext();

    /**
     * <p>
     *     Initiating base components for Application as Required below :
     *     <oL>
     *         <li>Setup Database to be Writable</li>
     *         <li>Retrieve Dynamic Configuration from Database otherwise initiate the default one</li>
     *     </oL>
     * </p>
     */
    void initBaseApplicationComponents();

    /**
     * <p>
     *     Initiating default user from ORM <code>ModelUser</code>
     *     otherwise initiate the default one
     * </p>
     */
    void initDefaultUser();
    
}
