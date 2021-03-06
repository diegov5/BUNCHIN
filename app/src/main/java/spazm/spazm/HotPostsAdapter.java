package spazm.spazm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import static spazm.spazm.MainActivity.hotPosts;

/**
 * Created by Diego Valdez Local on 4/12/2018.
 */

public class HotPostsAdapter extends BaseAdapter {
    private Context mContext;

    public HotPostsAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return hotPosts.hot.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(220, 220));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //imageView.setPadding(2, 2, 2, 2);
        } else {
            imageView = (ImageView) convertView;
        }

        //imageView.setImageResource(mThumbIds[position]);
        hotPosts.updateHotPosts();
        imageView.setImageResource(hotPosts.hot.get(position).getImage());
        return imageView;
    }

    // references to our images in the gridView
    private Integer[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
    };
}