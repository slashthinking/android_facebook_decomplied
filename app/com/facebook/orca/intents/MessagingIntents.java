package com.facebook.orca.intents;

import android.content.Intent;
import android.net.Uri;
import com.facebook.orca.compose.ComposeFragment.InitParams;

public class MessagingIntents
{
  public static int a(Intent paramIntent, String paramString, int paramInt)
  {
    if (paramIntent == null);
    while (true)
    {
      return paramInt;
      if (!paramIntent.hasExtra(paramString))
        continue;
      paramInt = paramIntent.getIntExtra(paramString, paramInt);
      paramIntent.removeExtra(paramString);
    }
  }

  public static ComposeFragment.InitParams a(Intent paramIntent)
  {
    Object localObject = null;
    if (paramIntent == null);
    while (true)
    {
      return localObject;
      boolean bool = paramIntent.getBooleanExtra("show_composer", false);
      localObject = null;
      if (!bool)
        continue;
      ComposeFragment.InitParams localInitParams = new ComposeFragment.InitParams();
      localInitParams.a = paramIntent.getStringExtra("composer_initial_text");
      localInitParams.b = ((Uri)paramIntent.getParcelableExtra("composer_photo_uri"));
      paramIntent.removeExtra("show_composer");
      localInitParams.c = a(paramIntent, "open_media_picker_source", -1);
      localObject = localInitParams;
    }
  }

  public static String a(Intent paramIntent, String paramString)
  {
    String str = null;
    if (paramIntent == null);
    while (true)
    {
      return str;
      boolean bool = paramIntent.hasExtra(paramString);
      str = null;
      if (!bool)
        continue;
      str = paramIntent.getStringExtra(paramString);
      paramIntent.removeExtra(paramString);
    }
  }

  public static boolean a(Intent paramIntent, String paramString, boolean paramBoolean)
  {
    if (paramIntent == null);
    while (true)
    {
      return paramBoolean;
      if (!paramIntent.hasExtra(paramString))
        continue;
      paramBoolean = paramIntent.getBooleanExtra(paramString, paramBoolean);
      paramIntent.removeExtra(paramString);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.intents.MessagingIntents
 * JD-Core Version:    0.6.0
 */