package com.senon.library.load;

import com.senon.library.ImageLoadConfiguration;
import com.senon.library.strategy.PicassoImageLoadStrategy;

/**
 * Picasso加载图片的策略
 */
public class PicassoImageLoad implements BaseImageLoadStrategy {

    @Override
    public void load(ImageLoadConfiguration imageLoadCfg) {
        PicassoImageLoadStrategy.load(imageLoadCfg);
    }

}
