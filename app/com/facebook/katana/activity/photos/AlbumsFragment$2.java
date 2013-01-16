package com.facebook.katana.activity.photos;

import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;

class AlbumsFragment$2 extends AppSessionListener
{
  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String[] paramArrayOfString, long paramLong)
  {
    if (AlbumsFragment.c(this.a).equals(paramString1))
    {
      AlbumsFragment.b(this.a);
      AlbumsFragment.e(this.a).b(AlbumsFragment.d(this.a));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.photos.AlbumsFragment.2
 * JD-Core Version:    0.6.0
 */