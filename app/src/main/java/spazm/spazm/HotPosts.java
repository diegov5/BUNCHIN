package spazm.spazm;

import java.util.ArrayList;

import static spazm.spazm.MainActivity.timeLine;

/**
 * Created by McLovin on 4/15/2018.
 */

public class HotPosts {
    protected ArrayList<TopPost> hot;
    //protected ArrayList<TopPost> allPosts;// maybe replace this with timeline
    //protected TimeLine tL;

    public HotPosts()//assuming arraylist contains all viewable posts
    {
        hot = new ArrayList<TopPost>();
        if(timeLine.size()>=8) {
            hot.ensureCapacity(8);
        }
        else if(timeLine.size()!= 0)
            hot.ensureCapacity(timeLine.size());
    }
    protected void updateHotPosts() {
        hot.clear();
        if(timeLine.size()>=8)
            hot.ensureCapacity(8);
        else
            hot.ensureCapacity(timeLine.size());
        findHotPosts();
    }
    protected TopPost getPost(int index)
    {
        return hot.get(index);
    }
    protected void findHotPosts()//i hate how i coded this but finds top 8 scores
    {
        ArrayList<TopPost> allPostCopy = (ArrayList<TopPost>)(timeLine.timeLine.clone());
        int maxScore = 0;
        int maxIndex = 0;
        int currentScore;
        for(int i = 0; i < 8; i++) {
            for (int k = 0; k < allPostCopy.size();k++) {
                currentScore = allPostCopy.get(k).getScore();
                if(currentScore>hot.get(hot.size()-1).getScore()) {
                    for (int j = 0; j < 8; j++) {
                        if (currentScore > hot.get(j).getScore()) {
                            hot.add(j, allPostCopy.get(k));
                            j = 8;
                            allPostCopy.remove(k);
                            if(hot.size()>8)
                                hot.remove(8);
                        }
                    }
                }
            }
        }
    }
}
