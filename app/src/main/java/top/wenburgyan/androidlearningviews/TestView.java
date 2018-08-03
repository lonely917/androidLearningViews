package top.wenburgyan.androidlearningviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by ywb on 2018-07-31.
 */

public class TestView extends View {
    int lastX, lastY;
    String tag = "TestView";

    public TestView(Context context) {
        super(context);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    lastX = (int) event.getX();
                    lastY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:

                    //计算移动的距离
                    int offsetX = x - lastX;
                    int offsetY = y - lastY;

//                    //调用layout方法来重新放置它的位置
//                    layout(getLeft()+offsetX, getTop()+offsetY,getRight()+offsetX , getBottom()+offsetY);
//
//                    //offset方法
//                    offsetLeftAndRight(offsetX);
//                    offsetTopAndBottom(offsetY);
//
//                    //LayoutParameters
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                    layoutParams.leftMargin = getLeft()+offsetX;
                    layoutParams.topMargin = getTop()+offsetY;
                    setLayoutParams(layoutParams);

                    //scroll by , why negative value?  and after scroll the getleft and gettop  are still the same as original value
//                    ((View)getParent()).scrollBy(-offsetX,-offsetY);
                    break;

                case MotionEvent.ACTION_UP:
                    Log.d(tag, "event.getX():"+event.getX()+"event.getY():"+event.getY());
                    Log.d(tag, "event.getRawX:"+event.getRawX()+"event.getRawY():"+event.getRawY());

                    Log.d(tag, "v.getX():"+this.getX()+"v.getY():"+this.getY());
                    Log.d(tag, "v.getLeft:"+this.getLeft()+"v.getTop():"+this.getTop()+"v.getRight():"+this.getRight()+"v.getBottom():"+this.getBottom());
                    break;
                default:
                    break;
        }

        //这里统一 return false 会导致收不到action move 和 up,因为down事件返回了false就不会在接收到后续事件。
        //这里统一 return true 会导致所有处理都在这里，view外部的onclick将不会触发
        return super.onTouchEvent(event);
    }
}
