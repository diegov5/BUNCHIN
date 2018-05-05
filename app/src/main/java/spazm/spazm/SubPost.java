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

    /**
     * Object SubPost contains all the data for any one post ie image, likes, ect.
     * @param
     * @returns
     */
    public SubPost (Integer image_i, String userName)
    {
        Calendar time = Calendar.getInstance();//get current time
        whoHasLiked = new ArrayList<>();
        poster = userName;
        //topPost = topPost_i;
        image = image_i;
        label ="";
    }
    //returns image
    protected Integer getImage(){
        return image;
    }
    //set label
    protected void setLabel(String label_i)
    {
        label=label_i;
    }
    //returns label
    protected String getLabel()
    {
        return label;
    }

}
