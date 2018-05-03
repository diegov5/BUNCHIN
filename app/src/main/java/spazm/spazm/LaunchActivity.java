package spazm.spazm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        // Have login button send you straight to the Home activity
        Button login = (Button) findViewById(R.id.LOGIN);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(Intent);
                finish();
            }
        });

        Button signup = (Button) findViewById(R.id.SIGNUP);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), SignupActivity.class);
                view.getContext().startActivity(Intent);}
        });

        /*
        Button test = (Button) findViewById(R.id.TEST);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(Intent);}
        });
        */
    }
}
