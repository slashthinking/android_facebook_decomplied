package com.facebook.katana.view.composer;

public enum ComposerAudienceSelectorButton$AudienceType
{
  static
  {
    EVENT = new AudienceType("EVENT", 1);
    GROUP = new AudienceType("GROUP", 2);
    PHOTO_ALBUM = new AudienceType("PHOTO_ALBUM", 3);
    HIDDEN = new AudienceType("HIDDEN", 4);
    AudienceType[] arrayOfAudienceType = new AudienceType[5];
    arrayOfAudienceType[0] = SELECTABLE;
    arrayOfAudienceType[1] = EVENT;
    arrayOfAudienceType[2] = GROUP;
    arrayOfAudienceType[3] = PHOTO_ALBUM;
    arrayOfAudienceType[4] = HIDDEN;
    $VALUES = arrayOfAudienceType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.composer.ComposerAudienceSelectorButton.AudienceType
 * JD-Core Version:    0.6.0
 */