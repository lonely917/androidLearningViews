package top.wenburgyan.androidlearningviews;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AnimatorActivity extends AppCompatActivity implements View.OnClickListener{

    final String tag = "AnimatorActivity";
    Button button1, button2, button3;
    TextView textView;
    ViewWithAScroller viewWithAScroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        button1 = (Button) findViewById(R.id.buttonAnimate1);
        button2 = (Button) findViewById(R.id.buttonAnimate2);
        button3 = (Button) findViewById(R.id.buttonGetCoordinate);
        textView = (TextView) findViewById(R.id.textView);
        viewWithAScroller = (ViewWithAScroller) findViewById(R.id.viewWithAScroller);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        viewWithAScroller.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonAnimate1:
                animateOne();
//                animateThree();// load animator from xml
                break;
            case R.id.buttonAnimate2:
                animateTwo();
                break;
            case R.id.buttonGetCoordinate:
                getCoordinate(textView);
                break;
            case R.id.viewWithAScroller:
                viewWithAScroller.CustomeScroll((int)viewWithAScroller.getX()-100, (int)viewWithAScroller.getY()-100);
//                viewWithAScroller.CustomeScroll(-400, 0);
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void getCoordinate(View v) {
        Log.d(tag, "click v.getX():"+v.getX()+"v.getY():"+v.getY());
        Log.d(tag, "click v.getLeft:"+v.getLeft()+"v.getTop():"+v.getTop()+"v.getRight():"+v.getRight()+"v.getBottom():"+v.getBottom());
        Log.d(tag, "click v.getTranslationX:"+v.getTranslationX()+"v.getTranslationY:"+v.getTranslationY()+"v.getTranslationZ():"+v.getTranslationZ());
    }

    private void animateOne() {

        //objectAnimator
        //针对translationX 进行values中数值集合的变化，动画持续时间为duration的数值，单位ms，默认设置为300ms，start后启动动画
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "translationX", 200,-200,200);
        objectAnimator.setDuration(5000);

        //activity destroy或者pause后，动画依然在进行?
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                Toast.makeText(getApplicationContext(), "animation start", Toast.LENGTH_SHORT).show();
                Log.d(tag, "onAnimationStart");
            }

            @Override
            public void onAnimationPause(Animator animation) {
                Toast.makeText(getApplicationContext(), "animation pause", Toast.LENGTH_SHORT).show();
                Log.d(tag, "onAnimationPause");
            }

            @Override
            public void onAnimationResume(Animator animation) {
                Toast.makeText(getApplicationContext(), "animation resume", Toast.LENGTH_SHORT).show();
                Log.d(tag, "onAnimationResume");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(getApplicationContext(), "animation end", Toast.LENGTH_SHORT).show();
                Log.d(tag, "onAnimationEnd");
            }
        });
        objectAnimator.start();
    }

    private void animateTwo(){

        // animatorSet
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(textView, "translationX", 200,-200,200);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(textView, "translationY", 200,-200,200);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(textView, "scaleX", 1.0f,0.5f,1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(5000);
        animatorSet.playTogether(animator1,animator2,animator3);
        animatorSet.start();
    }

    private void animateThree(){

        //load from xml
        Animator animator = AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.scale);
        animator.setTarget(textView);
        animator.start();
    }

}
