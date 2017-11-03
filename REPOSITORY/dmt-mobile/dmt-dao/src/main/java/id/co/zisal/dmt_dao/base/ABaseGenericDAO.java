package id.co.zisal.dmt_dao.base;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_dao.DAOHelper;
import id.co.zisal.dmt_dao.IGenericDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 *      Every single DAO will be inherited from this Super <code>Class</code>
 *      to avoid code boiler plate
 * </p>
 *
 * @param <DATA> an Object Relational Mapping (ORM)
 *
 * Created on 9/22/2015 : 7:39 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ABaseGenericDAO<DATA> implements IGenericDAO<DATA> {

    private DAOHelper daoHelper;
    private Dao dao;
    private String modelName;

    public DAOHelper getDaoHelper() {
        return daoHelper;
    }

    public ABaseGenericDAO(Context ctx) {
        daoHelper = new DAOHelper( ctx);
        if(dao == null){
            dao = getDaoHelper().getGenericDAO(getModelClass());
        }
        modelName = getModelClass().getSimpleName();
    }


    @Override
    public int insertEntity(DATA p_Entity) {
        int result = 0;
        try {
            result = dao.create((p_Entity));
            Log.i(ApplicationConstant.LogTag.DMT_INFO, "Successful insert ".concat(modelName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<DATA> getAllData() {
        List<DATA> result = null;
        try {
            result = dao.queryForAll();
            Log.i(ApplicationConstant.LogTag.DMT_INFO, "Successful select all ".concat(modelName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void updateEntity(DATA p_Entity) {
        try {
            dao.update(p_Entity);
            Log.i(ApplicationConstant.LogTag.DMT_INFO, "Successful update ".concat(modelName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEntity(Integer p_Id) {
        try {
            dao.deleteById(p_Id);
            Log.i(ApplicationConstant.LogTag.DMT_INFO, "Successful delete".concat(modelName).concat(" entity with id " + p_Id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeNativeCommand(String p_SqlCommand) {
        Log.d(ApplicationConstant.LogTag.DMT_INFO, p_SqlCommand);
        try{
            dao.executeRaw(p_SqlCommand);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<DATA> getListDataFromQuery(String p_Field, String p_Value) {
        QueryBuilder<DATA, Integer> queryBuilder;
        PreparedQuery<DATA> preparedQuery;
        List<DATA> result = null;
        try {
            queryBuilder = dao.queryBuilder();
            queryBuilder.where().eq(p_Field, p_Value);
            preparedQuery = queryBuilder.prepare();
            result = dao.query(preparedQuery);
            Log.i(ApplicationConstant.LogTag.DMT_INFO, "Successful select where ? ".concat(modelName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result != null) {
            if(result.size() == 0)
                return null;
        }
        return result;
    }

    @Override
    public DATA getSingleDataFromQuery(String p_Field, String p_Value) {
        DATA result = null;
        try{
            result = getListDataFromQuery(p_Field, p_Value).get(0);
            Log.i(ApplicationConstant.LogTag.DMT_INFO, "Successful select first data from ".concat(modelName));
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
