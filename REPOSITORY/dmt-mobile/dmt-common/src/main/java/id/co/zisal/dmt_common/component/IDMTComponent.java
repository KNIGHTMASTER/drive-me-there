package id.co.zisal.dmt_common.component;

/**
 * <p>
 *     This component is successor from <b>Previous Project</b> which is used
 *     to control setup an Object with Customized Component
 *     <code>PARAM</code> must be defined as <code>POJO</code> Object
 *     before using this interface
 * </p>
 * @see java.lang.Object
 * Created on 9/22/2015 : 4:19 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IDMTComponent<PARAM> {

    /**
     * <p>
     *     setup an object parameter
     * </p>
     * @param p_Param any parameter of component
     */
    void setParameter(PARAM p_Param);

    /**
     * <p>
     *     retrieve an object parameter
     * </p>
     * @return PARAM
     */
    PARAM getParameter();
}


