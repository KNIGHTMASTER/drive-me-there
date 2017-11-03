package id.co.zisal.am_rest.bgp;

/**
 * Created on 10/15/2015 : 8:59 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IUpload {

    String getFilePath();

    /**
     * Description of file that will be uploaded
     * @return description String
     */
    String getDescription();

}
