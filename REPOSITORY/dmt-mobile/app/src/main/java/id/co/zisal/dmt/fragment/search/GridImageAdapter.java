package id.co.zisal.dmt.fragment.search;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import id.co.zisal.dmt.R;

/**
 * Created on 3/17/2016 : 11:42 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class GridImageAdapter extends ArrayAdapter<GridImageItem> {

    private Context context;
    private int layoutResourceId;
    private ArrayList<GridImageItem> gridImageItems;

    public GridImageAdapter(Context p_Context, int p_LayoutResourceId, ArrayList<GridImageItem> p_GridImageItems) {
        super(p_Context, p_LayoutResourceId, p_GridImageItems);
        this.layoutResourceId = p_LayoutResourceId;
        this.gridImageItems = p_GridImageItems;
        this.context = p_Context;
    }

    /**
     * Updates grid data and refresh grid items.
     * @param p_GridImageItem object of image list
     */
    public void setGridData(ArrayList<GridImageItem> p_GridImageItem) {
        this.gridImageItems = p_GridImageItem;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageView = (ImageView) row.findViewById(R.id.grid_item_image);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        GridImageItem item = gridImageItems.get(position);
        Picasso.with(context).load(item.getImage()).into(holder.imageView);
        return row;
    }

    static class ViewHolder {
        ImageView imageView;
    }
}

