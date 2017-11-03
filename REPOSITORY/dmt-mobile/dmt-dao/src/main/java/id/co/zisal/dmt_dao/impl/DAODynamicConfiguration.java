package id.co.zisal.dmt_dao.impl;

import android.content.Context;

import javax.inject.Inject;

import id.co.zisal.dmt_dao.base.ABaseGenericDAO;
import id.co.zisal.dmt_model.ModelDynamicConfiguration;

/**
 * Created on 9/25/2015 : 9:07 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DAODynamicConfiguration extends ABaseGenericDAO {

    @Inject
    public DAODynamicConfiguration(Context p_Context) {
        super(p_Context);
    }

    @Override
    public Class getModelClass() {
        return ModelDynamicConfiguration.class;
    }
}
