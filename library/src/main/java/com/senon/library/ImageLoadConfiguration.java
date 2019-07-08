package com.senon.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import java.io.File;

/**
 * 配置图片加载属性
 */
public class ImageLoadConfiguration {

    public final Context context;//上下文
    public final ImageView imageView;//当前ImageView
    //加载model
//    public final String url;//加载网络地址
//    public final File file;//加载文件
//    public final Uri uri;//加载Uri
//    public final Integer resourceId;//加载resourceId
//    public final Bitmap bitmap;//加载Bitmap             Glide才有该属性
//    public final Byte[] bytes;//加载byte[]              Glide才有该属性
//    public final Drawable drawable;//加载Drawable       Glide才有该属性
    public final Object load;//不用传具体类型  Glide内部判断

    public final Integer placeholder;//加载占位图
    public final Integer error;//加载错误图
    public final boolean asCircle;//是否是圆形的
    public final boolean asGif;//是否是gif
    public final float thumbnail;//加载缩略图  参数范围为0~1
    public final int imageWidth;//宽度
    public final int imageHeight;//高度
    public final com.bumptech.glide.load.Transformation[] transformationsGlide;//Glide位图转换
    public final com.squareup.picasso.Transformation[] transformationsPicasso;//Picasso位图转换

    public ImageLoadConfiguration(Builder builder) {
        context = builder.context;
        imageView = builder.into;
//        url = builder.url;
//        file = builder.file;
//        bitmap = builder.bitmap;
//        bytes = builder.bytes;
//        drawable = builder.drawable;
//        uri = builder.uri;
//        resourceId = builder.resourceId;
        load = builder.load;
        asCircle = builder.asCircle;
        asGif = builder.asGif;
        thumbnail = builder.thumbnail;
        placeholder = builder.placeholder;
        error = builder.error;
        imageWidth = builder.imageWidth;
        imageHeight = builder.imageHeight;
        transformationsGlide = builder.transformationsGlide;
        transformationsPicasso = builder.transformationsPicasso;
    }

    public static final class Builder {

        private Context context;
        private ImageView into;
//        private String url;
//        private File file;
//        private Bitmap bitmap;
//        private Byte[] bytes;
//        private Drawable drawable;
//        private Uri uri;
//        private Integer resourceId;
        private Object load;
        private boolean asCircle;
        private boolean asGif;
        private float thumbnail;
        private Integer placeholder;
        private Integer error;
        private int imageWidth;
        private int imageHeight;
        private com.bumptech.glide.load.Transformation[] transformationsGlide;
        private com.squareup.picasso.Transformation[] transformationsPicasso;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder load(String url) {
//            this.url = url;
            this.load = url;
            return this;
        }

        public Builder load(File file) {
//            this.file = file;
            this.load = file;
            return this;
        }

        public Builder load(Bitmap bitmap) {
//            this.bitmap = bitmap;
            this.load = bitmap;
            return this;
        }

        public Builder load(Byte[] bytes) {
//            this.bytes = bytes;
            this.load = bytes;
            return this;
        }

        public Builder load(Drawable drawable) {
//            this.drawable = drawable;
            this.load = drawable;
            return this;
        }

        public Builder load(Uri uri) {
//            this.uri = uri;
            this.load = uri;
            return this;
        }
        public Builder load(Integer resourceId) {
//            this.resourceId = resourceId;
            this.load = resourceId;
            return this;
        }

        public Builder transformationsGlide(com.bumptech.glide.load.Transformation... transformationsGlide) {
            this.transformationsGlide = transformationsGlide;
            return this;
        }

        public Builder transformationsPicasso(com.squareup.picasso.Transformation... transformationsPicasso) {
            this.transformationsPicasso = transformationsPicasso;
            return this;
        }

        public Builder placeholder(Integer placeholder) {
            this.placeholder = placeholder;
            return this;
        }

        public Builder error(Integer error) {
            this.error = error;
            return this;
        }

        public Builder asCircle() {
            this.asCircle = true;
            return this;
        }

        public Builder asGif() {
            this.asGif = true;
            return this;
        }

        public Builder thumbnail(float thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder imageWidth(int imageWidth) {
            this.imageWidth = imageWidth;
            return this;
        }

        public Builder imageHeight(int imageHeight) {
            this.imageHeight = imageHeight;
            return this;
        }

        public Builder into(ImageView imageView) {
            this.into = imageView;
            return this;
        }

        public ImageLoadConfiguration build() {
            return new ImageLoadConfiguration(this);
        }

    }
}
