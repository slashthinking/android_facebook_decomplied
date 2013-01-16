package com.facebook.katana.binding;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.katana.util.ReentrantCallback;
import java.util.Iterator;
import java.util.Set;

class AppSession$2
  implements StreamPhotosCache.PhotosContainerListener
{
  public void a(Context paramContext, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      AppSession.a(this.a, paramContext, 73, -1L, null, null, -1L, paramString);
      continue;
      AppSession.a(this.a, paramContext, 72, -1L, null, null, -1L, paramString);
    }
  }

  public void a(Bitmap paramBitmap, String paramString)
  {
    Iterator localIterator = this.a.b.a().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).a(this.a, paramBitmap, paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.AppSession.2
 * JD-Core Version:    0.6.0
 */