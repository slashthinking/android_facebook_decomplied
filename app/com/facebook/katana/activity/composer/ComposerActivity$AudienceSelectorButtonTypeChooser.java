package com.facebook.katana.activity.composer;

import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.view.composer.ComposerAudienceSelectorButton.AudienceType;

public class ComposerActivity$AudienceSelectorButtonTypeChooser
{
  public static ComposerAudienceSelectorButton.AudienceType a(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2, FacebookAlbum paramFacebookAlbum)
  {
    ComposerAudienceSelectorButton.AudienceType localAudienceType;
    if (!paramBoolean1)
      localAudienceType = ComposerAudienceSelectorButton.AudienceType.HIDDEN;
    while (true)
    {
      return localAudienceType;
      if (paramString != null)
      {
        if (paramString.equals("event"))
        {
          localAudienceType = ComposerAudienceSelectorButton.AudienceType.EVENT;
          continue;
        }
        if (paramString.equals("group"))
        {
          localAudienceType = ComposerAudienceSelectorButton.AudienceType.GROUP;
          continue;
        }
      }
      if ((paramLong != -1L) && (!paramBoolean2))
      {
        localAudienceType = ComposerAudienceSelectorButton.AudienceType.HIDDEN;
        continue;
      }
      if (paramFacebookAlbum != null)
      {
        localAudienceType = ComposerAudienceSelectorButton.AudienceType.PHOTO_ALBUM;
        continue;
      }
      localAudienceType = ComposerAudienceSelectorButton.AudienceType.SELECTABLE;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.AudienceSelectorButtonTypeChooser
 * JD-Core Version:    0.6.0
 */