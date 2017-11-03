package id.co.zisal.dmt_util.preference;

import android.app.Application;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;

/**
 * <p>
 *     Injector <code>Class</code> for {@link android.content.SharedPreferences}
 * </p>
 *
 * Created on 2/8/2016 : 9:40 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Singleton
@Component(modules = {PreferenceModule.class})
public interface PreferenceComponent {

    SharedPreferences provideSharedPreferences();

    void inject(Application p_Application);

}
