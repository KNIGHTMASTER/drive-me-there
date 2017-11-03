package id.co.zisal.dmt_dao.impl;

import android.content.Context;

import javax.inject.Inject;

import id.co.zisal.dmt_dao.base.ABaseGenericDAO;
import id.co.zisal.dmt_model.ModelUser;

/**
 * Created on 5/27/2015 : 4:24 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
public class DAOUser extends ABaseGenericDAO {

    @Inject
    public DAOUser(Context p_Context) {
        super(p_Context);
    }

    @Override
    public Class getModelClass() {
        return ModelUser.class;
    }
}
