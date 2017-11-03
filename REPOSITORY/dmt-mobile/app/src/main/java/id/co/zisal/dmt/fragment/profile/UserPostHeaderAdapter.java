package id.co.zisal.dmt.fragment.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nhaarman.listviewanimations.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.co.zisal.dmt.R;
import id.co.zisal.dmt_component.image.Image;
import id.co.zisal.dmt_component.ui.util.DummyModel;
import id.co.zisal.dmt_component.ui.util.ImageUtil;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created on 4/28/2016 : 2:24 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class UserPostHeaderAdapter extends ArrayAdapter<String> implements StickyListHeadersAdapter, View.OnClickListener{

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<DummyModel> mDummyModelList;

    public UserPostHeaderAdapter(final Context context, ArrayList<DummyModel> dummyModelList) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mDummyModelList = dummyModelList;
        for (int i = 0; i < 100; i++) {
            add("Row number " + i);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_item_sticky_header_social, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) convertView.findViewById(R.id.list_item_sticky_header_social_image);
            viewHolder.name = (TextView) convertView.findViewById(R.id.list_item_sticky_header_social_name);
            viewHolder.likeIcon = (TextView) convertView.findViewById(R.id.list_item_sticky_header_social_icon_like);
            viewHolder.bookmarkIcon = (TextView) convertView.findViewById(R.id.list_item_sticky_header_social_icon_bookmark);
            viewHolder.shareIcon = (TextView) convertView.findViewById(R.id.list_item_sticky_header_social_icon_share);
            viewHolder.text = (TextView) convertView.findViewById(R.id.list_item_sticky_header_social_text);

            viewHolder.image.setOnClickListener(this);
            viewHolder.name.setOnClickListener(this);
            viewHolder.likeIcon.setOnClickListener(this);
            viewHolder.bookmarkIcon.setOnClickListener(this);
            viewHolder.shareIcon.setOnClickListener(this);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }


        ImageUtil.displayRoundImage(viewHolder.image,
                mDummyModelList.get(position % 5).getImageURL(), null, context);

        viewHolder.name.setText("John Smith "+position);
        viewHolder.text.setText(R.string.lorem_ipsum_long);
        viewHolder.image.setTag(position);
        viewHolder.name.setTag(position);
        viewHolder.likeIcon.setTag(position);
        viewHolder.shareIcon.setTag(position);
        viewHolder.bookmarkIcon.setTag(position);
        return convertView;
    }

    private static class ViewHolder {
        public ImageView image;
        public/* Roboto */TextView name;
        public/* Material */TextView likeIcon;
        public/* Material */TextView bookmarkIcon;
        public/* Material */TextView shareIcon;
        public/* Roboto */TextView text;
    }

    private static class HeaderViewHolder {
        public/* Roboto */TextView day;
        public/* Roboto */TextView date;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final HeaderViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(
                    R.layout.list_header_social, parent, false);
            holder = new HeaderViewHolder();
            holder.day = (TextView) view
                    .findViewById(R.id.list_header_social_day);
            holder.date = (TextView) view
                    .findViewById(R.id.list_header_social_date);
            view.setTag(holder);
        } else {
            holder = (HeaderViewHolder) view.getTag();
        }

        holder.day.setText("Yesterday");
        holder.date.setText("14.6.2015.");
        // holder.name.setText("Header " + getHeaderId(position));

        return view;
    }

    @Override
    public long getHeaderId(int position) {
        return position / 5;
    }

    @Override
    public void onClick(View v) {

    }

}
