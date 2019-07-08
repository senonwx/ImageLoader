package com.senon.library.strategy;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.senon.library.ImageLoadConfiguration;

/**
 * 具体的加载策略
 */
public class GlideImageLoadStrategy {

    public static void load(ImageLoadConfiguration imageLoadCfg) {
        RequestManager requestManager = Glide.with(imageLoadCfg.context);
        RequestBuilder requestBuilder = null;

        if (imageLoadCfg.asGif) requestManager.asGif();
        if (imageLoadCfg.load != null) requestBuilder = requestManager.load(imageLoadCfg.load);

        if (imageLoadCfg.placeholder != null) requestBuilder.placeholder(imageLoadCfg.placeholder);
        if (imageLoadCfg.error != null) requestBuilder.error(imageLoadCfg.error);
        if (imageLoadCfg.asCircle) requestBuilder.circleCrop();
        if (imageLoadCfg.thumbnail > 0 && imageLoadCfg.thumbnail < 1) requestBuilder.thumbnail(imageLoadCfg.thumbnail);
        if (imageLoadCfg.imageWidth != 0 && imageLoadCfg.imageHeight != 0) requestBuilder.override(imageLoadCfg.imageWidth, imageLoadCfg.imageHeight);
        if (imageLoadCfg.transformationsGlide != null && imageLoadCfg.transformationsGlide.length > 0) requestBuilder.transform(imageLoadCfg.transformationsGlide);

        requestBuilder.into(imageLoadCfg.imageView);
    }
}
