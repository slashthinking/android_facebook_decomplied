package com.facebook.katana.service.method;

public enum GraphEventCreate$PrivacyType
{
  private final String type;

  static
  {
    FRIENDS = new PrivacyType("FRIENDS", 1, "FRIENDS");
    INVITE_ONLY = new PrivacyType("INVITE_ONLY", 2, "SECRET");
    PrivacyType[] arrayOfPrivacyType = new PrivacyType[3];
    arrayOfPrivacyType[0] = PUBLIC;
    arrayOfPrivacyType[1] = FRIENDS;
    arrayOfPrivacyType[2] = INVITE_ONLY;
    $VALUES = arrayOfPrivacyType;
  }

  private GraphEventCreate$PrivacyType(String paramString)
  {
    this.type = paramString;
  }

  public String toString()
  {
    return this.type;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.GraphEventCreate.PrivacyType
 * JD-Core Version:    0.6.0
 */