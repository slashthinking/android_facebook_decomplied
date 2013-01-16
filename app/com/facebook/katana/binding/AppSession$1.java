package com.facebook.katana.binding;

import android.content.Context;
import com.facebook.katana.util.ReentrantCallback;
import java.util.Iterator;
import java.util.Set;

class AppSession$1
  implements ProfileImagesCache.ProfileImagesContainerListener
{
  public void a(Context paramContext, long paramLong, String paramString)
  {
    AppSession.a(this.a, paramContext, paramLong, paramString);
  }

  public void a(Context paramContext, ProfileImage paramProfileImage)
  {
    Widget.a().a(paramContext, paramProfileImage);
    Iterator localIterator = this.a.b.a().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).a(this.a, paramProfileImage);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.AppSession.1
 * JD-Core Version:    0.6.0
 */