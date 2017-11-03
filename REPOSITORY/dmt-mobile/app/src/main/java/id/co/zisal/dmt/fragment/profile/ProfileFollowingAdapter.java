package id.co.zisal.dmt.fragment.profile;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.co.zisal.dmt.R;

/**
 * Created on 4/29/2016 : 5:23 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ProfileFollowingAdapter extends BaseAdapter {

    private List<DummyFollowersData> dummyFollowersDatas;

    private LayoutInflater inflater;

    public ProfileFollowingAdapter(Activity p_Activity) {
        dummyFollowersDatas = new FollowersDataGenerator(p_Activity).getDummyFollowersDatas();
        inflater = (LayoutInflater)p_Activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dummyFollowersDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return dummyFollowersDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class ViewHolder {
        public ImageView image;
        public TextView name;
        public TextView title;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_followers, null);

            viewHolder = new ViewHolder();
            viewHolder.title = (TextView)convertView.findViewById(R.id.title);
            viewHolder.name = (TextView)convertView.findViewById(R.id.artist);
            viewHolder.image=(ImageView)convertView.findViewById(R.id.list_image);

            viewHolder.title.setText(dummyFollowersDatas.get(position).getTitle());
            viewHolder.name.setText(dummyFollowersDatas.get(position).getName());
            viewHolder.image.setImageDrawable(dummyFollowersDatas.get(position).getImageThumbnails());

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
