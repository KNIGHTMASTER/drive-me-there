package id.co.zisal.dmt_common.bus;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * <p>
 *     Injection module for {@link Bus}
 * </p>
 *
 * Created on 2/21/2016 : 5:25 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Module
public class BusModule {

    @Singleton
    @Provides
    Bus provideBus(){
        return new Bus(ThreadEnforcer.ANY);
    }
}
