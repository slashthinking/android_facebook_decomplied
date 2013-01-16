package com.facebook.katana.activity.media;

import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.util.StringUtils;

class AlbumsActivity$AlbumsAppSessionListener extends AppSessionListener
{
  private AlbumsActivity$AlbumsAppSessionListener(AlbumsActivity paramAlbumsActivity)
  {
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3)
  {
    this.a.removeDialog(3);
    AlbumsActivity.a(this.a, null);
    if (paramInt == 200)
    {
      if (AlbumsActivity.f(this.a) != null)
      {
        AlbumsActivity.a(this.a, null);
        this.a.removeDialog(2);
      }
      AlbumsActivity.e(this.a);
    }
    while (true)
    {
      return;
      String str = StringUtils.a(this.a, this.a.getString(2131362818), paramInt, paramString2, paramException);
      Toaster.a(this.a, str);
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String[] paramArrayOfString, long paramLong)
  {
    if (paramLong != AlbumsActivity.a(this.a));
    while (true)
    {
      return;
      AlbumsActivity.a(this.a, false);
      if (paramInt == 200)
      {
        AlbumsActivity.c(this.a).b(AlbumsActivity.b(this.a));
        AlbumsActivity.d(this.a);
        AlbumsActivity.e(this.a);
        continue;
      }
      String str = StringUtils.a(this.a, this.a.getString(2131362822), paramInt, paramString2, paramException);
      Toaster.a(this.a, str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.AlbumsActivity.AlbumsAppSessionListener
 * JD-Core Version:    0.6.0
 */