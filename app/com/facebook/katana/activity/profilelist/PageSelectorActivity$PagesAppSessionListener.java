package com.facebook.katana.activity.profilelist;

import android.database.Cursor;
import com.facebook.common.util.Toaster;
import com.facebook.katana.PageListAdapter;
import com.facebook.katana.ProfileSearchResultsActivity.ProfileSearchAppSessionListener;
import com.facebook.katana.ProfileSearchResultsAdapter;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ProfileImage;
import com.facebook.katana.util.StringUtils;

class PageSelectorActivity$PagesAppSessionListener extends ProfileSearchResultsActivity.ProfileSearchAppSessionListener
{
  private PageSelectorActivity$PagesAppSessionListener(PageSelectorActivity paramPageSelectorActivity)
  {
    super(paramPageSelectorActivity);
  }

  public void a(AppSession paramAppSession, ProfileImage paramProfileImage)
  {
    PageSelectorActivity.a(this.a).a(paramProfileImage);
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt1, String paramString2, Exception paramException, int paramInt2)
  {
    if (!paramString1.equals(PageSelectorActivity.b(this.a)));
    while (true)
    {
      return;
      PageSelectorActivity.b(this.a, 2, false);
      if (paramInt1 == 200)
      {
        PageSelectorActivity.c(this.a);
        Cursor localCursor = PageSelectorActivity.d(this.a).e();
        if (localCursor != null)
          localCursor.requery();
        PageSelectorActivity.e(this.a).a(localCursor);
        continue;
      }
      String str = StringUtils.a(this.a, this.a.getString(2131362942), paramInt1, paramString2, paramException);
      Toaster.a(this.a, str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.PageSelectorActivity.PagesAppSessionListener
 * JD-Core Version:    0.6.0
 */