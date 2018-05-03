package spazm.spazm;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by McLovin on 4/15/2018.
 */

public class SubPost extends PostDetails {
    protected PostDetails topPost;
    private String label;//text label
    private Integer image;

    public SubPost()
    {//for subclass's
    }
    public SubPost (Integer image_i, String userName)
    {
        Calendar time = Calendar.getInstance();//get current time
        whoHasLiked = new ArrayList<>();
        poster = userName;
        //topPost = topPost_i;
        image = image_i;
        label ="";
    }
    protected Integer getImage(){
        return image;
    }
    protected void setLabel(String label_i)
    {
        label=label_i;
    }
    protected String getLabel()
    {
        return label;
    }

}
