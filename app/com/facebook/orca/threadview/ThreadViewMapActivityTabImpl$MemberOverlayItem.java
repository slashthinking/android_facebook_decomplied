package com.facebook.orca.threadview;

import com.facebook.orca.threads.Message;
import com.facebook.orca.users.UserKey;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

class ThreadViewMapActivityTabImpl$MemberOverlayItem extends OverlayItem
{
  private final UserKey b;
  private final float c;
  private final Message d;

  public ThreadViewMapActivityTabImpl$MemberOverlayItem(ThreadViewMapActivityTabImpl paramThreadViewMapActivityTabImpl, GeoPoint paramGeoPoint, float paramFloat, String paramString1, String paramString2, UserKey paramUserKey, Message paramMessage)
  {
    super(paramGeoPoint, paramString1, paramString2);
    this.b = paramUserKey;
    this.c = paramFloat;
    this.d = paramMessage;
  }

  public UserKey a()
  {
    return this.b;
  }

  public Message b()
  {
    return this.d;
  }

  public float c()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewMapActivityTabImpl.MemberOverlayItem
 * JD-Core Version:    0.6.0
 */