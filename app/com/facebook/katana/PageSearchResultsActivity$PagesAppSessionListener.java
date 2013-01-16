package com.facebook.katana;

import android.database.Cursor;
import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ProfileImage;
import com.facebook.katana.util.StringUtils;

class PageSearchResultsActivity$PagesAppSessionListener extends ProfileSearchResultsActivity.ProfileSearchAppSessionListener
{
  private PageSearchResultsActivity$PagesAppSessionListener(PageSearchResultsActivity paramPageSearchResultsActivity)
  {
    super(paramPageSearchResultsActivity);
  }

  public void a(AppSession paramAppSession, ProfileImage paramProfileImage)
  {
    PageSearchResultsActivity.a(this.a).a(paramProfileImage);
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt1, String paramString2, Exception paramException, int paramInt2)
  {
    if (!paramString1.equals(this.a.r));
    while (true)
    {
      return;
      this.a.a(2, false);
      if (paramInt1 == 200)
      {
        PageSearchResultsActivity.b(this.a);
        Cursor localCursor = this.a.p.e();
        if (localCursor != null)
          localCursor.requery();
        this.a.p.a(localCursor);
        continue;
      }
      String str = StringUtils.a(this.a, this.a.getString(2131362942), paramInt1, paramString2, paramException);
      Toaster.a(this.a, str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.PageSearchResultsActivity.PagesAppSessionListener
 * JD-Core Version:    0.6.0
 */