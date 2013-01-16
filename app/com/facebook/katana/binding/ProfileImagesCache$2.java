package com.facebook.katana.binding;

import java.util.Comparator;

class ProfileImagesCache$2
  implements Comparator<ProfileImage>
{
  public int a(ProfileImage paramProfileImage1, ProfileImage paramProfileImage2)
  {
    int i;
    if (paramProfileImage1.a() > paramProfileImage2.a())
      i = 1;
    while (true)
    {
      return i;
      if (paramProfileImage1.a() == paramProfileImage2.a())
      {
        i = 0;
        continue;
      }
      i = -1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.ProfileImagesCache.2
 * JD-Core Version:    0.6.0
 */