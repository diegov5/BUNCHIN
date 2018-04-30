package spazm.spazm;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NewPostFragment extends Fragment {

    public NewPostFragment() {
    }

    ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        getActivity().setTitle("Timeline");
        View rootView = inflater.inflate(R.layout.fragment_newpost, container, false);

        return rootView;
    }
}