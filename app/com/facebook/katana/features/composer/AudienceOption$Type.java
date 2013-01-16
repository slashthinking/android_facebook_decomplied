package com.facebook.katana.features.composer;

public enum AudienceOption$Type
{
  static
  {
    FRIEND_LIST = new Type("FRIEND_LIST", 1);
    Type[] arrayOfType = new Type[2];
    arrayOfType[0] = PRIVACY_SETTING;
    arrayOfType[1] = FRIEND_LIST;
    $VALUES = arrayOfType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.composer.AudienceOption.Type
 * JD-Core Version:    0.6.0
 */