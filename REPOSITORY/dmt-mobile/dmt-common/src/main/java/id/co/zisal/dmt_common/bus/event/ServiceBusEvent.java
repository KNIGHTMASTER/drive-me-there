package id.co.zisal.dmt_common.bus.event;

/**
 * Created on 2/21/2016 : 6:00 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public class ServiceBusEvent<DATA> extends AServiceBusEvent {

    public enum Type {
        STARTED,
        COMPLETED
    }

    private int resultCode;

    private DATA singleDATABus;

    public ServiceBusEvent(Type type, int p_ResultCode, DATA p_SingleDATABus) {
        super(type);
        this.resultCode = p_ResultCode;
        this.singleDATABus = p_SingleDATABus;
    }

    public int getResultCode() {
        return resultCode;
    }

    public DATA getSingleDATABus() {
        return singleDATABus;
    }
}
