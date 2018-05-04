package spazm.spazm;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;



public class NewPostFragment extends Fragment {

    public static final int PICK_IMAGE = 1;
    public static final int REQUEST_IMAGE_CAPTURE = 2;
    public ImageView imageView;
    private EditText title;
    private EditText numLikes;
    private String mCurrentPhotoPath;

    // Necessary constructor for fragment
    public NewPostFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        getActivity().setTitle("New Post");
        // Set Layout for fragment
        final View rootView = inflater.inflate(R.layout.fragment_newpost, container, false);
        imageView = rootView.findViewById(R.id.NEW_POST);
        Button post = rootView.findViewById(R.id.POST);

        // Give buttons on the page functionality
        Button takePic = rootView.findViewById(R.id.takePic);
        takePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    dispatchTakePictureIntent();
            }
        });

        Button choosePic = rootView.findViewById(R.id.choosePic);
        choosePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            //Drawable myDrawable = getResources().getDrawable(R.drawable.NEW_POST);
            @Override
            public void onClick(View view) {
                //Integer ID = imageView;
                title = rootView.findViewById(R.id.LABEL);
                numLikes = rootView.findViewById(R.id.NUMLIKES);
                //TopPost newPost = new TopPost(imageView, title.getText().toString(), numLikes.getText().toString());

            }
        });

        return rootView;

    }

    // Handle camera permissions if user decides to take a picture
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    }

    // Handle information received from either choosing or taking a picture
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
            // Check to see if user used the camera
            if (resultCode == REQUEST_IMAGE_CAPTURE || requestCode == REQUEST_IMAGE_CAPTURE) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                BitmapFactory.Options o = new BitmapFactory.Options();

                o.inJustDecodeBounds = true;

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
                BitmapFactory.Options o2 = new BitmapFactory.Options();
                o2.inSampleSize = scale;
                Bitmap croppedBitmap = Bitmap.createScaledBitmap(imageBitmap, 550, 550, true);
                // Make the picture the image view
                imageView.setImageBitmap(croppedBitmap);
            }
            else{
                decodeUri(data.getData());
            }
    }

    // Convert the image the user selected into a usable Bitmap
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

            // decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            Bitmap bitmap = BitmapFactory.decodeFileDescriptor(imageSource, null, o2);
            Bitmap croppedBitmap = Bitmap.createScaledBitmap(bitmap, 550, 550, true);
            imageView.setImageBitmap(croppedBitmap);
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