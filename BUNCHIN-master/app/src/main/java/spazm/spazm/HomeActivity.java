package spazm.spazm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by Diego Valdez Local on 4/5/2018.
 */

public class HomeActivity extends AppCompatActivity  {

    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Populate the grid view in the XML doc through help of ImageAdapter Class
        GridView gridView = findViewById(R.id.hotGridView);
        gridView.setAdapter(new ImageAdapter(this));

        // Give each picture in gridView button functionality
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(HomeActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Attempt to use gesture swiping with activities
        /*
        gestureDetector = new GestureDetector(this, new SwipeDetector());
        gestureListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        };*/
    }
}
