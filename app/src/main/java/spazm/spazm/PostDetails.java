package spazm.spazm;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by McLovin on 4/15/2018.
 */

public class PostDetails {
    protected Calendar time;
    protected ArrayList<String> whoHasLiked;
    protected String title;
    protected enum Type{PHOTO,VIDEO,RANT,POLL,LINK};
    protected Type type;
    String poster;
    //protected ArrayList<SubPost> comments;
    public PostDetails(String title_i, Type type_i, String userName)
    {
        Calendar time = Calendar.getInstance();//get current time
        whoHasLiked = new ArrayList<>();
        title = title_i;
        type = type_i;
        poster = userName;
        //comments = new ArrayList<SubPost>;
    }
    protected String getTitle()
    {
        return title;
    }
    protected int getLikes()
    {
        return whoHasLiked.size();
    }
    protected int getScore()
    {
        Calendar current= Calendar.getInstance();
        int timeDiff = time.compareTo(current);//in mili seconds
        timeDiff = timeDiff/3600000;//converts to hours
        int score = (getLikes()/*+(.5*comments.size())*/)- (timeDiff*timeDiff)/8; //decays as time pass
        return score;
    }
    protected void changeTitle(String title_i)
    {
        title = title_i;
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
    /*protected void addComment(SubPost newComment)
    {
        comments.add(newComment);
    }*/
}
