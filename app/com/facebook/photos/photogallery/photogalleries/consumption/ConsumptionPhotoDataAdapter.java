package com.facebook.photos.photogallery.photogalleries.consumption;

import android.widget.ArrayAdapter;
import com.facebook.photos.photogallery.tags.Tag;

public abstract interface ConsumptionPhotoDataAdapter
{
  public abstract void a();

  public abstract void a(long paramLong);

  public abstract void a(long paramLong, Tag paramTag);

  public abstract void a(long paramLong, boolean paramBoolean);

  public abstract void a(ConsumptionPhotoDataAdapter.ConsumptionPhotoDataAdapterListener paramConsumptionPhotoDataAdapterListener);

  public abstract ArrayAdapter b();

  public abstract void b(long paramLong);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhotoDataAdapter
 * JD-Core Version:    0.6.0
 */