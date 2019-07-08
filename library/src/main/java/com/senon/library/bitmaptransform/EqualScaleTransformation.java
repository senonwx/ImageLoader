package com.senon.library.bitmaptransform;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

/**
 * Created by chenpengfei on 2017/4/26.
 */
public class EqualScaleTransformation  implements Transformation<Bitmap> {

    private int mMaxWidth, mMaxHeight;

    public EqualScaleTransformation(int maxWdith, int maxHeight) {
        mMaxWidth = maxWdith;
        mMaxHeight = maxHeight;
    }

    @NonNull
    @Override
    public Resource<Bitmap> transform(@NonNull Context context, @NonNull Resource<Bitmap> resource, int outWidth, int outHeight) {
        return null;
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

    }
}
