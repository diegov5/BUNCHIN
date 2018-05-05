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
 * Created by David Ihle Local on 4/26/2018. The signup activity will implement the logic
 * of creating a new user, making sure the user inputs a username and password, and adding them to
 * the Arraylist of users
 */

public class SignupActivity extends AppCompatActivity {


    EditText username;
    EditText password;
    Button signup ;


    /**
     * When the function is first called, you will be taken to the signup page
     * and initialize the variables to be used in creating a User
     * @param savedInstanceState
     * @returns none
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.NEW_USERNAME);
        password = findViewById(R.id.NEW_PASSWORD);

        // Give the signup button a job to do when pushed
        signup = findViewById(R.id.SIGNUP);
        signup.setOnClickListener(saveButtonListener);


    }

    /**
     * Will make sure the input is valid and create a new User. It will then send the user
     * to the homepage of the app
     * @param savedInstanceState
     * @returns none
     */
    protected View.OnClickListener saveButtonListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            if(isValidData())  // When the user clicks the signup button, make sure they have valid input
            {
                User newUser = new User(username,password);
                User.userList.add(newUser);

                Intent Intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(Intent);
                User.printUserList();
            }
            else
            {
                makeToast("Please make sure you make a valid account");
            }
        }
    };

    /**
     * Will check if the textbox is empty
     * @param text
     * @returns True if the given text field is empty, false otherwise
     */
    boolean isEmpty(EditText text)
    {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    /**
     * Will make sure that the username and password fields aren't empty
     * @param
     * @returns true if the inputs meet all specifications, false otherwise
     */
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

            return true;
        }

        else
            return false;
    }

    /**
     * Will create a short popup message displayed on the current view
     * @param message
     * @returns none
     */
    private void makeToast(String message)
    {
        Toast t = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        t.show();
    }

}
