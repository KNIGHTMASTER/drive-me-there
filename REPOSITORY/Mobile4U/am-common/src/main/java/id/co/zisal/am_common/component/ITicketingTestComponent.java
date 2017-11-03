package id.co.zisal.am_common.component;

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
 *     can take the result from <code>getTestResult()</code> method
 * </p>
 * {@link java.lang.Object}
 * @see ITicketingTestComponent#getTestResult()
 * Created on 9/22/2015 : 4:19 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * @param <TEST_PARAM> parameter Object
 * @param <TEST_RESULT> result Object
 */
public interface ITicketingTestComponent<TEST_PARAM, TEST_RESULT> extends ITicketingComponent<TEST_PARAM> {

    void setTestResult(TEST_RESULT _result);

    TEST_RESULT getTestResult();

    void process();
}
