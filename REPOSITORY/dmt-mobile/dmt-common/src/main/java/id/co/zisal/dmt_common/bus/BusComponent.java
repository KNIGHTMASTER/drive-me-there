package id.co.zisal.dmt_common.bus;

import android.app.Activity;
import android.app.Fragment;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * <p>
 *     Instead of using {@link BusProvider},
 *     if capable recommended using injection,
 *     with this {@link BusComponent}
 * </p>
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * Created on 2/21/2016 : 5:25 PM.
 */
@Singleton
@Component(modules = BusModule.class)
public interface BusComponent {

    void inject(Activity activity);

    void inject(Fragment fragment);

    Bus provideBus();
}
