package spazm.spazm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by Diego Valdez Local on 4/5/2018.
 */

public class Home extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        GridView gridview = findViewById(R.id.hotGridView);
        gridview.setAdapter(new ImageAdapter(this));

        /* gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(Home.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        }); */
    }
}
