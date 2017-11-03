package id.co.zisal.dmt_model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_common.constant.ApplicationConstant.Database.TableCustomer;

/**
 * Created by Achmad Fauzi on 6/4/2015 : 9:59 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@DatabaseTable(tableName = TableCustomer.TABLE_NAME)
public class ModelCustomer {

    @DatabaseField(generatedId = true, canBeNull = false, columnName = ApplicationConstant.Database.ID, unique = true)
    private int id;

    @DatabaseField(columnName = TableCustomer.CUSTOMER_NAME)
    private String customerName;

    @DatabaseField(columnName = TableCustomer.CUSTOMER_ADDRESS)
    private String customerAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "ModelCustomer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}
