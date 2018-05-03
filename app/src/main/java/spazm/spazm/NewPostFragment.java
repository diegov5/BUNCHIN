package spazm.spazm;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
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

import static android.app.Activity.RESULT_OK;

public class NewPostFragment extends Fragment {

    public static final int PICK_IMAGE = 1;
    private static final int RESULT_LOAD_IMAGE = 1;
    public Button takePic;
    private Button post;
    public ImageView imageView;
    private EditText title;
    private EditText numLikes;

    public NewPostFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        getActivity().setTitle("New Post");
        final View rootView = inflater.inflate(R.layout.fragment_newpost, container, false);

        takePic = (Button) rootView.findViewById(R.id.takePic);
        takePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), CameraActivity.class);
                view.getContext().startActivity(Intent);
            }
        });

        Button choosePic = (Button) rootView.findViewById(R.id.choosePic);
        choosePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });


        imageView = (ImageView) rootView.findViewById(R.id.NEW_POST);

        post = (Button) rootView.findViewById(R.id.POST);
        post.setOnClickListener(new View.OnClickListener() {

            //Drawable myDrawable = getResources().getDrawable(R.drawable.NEW_POST);
            @Override
            public void onClick(View view) {
                //Integer ID = imageView;
                title = (EditText) rootView.findViewById(R.id.LABEL);
                numLikes = (EditText) rootView.findViewById(R.id.NUMLIKES);
                //TopPost newPost = new TopPost(imageView, title.getText().toString(), numLikes.getText().toString());

            }
        });

        return rootView;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1 && null != data) {
            decodeUri(data.getData());
        }
    }

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

            imageView.setImageBitmap(bitmap);

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