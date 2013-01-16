package com.facebook.katana.orca;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.katana.SettingsActivity;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.intents.MessagingIntentUris;

public class FbandroidMessagingIntentUris
  implements MessagingIntentUris
{
  public Intent a(Context paramContext)
  {
    return new Intent(paramContext, SettingsActivity.class);
  }

  public Uri a()
  {
    return Uri.parse("fb://messaging");
  }

  public Uri a(String paramString)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Uri.encode(paramString);
    return Uri.parse(StringLocaleUtil.a("fb://messaging/thread/thread?id=%s", arrayOfObject));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidMessagingIntentUris
 * JD-Core Version:    0.6.0
 */