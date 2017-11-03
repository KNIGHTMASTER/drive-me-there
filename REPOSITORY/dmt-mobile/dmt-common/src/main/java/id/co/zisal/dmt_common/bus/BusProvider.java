package id.co.zisal.dmt_common.bus;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * <p>
 *      Bus provider for any communication looks like Observer Design Pattern.
 *      different parts of the application implemented the interface and performed registration and
 *      un registration on the listener where appropriate.
 * </p>
 *
 * <p>
 *      But, this is in more elegant way.
 *      Because each component implementing the interface does not contained
 *      a hard dependency on provider for registering the listener.
 * </p>
 *
 * Created on 2/10/2016 : 10:00 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public final class BusProvider {

    private static final Bus BUS = new Bus(ThreadEnforcer.ANY);

    /**
     * @return Bus as a singleton instance
     */
    public static Bus getInstance(){
        return BUS;
    }

    private BusProvider(){
        /*No Instances*/
    }
}
