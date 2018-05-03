package spazm.spazm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static spazm.spazm.MainActivity.currentIndex;
import static spazm.spazm.MainActivity.hotPosts;
import static spazm.spazm.MainActivity.inHotPost;
import static spazm.spazm.MainActivity.timeLine;

public class ViewPostActivity extends AppCompatActivity {
    protected TopPost current;
    private static boolean inComments;
    private static int commentIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (inHotPost)
            current = hotPosts.hot.get(currentIndex);
        else
            current = timeLine.timeLine.get(currentIndex);

        setContentView(R.layout.activity_viewpostactivity);

        ImageView view = findViewById(R.id.imageDisplayed);//sets image
        view.setImageResource(current.getImage());

        TextView lable = findViewById(R.id.Lable);//sets label
        lable.setText(current.getLabel());

        TextView title = findViewById(R.id.Title);//sets title
        title.setText(current.getTitle());

        TextView username = findViewById(R.id.Username);//sets username
        username.setText(current.poster);

        Button nextPic = findViewById(R.id.nextPic);
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

                Intent intent = new Intent(view.getContext(), ViewPostActivity.class);
                startActivity(intent);
            }
        });
    }
    /*@Override
    protected void onDestroy(Bundle savedInstanceState) {*/
}
