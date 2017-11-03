package id.co.zisal.dmt_component.ui.card;

import android.content.Context;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * <p>
 *     Every single custom card view should extend from this class
 * </p>
 * Created on 9/28/2015 : 9:17 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ABaseCustomCard extends Card implements ICustomCard {

    public ABaseCustomCard(Context p_Context) {
        super(p_Context);
        initActions();
    }

    public ABaseCustomCard(Context p_Context, int p_InnerLayout) {
        super(p_Context, p_InnerLayout);
        initActions();
    }
}
