package id.co.zisal.dmt_service.bgp;

/**
 * <p>
 *     <bold><code>Service</code></bold> Parameter for Application
 * </p>
 * Created on 9/28/2015 : 10:33 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DMTSParam<VIEW> {

    private Class<VIEW> viewClass;

    public Class<VIEW> getViewClass() {
        return viewClass;
    }

    public void setViewClass(Class<VIEW> p_ViewClass) {
        this.viewClass = p_ViewClass;
    }
}
