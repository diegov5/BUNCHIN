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
        timeLine = new ArrayList<TopPost>();
    }
    protected TopPost getPost(int index)
    {
        return timeLine.get(index);
    }
    protected void addPost(TopPost newPost)//not sure if this should just add to end or if time should be checked
    {
        timeLine.add(newPost);
    }
    protected void example()
    {
        TopPost t0 = new TopPost(R.drawable.sample_0,"Doggy","DogLover69");
        TopPost t1 = new TopPost(R.drawable.sample_1,"Dog-o","Ksig");
        TopPost t2 = new TopPost(R.drawable.sample_2,"My Dog","Bet");
        TopPost t3 = new TopPost(R.drawable.sample_3,"Most Liked Dog","Chance");
        TopPost t4 = new TopPost(R.drawable.sample_4,"Dog","BhadBhabie");
        TopPost t5 = new TopPost(R.drawable.sample_5,"a Pup","69");
        TopPost t6 = new TopPost(R.drawable.sample_6,"Puppy","PupLover69");
        TopPost t7 = new TopPost(R.drawable.sample_7,"Too Cute","MeLoveDog");
        t3.addLike("BhadBhabie");
        t3.addLike("MeLoveDog");
        t1.addLike("BhadBhabie");
        SubPost s0 = new SubPost(R.drawable.logo_circle,"Xx_poser_xX");
        SubPost s1 = new SubPost(R.drawable.sample_6,"Sixty9");
        SubPost s2 = new SubPost(R.drawable.sample_5,"60Nine");
        this.addPost(t0);
        this.addPost(t1);
        this.addPost(t2);
        this.addPost(t3);
        this.addPost(t4);
        this.addPost(t5);
        this.addPost(t6);
        this.addPost(t7);
        timeLine.get(3).addComment(s0);
        timeLine.get(3).addComment(s1);
        timeLine.get(3).addComment(s2);
    }
    protected void removePost(int index)//doesnt remove from hot posts
    {
        timeLine.remove(index);
    }
    protected int size()
    {
        return timeLine.size();
    }

}
