package top.wenburgyan.androidlearningviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by ywb on 2018-08-10.
 */

public class LinearLayoutForEvent extends LinearLayout {
    public final String tag = "LinearLayoutForEvent";

    public LinearLayoutForEvent(Context context) {
        super(context);
    }

    public LinearLayoutForEvent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(tag, "dispatchTouchEvent "+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(tag, "onTouchEvent "+event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(tag, "onInterceptTouchEvent "+ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }


}
