package top.wenburgyan.androidlearningviews;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ViewCoordinateActivity extends AppCompatActivity {

    private final String tag = "ViewCoordinateActivity";
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_coordinate);
        view = findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Log.d(tag, "click v.getX():"+v.getX()+"v.getY():"+v.getY());
                Log.d(tag, "click v.getLeft:"+v.getLeft()+"v.getTop():"+v.getTop()+"v.getRight():"+v.getRight()+"v.getBottom():"+v.getBottom());
                Log.d(tag, "click v.getTranslationX:"+v.getTranslationX()+"v.getTranslationY:"+v.getTranslationY()+"v.getTranslationZ():"+v.getTranslationZ());
            }
        });
    }
}
