package flower.windowanim;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * @author 赵凝强
 * @version 1.0.0
 * @Time 16/12/13/上午11:35
 */

public class FrescoHelper {


    public static void load(String url, SimpleDraweeView draweeView, BaseControllerListener listener) {
        ImageRequest request =
                ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                        .setProgressiveRenderingEnabled(true)//支持图片渐进式加载
                        .setAutoRotateEnabled(true) //如果图片是侧着,可以自动旋转
                        .build();

        PipelineDraweeController controller =
                (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setControllerListener(listener)
                        .setOldController(draweeView.getController())
                        .setAutoPlayAnimations(true) //自动播放gif动画
                        .build();

        draweeView.setController(controller);
    }


    /**
     * 拿到指定宽高，并经过Processor处理的bitmap
     * @param url
     * @param context
     * @param width
     * @param height
     * @param listener
     *
     */
    public static void getBitmapWithProcessor(String url, Context context, int width, int height,
                                             final BitmapListener listener){

        ResizeOptions resizeOptions = null;
        if (width !=0 && height != 0 ){
            resizeOptions = new ResizeOptions(width, height);
        }

        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                .setProgressiveRenderingEnabled(false)
                //我们是拿bitmap对象,不是显示,所以这里不需要渐进渲染
                .setResizeOptions(resizeOptions)
                .build();

        ImagePipeline imagePipeline = Fresco.getImagePipeline();

        DataSource<CloseableReference<CloseableImage>> dataSource = imagePipeline.fetchDecodedImage(imageRequest, context.getApplicationContext());
        dataSource.subscribe(new BaseBitmapDataSubscriber() {
            @Override
            protected void onNewResultImpl(Bitmap bitmap) {
                listener.onSuccess(bitmap);
            }

            @Override
            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                listener.onFail();
            }
        }, CallerThreadExecutor.getInstance());

    }

    public interface BitmapListener{
        public void onSuccess(Bitmap bitmap);
        public void onFail();
    }


}
