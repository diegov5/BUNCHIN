package spazm.spazm;import android.content.Context;import android.graphics.Color;import android.view.View;import android.view.ViewGroup;import android.widget.BaseAdapter;import android.widget.ImageView;import android.widget.TextView;import static spazm.spazm.MainActivity.timeLine;public class TimelineAdapter extends BaseAdapter {    private Context mContext;    public TimelineAdapter(Context c) {        mContext = c;    }    public int getCount() {        return timeLine.size();    }    public Object getItem(int position) {        return null;    }    public long getItemId(int position) {        return 0;    }    // create a new ImageView for each item referenced by the Adapter    public View getView(int position, View convertView, ViewGroup parent) {        if(position % 2 == 0)        {            ImageView imageView;            TextView textView;            if (convertView == null) {                // if it's not recycled, initialize some attributes                imageView = new ImageView(mContext);                imageView.setLayoutParams(new ViewGroup.LayoutParams(220, 220));                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);                //imageView.setPadding(2, 2, 2, 2);            } else {                imageView = (ImageView) convertView;            }            imageView.setImageResource(timeLine.getPost(position/2).getImage());            return imageView;        } else{            TextView textView;            if (convertView == null) {                // if it's not recycled, initialize some attributes                textView = new TextView(mContext);                textView.setLayoutParams(new ViewGroup.LayoutParams(220, 220));                textView.setTextColor(Color.WHITE);                textView.setTextSize(15);                //imageView.setPadding(2, 2, 2, 2);            } else {                textView = (TextView) convertView;            }            textView.setText("Posted by: " + timeLine.getPost(position/2).getTitle());            return textView;        }    }}