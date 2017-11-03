package id.co.zisal.dmt_common.component;

/**
 * <p>
 *     Combination between <code>PARAM</code> and <code>RESULT</code>
 *     to simplify process within application.
 *     <code>PARAM</code> and <code>RESULT</code>
 *     must be defined in an object
 * </p>
 * <p>
 *     After <code>PARAM</code> and <code>RESULT</code> Object is defined,
 *     the next process should call method process. The implementor Class
 *     will be able to take the result from <code>getTestResult()</code>
 *     method
 * </p>
 * @see java.lang.Object
 * @see IDMTProcessComponent#getTestResult()
 * Created on 9/22/2015 : 4:19 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * @param <PROCESS_PARAM> parameter Object
 * @param <PROCESS_RESULT> result Object
 */
public interface IDMTProcessComponent<PROCESS_PARAM, PROCESS_RESULT> extends IDMTComponent<PROCESS_PARAM> {

    /**
     * <p>
     *     setup an object result
     * </p>
     * @param p_Result result Object after process
     */
    void setTestResult(PROCESS_RESULT p_Result);

    /**
     * <p>
     *     retrieve an object result
     * </p>
     * @return TEST_RESULT
     */
    PROCESS_RESULT getTestResult();

    /**
     * <p>
     *     Main process from a component or formula
     * </p>
     */
    void process();
}
