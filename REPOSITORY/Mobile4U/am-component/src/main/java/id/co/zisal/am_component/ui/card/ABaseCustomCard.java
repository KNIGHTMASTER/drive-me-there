package id.co.zisal.am_component.ui.card;

import android.content.Context;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created on 9/28/2015 : 9:17 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ABaseCustomCard extends Card implements ICustomCard {

    public ABaseCustomCard(Context context) {
        super(context);
        initActions();
    }

    public ABaseCustomCard(Context context, int innerLayout) {
        super(context, innerLayout);
        initActions();
    }
}
