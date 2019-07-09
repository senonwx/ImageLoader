# ImageLoader
ImageLoader图片加载模块
采用策略模式及构建者模式。使用方法
```
 ImageLoadProxy.getInstance().load(new ImageLoadConfiguration.Builder(this)
         .load(url)
         .into(imageView)
         .build());
```
