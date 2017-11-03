package id.co.zisal.dmt_dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import javax.inject.Inject;

import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_model.ModelCustomer;
import id.co.zisal.dmt_model.ModelDynamicConfiguration;
import id.co.zisal.dmt_model.ModelUser;

/**
 * <p>
 *     Helper <code>class</code> to access database
 * </p>
 * Created on 6/4/2015 : 9:58 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public class DAOHelper extends OrmLiteSqliteOpenHelper{

    private Dao genericDAO;

    @Inject
    public DAOHelper(Context p_Context) {
        super(p_Context, ApplicationConstant.Database.DATABASE_NAME, null, ApplicationConstant.Database.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, ModelCustomer.class);
            TableUtils.createTable(connectionSource, ModelDynamicConfiguration.class);
            TableUtils.createTable(connectionSource, ModelUser.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.createTable(connectionSource, ModelCustomer.class);
            TableUtils.dropTable(connectionSource, ModelDynamicConfiguration.class, true);
            TableUtils.dropTable(connectionSource, ModelUser.class, true);
            onCreate(database, connectionSource);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public Dao getGenericDAO(Class p_DATA) {
        try{
            genericDAO = getDao(p_DATA);
        }catch (Exception e){
            e.printStackTrace();
        }
         return genericDAO;
    }


}
