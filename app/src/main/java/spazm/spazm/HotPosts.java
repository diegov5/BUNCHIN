package spazm.spazm;

import java.util.ArrayList;

/**
 * Created by McLovin on 4/15/2018.
 */

public class HotPosts {
    protected ArrayList<TopPost> hot;
    protected ArrayList<TopPost> allPosts;

    public HotPosts(ArrayList<TopPost> allPosts_i)//assuming arraylist contains all viewable posts
    {
        allPosts = allPosts_i;
        if(allPosts.size()>=8)
            hot.ensureCapacity(8);
        else
            hot.ensureCapacity(allPosts.size());
    }
    protected void updateHotPosts(ArrayList<TopPost> allPosts_i) {
        allPosts = allPosts_i;
        hot.clear();
        if(allPosts.size()>=8)
            hot.ensureCapacity(8);
        else
            hot.ensureCapacity(allPosts.size());
        findHotPosts();
    }

    protected void findHotPosts()//i hate how i coded this but finds top 8 scores
    {
        ArrayList<TopPost> allPostCopy = (ArrayList<TopPost>)(allPosts.clone());
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
