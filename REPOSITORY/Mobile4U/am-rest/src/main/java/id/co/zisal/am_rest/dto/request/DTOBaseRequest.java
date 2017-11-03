package id.co.zisal.am_rest.dto.request;

import org.parceler.Parcel;

/**
 * Created on 12/14/2015 : 4:27 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class DTOBaseRequest {

    private String rqid;
    private String app;
    private String action;

    public String getRqid() {
        return rqid;
    }

    public void setRqid(String rqid) {
        this.rqid = rqid;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "DTOBaseRequest{" +
                "rqid='" + rqid + '\'' +
                ", app='" + app + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
