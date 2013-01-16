package com.facebook.katana;

import android.database.Cursor;
import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.ProfileImage;
import com.facebook.katana.binding.ProfileImagesCache;
import com.facebook.katana.util.StringUtils;

class FriendsActivity$FriendsAppSessionListener extends AppSessionListener
{
  private FriendsActivity$FriendsAppSessionListener(FriendsActivity paramFriendsActivity)
  {
  }

  public void a(AppSession paramAppSession, ProfileImage paramProfileImage)
  {
    FriendsActivity.a(this.a).a(paramProfileImage);
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    this.a.a(2, false);
    if (paramInt == 200)
    {
      FriendsActivity.d(this.a);
      Cursor localCursor = FriendsActivity.a(this.a).a;
      if (localCursor != null)
        localCursor.requery();
      FriendsActivity.a(this.a).b(localCursor);
    }
    while (true)
    {
      return;
      String str = StringUtils.a(this.a, this.a.getString(2131362939), paramInt, paramString2, paramException);
      Toaster.a(this.a, str);
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt1, String paramString2, Exception paramException, int paramInt2, int paramInt3)
  {
    if ((this.a.n == null) || (!paramString1.equals(this.a.n)));
    while (true)
    {
      return;
      this.a.a(8, false);
      if (paramInt1 == 200)
      {
        FriendsActivity.e(this.a);
        Cursor localCursor = FriendsActivity.a(this.a).b;
        if (localCursor != null)
          localCursor.requery();
        FriendsActivity.a(this.a).a(true);
        FriendsActivity.a(this.a).a_(localCursor);
        continue;
      }
      String str = StringUtils.a(this.a, this.a.getString(2131362942), paramInt1, paramString2, paramException);
      Toaster.a(this.a, str);
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, ProfileImage paramProfileImage, ProfileImagesCache paramProfileImagesCache)
  {
    if (paramInt == 200)
      FriendsActivity.a(this.a).a(paramProfileImage);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FriendsActivity.FriendsAppSessionListener
 * JD-Core Version:    0.6.0
 */