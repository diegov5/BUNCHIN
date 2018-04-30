package spazm.spazm;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by McLovin on 4/27/2018.
 */

public final class SubPicture extends SubPost {
    private String label;//text
    private String image;//what type (needs getter and setter)

    public SubPicture (Type type_i, String userName,PostDetails topPost_i)
    {
        Calendar time = Calendar.getInstance();//get current time
        whoHasLiked = new ArrayList<>();
        type = type_i;
        poster = userName;
        topPost = topPost_i;
        label = "";
    }
    public SubPicture (String image_i, Type type_i, String userName,PostDetails topPost_i)
    {
        Calendar time = Calendar.getInstance();//get current time
        whoHasLiked = new ArrayList<>();
        type = type_i;
        poster = userName;
        topPost = topPost_i;
        image = image_i;
        label = "";
    }
}
