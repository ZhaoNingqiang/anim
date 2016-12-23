package flower.windowanim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

/**
 * @author 赵凝强
 * @version 1.0.0
 * @Time 16/12/23/下午2:45
 */

public class CircularRevealActivity extends AppCompatActivity {

    private ImageView iv_bick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_reveal);

        iv_bick = (ImageView) findViewById(R.id.iv_bike);

    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void go(View v) {
        switch (v.getId()) {
            case R.id.btn_show: {
                int cx = (iv_bick.getLeft() + iv_bick.getRight()) / 2;
                int cy = (iv_bick.getTop() + iv_bick.getBottom()) / 2;

                int radius = Math.max(iv_bick.getWidth(), iv_bick.getHeight());

                Animator circularReveal = ViewAnimationUtils.createCircularReveal(iv_bick, cx, cy, 0, radius);

                iv_bick.setVisibility(View.VISIBLE);

                circularReveal.start();
            }
            break;

            case R.id.btn_hide: {
                int cx = (iv_bick.getLeft() + iv_bick.getRight()) / 2;
                int cy = (iv_bick.getTop() + iv_bick.getBottom()) / 2;

                int radius = iv_bick.getWidth();
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(iv_bick, cx, cy, radius, 0);
                circularReveal.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        iv_bick.setVisibility(View.INVISIBLE);
                    }
                });
                circularReveal.start();


            }


            break;
        }
    }
}
