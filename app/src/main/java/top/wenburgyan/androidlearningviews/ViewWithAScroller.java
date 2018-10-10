package top.wenburgyan.androidlearningviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Scroller;

/**
 * Created by ywb on 2018-08-06.
 */

public class ViewWithAScroller extends android.support.v7.widget.AppCompatTextView {
    private Scroller mScroller;
    private static final String Tag = "ViewWithAScroller";
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
//            ((View)getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            Log.d(Tag, "getScrollX"+getScrollX()+"getScrollY"+getScrollY());
            Log.d(Tag, "mScroller.getCurrX()"+mScroller.getCurrX()+"mScroller.getCurrY()"+mScroller.getCurrY());
            invalidate();
        }
    }

    public void CustomScrollTo(int destX, int destY)
    {
        int startX = getScrollX();
        int startY = getScrollY();
        Log.d(Tag, "CustomScrollTo: "+"startX"+startX+"startY"+startY+"destX"+destX+"destY"+destY);
        mScroller.startScroll(startX, startY, destX-startX, destY-startY, 4000);
        invalidate();
    }

    public void CustomeScrollBy(int dx, int dy)
    {
        int startX = getScrollX();
        int startY = getScrollY();
        Log.d(Tag, "CustomScrollTo: "+"startX"+startX+"startY"+startY+"destX"+startX+dx+"destY"+startY+dy);
        mScroller.startScroll(startX, startY, dx,dy, 4000);
        invalidate();
    }
}
