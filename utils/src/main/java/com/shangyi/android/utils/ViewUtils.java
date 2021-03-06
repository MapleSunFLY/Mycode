package com.shangyi.android.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * <pre>
 *           .----.
 *        _.'__    `.
 *    .--(Q)(OK)---/$\
 *  .' @          /$$$\
 *  :         ,   $$$$$
 *   `-..__.-' _.-\$$/
 *         `;_:    `"'
 *       .'"""""`.
 *      /,  FLY  ,\
 *     //         \\
 *     `-._______.-'
 *     ___`. | .'___
 *    (______|______)
 * </pre>
 * 包    名 : com.fly.postop.core.utils
 * 作    者 : FLY
 * 创建时间 : 2018/10/8
 * 描述: view 帮助类
 */
public class ViewUtils {
    /**
     * 获取屏幕高度
     *
     * @param activity
     * @return
     */
    public static int getHeight(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenHeight = dm.heightPixels;
        return screenHeight;
    }


    /**
     * 获取屏幕宽度
     *
     * @param activity
     * @return
     */
    public static int getWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        return screenWidth;
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int dip2px(float dipValue) {
        final float scale =Utils.getInstance().getContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static float sp2px(float sp) {
        final float scale = Utils.getInstance().getContext().getResources().getDisplayMetrics().scaledDensity;
        return sp * scale;
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    public static void setMargins(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

    /**
     * 设置ImageView的宽高（宽度设定，高度自适应）
     * 需要给你的ImageView布局加上android:adjustViewBounds="true"
     * @param mContext
     * @param mImageView
     * @param margin 宽度的间距
     */
    public static void setImageViewMatchParentWidthAndWrapContentHeight(Context mContext, ImageView mImageView, int margin){
        int width = ViewUtils.getWidth((Activity) mContext);
        ViewGroup.LayoutParams params = mImageView.getLayoutParams();
        params.width = width-=dip2px(mContext,margin);
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        mImageView.setLayoutParams(params);
        mImageView.setMaxWidth(width);
        mImageView.setMaxHeight(width*5);
    }

    /**
     * 设置ImageView的宽高（宽度设定，高度自适应）
     * 需要给你的ImageView布局加上android:adjustViewBounds="true"
     * @param mContext
     * @param mImageView
     * @param mWidth 宽度
     */
    public static void setImageViewWidthAndHeight(Context mContext, ImageView mImageView,float mWidth){
        int width = ViewUtils.dip2px(mContext,mWidth);
        ViewGroup.LayoutParams params = mImageView.getLayoutParams();
        params.width = width;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        mImageView.setLayoutParams(params);
        mImageView.setMaxWidth(width);
        mImageView.setMaxHeight(width*5);
    }

    /**
     * 设置imageView的宽高
     * @param mImageView
     */
    public static void setImageViewWidthAndHeight(ImageView mImageView,int width){
        ViewGroup.LayoutParams params = mImageView.getLayoutParams();
        params.width = width;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        mImageView.setLayoutParams(params);
        mImageView.setMaxWidth(width);
        mImageView.setMaxHeight(width*5);
    }

}
