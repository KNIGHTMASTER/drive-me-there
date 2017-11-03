package id.co.zisal.dmt.action.register;

/**
 * Created on 4/5/2016 : 12:31 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <REGISTER_PARAM>
 */
public interface IRegister<REGISTER_PARAM> {

    void setParam(REGISTER_PARAM p_REGISTER_PARAM);

    REGISTER_PARAM getParam();

    void doRegister();
}
