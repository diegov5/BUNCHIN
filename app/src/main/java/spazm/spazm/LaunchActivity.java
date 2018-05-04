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
        if(User.userList.size() > 0){
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent Intent = new Intent(view.getContext(), MainActivity.class);
                    view.getContext().startActivity(Intent);
                    finish();
                }
            });
        }
        else {
            login.setError("You must create an account first");
        }

        // Have signup button send you to the respective page
        Button signup = (Button) findViewById(R.id.SIGNUP);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), SignupActivity.class);
                view.getContext().startActivity(Intent);}
        });
    }
}
