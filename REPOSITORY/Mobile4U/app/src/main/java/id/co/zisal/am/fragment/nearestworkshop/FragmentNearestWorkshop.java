package id.co.zisal.am.fragment.nearestworkshop;


import java.util.ArrayList;

import butterknife.InjectView;
import id.co.zisal.am.R;
import id.co.zisal.am_common.constant.ApplicationConstant.FragmentInfo.Title;
import id.co.zisal.am_component.ui.fragment.impl.ANavigationDrawerFragment;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

public class FragmentNearestWorkshop extends ANavigationDrawerFragment {

    @InjectView(R.id.panelNearestWorkshop)
    CardListView panelNearestWorkshop;

    @Override
    public String getFragmentTitle() {
        return Title.NEAREST_WORKSHOP;
    }

    @Override
    public void initWidget() {
        initPanels();
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.fragment_nearest_workshop;
    }

    private void initPanels(){
        ArrayList<Card> cards = new ArrayList<>();
        for(int a=0; a<3; a++){
            Card card = new PanelNearestWorkshop(getActivity(), R.layout.card_nearest_workshop);
            cards.add(card);
        }
        CardArrayAdapter detailCardArrayAdapter = new CardArrayAdapter(rootView.getContext(), cards);
        if (panelNearestWorkshop != null){
            panelNearestWorkshop.setAdapter(detailCardArrayAdapter);
        }
    }
}
