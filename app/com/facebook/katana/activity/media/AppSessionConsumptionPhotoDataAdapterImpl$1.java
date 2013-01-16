package com.facebook.katana.activity.media;

import android.graphics.PointF;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.katana.service.method.GraphObjectLike.Operation;
import com.facebook.orca.inject.FbInjector;
import com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhotoDataAdapter.ConsumptionPhotoDataAdapterListener;
import com.facebook.photos.photogallery.tags.Tag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AppSessionConsumptionPhotoDataAdapterImpl$1 extends AppSessionListener
{
  public void a(AppSession paramAppSession, String paramString1, int paramInt1, String paramString2, Exception paramException, long paramLong, Set<Long> paramSet, int paramInt2)
  {
    if (AppSessionConsumptionPhotoDataAdapterImpl.a(this.a) == null);
    while (true)
    {
      return;
      if ((paramInt1 == 200) && (paramException == null))
      {
        AppSessionConsumptionPhotoDataAdapterImpl.a(this.a).a(paramLong, paramSet.size(), paramInt2);
        continue;
      }
      ((FbErrorReporter)FbInjector.a(AppSessionConsumptionPhotoDataAdapterImpl.b(this.a)).a(FbErrorReporter.class)).a("AppSessionConsumptionPhotoDataAdapterImpl", "Failed to fetch likes and comments", paramException);
      AppSessionConsumptionPhotoDataAdapterImpl.a(this.a).a(paramLong);
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, GraphObjectLike.Operation paramOperation)
  {
    if (AppSessionConsumptionPhotoDataAdapterImpl.a(this.a) == null);
    while (true)
    {
      return;
      if ((paramInt == 200) && (paramException == null))
      {
        AppSessionConsumptionPhotoDataAdapterImpl.a(this.a).c(Long.parseLong(paramString3));
        continue;
      }
      ((FbErrorReporter)FbInjector.a(AppSessionConsumptionPhotoDataAdapterImpl.b(this.a)).a(FbErrorReporter.class)).a("AppSessionConsumptionPhotoDataAdapterImpl", "Failed to set like", paramException);
      AppSessionConsumptionPhotoDataAdapterImpl.a(this.a).d(Long.parseLong(paramString3));
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, List<FacebookPhotoTag> paramList)
  {
    if (AppSessionConsumptionPhotoDataAdapterImpl.a(this.a) == null);
    while (true)
    {
      return;
      if ((paramInt == 200) && (paramException == null))
      {
        AppSessionConsumptionPhotoDataAdapterImpl.a(this.a).e(Long.parseLong(paramString3));
        continue;
      }
      ((FbErrorReporter)FbInjector.a(AppSessionConsumptionPhotoDataAdapterImpl.b(this.a)).a(FbErrorReporter.class)).a("AppSessionConsumptionPhotoDataAdapterImpl", "Failed to add tag", paramException);
      AppSessionConsumptionPhotoDataAdapterImpl.a(this.a).f(Long.parseLong(paramString3));
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, List<Long> paramList, Map<Long, List<FacebookPhotoTag>> paramMap)
  {
    if (AppSessionConsumptionPhotoDataAdapterImpl.a(this.a) == null);
    while (true)
    {
      return;
      if ((paramInt == 200) && (paramException == null))
      {
        Iterator localIterator1 = paramMap.entrySet().iterator();
        while (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          long l = ((Long)localEntry.getKey()).longValue();
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
          while (localIterator2.hasNext())
          {
            FacebookPhotoTag localFacebookPhotoTag = (FacebookPhotoTag)localIterator2.next();
            localArrayList.add(new Tag(localFacebookPhotoTag.b(), localFacebookPhotoTag.f(), localFacebookPhotoTag.a()));
          }
          AppSessionConsumptionPhotoDataAdapterImpl.a(this.a).a(l, localArrayList);
        }
        continue;
      }
      ((FbErrorReporter)FbInjector.a(AppSessionConsumptionPhotoDataAdapterImpl.b(this.a)).a(FbErrorReporter.class)).a("AppSessionConsumptionPhotoDataAdapterImpl", "Failed to fetch tags", paramException);
      AppSessionConsumptionPhotoDataAdapterImpl.a(this.a).b(-1L);
    }
  }

  public void c(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, List<FacebookPhoto> paramList)
  {
    if (AppSessionConsumptionPhotoDataAdapterImpl.a(this.a) == null);
    while (true)
    {
      return;
      if ((paramInt != 200) || (paramException != null))
        continue;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FacebookPhoto localFacebookPhoto = (FacebookPhoto)localIterator.next();
        if (!AppSessionConsumptionPhotoDataAdapterImpl.c(this.a).containsKey(Long.valueOf(localFacebookPhoto.j())))
          continue;
        Tag localTag = (Tag)AppSessionConsumptionPhotoDataAdapterImpl.c(this.a).get(Long.valueOf(localFacebookPhoto.j()));
        String str = localFacebookPhoto.a();
        FacebookPhotoTag localFacebookPhotoTag = new FacebookPhotoTag(str, localTag.c(), localTag.a().x, localTag.a().y, 0L, localTag.b());
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localFacebookPhotoTag);
        AppSessionConsumptionPhotoDataAdapterImpl.d(this.a).a(AppSessionConsumptionPhotoDataAdapterImpl.b(this.a), str, localArrayList);
        AppSessionConsumptionPhotoDataAdapterImpl.c(this.a).remove(Long.valueOf(localFacebookPhoto.j()));
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.AppSessionConsumptionPhotoDataAdapterImpl.1
 * JD-Core Version:    0.6.0
 */