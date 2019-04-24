package Listview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

public class MyBlock  {
    private String station;
    private String location;
    private Button button;

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;

    }

    public MyBlock(String name, String location) {
        this.station = name;
        this.location = location;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String name) {
        this.station = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void onClick(Activity activity){
        final Activity act = activity;
        final String url = "https://google.com/search?q="+this.station;
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                act.startActivity(intent);
            }
        });
    }
}
