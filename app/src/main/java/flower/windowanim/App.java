package flower.windowanim;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author 赵凝强
 * @version 1.0.0
 * @Time 16/12/13/下午2:07
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
