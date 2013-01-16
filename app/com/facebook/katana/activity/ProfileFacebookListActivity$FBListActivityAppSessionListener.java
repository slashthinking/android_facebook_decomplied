package com.facebook.katana.activity;

import android.graphics.Bitmap;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.ProfileImage;
import com.facebook.katana.binding.ProfileImagesCache;
import com.facebook.katana.model.FacebookProfileUtil;
import com.facebook.katana.model.FacebookSessionInfo;

public class ProfileFacebookListActivity$FBListActivityAppSessionListener extends AppSessionListener
{
  protected ProfileFacebookListActivity$FBListActivityAppSessionListener(ProfileFacebookListActivity paramProfileFacebookListActivity)
  {
  }

  public void a(AppSession paramAppSession, ProfileImage paramProfileImage)
  {
    if (paramProfileImage.a == this.a.p)
      this.a.k();
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, FacebookProfile paramFacebookProfile)
  {
    if ((paramInt == 200) && (paramFacebookProfile != null) && (paramFacebookProfile.mId == this.a.p))
    {
      this.a.r = paramFacebookProfile;
      this.a.k();
      this.a.o();
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, ProfileImage paramProfileImage, ProfileImagesCache paramProfileImagesCache)
  {
    if ((paramInt == 200) && (paramProfileImage.a == this.a.p))
      if (this.a.p != paramAppSession.b().userId)
        break label72;
    for (this.a.r = FacebookProfileUtil.a(this.a.n.b().a()); ; this.a.r = new FacebookProfile(this.a.p, this.a.r.mDisplayName, paramProfileImage.b, this.a.r.mType))
    {
      this.a.k();
      label72: 
      do
        return;
      while (this.a.r == null);
    }
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, String paramString3, Bitmap paramBitmap)
  {
    if ((paramInt == 200) && (this.a.q == 2))
      this.a.k();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.ProfileFacebookListActivity.FBListActivityAppSessionListener
 * JD-Core Version:    0.6.0
 */