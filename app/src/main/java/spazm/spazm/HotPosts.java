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
        else if(timeLine.size() != 0)
            hot.ensureCapacity(timeLine.size());
        else
            return;
        findHotPosts();
    }
    protected TopPost getPost(int index)
    {
        return hot.get(index);
    }
    protected void findHotPosts()//i hate how i coded this but finds top 8 scores
    {
        int size = timeLine.timeLine.size();
        ArrayList<TopPost> allPostCopy = new ArrayList<>(size);
        //ArrayList<Integer> allScores = new ArrayList<>(size)
        //int maxScore = 0;
        //int maxIndex = 0;
        int minScore = -1;
        int currentScore;
        for(int i = 0; i< size;i++) {
            allPostCopy.add(timeLine.timeLine.get(i));//makes arraylist coy of timeline
            //allScores.add(allPostCopy.get(i).getScore());
        }
        for(int i = 0; i < 8; i++) {
            for (int k = 0; k < allPostCopy.size();k++) {
                currentScore = allPostCopy.get(k).getScore();
                if(currentScore >= minScore) {
                    if(hot.size() == 0)
                        hot.add(allPostCopy.get(k));
                    else {
                        for (int j = 0; j < Math.min(8,hot.size()); j++) {
                            if (currentScore > hot.get(j).getScore()) {
                                hot.add(j, allPostCopy.get(k));
                                j = 8;
                                //allPostCopy.remove(k);
                                if (hot.size() > 8) {
                                    hot.remove(8);
                                    minScore = hot.get(7).getScore();
                                }
                            }
                            if(hot.size() < 8 && j == hot.size() -1){
                                hot.add(allPostCopy.get(k));}
                        }

                    }
                }
            }
        }
        hot.trimToSize();
    }
}
