package spazm.spazm;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Diego Valdez Local on 4/24/2018.
 */

public class SignupActivity extends AppCompatActivity {


    //private final static int SELECT_PHOTO = 12345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button addTextButton = (Button) findViewById(R.id.SIGNUP);
        final EditText username = (EditText) findViewById(R.id.NEW_USERNAME);
        final EditText password = (EditText)findViewById(R.id.NEW_PASSWORD);
        final EditText biography = (EditText) findViewById(R.id.NEW_BIOGRAPHY);



        addTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValidInput(username,password,biography)) // Check if the fields have been properly filled out
                {
                    User newUser = new User(username, password, biography);
                    User.userList.add(newUser);
                    System.out.println("THE NUMBER OF USERS IS CURRENTLY: " + User.userList.size());
                    Intent Intent = new Intent(view.getContext(), HomeActivity.class);
                    view.getContext().startActivity(Intent);
                }
            }
        });

    }


    /**
     * Will create a Toast notification on the screen with given message
     * @param message
     * @returns nothing
     */
    public void makeToast(String message)
    {
        Toast t = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        t.show();
    }

    /**
     * Will check if the entered string is an email
     * @param text from the Email text field
     * @returns true if the input text is an email, false otherwise
     */
    boolean isEmail(EditText text)
    {
        CharSequence email = text.getText().toString();   // Will check if the user has input anything
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    /**
     * Will check if the entered string is empty
     * @param text from the Email text field
     * @returns true if the input text is empty, false otherwise
     */
    boolean isEmpty(EditText text)
    {
        CharSequence str = text.getText().toString();   // Will check if the user has input anything
        return TextUtils.isEmpty(str);
    }

    /**
     * Will check if the required fields: password, username, and optional fields: biography
     * @param  username, password and biography
     * @returns true if the required fields are filled out, false otherwise
     */
    boolean isValidInput(EditText username, EditText password, EditText biography)
    {
        boolean userNameIsGood = false;
        boolean passWordIsGood = false;


        // If the username field is empty, make a pop-up error message telling user to enter valid username
        if(isEmpty(username))
        {
           username.setError("Username is required to register!");
        }
        else
        {
            userNameIsGood = true;
        }


        // If the username field is empty, make a pop-up note telling user to enter valid password
        if(isEmpty(password))
        {
            password.setError("Password is required to register!");
        }
        else
        {
            passWordIsGood = true;
        }

        // If the username field is empty, make a pop-up error message telling user to enter valid username
        if(isEmpty(biography))
        {
            Toast t = Toast.makeText(this, "You can always add a biography later!", Toast.LENGTH_SHORT);
            t.show();
        }


        if(userNameIsGood && passWordIsGood )
        {
            return true; // if the required fields userName and password pass all requirements, true
        }
        else
        {
            return false;
        }
    }

    /*

    // Will Read the data from the text fields when the user clicks submit
    public View.OnClickListener submitButtonListener = new View.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            String newUsername = username.getText().toString();

            if (newUsername.length() > 0)
            {
                String existingText =((TextView) findViewById(R.id.NEW_USERNAME)).getText().toString();
                ((TextView) findViewById(R.id.NEW_USERNAME)).setText(existingText + (char)10 + (char)13 + newUsername );
                username.setText("");
            }else
            {
                //Print statement telling user to input a valid string
            }

            String newPassword = PASSWORD.getText().toString();

            if (newPassword.length() > 0)
            {
                String existingText =((TextView) findViewById(R.id.NEW_PASSWORD)).getText().toString();
                ((TextView) findViewById(R.id.NEW_PASSWORD)).setText(existingText + (char)10 + (char)13 + newPassword );
                USERNAME.setText("");
            }else
            {
                //Print statement telling user to input a valid Password
            }

            String newBio = BIOGRAPHY.getText().toString();

            if (newBio.length() > 0)
            {
                String existingText =((TextView) findViewById(R.id.NEW_BIOGRAPHY)).getText().toString();
                ((TextView) findViewById(R.id.NEW_BIOGRAPHY)).setText(existingText + (char)10 + (char)13 + newBio );
                USERNAME.setText("");
            }else
            {
                //Print statement telling user to input a valid Biography
            }
        }
    };*/





     /*imagePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
            }
        });

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            // Here we need to check if the activity that was triggers was the Image Gallery.
            // If it is the requestCode will match the LOAD_IMAGE_RESULTS value.
            // If the resultCode is RESULT_OK and there is some data we know that an image was picked.
            if (requestCode == SELECT_PHOTO && resultCode == RESULT_OK && data != null) {
                // Let's read picked image data - its URI
                Uri pickedImage = data.getData();
                // Let's read picked image path using content resolver
                String[] filePath = { MediaStore.Images.Media.DATA };
                Cursor cursor = getContentResolver().query(pickedImage, filePath, null, null, null);
                cursor.moveToFirst();
                String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);
                imageView.setImageBitmap(bitmap);

                // Do something with the bitmap


                // At the end remember to close the cursor or you will end with the RuntimeException!
                cursor.close();
            }
        }
        */
}
