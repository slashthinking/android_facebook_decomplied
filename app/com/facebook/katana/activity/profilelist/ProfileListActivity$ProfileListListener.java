package com.facebook.katana.activity.profilelist;

import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.ProfileImage;
import com.facebook.katana.binding.ProfileImagesCache;

public class ProfileListActivity$ProfileListListener extends AppSessionListener
{
  public ProfileListActivity$ProfileListListener(ProfileListActivity paramProfileListActivity)
  {
  }

  public void a(AppSession paramAppSession, ProfileImage paramProfileImage)
  {
    this.b.B.a(paramProfileImage);
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, ProfileImage paramProfileImage, ProfileImagesCache paramProfileImagesCache)
  {
    if (paramInt == 200)
      this.b.B.a(paramProfileImage);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.ProfileListActivity.ProfileListListener
 * JD-Core Version:    0.6.0
 */