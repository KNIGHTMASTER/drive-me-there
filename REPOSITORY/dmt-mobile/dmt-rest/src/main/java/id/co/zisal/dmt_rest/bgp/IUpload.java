package id.co.zisal.dmt_rest.bgp;

/**
 * Created on 10/15/2015 : 8:59 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IUpload {

    String getFilePath();

    /**
     * Description of file that will be uploaded
     * @return description String
     */
    String getDescription();

}
