package spazm.spazm;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import java.io.IOException;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {}


    User currentUser;
    public ImageView newPicture;
    private int PICK_IMAGE_REQUEST = 1;
    private static int RESULT_LOAD_IMAGE = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //super.onCreateView(inflater, container, savedInstanceState);
        //getActivity().setTitle("Profile");
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

            User currentUser = User.userList.get(User.userList.size()-1);
            String username = currentUser.getUsername();





        Button changeProfile = (Button) rootView.findViewById(R.id.CHANGE_PIC);
        Button makeNewUser   = (Button) rootView.findViewById(R.id.MAKE_USERS);
        newPicture = (ImageView) rootView.findViewById(R.id.PROFILE_PIC);
        TextView name = rootView.findViewById(R.id.name);
        name.setText("Welcome " + currentUser.getUsername());
        changeProfile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {



                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                intent.setType("image/*");
                intent.putExtra("crop", "true");
                intent.putExtra("scale", true);
                intent.putExtra("outputX", 256);
                intent.putExtra("outputY", 256);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, 1);

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContext().getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) getView().findViewById(R.id.PROFILE_PIC);
            imageView.getLayoutParams().height = 600;
            imageView.getLayoutParams().width = 600;
            //imageView.setLayoutParams(new ViewGroup.LayoutParams(220,220));
            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));




        }
    }
}