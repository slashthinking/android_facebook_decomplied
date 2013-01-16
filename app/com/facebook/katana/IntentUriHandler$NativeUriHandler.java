package com.facebook.katana;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class IntentUriHandler$NativeUriHandler
  implements IntentUriHandler.UriHandler
{
  private final Bundle a;
  private final Class<? extends Activity> b;

  public IntentUriHandler$NativeUriHandler(Class<? extends Activity> paramClass, Bundle paramBundle)
  {
    this.b = paramClass;
    this.a = paramBundle;
  }

  public Intent a(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent;
    if (this.b == null)
      localIntent = null;
    while (true)
    {
      return localIntent;
      localIntent = new Intent(paramContext, this.b);
      if (this.a != null)
        localIntent.putExtras(this.a);
      if (paramBundle != null)
        localIntent.putExtras(paramBundle);
      localIntent.setAction("android.intent.action.VIEW");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.IntentUriHandler.NativeUriHandler
 * JD-Core Version:    0.6.0
 */