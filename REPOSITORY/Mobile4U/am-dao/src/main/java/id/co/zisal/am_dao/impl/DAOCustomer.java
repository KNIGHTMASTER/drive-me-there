package id.co.zisal.am_dao.impl;

import android.content.Context;

import id.co.zisal.am_dao.base.ABaseGenericDAO;
import id.co.zisal.am_model.ModelCustomer;

/**
 * Created on 10/11/2015 : 4:50 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DAOCustomer extends ABaseGenericDAO {

    public DAOCustomer(Context ctx) {
        super(ctx);
    }

    @Override
    public Class getModelClass() {
        return ModelCustomer.class;
    }
}
