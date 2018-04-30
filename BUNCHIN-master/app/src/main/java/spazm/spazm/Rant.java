package spazm.spazm;

import java.util.ArrayList;
import java.util.Calendar;
C:\Users\David\OneDrive\Spring 2018\CPSC\Bunchin\BUNCHIN-master
/**
 * Created by McLovin on 4/27/2018.
 */

public final class Rant extends TopPost {
    private String rant;//text
    private String backgroundImage;//what type (needs getter and setter)
    private String font;//what type

    public Rant(String rant_i,String title_i, Type type_i, String userName)
    {
        Calendar time = Calendar.getInstance();//get current time
        whoHasLiked = new ArrayList<>();
        title = title_i;
        type = type_i;
        poster = userName;
        comments = new ArrayList<SubPost>();
        rant = rant_i;
    }
    public Rant(String title_i, Type type_i, String userName)
    {
        Calendar time = Calendar.getInstance();//get current time
        whoHasLiked = new ArrayList<>();
        title = title_i;
        type = type_i;
        poster = userName;
        comments = new ArrayList<SubPost>();
        rant = "";
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
