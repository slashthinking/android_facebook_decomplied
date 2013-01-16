package com.facebook.katana.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.facebook.ipc.katana.model.FacebookPage;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.IntentUriHandler;
import com.facebook.orca.common.util.StringLocaleUtil;

public final class ApplicationUtils
{
  public static Intent a(Context paramContext)
  {
    return IntentUriHandler.a(paramContext, "fb://feed");
  }

  public static void a(Context paramContext, long paramLong, FacebookProfile paramFacebookProfile)
  {
    Intent localIntent = IntentUriHandler.a(paramContext, "fb://profile/" + paramLong);
    if (paramFacebookProfile != null)
    {
      localIntent.putExtra("extra_user_display_name", paramFacebookProfile.mDisplayName);
      localIntent.putExtra("extra_image_url", paramFacebookProfile.mImageUrl);
      localIntent.putExtra("can_post", paramFacebookProfile.mCanPost);
    }
    paramContext.startActivity(localIntent);
  }

  public static boolean a(Context paramContext, FacebookPlace paramFacebookPlace)
  {
    return a(paramContext, paramFacebookPlace, null);
  }

  public static boolean a(Context paramContext, FacebookPlace paramFacebookPlace, Integer paramInteger)
  {
    int i = 1;
    FacebookPage localFacebookPage;
    if (paramFacebookPlace != null)
    {
      localFacebookPage = paramFacebookPlace.a();
      if (localFacebookPage != null);
    }
    else
    {
      i = 0;
    }
    while (true)
    {
      return i;
      Object[] arrayOfObject = new Object[i];
      arrayOfObject[0] = Long.valueOf(localFacebookPage.mPageId);
      Intent localIntent = IntentUriHandler.a(paramContext, StringLocaleUtil.a("fb://place/fw?pid=%d", arrayOfObject));
      localIntent.putExtra("extra_place", paramFacebookPlace);
      if (paramInteger != null)
        localIntent.setFlags(paramInteger.intValue());
      paramContext.startActivity(localIntent);
    }
  }

  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 0);
      i = 1;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        int i = 0;
    }
  }

  public static void b(Context paramContext)
  {
    paramContext.startActivity(a(paramContext));
  }

  public static void b(Context paramContext, long paramLong, FacebookProfile paramFacebookProfile)
  {
    Intent localIntent = IntentUriHandler.a(paramContext, "fb://page/" + paramLong);
    if (paramFacebookProfile != null)
    {
      localIntent.putExtra("extra_user_display_name", paramFacebookProfile.mDisplayName);
      localIntent.putExtra("extra_image_url", paramFacebookProfile.mImageUrl);
    }
    paramContext.startActivity(localIntent);
  }

  public static void b(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + paramString));
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }

  public static boolean c(Context paramContext)
  {
    return a(paramContext, "com.facebook.orca");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.ApplicationUtils
 * JD-Core Version:    0.6.0
 */