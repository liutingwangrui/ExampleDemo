package example.com.library.util.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import example.com.library.R;


/**
 * Created by Administrator on 2018/6/21 0021.
 * Glide加载图片的工具类
 */

public class GlideLoadImgUtil {
    /**
     * 普通图片加载
     *
     * @param context
     * @param img
     * @param path
     */
    public static void loadImageView(Context context, ImageView img, String path) {
        Glide.with(context).load(path)
                .error(context.getResources().getDrawable(R.mipmap.ic_launcher))
                .placeholder(context.getResources().getDrawable(R.mipmap.ic_launcher))

                .into(img);
    }

    /**
     * 圆形图片加载
     *
     * @param context
     * @param img
     * @param path
     */
    public static void loadCircleImageView(Context context, ImageView img, String path) {
        Glide.with(context).load(path)
                .error(context.getResources().getDrawable(R.mipmap.ic_launcher))
                .placeholder(context.getResources().getDrawable(R.mipmap.ic_launcher))
                .transform(new CenterCrop(context), new GlideCircleTransform(context))
                .into(img);
    }

    /**
     * 圆角矩形图片加载
     *
     * @param context
     * @param img
     * @param path
     */
    public static void loadRoundImageView(Context context, ImageView img, String path) {
        Glide.with(context)
                .load(path)
                .error(R.mipmap.ic_launcher)
                .placeholder(context.getResources().getDrawable(R.mipmap.ic_launcher))
                .transform(new CenterCrop(context), new GlideRoundTransform(context))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .override(300, 300)
                .into(img);
    }


}
