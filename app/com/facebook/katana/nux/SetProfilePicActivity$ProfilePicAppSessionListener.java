package com.facebook.katana.nux;

import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.service.method.CropProfilePicture;

class SetProfilePicActivity$ProfilePicAppSessionListener extends AppSessionListener
{
  private int b;

  private SetProfilePicActivity$ProfilePicAppSessionListener(SetProfilePicActivity paramSetProfilePicActivity, int paramInt)
  {
    this.b = paramInt;
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt1, String paramString2, Exception paramException, int paramInt2, FacebookPhoto paramFacebookPhoto, String paramString3, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (SetProfilePicActivity.a(this.a).equals(paramString3))
      CropProfilePicture.a(this.a, paramFacebookPhoto.c(), paramFacebookPhoto.a(), 0, 0, this.b, this.b);
  }

  public void f(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (paramInt == 200)
    {
      AppSession.a(this.a, SetProfilePicActivity.b(this.a));
      Toaster.a(this.a.getApplicationContext(), 2131363267);
    }
    while (true)
    {
      if (SetProfilePicActivity.b(this.a) != null)
        SetProfilePicActivity.b(this.a).b(this);
      return;
      Toaster.a(this.a.getApplicationContext(), 2131363266);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.nux.SetProfilePicActivity.ProfilePicAppSessionListener
 * JD-Core Version:    0.6.0
 */