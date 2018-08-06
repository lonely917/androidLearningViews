package top.wenburgyan.androidlearningviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by ywb on 2018-08-06.
 */

public class ViewWithAScroller extends View {
    private Scroller mScroller;
    public ViewWithAScroller(Context context) {
        super(context);
        mScroller = new Scroller(context);
    }

    public ViewWithAScroller(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset())
        {
            ((View)getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    public void CustomeScroll(int destX, int destY)
    {
        int startX = getScrollX();
        int startY = getScrollY();
        mScroller.startScroll(startX, startY, destX-startX, destY-startY, 1000);
        invalidate();
    }
}
