package flower.windowanim.transition;

import android.animation.Animator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.ViewGroup;

/**
 * @author 赵凝强
 * @version 1.0.0
 * @Time 16/12/21/下午4:47
 */

public class CustomTransition extends Transition {
    @Override
    public void captureStartValues(TransitionValues transitionValues) {

    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {

    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {






        return super.createAnimator(sceneRoot, startValues, endValues);
    }
}
