package spazm.spazm;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Diego Valdez Local on 4/24/2018.
 */

public class SignupActivity extends AppCompatActivity {

    private final static int SELECT_PHOTO = 12345;
    EditText username;
    EditText password;
    //EditText bio ;
    Button signup ;
    Button uploadPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.NEW_USERNAME);
        password = findViewById(R.id.NEW_PASSWORD);
        signup = findViewById(R.id.SIGNUP);
        //uploadPhoto = findViewById(R.id.UPLOADPIC);




       //uploadPhoto.setOnClickListener(pickPhoto);
        signup.setOnClickListener(saveButtonListener);


    }

    protected View.OnClickListener saveButtonListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            if(isValidData())  // When the user clicks the signup button, make sure they have valid input
            {
                User newUser = new User(username,password);
                User.userList.add(newUser);
                Intent Intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(Intent);
            }
            else
            {
                makeToast("Please make sure you make a valid account");
            }
        }
    };

    protected View.OnClickListener pickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent Intent = new Intent(v.getContext(), ImageGalleryActivity.class);
            v.getContext().startActivity(Intent);
        }

    };

    boolean isEmail(EditText text)
    {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text)
    {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }


    protected boolean isValidData()
    {
        boolean usernameGood = false;
        boolean passwordGood = false;
        if(isEmpty(username))
            username.setError("Username is required to register");
        else
            usernameGood = true;

        if(isEmpty(password))
            password.setError("Password is required to register");
        else
            passwordGood = true;

        if(passwordGood && usernameGood)
        {
           // if(isEmpty(bio))
           //     makeToast("You can always change your bio later!");
            return true;
        }

        else
            return false;
    }

    private void makeToast(String message)
    {
        Toast t = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        t.show();
    }

}
