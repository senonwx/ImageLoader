package com.senon.library.load;

import com.senon.library.ImageLoadConfiguration;

/**
 * 加载图片配置 接口
 * 由子类实现 如何加载
 */
public interface BaseImageLoadStrategy {

    void load(ImageLoadConfiguration imageLoadCfg);

}
