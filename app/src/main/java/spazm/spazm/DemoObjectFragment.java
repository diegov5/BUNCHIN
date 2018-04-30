package spazm.spazm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A dummy fragment representing a section of the app, but that simply displays dummy text.
 */
public class DemoObjectFragment extends Fragment {

    public DemoObjectFragment() {}

    public static final String ARG_OBJECT = "object";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        getActivity().setTitle("Timeline");
        View rootView = inflater.inflate(R.layout.activity_home, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.hotGridView);
        gridView.setAdapter(new ImageAdapter(getActivity()));

        // Give each picture in gridView button functionality
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}