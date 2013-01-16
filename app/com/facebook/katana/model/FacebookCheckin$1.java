package com.facebook.katana.model;

import java.util.Comparator;

final class FacebookCheckin$1
  implements Comparator<FacebookCheckin>
{
  public int a(FacebookCheckin paramFacebookCheckin1, FacebookCheckin paramFacebookCheckin2)
  {
    return (int)(paramFacebookCheckin2.mCheckinDetails.mTimestamp - paramFacebookCheckin1.mCheckinDetails.mTimestamp);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookCheckin.1
 * JD-Core Version:    0.6.0
 */