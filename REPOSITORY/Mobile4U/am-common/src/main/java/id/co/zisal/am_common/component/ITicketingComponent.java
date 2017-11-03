package id.co.zisal.am_common.component;

/**
 * <p>
 *     This component is successor from <b>MFORCE MQA BACKGROUND</b> which is used
 *     to control setup an Object with Customized Component
 *     <code>PARAM</code> must be defined as POJO Object before using this interface
 * </p>
 * {@link java.lang.Object}
 * Created on 9/22/2015 : 4:19 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ITicketingComponent<PARAM> {

    void setParameter(PARAM _param);

    PARAM getParameter();
}


