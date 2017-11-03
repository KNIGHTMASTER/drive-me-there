package id.co.zisal.dmt_util.network.socket;

/**
 * <p>
 *     Post processing after conduct Socket communication. This interface will held
 *     any result as {@link SocketClientResult}
 * </p>
 *
 * for basic result :
 * @see SocketClientResult#getStartDate()
 * @see SocketClientResult#getEndDate()
 * @see SocketClientResult#getResult()
 *
 * Created by Achmad Fauzi on 6/11/2015 : 6:12 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IPostSocketClient {

    /**
     * <p>
     *     Listener after socket process done
     * </p>
     * 
     * @param p_SocketClientResult result from socket
     */
    void onPostSocketClient(SocketClientResult p_SocketClientResult);

}
