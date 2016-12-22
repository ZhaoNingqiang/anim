package flower.windowanim;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author 赵凝强
 * @version 1.0.0
 * @Time 16/12/20/下午8:03
 */

public class TransitionWithoutScene extends AppCompatActivity {
    ViewGroup mainLayout;
    Fade mFade;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        mainLayout = (ViewGroup) findViewById(R.id.mainLayout);
        mFade = new Fade(Fade.IN);
        //设置监听回调
        mFade.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {

            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });
    }

    public void go(View view) {
        switch (view.getId()) {
            case R.id.btn_transition:
                TransitionManager.beginDelayedTransition(mainLayout, mFade);
                TextView textView = new TextView(this);
                textView.setText("Lable");
                mainLayout.addView(textView);
                break;
            case R.id.btn_normal:
                TextView textView2 = new TextView(this);
                textView2.setText("Lable2");
                mainLayout.addView(textView2);
                break;
        }


    }
}
