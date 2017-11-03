package id.co.zisal.dmt_common.bus.event;

/**
 * Created on 2/21/2016 : 5:59 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class AServiceBusEvent {

    private Enum type;

    public AServiceBusEvent(Enum type) {
        this.type = type;
    }

    public Enum getType() {
        return type;
    }
}
