package id.co.zisal.dmt_component.ui.dialog.calendar;

import android.widget.DatePicker;

/**
 * <p>
 *     A Utility to display Calendar within a fragment or activity
 * </p>
 *
 * Created on 10/12/2015 : 4:45 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IDMTCalendar {

    void action(DatePicker p_View, int p_Year, int p_MonthOfYear, int p_DayOfMonth);

}
