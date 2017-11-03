package id.co.zisal.dmt_common.error;

/**
 * <p>
 *     An <code>interface</code> to handle
 *     <code>Exception</code> that occurs in
 *     lower level
 * </p>
 *
 * Created on 9/22/2015 : 4:27 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <ERROR> Object of error
 */
public interface IErrorListener<ERROR> {

    /**
     * <p>
     *     Listening through component when an error occurred
     * </p>
     * @param p_ErrorMessage the message of error (usually as thrown <code>Exception</code> message)
     */
    void onError(ERROR p_ErrorMessage);
}
