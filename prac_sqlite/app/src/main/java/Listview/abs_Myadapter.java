package Listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.test0.pwing.prac_sqlite.R;

import java.util.ArrayList;

public abstract class abs_Myadapter extends ArrayAdapter {
    private Context mContext;
    private ArrayList<MyBlock> myBlockArrayList;
    private int mLayout;
    private String url;

    public abs_Myadapter(Context context, int layout, ArrayList<MyBlock> myBlockArrayList) {
        super(context, layout, myBlockArrayList);
        this.myBlockArrayList = myBlockArrayList;
        this.mContext = context;
        this.mLayout = layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            view = inflater.inflate(mLayout, parent, false);
        }

        MyBlock block = myBlockArrayList.get(position);

//            ImageView img = (ImageView) view.findViewById(R.id.LocationImageView);
//            img.setImageResource(block.getImage);

        TextView tvName = (TextView) view.findViewById(R.id.NameTextView);
        tvName.setText(block.getStation());

        TextView tvDesc = (TextView) view.findViewById(R.id.DescTextView);
        String location = block.getLocation();
        tvDesc.setText(location);

        block.setButton((Button) view.findViewById(R.id.googleBV));
        url = "https://google.com/search?q=" + location;
        block.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWeb();
            }
        });


        return view;
    }

    public abstract void openWeb();

    public String getUrl() {
        return url;
    }
}