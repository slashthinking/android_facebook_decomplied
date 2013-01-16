package com.facebook.orca.app;

public enum IntendedAudience
{
  static
  {
    FACEBOOK = new IntendedAudience("FACEBOOK", 1);
    DEVELOPMENT = new IntendedAudience("DEVELOPMENT", 2);
    IntendedAudience[] arrayOfIntendedAudience = new IntendedAudience[3];
    arrayOfIntendedAudience[0] = PUBLIC;
    arrayOfIntendedAudience[1] = FACEBOOK;
    arrayOfIntendedAudience[2] = DEVELOPMENT;
    $VALUES = arrayOfIntendedAudience;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.IntendedAudience
 * JD-Core Version:    0.6.0
 */