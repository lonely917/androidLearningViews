package top.wenburgyan.androidlearningviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewEventDispatchActivity extends AppCompatActivity {
    private final String TAG = "ViewEventDispatchActivity";
    private Button mTestButton;
    private TextView mTextView;
    private ImageView mImageView;
    private ViewForEvent viewForEvent;
    private LinearLayoutForEvent viewLinearLayoutForEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event_dispatch);
        mTestButton = (Button) findViewById(R.id.button);
        mTextView = (TextView) findViewById(R.id.textView);
        mImageView = (ImageView) findViewById(R.id.imageView);
        testClickable();

        viewForEvent = (ViewForEvent) findViewById(R.id.viewForEvent);
        viewLinearLayoutForEvent = (LinearLayoutForEvent) findViewById(R.id.linearLayoutForEvent);
    }

    private void testClickable() {
        Log.d(TAG, "onCreate: mTestButton.isClickable()"+mTestButton.isClickable());//true
        Log.d(TAG, "onCreate: mTextView.isClickable()"+mTextView.isClickable());//false
        Log.d(TAG, "onCreate: mImageView.isClickable()"+mImageView.isClickable());//false
        Log.d(TAG, "onCreate: newButton.isClickable()"+ new Button(this).isClickable());//true
        Log.d(TAG, "onCreate: View.isClickable()"+new View(this).isClickable());//false
    }


    public void viewGroupClickable(View view) {
        viewLinearLayoutForEvent.setClickable(!viewLinearLayoutForEvent.isClickable());
        Toast.makeText(getApplicationContext(), "viewLinearLayoutForEvent isclickable "+ viewLinearLayoutForEvent.isClickable(), Toast.LENGTH_SHORT).show();
    }

    public void viewClickable(View view) {
        viewForEvent.setClickable(!viewForEvent.isClickable());
        Toast.makeText(getApplicationContext(), "viewForEvent isclickable "+ viewForEvent.isClickable(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: "+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: "+event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public void onUserInteraction() {
        Log.d(TAG, "onUserInteraction: ");
        super.onUserInteraction();
    }
}
