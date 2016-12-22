package flower.windowanim;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {
    private Scene mAScene, mBScene;
    private ViewGroup mSceneRoot;
    Transition transition,transition_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSceneRoot = (ViewGroup) findViewById(R.id.scene_root);
        //布局创建scene
        mAScene = Scene.getSceneForLayout(mSceneRoot,R.layout.secne_a,this);
        mBScene = Scene.getSceneForLayout(mSceneRoot,R.layout.secne_b,this);

        //代码创建scene
//        ViewGroup viewA = (ViewGroup) View.inflate(this,R.layout.secne_a,null);
//        mAScene = new Scene(mSceneRoot,viewA);
//        ViewGroup viewB = (ViewGroup) View.inflate(this,R.layout.secne_b,null);
//        mBScene = new Scene(mSceneRoot,viewB);

         //设置action
//        mAScene.setEnterAction(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//        mAScene.setExitAction(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });

        //create transition from a resource file
        transition = TransitionInflater.from(this).inflateTransition(R.transition.transition);
        //create transition in code
//        Transition transition1 = new Fade();

        transition_set = TransitionInflater.from(this).inflateTransition(R.transition.transition_set);

    }

    public void go(View v){
        switch (v.getId()){
            case R.id.tv_tans_1:
                //use transition
                TransitionManager.go(mBScene,transition);
                break;
            case R.id.tv_tans_2:
                //use transition
                TransitionManager.go(mAScene,transition_set);
                break;
            case R.id.tv_tans_3:
                Intent i = new Intent(this,TransitionWithoutScene.class);
                startActivity(i);
                break;

        }

    }
}
