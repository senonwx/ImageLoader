package com.senon.library.strategy;

import android.net.Uri;
import com.senon.library.ImageLoadConfiguration;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.File;
import java.util.Arrays;

/**
 * 具体的加载策略
 */
public class PicassoImageLoadStrategy {

    public static void load(ImageLoadConfiguration imageLoadCfg) {
        RequestCreator requestCreator = null;

        if(imageLoadCfg.load instanceof Uri){
            requestCreator = Picasso.get().load((Uri)imageLoadCfg.load);
        }else if(imageLoadCfg.load instanceof String){
            requestCreator = Picasso.get().load((String)imageLoadCfg.load);
        }else if(imageLoadCfg.load instanceof File){
            requestCreator = Picasso.get().load((File)imageLoadCfg.load);
        }else if(imageLoadCfg.load instanceof Integer){
            requestCreator = Picasso.get().load((Integer)imageLoadCfg.load);
        }

        if (imageLoadCfg.placeholder != null) requestCreator.placeholder(imageLoadCfg.placeholder);
        if (imageLoadCfg.error != null) requestCreator.error(imageLoadCfg.error);
        if (imageLoadCfg.imageWidth != 0 && imageLoadCfg.imageHeight != 0) requestCreator.resize(imageLoadCfg.imageWidth, imageLoadCfg.imageHeight);
        if (imageLoadCfg.transformationsPicasso != null && imageLoadCfg.transformationsPicasso.length > 0)
            requestCreator.transform(Arrays.asList(imageLoadCfg.transformationsPicasso));

        requestCreator.into(imageLoadCfg.imageView);
    }
}
