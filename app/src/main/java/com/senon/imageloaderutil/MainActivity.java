package com.senon.imageloaderutil;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.senon.library.ImageLoadConfiguration;
import com.senon.library.ImageLoadProxy;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.MaskTransformation;
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation;



public class MainActivity extends AppCompatActivity {
    private String url = "https://p5.ssl.qhimgs1.com/sdr/400__/t017adbb090d352381b.gif";
    private String url2 = "http://imgsrc.baidu.com/baike/pic/item/7aec54e736d12f2ee289bffe4cc2d5628435689b.jpg";
    private ImageView image,image2,image3,igv,igv2,igv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageLoadProxy.getInstance().init(ImageLoadProxy.IMAGE_LOAD_GLIDE);

        image = findViewById(R.id.image);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        igv = findViewById(R.id.igv);
        igv2 = findViewById(R.id.igv2);
        igv3 = findViewById(R.id.igv3);


        initBaseView();

        /**
         * 要使用不同的位图转换  在library build.gradle切换不同的GPU Filters
         */
        // 初始化图片加载模块
        ImageLoadProxy.getInstance().init(ImageLoadProxy.IMAGE_LOAD_GLIDE);
        loadByGlide();

//        ImageLoadProxy.getInstance().init(ImageLoadProxy.IMAGE_LOAD_PICASSO);
//        loadByPicasso();

    }

    private void initBaseView() {
        Glide.with(this).load(url).into(image);
        Glide.with(this).load(R.drawable.testigv).override(400,400).into(image2);
        Glide.with(this).load(url2).into(image3);

    }

    private void loadByGlide() {
        ImageLoadProxy.getInstance().load(new ImageLoadConfiguration.Builder(this)
                .load(url)
                .asGif()
                .transformationsGlide(new jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation(1.0F))
                .into(igv)
                .build());

        ImageLoadProxy.getInstance().load(new ImageLoadConfiguration.Builder(this)
//                .load(url)
//                .load(R.drawable.ic_launcher_foreground)
                .load(drawableToFile(R.drawable.testigv))//测试File的加载
                .imageWidth(400)
                .imageHeight(400)
                .into(igv2)
                .transformationsGlide(new KuwaharaFilterTransformation(10),
                        new CropCircleTransformation())
                .build());

        ImageLoadProxy.getInstance().load(new ImageLoadConfiguration.Builder(this)
                .load(url2)
                .into(igv3)
                .transformationsGlide(new GrayscaleTransformation(),new ToonFilterTransformation(0.2F, 10F))
                .build());
    }


    private void loadByPicasso() {
        ImageLoadProxy.getInstance().load(new ImageLoadConfiguration.Builder(this)
                .load(R.drawable.testigv)
                .transformationsPicasso(new jp.wasabeef.picasso.transformations.gpu.SepiaFilterTransformation(this,1.0F),
                        new jp.wasabeef.picasso.transformations.CropCircleTransformation())
                .imageWidth(400)
                .imageHeight(400)
                .into(igv2)
                .build()
        );
        ImageLoadProxy.getInstance().load(new ImageLoadConfiguration.Builder(this)
                .load(url2)
                .transformationsPicasso(new jp.wasabeef.picasso.transformations.GrayscaleTransformation(),
                        new jp.wasabeef.picasso.transformations.gpu.ToonFilterTransformation(this,0.2F, 10F))
                .into(igv3)
                .build()
        );

    }



    /**
     * 测试File文件显示
     */
    public File drawableToFile(int drawableId) {
        Resources res = getResources();
        BitmapDrawable d = (BitmapDrawable) res.getDrawable(drawableId);
        Bitmap img = d.getBitmap();

        String fn = "image_test.png";
        String path = getFilesDir() + File.separator + fn;
        try{
            OutputStream os = new FileOutputStream(path);
            img.compress(Bitmap.CompressFormat.PNG, 100, os);
            os.close();
        }catch(Exception e){
            Log.e("TAG", "", e);
        }

        File file = new File(path);
        return file;
    }

}
