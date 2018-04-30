package spazm.spazm;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by McLovin on 4/27/2018.
 */

public final class Picture extends TopPost {
    private String label;//text
    private String image;//what type (needs getter and setter)

    public Picture(String image_i,String title_i, Type type_i, String userName)
    {
        Calendar time = Calendar.getInstance();//get current time
        whoHasLiked = new ArrayList<>();
        title = title_i;
        type = type_i;
        poster = userName;
        comments = new ArrayList<SubPost>();
        image = image_i;
        label="";
    }
    public Picture(String title_i, Type type_i, String userName)
    {
        Calendar time = Calendar.getInstance();//get current time
        whoHasLiked = new ArrayList<>();
        title = title_i;
        type = type_i;
        poster = userName;
        comments = new ArrayList<SubPost>();
        image = "";
        label = "";
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
