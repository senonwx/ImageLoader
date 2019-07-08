package com.senon.library.load;

import com.senon.library.ImageLoadConfiguration;
import com.senon.library.strategy.GlideImageLoadStrategy;

/**
 * Glide加载图片的策略
 */
public class GlideImageLoad implements BaseImageLoadStrategy {

    @Override
    public void load(ImageLoadConfiguration imageLoadCfg) {
        GlideImageLoadStrategy.load(imageLoadCfg);
    }

}
