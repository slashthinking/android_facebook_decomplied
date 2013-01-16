package com.facebook.katana.activity.composer;

import com.facebook.katana.model.FacebookAlbum;

public enum LegacyAlbumPrivacyValues
{
  private final int mIconRes;
  private final int mNameStringRes;

  static
  {
    FRIENDS = new LegacyAlbumPrivacyValues("FRIENDS", 2, 2131363056, 2130837545);
    CUSTOM = new LegacyAlbumPrivacyValues("CUSTOM", 3, 2131363059, 2130837541);
    LegacyAlbumPrivacyValues[] arrayOfLegacyAlbumPrivacyValues = new LegacyAlbumPrivacyValues[4];
    arrayOfLegacyAlbumPrivacyValues[0] = EVERYONE;
    arrayOfLegacyAlbumPrivacyValues[1] = FRIEND_OF_FRIENDS;
    arrayOfLegacyAlbumPrivacyValues[2] = FRIENDS;
    arrayOfLegacyAlbumPrivacyValues[3] = CUSTOM;
    $VALUES = arrayOfLegacyAlbumPrivacyValues;
  }

  private LegacyAlbumPrivacyValues(int paramInt1, int paramInt2)
  {
    this.mNameStringRes = paramInt1;
    this.mIconRes = paramInt2;
  }

  public static LegacyAlbumPrivacyValues fromAlbum(FacebookAlbum paramFacebookAlbum)
  {
    String str = paramFacebookAlbum.j();
    LegacyAlbumPrivacyValues localLegacyAlbumPrivacyValues;
    if ("everyone".equals(str))
      localLegacyAlbumPrivacyValues = EVERYONE;
    while (true)
    {
      return localLegacyAlbumPrivacyValues;
      if ("friends-of-friends".equals(str))
      {
        localLegacyAlbumPrivacyValues = FRIEND_OF_FRIENDS;
        continue;
      }
      if ("friends".equals(str))
      {
        localLegacyAlbumPrivacyValues = FRIENDS;
        continue;
      }
      localLegacyAlbumPrivacyValues = CUSTOM;
    }
  }

  public int getIconResource()
  {
    return this.mIconRes;
  }

  public int getNameResource()
  {
    return this.mNameStringRes;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.LegacyAlbumPrivacyValues
 * JD-Core Version:    0.6.0
 */