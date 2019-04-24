package Listview;

import android.widget.Button;

public class MyBlock {
    private String location;
    private String descript;
    private Button button;

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;

    }

    public MyBlock(String location, String descript) {
        this.location = location;
        this.descript = descript;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

}
