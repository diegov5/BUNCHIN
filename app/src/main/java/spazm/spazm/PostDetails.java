package spazm.spazm;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by McLovin on 4/15/2018.
 */

public class PostDetails {
    protected Calendar time;
    protected ArrayList<String> whoHasLiked;
    //protected enum Type{PHOTO,VIDEO,RANT,POLL,LINK};
    //protected Type type;
    String poster;

    public PostDetails()
    {//here for subclass
    }
    protected int getLikes()
    {
        return whoHasLiked.size();
    }

    protected void unlike(String userName)
    {
        int index = whoHasLiked.lastIndexOf(userName);
        if(index==-1)//aka username not found
        {
            return ;
        }
        whoHasLiked.remove(index);
    }
    protected boolean hasUserLiked(String userName)
    {
        int index = whoHasLiked.lastIndexOf(userName);
        if(index==-1)//aka username not found
        {
            return false;
        }
        return true;
    }
    protected void addLike(String userName)//takes user
    {
        int index = whoHasLiked.lastIndexOf(userName);
        if(index==-1)//aka username not found
        {
            whoHasLiked.add(userName);
        }
    }

}
