package com.facebook.katana.activity.media;

import android.content.Context;
import com.facebook.katana.binding.AppSession;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhotoDataAdapter;

class Fb4aPhotosModule$ConsumptionPhotoDataAdapterProvider extends AbstractProvider<ConsumptionPhotoDataAdapter>
{
  private Fb4aPhotosModule$ConsumptionPhotoDataAdapterProvider(Fb4aPhotosModule paramFb4aPhotosModule)
  {
  }

  public ConsumptionPhotoDataAdapter a()
  {
    return new AppSessionConsumptionPhotoDataAdapterImpl((Context)b(Context.class), (AppSession)b(AppSession.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.Fb4aPhotosModule.ConsumptionPhotoDataAdapterProvider
 * JD-Core Version:    0.6.0
 */