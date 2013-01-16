package com.facebook.katana.activity.photos;

import com.facebook.katana.activity.media.PhotoSetGridAdapter;
import com.facebook.katana.service.method.PhotosGetPhotos;
import com.facebook.katana.ui.SmoothedScrollAdapter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class PhotoSetGridFragment$ScrollListener extends SmoothedScrollAdapter
{
  private PhotoSetGridFragment$ScrollListener(PhotoSetGridFragment paramPhotoSetGridFragment)
  {
  }

  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > 0)
    {
      PhotoSetGridFragment.a(this.a).a(paramInt1, paramInt2);
      ArrayList localArrayList = Lists.a();
      Iterator localIterator = PhotoSetGridFragment.b(this.a).a(paramInt1, paramInt1 + paramInt2).iterator();
      while (localIterator.hasNext())
      {
        Set localSet = (Set)localIterator.next();
        if (PhotoSetGridFragment.c(this.a).contains(localSet))
          continue;
        PhotoSetGridFragment.c(this.a).add(localSet);
        localArrayList.addAll(localSet);
      }
      if (!localArrayList.isEmpty())
        PhotoSetGridFragment.d(this.a).add(PhotosGetPhotos.a(this.a.n(), localArrayList));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.photos.PhotoSetGridFragment.ScrollListener
 * JD-Core Version:    0.6.0
 */