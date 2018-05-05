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

    /**
     * Object Top post contains all the data for any one post ie image likes ect.
     * @param
     * @returns
     */
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
    /**
     * returns title of post
     * @param
     * @returns title
     */
    protected String getTitle()
    {
        return title;
    }
    /**
     * calculates and returns score of this post
     * @param
     * @returns score
     */
    protected int getScore()
    {
        Calendar current= Calendar.getInstance();
        int timeDiff = time.compareTo(current);//in mili seconds
        timeDiff = timeDiff/3600000;//converts to hours
        return (getLikes()+(2*getAmountOfComments()/3))- (timeDiff*timeDiff)/8; //decays as time pass
    }
    //sets title
    protected void changeTitle(String title_i)
    {
        title = title_i;
    }
    //returns comment
    protected SubPost getComment(int index)
    {
        return comments.get(index);
    }
    //returns number of comments on this post
    protected int getAmountOfComments()
    {
        return comments.size();
    }
    //adds a new comment
    protected void addComment(SubPost newComment)
    {
        comments.add(newComment);
    }
    //returns image
    protected Integer getImage(){
        return image;
    }
    //set the label
    protected void setLabel(String label_i)
    {
        label=label_i;
    }
    //returns the label
    protected String getLabel()
    {
        return label;
    }
}
