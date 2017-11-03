package id.co.zisal.dmt_util.preference;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * <p>
 *     Injection module for {@link SharedPreferences}
 * </p>
 *
 * Created on 2/8/2016 : 9:39 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Module
public class PreferenceModule {

    private final Application application;

    public PreferenceModule(Application p_Application) {
        this.application = p_Application;
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
