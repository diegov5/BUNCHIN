package spazm.spazm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static spazm.spazm.MainActivity.currentIndex;
import static spazm.spazm.MainActivity.hotPosts;
import static spazm.spazm.MainActivity.inHotPost;
import static spazm.spazm.MainActivity.timeLine;

public class ViewPostActivity extends AppCompatActivity {
    protected TopPost current;
    protected SubPost currentComment;
    private static boolean inComments;
    private static int commentIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    /**
     * runs when this activity is started and sets up listeners for various conditions
     * @param
     * @returns
     */
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_viewpostactivity);
        if (inHotPost)
            current = hotPosts.hot.get(currentIndex);
        else
            current = timeLine.timeLine.get(currentIndex);
        if(!inComments) {


           ImageView view = findViewById(R.id.imageDisplayed);//sets image
           view.setImageResource(current.getImage());

           TextView lable = findViewById(R.id.Lable);//sets label
           lable.setText(current.getLabel());

           TextView title = findViewById(R.id.Title);//sets title
           title.setText(" "+current.getTitle());

           TextView username = findViewById(R.id.Username);//sets username
           username.setText(current.poster);

           Button nextPic = findViewById(R.id.nextPic);//send to new activity with next picture
           nextPic.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (inHotPost == true) {
                       if (currentIndex < hotPosts.hot.size() - 1)//if still in hot post
                           currentIndex++;
                       else {
                           inHotPost = false;
                           currentIndex = 0;
                       }
                   } else if (currentIndex < timeLine.size() - 1)
                       currentIndex++;
                   else
                       return;
                   Intent intent = new Intent(ViewPostActivity.this, ViewPostActivity.class);
                   startActivity(intent);
                   finish();
               }
           });
           Button lastPic = findViewById(R.id.lastPic);//send to new activity with last picture
           lastPic.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (inHotPost == true) {
                       if (currentIndex == 0)//if still in hot post
                           return;
                       else {
                           currentIndex--;
                       }
                   } else if (currentIndex == 0) {
                       currentIndex = hotPosts.hot.size() - 1;
                       inHotPost = true;
                   } else
                       currentIndex--;
                   Intent intent = new Intent(ViewPostActivity.this, ViewPostActivity.class);
                   startActivity(intent);
                   finish();
               }
           });

           ImageButton like = findViewById(R.id.Like);//adds like to post
           like.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   current.addLike("default");
               }
           });

           Button toProfile = findViewById(R.id.toProfile);//might be used to send to profile later
           toProfile.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   //goto profile
                   finish();
               }
           });

           Button toComment = findViewById(R.id.toComment);//send them to the comments to view of current post
           toComment.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (current.comments.size() > 0) {
                       inComments = true;
                       commentIndex = 0;
                       Intent intent = new Intent(ViewPostActivity.this, ViewPostActivity.class);
                       startActivity(intent);
                       finish();
                   } else
                       return;

               }
           });
       }else{//if it is a comment
           currentComment = current.getComment(commentIndex);

            ImageView view = findViewById(R.id.imageDisplayed);//sets image
           view.setImageResource(current.getComment(commentIndex).getImage());

           TextView lable = findViewById(R.id.Lable);//sets label
           lable.setText(currentComment.getLabel());

           TextView title = findViewById(R.id.Title);//sets title
           title.setText(current.getTitle());

           TextView username = findViewById(R.id.Username);//sets username
           username.setText(currentComment.poster);

           Button nextPic = findViewById(R.id.nextPic);
           nextPic.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if(commentIndex==current.comments.size()-1){
                       return;
                   }
                   else
                       commentIndex++;
                   Intent intent = new Intent(ViewPostActivity.this, ViewPostActivity.class);
                   startActivity(intent);
                   finish();
               }
           });//goes to last comment
           Button lastPic = findViewById(R.id.lastPic);
           lastPic.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if(commentIndex ==0)
                       return;
                   else
                       commentIndex--;
                   Intent intent = new Intent(ViewPostActivity.this, ViewPostActivity.class);
                   startActivity(intent);
                   finish();
               }
           });//adds like to comment
           ImageButton like = findViewById(R.id.Like);
           like.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   currentComment.addLike("default");
               }
           });
            //unused as of now send user to home screen
           Button toProfile = findViewById(R.id.toProfile);
           toProfile.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   //goto profile
                   finish();
               }
           });



       }
    }
    @Override//used to sent user back to top post when in a comment
    public void onBackPressed(){
        if(inComments){
            inComments = false;
            Intent intent = new Intent(ViewPostActivity.this, ViewPostActivity.class);
            startActivity(intent);
            finish();
        }
        else
            super.onBackPressed();
    }
    @Override//unused
    protected void onDestroy() {
        super.onDestroy();

    }
}
