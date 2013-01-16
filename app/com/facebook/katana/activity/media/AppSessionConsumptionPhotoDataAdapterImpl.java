package com.facebook.katana.activity.media;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.features.tagging.TagTypeaheadAdapter;
import com.facebook.katana.service.method.GraphObjectLike;
import com.facebook.katana.service.method.GraphObjectLike.Operation;
import com.facebook.katana.service.method.PhotosGetLikesAndComments;
import com.facebook.katana.service.method.PhotosGetPhotos;
import com.facebook.katana.service.method.PhotosGetTagsByFBID;
import com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhotoDataAdapter;
import com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhotoDataAdapter.ConsumptionPhotoDataAdapterListener;
import com.facebook.photos.photogallery.tags.Tag;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppSessionConsumptionPhotoDataAdapterImpl
  implements ConsumptionPhotoDataAdapter
{
  private final Context a;
  private final AppSession b;
  private ConsumptionPhotoDataAdapter.ConsumptionPhotoDataAdapterListener c;
  private HashMap<Long, Tag> d = new HashMap();
  private final AppSessionListener e = new AppSessionConsumptionPhotoDataAdapterImpl.1(this);

  public AppSessionConsumptionPhotoDataAdapterImpl(Context paramContext, AppSession paramAppSession)
  {
    this.a = ((Context)Preconditions.checkNotNull(paramContext));
    this.b = ((AppSession)Preconditions.checkNotNull(paramAppSession));
  }

  public void a()
  {
    this.b.b(this.e);
    this.c = null;
  }

  public void a(long paramLong)
  {
    PhotosGetLikesAndComments.a(this.a, paramLong);
  }

  public void a(long paramLong, Tag paramTag)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Long.valueOf(paramLong));
    this.d.put(Long.valueOf(paramLong), paramTag);
    PhotosGetPhotos.a(this.a, localArrayList);
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    Context localContext = this.a;
    if (paramBoolean);
    for (GraphObjectLike.Operation localOperation = GraphObjectLike.Operation.LIKE; ; localOperation = GraphObjectLike.Operation.UNLIKE)
    {
      GraphObjectLike.a(localContext, localOperation, Long.valueOf(paramLong));
      return;
    }
  }

  public void a(ConsumptionPhotoDataAdapter.ConsumptionPhotoDataAdapterListener paramConsumptionPhotoDataAdapterListener)
  {
    this.b.a(this.e);
    this.c = paramConsumptionPhotoDataAdapterListener;
  }

  public ArrayAdapter b()
  {
    return new TagTypeaheadAdapter(this.a);
  }

  public void b(long paramLong)
  {
    PhotosGetTagsByFBID.a(this.a, paramLong);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.AppSessionConsumptionPhotoDataAdapterImpl
 * JD-Core Version:    0.6.0
 */