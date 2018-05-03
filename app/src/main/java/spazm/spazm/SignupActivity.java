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
