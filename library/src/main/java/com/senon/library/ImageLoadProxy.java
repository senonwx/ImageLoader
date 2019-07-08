package com.senon.library;

import android.util.Log;
import com.senon.library.load.BaseImageLoadStrategy;
import com.senon.library.load.GlideImageLoad;
import com.senon.library.load.PicassoImageLoad;

/**
 * 初始化图片加载模块
 */
public class ImageLoadProxy {

    public static final int IMAGE_LOAD_GLIDE = 1;
    public static final int IMAGE_LOAD_PICASSO = 2;

    private static ImageLoadProxy mInstance;
    private BaseImageLoadStrategy mImageLoad;

    public static ImageLoadProxy getInstance() {
        if (mInstance == null) {
            synchronized (ImageLoadProxy.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoadProxy();
                }
            }
        }
        return mInstance;
    }


    private ImageLoadProxy() {
    }

    public void init(int imageLoadType) {
        switch (imageLoadType) {
            case IMAGE_LOAD_GLIDE:
                mImageLoad = new GlideImageLoad();
                break;
            case IMAGE_LOAD_PICASSO:
                mImageLoad = new PicassoImageLoad();
                break;
            default:
                mImageLoad = new GlideImageLoad();
                break;
        }
    }

    public void load(ImageLoadConfiguration imageLoadCfg) {
        if (mImageLoad == null || imageLoadCfg == null){
            Log.e("ImageLoadProxy","ImageLoad or ImageLoadConfiguration is null");
            return;
        }
        mImageLoad.load(imageLoadCfg);
    }


}
