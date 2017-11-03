package id.co.zisal.dmt.fragment.profile;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

import id.co.zisal.dmt.R;

/**
 * Created on 4/29/2016 : 5:32 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FollowersDataGenerator {

    private List<DummyFollowersData> dummyFollowersDatas;

    private Activity activity;

    public FollowersDataGenerator(Activity activity) {
        this.activity = activity;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public List<DummyFollowersData> getDummyFollowersDatas() {
        dummyFollowersDatas = new ArrayList<>();
        for (int a=1; a<10; a++){
            DummyFollowersData dummyFollowersData = new DummyFollowersData();
            dummyFollowersData.setImageThumbnails(activity.getResources().getDrawable(R.drawable.isyana, null));
            dummyFollowersData.setDuration("03:44");
            dummyFollowersData.setName("Isyana Sarasvati");
            dummyFollowersData.setTitle("Keep Being You");
            dummyFollowersDatas.add(dummyFollowersData);
        }
        return dummyFollowersDatas;
    }

    public void setDummyFollowersDatas(List<DummyFollowersData> dummyFollowersDatas) {
        this.dummyFollowersDatas = dummyFollowersDatas;
    }

}
