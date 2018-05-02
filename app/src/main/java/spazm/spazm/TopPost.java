package spazm.spazm;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by McLovin on 4/15/2018.
 */

public class TopPost extends PostDetails {
    protected ArrayList<SubPost> comments;
    protected String title;
    private String label;//text
    private Integer image;//what type (needs getter and setter)

    //shouldnt be called maybe get rid of \/
    public TopPost(Integer image_i, String title_i, String userName)
    {
        time = Calendar.getInstance();//get current time
        whoHasLiked = new ArrayList<>();
        title = title_i;
        //type = type_i;
        poster = userName;
        comments = new ArrayList<SubPost>();
        image = image_i;
        label="";
    }
    protected String getTitle()
    {
        return title;
    }
    protected int getScore()
    {
        Calendar current= Calendar.getInstance();
        int timeDiff = time.compareTo(current);//in mili seconds
        timeDiff = timeDiff/3600000;//converts to hours
        return (getLikes()+(2*getAmountOfComments()/3))- (timeDiff*timeDiff)/8; //decays as time pass
    }
    protected void changeTitle(String title_i)
    {
        title = title_i;
    }
    protected SubPost getComment(int index)
    {
        return comments.get(index);
    }
    protected int getAmountOfComments()
    {
        return comments.size();
    }
    protected void addComment(SubPost newComment)
    {
        comments.add(newComment);
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
