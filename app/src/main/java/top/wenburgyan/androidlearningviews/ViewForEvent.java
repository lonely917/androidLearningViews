package top.wenburgyan.androidlearningviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ywb on 2018-08-10.
 */

public class ViewForEvent extends View {
    String tag = "ViewForEvent"+this.getId();
    public ViewForEvent(Context context) {
        super(context);
    }

    public ViewForEvent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(tag, "dispatchTouchEvent"+String.valueOf(event.getAction()));
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(tag, "onTouchEvent"+String.valueOf(event.getAction()));
        return super.onTouchEvent(event);
    }
}
