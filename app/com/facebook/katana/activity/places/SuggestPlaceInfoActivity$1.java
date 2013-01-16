package com.facebook.katana.activity.places;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import com.facebook.common.util.Toaster;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookPageFull;
import com.google.common.base.Objects;

class SuggestPlaceInfoActivity$1 extends AppSessionListener
{
  public <typeClass> void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, long paramLong, typeClass paramtypeClass)
  {
    if ((SuggestPlaceInfoActivity.a(this.a) == null) || (!Objects.equal(SuggestPlaceInfoActivity.a(this.a), paramString1)));
    while (true)
    {
      return;
      Assert.a(SuggestPlaceInfoActivity.b(this.a), SuggestPlaceInfoActivity.State.FETCHING);
      SuggestPlaceInfoActivity.a(this.a, SuggestPlaceInfoActivity.State.NONE);
      SuggestPlaceInfoActivity.c(this.a).a();
      Assert.a(SuggestPlaceInfoActivity.d(this.a).mPageId, paramLong);
      if (paramInt == 200)
      {
        SuggestPlaceInfoActivity.a(this.a, (FacebookPageFull)paramtypeClass);
        SuggestPlaceInfoActivity.d(this.a).a(SuggestPlaceInfoActivity.e(this.a));
      }
      SuggestPlaceInfoActivity.f(this.a);
    }
  }

  public void b(AppSession paramAppSession, String paramString1, int paramInt1, String paramString2, Exception paramException, int paramInt2)
  {
    if ((SuggestPlaceInfoActivity.g(this.a) == null) || (!Objects.equal(SuggestPlaceInfoActivity.g(this.a), paramString1)));
    while (true)
    {
      return;
      Assert.a(SuggestPlaceInfoActivity.b(this.a), SuggestPlaceInfoActivity.State.SAVING);
      SuggestPlaceInfoActivity.c(this.a).a();
      SuggestPlaceInfoActivity.a(this.a, SuggestPlaceInfoActivity.State.NONE);
      if (paramInt1 == 200)
      {
        Intent localIntent = new Intent();
        this.a.setResult(-1, localIntent);
        this.a.finish();
        continue;
      }
      Toaster.a(this.a, 2131363359);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SuggestPlaceInfoActivity.1
 * JD-Core Version:    0.6.0
 */