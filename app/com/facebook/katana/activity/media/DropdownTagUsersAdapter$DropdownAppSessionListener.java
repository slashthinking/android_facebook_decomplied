package com.facebook.katana.activity.media;

import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.ProfileImage;
import com.facebook.katana.binding.ProfileImagesCache;

public class DropdownTagUsersAdapter$DropdownAppSessionListener extends AppSessionListener
{
  protected DropdownTagUsersAdapter$DropdownAppSessionListener(DropdownTagUsersAdapter paramDropdownTagUsersAdapter)
  {
  }

  public void a(AppSession paramAppSession, ProfileImage paramProfileImage)
  {
    this.a.a(paramProfileImage);
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, ProfileImage paramProfileImage, ProfileImagesCache paramProfileImagesCache)
  {
    if (paramInt == 200)
      this.a.a(paramProfileImage);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.DropdownTagUsersAdapter.DropdownAppSessionListener
 * JD-Core Version:    0.6.0
 */