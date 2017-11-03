package id.co.zisal.dmt_rest.bgp.impl.upload;

import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_rest.bgp.IUpload;
import id.co.zisal.dmt_rest.bgp.base.ABGP;
import id.co.zisal.dmt_rest.callback.GenericCallBack;
import id.co.zisal.dmt_rest.endpoints.EPUpload;
import id.co.zisal.dmt_rest.post.IGenericPost;

import java.io.File;

import retrofit.Callback;
import retrofit.mime.TypedFile;

/**
 * Created on 10/1/2015 : 4:56 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class BGPUpload extends ABGP implements IUpload {

    public BGPUpload(IGenericPost p_IGenericPost) {
        super(p_IGenericPost);
    }

    @Override
    protected Object doInBackground(Object[] p_MultipleParams) {
        TypedFile typedFile = new TypedFile(
                ApplicationConstant.Rest.MULTIPART,
                new File(getFilePath())
        );

        EPUpload epUpload = (EPUpload) restGenerator.createService(getEPClass());
        epUpload.upload(typedFile, getDescription(), getCallBack());
        return null;
    }

    @Override
    public Callback getCallBack() {
        return new GenericCallBack(iGenericPost, null);
    }

    @Override
    public Class getEPClass() {
        return EPUpload.class;
    }

}
