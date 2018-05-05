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

    /**
     * Creates hotPosts object that finds and holds the hottest posts
     * @param
     */
    public HotPosts()//assuming arraylist contains all viewable posts
    {
        hot = new ArrayList<TopPost>();
        if(timeLine.size()>=8) {
            hot.ensureCapacity(8);
        }
        else if(timeLine.size()!= 0)
            hot.ensureCapacity(timeLine.size());
    }
    /**
     * clears arraylist and finds all current hot posts
     * @param
     * @returns
     */
    protected void updateHotPosts() {
        hot.clear();
        if(timeLine.size()>=8)
            hot.ensureCapacity(8);
        else if(timeLine.size() != 0)
            hot.ensureCapacity(timeLine.size());
        else
            return;
        findHotPosts();
    }
    /**
     * returns one of the hotPost at an index
     * @param
     * @returns a TopPost
     */
    protected TopPost getPost(int index)
    {
        return hot.get(index);
    }
    /**
     * only called by updatePost, it finds the hottest posts and stores them in hot
     * @param
     * @returns
     */
    protected void findHotPosts()
    {

        int size = timeLine.timeLine.size();
        ArrayList<TopPost> allPostCopy = new ArrayList<>(size);
        ArrayList<Integer> allScores = new ArrayList<>(size);
        int maxScore = -1;
        int maxIndex = 0;
        int minScore = -1;
        int currentScore;
        for(int i = 0; i< size;i++) {
            allPostCopy.add(timeLine.timeLine.get(i));//makes arraylist copy of timeline
            allScores.add(allPostCopy.get(i).getScore());
        }
        for(int i = 0; i < 8; i++){

            maxIndex = findMax(allPostCopy);
            allPostCopy.remove(maxIndex);
        }
        hot.trimToSize();
    }
    /**
     * returns max post, used in update
     * @param
     * @returns Int max post
     */
    private int findMax(ArrayList<TopPost> myPosts)
    {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < myPosts.size(); i++ )
        {
            if(myPosts.get(i).getScore() > max)
            {
                max = myPosts.get(i).getScore();
                maxIndex = i;
            }
        }
        hot.add(myPosts.get(maxIndex));

        return maxIndex;
    }
}
