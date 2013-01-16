package com.facebook.katana.activity.places;

import android.location.Location;
import android.support.v4.app.DialogFragment;
import com.facebook.common.util.Toaster;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.features.places.SelectAtTagFetcher.SearchType;
import com.facebook.katana.model.GeoRegion;
import com.facebook.katana.util.StringUtils;
import java.util.List;

class SelectAtTagActivity$1 extends AppSessionListener
{
  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, List<FacebookPlace> paramList, List<GeoRegion> paramList1, Location paramLocation, String paramString3, SelectAtTagFetcher.SearchType paramSearchType, long paramLong)
  {
    if (SelectAtTagActivity.a(this.a));
    while (true)
    {
      return;
      if ((("MDS_PENDING_REQUEST_ID".equals(SelectAtTagActivity.b(this.a))) && (StringUtils.c(paramString3))) || (paramString1.equals(SelectAtTagActivity.b(this.a))))
      {
        if (paramInt == 200)
        {
          if (SelectAtTagActivity.c(this.a))
            SelectAtTagActivity.a(this.a, paramList1);
          SelectAtTagActivity.b(this.a, paramList);
          SelectAtTagActivity.a(this.a, paramLocation);
          SelectAtTagActivity.a(this.a, null);
          this.a.c(false);
          SelectAtTagActivity.a(this.a, 0);
          continue;
        }
        if (paramInt != 0)
          continue;
        if (SelectAtTagActivity.d(this.a) < 3)
        {
          SelectAtTagActivity.e(this.a);
          continue;
        }
        SelectAtTagActivity.a(this.a, null);
        this.a.c(false);
        continue;
      }
    }
  }

  public void b(AppSession paramAppSession, String paramString1, int paramInt1, String paramString2, Exception paramException, int paramInt2)
  {
    if ((paramString1 == null) || (!paramString1.equals(SelectAtTagActivity.j(this.a))))
      return;
    Assert.a(SelectAtTagActivity.g(this.a), true);
    SelectAtTagActivity.h(this.a).a();
    if (paramInt1 == 200)
    {
      SelectAtTagActivity.i(this.a);
      if (paramInt2 < 0)
        Toaster.a(this.a, 2131363353);
    }
    while (true)
    {
      SelectAtTagActivity.a(this.a, false);
      break;
      Toaster.a(this.a, 2131363359);
    }
  }

  public void g(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if ((paramString1 == null) || (!paramString1.equals(SelectAtTagActivity.f(this.a))))
      return;
    Assert.a(SelectAtTagActivity.g(this.a), true);
    SelectAtTagActivity.h(this.a).a();
    if (paramInt == 200)
    {
      SelectAtTagActivity.i(this.a);
      Toaster.a(this.a, 2131363353);
    }
    while (true)
    {
      SelectAtTagActivity.a(this.a, false);
      break;
      Toaster.a(this.a, 2131363359);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectAtTagActivity.1
 * JD-Core Version:    0.6.0
 */