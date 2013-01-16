package com.facebook.katana.activity.places;

import android.graphics.Bitmap;
import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookCheckin;
import com.facebook.katana.util.StringUtils;
import java.util.List;

class FriendCheckinsActivity$FriendCheckinsListener extends AppSessionListener
{
  private FriendCheckinsActivity$FriendCheckinsListener(FriendCheckinsActivity paramFriendCheckinsActivity)
  {
  }

  public void a(AppSession paramAppSession, Bitmap paramBitmap, String paramString)
  {
    FriendCheckinsActivity.a(this.a).a(paramBitmap, paramString);
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, Bitmap paramBitmap)
  {
    if (paramInt == 200)
      FriendCheckinsActivity.a(this.a).a(paramBitmap, paramString3);
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, boolean paramBoolean)
  {
    if ((paramInt == 200) && ("places".equals(paramString3)) && (paramBoolean == true))
    {
      FriendCheckinsActivity.c(this.a, true);
      this.a.i();
      FriendCheckinsActivity.a(this.a).e();
    }
  }

  public void d(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (paramString1.equals(FriendCheckinsActivity.c(this.a)))
    {
      FriendCheckinsActivity.a(this.a, null);
      if (paramInt == 200)
        this.a.i();
    }
  }

  public void d(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, List<FacebookCheckin> paramList)
  {
    FriendCheckinsActivity.a(this.a, false);
    if (paramInt == 200)
    {
      FriendCheckinsActivity.b(this.a);
      FriendCheckinsActivity.a(this.a).a(paramList);
      int i = paramList.size();
      bool = false;
      if (i <= 0);
    }
    for (boolean bool = true; ; bool = false)
    {
      FriendCheckinsActivity.b(this.a, bool);
      return;
      String str = StringUtils.a(this.a, this.a.getString(2131363203), paramInt, paramString2, paramException);
      Toaster.a(this.a, str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.FriendCheckinsActivity.FriendCheckinsListener
 * JD-Core Version:    0.6.0
 */