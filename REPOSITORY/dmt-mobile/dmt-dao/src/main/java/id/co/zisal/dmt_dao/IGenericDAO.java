package id.co.zisal.dmt_dao;

import java.util.List;

/**
 * Created on 5/27/2015 : 12:00 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * @param <DATA>
 */
public interface IGenericDAO<DATA> {

    /**
     * <p>
     *     This function will add one entity which is 1 complete row in table
     * </p>
     * @param p_Entity DATA
     */
    int insertEntity(DATA p_Entity);

    /**
     * <p>
     *     This function will return all data from a table in an array list form
     * </p>
     * @return List<DATA>
     */
    List<DATA> getAllData();

    /**
     * <p>
     *     This function will update value from an entity
     * </p>
     *
     * @param p_Entity DATA
     */
    void updateEntity(DATA p_Entity);

    /**
     * <p>
     *     This function will delete entity in table
     * </p>
     *
     * @param p_Id Integer
     */
    void deleteEntity(Integer p_Id);

    /**
     * <p>
     *     This function will execute sql command
     * </p>
     *
     * @param p_SqlCommand String
     */
    void executeNativeCommand(String p_SqlCommand);

    /**
     * <p>
     *     This function will select one row from table with one condition only
     * </p>
     *
     * @param p_Field String
     * @param p_Value String
     * @return <DATA>
     */
    Object getSingleDataFromQuery(String p_Field, String p_Value);

    /**
     * <p>
     *     This function will select list rows from table with one condition only
     * </p>
     *
     * @param p_Field String
     * @param p_Value String
     * @return List<DATA>
     */
    List<DATA> getListDataFromQuery(String p_Field, String p_Value);

    /**
     * @return Class for name loading
     */
    Class<DATA> getModelClass();

}
