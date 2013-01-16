package com.facebook.katana.features.places;

import android.content.Context;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination.Encoder;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.model.FacebookCheckin;
import com.facebook.katana.model.FacebookCheckinDetails;
import com.facebook.katana.provider.UserValuesManager;

public class PlacesUtils
{
  public static void a(Context paramContext, FacebookCheckin paramFacebookCheckin, long paramLong)
  {
    UserValuesManager.a(paramContext, "places:last_checkin_pageid", Long.valueOf(paramFacebookCheckin.a().a().mPageId));
    UserValuesManager.a(paramContext, "places:last_checkin_time", Long.valueOf(paramLong));
    String str = JMStaticKeysDictDestination.Encoder.a(paramFacebookCheckin);
    if (str != null)
      UserValuesManager.a(paramContext, "places:last_checkin", str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.places.PlacesUtils
 * JD-Core Version:    0.6.0
 */