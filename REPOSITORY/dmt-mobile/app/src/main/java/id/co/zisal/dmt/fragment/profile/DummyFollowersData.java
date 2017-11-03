package id.co.zisal.dmt.fragment.profile;

import android.graphics.drawable.Drawable;

/**
 * Created on 4/29/2016 : 5:30 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DummyFollowersData {

    private Drawable imageThumbnails;
    private String name;
    private String title;
    private String duration;

    public Drawable getImageThumbnails() {
        return imageThumbnails;
    }

    public void setImageThumbnails(Drawable imageThumbnails) {
        this.imageThumbnails = imageThumbnails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
