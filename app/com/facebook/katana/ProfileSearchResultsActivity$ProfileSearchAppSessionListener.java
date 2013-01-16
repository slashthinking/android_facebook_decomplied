package com.facebook.katana;

import android.graphics.Bitmap;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;

public class ProfileSearchResultsActivity$ProfileSearchAppSessionListener extends AppSessionListener
{
  protected ProfileSearchResultsActivity$ProfileSearchAppSessionListener(ProfileSearchResultsActivity paramProfileSearchResultsActivity)
  {
  }

  public void a(AppSession paramAppSession, Bitmap paramBitmap, String paramString)
  {
    this.b.p.a(paramBitmap, paramString);
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, Bitmap paramBitmap)
  {
    this.b.p.a(paramBitmap, paramString3);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ProfileSearchResultsActivity.ProfileSearchAppSessionListener
 * JD-Core Version:    0.6.0
 */