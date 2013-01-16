package com.facebook.orca.images;

import android.content.Context;
import com.facebook.orca.attachments.ImageAttachmentDecoder;
import com.facebook.orca.attachments.MediaAttachmentFactory;
import com.facebook.orca.attachments.MediaAttachmentUtil;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.media.MediaCache;

public class ImageModule extends AbstractModule
{
  private final Context a;

  public ImageModule(Context paramContext)
  {
    this.a = paramContext;
  }

  protected void a()
  {
    a(ImageCache.class).a(new ImageModule.ImageCacheProvider(this, null)).a();
    a(FetchImageCoordinator.class).a(new ImageModule.FetchImageCoordinatorProvider(this, null)).a();
    a(FetchImageExecutor.class).a(new ImageModule.FetchImageExecutorProvider(this, null)).a();
    a(FetchImageDecodingExecutor.class).a(new ImageModule.FetchImageDecodingExecutorProvider(this, null)).a();
    a(FetchImageHelper.class).a(new ImageModule.FetchImageHelperProvider(this, null)).a();
    a(ImageMediaDownloader.class).a(new ImageModule.ImageMediaDownloaderProvider(this, null));
    a(ImageScalingUtil.class).a(new ImageModule.ImageScalingUtilProvider(this, null)).a();
    a(MediaAttachmentFactory.class).a(new ImageModule.MediaAttachmentFactoryProvider(this, null)).a();
    a(ImageAttachmentDecoder.class).a(new ImageModule.ImageAttachmentDecoderProvider(this, null)).a();
    a(MediaAttachmentUtil.class).a(new ImageModule.MediaAttachmentUtilProvider(this, null)).a();
    c(MediaCache.class).a(ImageCache.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageModule
 * JD-Core Version:    0.6.2
 */