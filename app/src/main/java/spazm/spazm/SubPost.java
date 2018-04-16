package spazm.spazm;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by McLovin on 4/15/2018.
 */

public class SubPost extends PostDetails {
    protected PostDetails topPost;

    public SubPost (Type type_i, String userName,PostDetails topPost_i)
    {
        Calendar time = Calendar.getInstance();//get current time
        whoHasLiked = new ArrayList<>();
        type = type_i;
        poster = userName;
        topPost = topPost_i;
    }
}
