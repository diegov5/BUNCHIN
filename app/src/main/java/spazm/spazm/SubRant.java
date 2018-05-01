package spazm.spazm;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by McLovin on 4/27/2018.
 */

public final class SubRant extends SubPost {
    private String rant;//text
    private String backgroundImage;//what type (needs getter and setter)
    private String font;//what type

    public SubRant (Type type_i, String userName, PostDetails topPost_i)
    {
        Calendar time = Calendar.getInstance();//get current time
        whoHasLiked = new ArrayList<>();
        Type type = type_i;
        poster = userName;
        topPost = topPost_i;
    }
    public SubRant (String rant_i, Type type_i, String userName,PostDetails topPost_i)
    {
        Calendar time = Calendar.getInstance();//get current time
        whoHasLiked = new ArrayList<>();
        Type type = type_i;
        poster = userName;
        topPost = topPost_i;
        rant = rant_i;
    }
    protected void setRant(String rant_i)
    {
        rant=rant_i;
    }
    protected String getRant()
    {
        return rant;
    }
}
