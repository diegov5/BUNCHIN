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
    /**
     * Object Post details contains the variable types that are shared by comments and top posts
     * @param
     * @returns
     */
    public PostDetails()
    {//here for subclass
    }
    //returns likes of current post
    protected int getLikes()
    {
        return whoHasLiked.size();
    }

    //removes like if user liked it already
    protected void unlike(String userName)
    {
        int index = whoHasLiked.lastIndexOf(userName);
        if(index==-1)//aka username not found
        {
            return ;
        }
        whoHasLiked.remove(index);
    }
    //used by like to see if user has liked
    protected boolean hasUserLiked(String userName)
    {
        int index = whoHasLiked.lastIndexOf(userName);
        if(index==-1)//aka username not found
        {
            return false;
        }
        return true;
    }
    //adds user who liked post to current reference later
    protected void addLike(String userName)//takes user
    {
        int index = whoHasLiked.lastIndexOf(userName);
        if(index==-1)//aka username not found
        {
            whoHasLiked.add(userName);
        }
    }

}
