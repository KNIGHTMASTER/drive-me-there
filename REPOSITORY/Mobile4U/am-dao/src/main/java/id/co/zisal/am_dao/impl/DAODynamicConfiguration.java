package id.co.zisal.am_dao.impl;

import android.content.Context;

import id.co.zisal.am_dao.base.ABaseGenericDAO;
import id.co.zisal.am_model.ModelDynamicConfiguration;

/**
 * Created on 9/25/2015 : 9:07 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DAODynamicConfiguration extends ABaseGenericDAO {

    public DAODynamicConfiguration(Context ctx) {
        super(ctx);
    }

    @Override
    public Class getModelClass() {
        return ModelDynamicConfiguration.class;
    }
}
