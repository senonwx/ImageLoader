# ImageLoader
ImageLoader图片加载模块，采用策略模式及构建者模式。

<img src="https://github.com/senonwx/ImageLoad/blob/master/glide_screen.gif" width="50%"><img/><br/>
Glide使用</br>
<img src="https://github.com/senonwx/ImageLoad/blob/master/picasso_screen.gif" width="50%"><img/><br/>
Picasso使用</br>

* 使用方法
```
 ImageLoadProxy.getInstance().load(new ImageLoadConfiguration.Builder(this)
         .load(url)
         .into(imageView)
         .build());
```
* 扩展用法，类似Glide/Picasso的使用方法
```
 ImageLoadProxy.getInstance().load(new ImageLoadConfiguration.Builder(this)
         .load(file)
         .asGif()
         .imageWidth(400)
         .imageHeight(400)
         .transformationsGlide(new SepiaFilterTransformation(1.0F),
                               new GrayscaleTransformation(),
                               new CropCircleTransformation())
         .into(imageView)
         .build());
```
* 更多使用方法参考类[ImageLoadConfiguration](/library/src/main/java/com/senon/library/ImageLoadConfiguration.java)
