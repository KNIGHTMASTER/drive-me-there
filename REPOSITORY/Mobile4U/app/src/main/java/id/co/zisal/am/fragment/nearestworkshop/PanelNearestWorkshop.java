package id.co.zisal.am.fragment.nearestworkshop;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import id.co.zisal.am.R;
import id.co.zisal.am_component.ui.card.ABaseCustomCard;
import id.co.zisal.am_component.ui.fragment.impl.NavigatorFragment;
import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created on 1/7/2016 : 9:10 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class PanelNearestWorkshop extends ABaseCustomCard {

    private FragmentActivity fragmentActivity;

    public PanelNearestWorkshop(Context context) {
        super(context);
    }

    public PanelNearestWorkshop(FragmentActivity context, int innerLayout) {
        super(context, innerLayout);
        this.fragmentActivity = context;
    }

    @Override
    public void initActions() {
        setOnClickListener(new OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                NavigatorFragment navigatorFragment = new NavigatorFragment() {
                    @Override
                    public FragmentActivity getFragmentActivity() {
                        return fragmentActivity;
                    }
                };
                /*FragmentDetailWorkshop fragmentDetailWorkshop = new FragmentDetailWorkshop();
                navigatorFragment.gotoNextFragment(R.id.container, fragmentDetailWorkshop);*/
            }
        });
    }
}
