package spazm.spazm;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {}

    public ImageView newPicture;
    private static int RESULT_LOAD_IMAGE = 1;


    /**
     * When the user comes to the profile page, will initialize fields and display their username
     * in the middle of the page
     * @param  inflater, container, savedInstanceState
     * @returns View
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        User currentUser = User.userList.get(User.userList.size()-1);
        String username = currentUser.getUsername();
        Button changeProfile = (Button) rootView.findViewById(R.id.CHANGE_PIC);
        Button makeNewUser   = (Button) rootView.findViewById(R.id.MAKE_USERS);
        newPicture = (ImageView) rootView.findViewById(R.id.PROFILE_PIC);
        TextView name = rootView.findViewById(R.id.name);
        name.setText("Welcome " + currentUser.getUsername());

        // Give buttons functionality for changing their profile picture
        changeProfile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }

        });

        makeNewUser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent Intent = new Intent(v.getContext(), SignupActivity.class);
                v.getContext().startActivity(Intent);
            }

        });

        return rootView;
    }


    /**
     * When the user finally picks a pictures, it will decode the uri and create a bitmap
     * @param  requestCode,  resultCode, Intent data
     * @returns none
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1 && null != data) {
            decodeUri(data.getData());
        }
    }

    /**
     * Will decode the uri passed in and set the profile picture to the chosen image
     * @param uri
     * @returns none
     */
    public void decodeUri(Uri uri) {
        ParcelFileDescriptor parcelFD = null;
        try {
            parcelFD = getContext().getContentResolver().openFileDescriptor(uri, "r");
            FileDescriptor imageSource = parcelFD.getFileDescriptor();

            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(imageSource, null, o);

            // the new size we want to scale to
            final int REQUIRED_SIZE = 1024;

            // Find the correct scale value. It should be the power of 2.
            int width_tmp = o.outWidth, height_tmp = o.outHeight;
            int scale = 1;
            while (true) {
                if (width_tmp < REQUIRED_SIZE && height_tmp < REQUIRED_SIZE) {
                    break;
                }
                width_tmp /= 2;
                height_tmp /= 2;
                scale *= 2;
            }

            // decode with inSampleSize, and resize to 550x550 pixels
            // Then sets newPicture = to the new photo
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            Bitmap bitmap = BitmapFactory.decodeFileDescriptor(imageSource, null, o2);
            Bitmap croppedBitmap = bitmap.createScaledBitmap(bitmap, 550, 550, true);
            newPicture.setImageBitmap(croppedBitmap);


        } catch (FileNotFoundException e) {
            // handle errors
        } finally {
            if (parcelFD != null)
                try {
                    parcelFD.close();
                } catch (IOException e) {
                    // ignored
                }
        }
    }
}