package com.facebook.uri;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class UriIntentBuilder$UriBuilder
  implements UriIntentBuilder.IUriTemplateIntentBuilder
{
  private final Class<? extends Activity> a;
  private final Bundle b;

  public UriIntentBuilder$UriBuilder(Class<? extends Activity> paramClass, Bundle paramBundle)
  {
    this.a = paramClass;
    this.b = paramBundle;
  }

  public Intent a(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, this.a);
    if (this.b != null)
      localIntent.putExtras(this.b);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    return localIntent;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.uri.UriIntentBuilder.UriBuilder
 * JD-Core Version:    0.6.0
 */