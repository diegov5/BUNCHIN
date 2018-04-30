package spazm.spazm;

import java.util.ArrayList;

/**
 * Created by McLovin on 4/16/2018.
 */

public class TimeLine
{
    protected ArrayList<TopPost> timeLine;
    public TimeLine()
    {
        timeLine = new ArrayList<>();
    }
    protected TopPost getPost(int index)
    {
        return timeLine.get(index);
    }
    protected void addPost(Picture newPost)//not sure if this should just add to end or if time should be checked
    {
        timeLine.add(newPost);
    }
    protected void addPost(Rant newPost)//not sure if this should just add to end or if time should be checked
    {
        timeLine.add(newPost);
    }
    protected void removePost(int index)
    {
        timeLine.remove(index);
    }
    protected int size()
    {
        return timeLine.size();
    }

}
