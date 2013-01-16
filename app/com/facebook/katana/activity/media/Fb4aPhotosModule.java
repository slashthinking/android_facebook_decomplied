package com.facebook.katana.activity.media;

import android.app.Application;
import com.facebook.facedetection.NativeFDCrashHandler;
import com.facebook.katana.features.camera.FaceDetectionGatingHandler;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnBackgroundThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.photos.annotation.IsNewGalleryEnabled;
import com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhotoDataAdapter;

public class Fb4aPhotosModule extends AbstractModule
{
  private final Application a;

  public Fb4aPhotosModule(Application paramApplication)
  {
    this.a = paramApplication;
  }

  protected void a()
  {
    a(Boolean.class).a(IsNewGalleryEnabled.class).a(new Fb4aPhotosModule.IsNewGalleryEnabledProvider(this, null));
    a(ImageGridPhotoManager.class).a(new Fb4aPhotosModule.ImageGridPhotoManagerProvider(this, null));
    a(GridImageLoader.class).a(new Fb4aPhotosModule.GridImageLoaderProvider(this, null));
    a(AndroidMediaThumbnails.class).a(new Fb4aPhotosModule.AndroidMediaThumbnailsProvider(this, null));
    a(FaceDetectionGatingHandler.class).a(new Fb4aPhotosModule.FaceDetectionGatingHandlerProvider(this, null));
    a(ConsumptionPhotoDataAdapter.class).a(new Fb4aPhotosModule.ConsumptionPhotoDataAdapterProvider(this, null)).e();
    a(NativeFDCrashHandler.class).a(new Fb4aPhotosModule.NativeFDCrashHandlerProvider(this, null)).a();
    a(INeedInit.class, NeedsLowPriorityInitOnBackgroundThread.class).a(NativeFDCrashHandler.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.Fb4aPhotosModule
 * JD-Core Version:    0.6.0
 */