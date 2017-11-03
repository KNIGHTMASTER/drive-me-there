package id.co.zisal.dmt_component.ui;

import id.co.zisal.dmt_dao.DAOComponent;
import id.co.zisal.dmt_util.network.NetworkComponent;

/**
 * Created on 3/23/2016 : 1:06 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IComponentInjector {

    void injectNetworkComponent(NetworkComponent p_NetworkComponent);

    void injectDAOComponent(DAOComponent p_DAOComponent);
}
