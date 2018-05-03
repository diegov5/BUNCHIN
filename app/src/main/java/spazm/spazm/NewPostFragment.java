package spazm.spazm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NewPostFragment extends Fragment {

    public NewPostFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        getActivity().setTitle("New Post");
        View rootView = inflater.inflate(R.layout.fragment_newpost, container, false);

        Button takePic = (Button) rootView.findViewById(R.id.takePic);
        takePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), CameraActivity.class);
                view.getContext().startActivity(Intent);}
        });
        return rootView;
    }
}