package id.co.zisal.dmt.dto;

import android.graphics.drawable.Drawable;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created on 3/13/2016 : 8:54 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class DTOTimeLine {

    String timeLineId;
    Drawable imgUserPhoto;
    String userName;
    String timeleftTimeline;
    String headerTimeLine;
    String bodyTimeLine;
    ArrayList<Drawable> imgBodyTimeLine;
    ArrayList<String> comments;
    ArrayList<Integer> likes;

    public String getTimeLineId() {
        return timeLineId;
    }

    public void setTimeLineId(String timeLineId) {
        this.timeLineId = timeLineId;
    }

    public Drawable getImgUserPhoto() {
        return imgUserPhoto;
    }

    public void setImgUserPhoto(Drawable imgUserPhoto) {
        this.imgUserPhoto = imgUserPhoto;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTimeleftTimeline() {
        return timeleftTimeline;
    }

    public void setTimeleftTimeline(String timeleftTimeline) {
        this.timeleftTimeline = timeleftTimeline;
    }

    public String getHeaderTimeLine() {
        return headerTimeLine;
    }

    public void setHeaderTimeLine(String headerTimeLine) {
        this.headerTimeLine = headerTimeLine;
    }

    public String getBodyTimeLine() {
        return bodyTimeLine;
    }

    public void setBodyTimeLine(String bodyTimeLine) {
        this.bodyTimeLine = bodyTimeLine;
    }

    public ArrayList<Drawable> getImgBodyTimeLine() {
        return imgBodyTimeLine;
    }

    public void setImgBodyTimeLine(ArrayList<Drawable> imgBodyTimeLine) {
        this.imgBodyTimeLine = imgBodyTimeLine;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public ArrayList<Integer> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Integer> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "DTOTimeLine{" +
                "imgUserPhoto=" + imgUserPhoto +
                ", userCode='" + userName + '\'' +
                ", timeleftTimeline='" + timeleftTimeline + '\'' +
                ", headerTimeLine='" + headerTimeLine + '\'' +
                ", bodyTimeLine='" + bodyTimeLine + '\'' +
                ", imgBodyTimeLine=" + imgBodyTimeLine +
                ", comments=" + comments +
                ", likes=" + likes +
                '}';
    }
}
