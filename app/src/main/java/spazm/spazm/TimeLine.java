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
        TopPost t8 = new TopPost(R.drawable.img1,"Music Stands","McLovin");
       // TopPost t9 = new TopPost(R.drawable.img2,"Sunset","McLovin");
       /* TopPost t10 = new TopPost(R.drawable.img3,"Catan","MonopolySheep");
        TopPost t11= new TopPost(R.drawable.img4,"Should i Get?","SuitGuy");
        TopPost t12 = new TopPost(R.drawable.img5,"Dirt Bike","HogRider");
        //TopPost t13 = new TopPost(R.drawable.img7,"GoZags","Corey");*/

        t3.addLike("BhadBhabie");
        t3.addLike("MeLoveDog");
        t1.addLike("BhadBhabie");
        //t12.addLike("BhadBhabie");
        //t13.addLike("BhadBhabie");
        //t11.addLike("BhadBhabie");
        //t10.addLike("BhadBhabie");
       // t9.addLike("BhadBhabie");
        //t9.addLike("MeLoveDog");
        SubPost s0 = new SubPost(R.drawable.logo_circle,"Xx_poser_xX");
        SubPost s1 = new SubPost(R.drawable.sample_6,"Sixty9");
        SubPost s2 = new SubPost(R.drawable.sample_5,"60Nine");
        //this.addPost(t11);
        this.addPost(t0);
        this.addPost(t8);
        //this.addPost(t10);
        this.addPost(t1);
       // this.addPost(t9);
        this.addPost(t2);
        //this.addPost(t12);
        this.addPost(t3);
        this.addPost(t4);
        //this.addPost(t13);
        this.addPost(t5);
        this.addPost(t6);
        this.addPost(t7);
        timeLine.get(3).addComment(s0);
        timeLine.get(3).addComment(s1);
        timeLine.get(3).addComment(s2);
        timeLine.get(2).addComment(s0);
        timeLine.get(2).addComment(s1);
        timeLine.get(1).addComment(s2);
        timeLine.get(6).addComment(s0);
        timeLine.get(6).addComment(s1);
        timeLine.get(6).addComment(s2);
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
