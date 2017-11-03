package id.co.zisal.dmt_dao.impl;

import android.content.Context;

import javax.inject.Inject;

import id.co.zisal.dmt_dao.base.ABaseGenericDAO;
import id.co.zisal.dmt_model.ModelCustomer;

/**
 * Created on 10/11/2015 : 4:50 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DAOCustomer extends ABaseGenericDAO {

    @Inject
    public DAOCustomer(Context p_Context) {
        super(p_Context);
    }

    @Override
    public Class getModelClass() {
        return ModelCustomer.class;
    }
}
