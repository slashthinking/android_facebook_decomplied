package com.facebook.uri;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.orca.inject.FbInjector;
import com.google.inject.Key;
import java.lang.annotation.Annotation;

class UriIntentBuilder$FragmentUriBuilder
  implements UriIntentBuilder.IUriTemplateIntentBuilder
{
  private final int a;
  private final Class<? extends Annotation> b;
  private final Bundle c;

  public UriIntentBuilder$FragmentUriBuilder(int paramInt, Class<? extends Annotation> paramClass, Bundle paramBundle)
  {
    this.a = paramInt;
    this.b = paramClass;
    this.c = paramBundle;
  }

  public Intent a(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, (Class)FbInjector.a(paramContext).a(Key.a(new UriIntentBuilder.FragmentUriBuilder.1(this), this.b)));
    localIntent.putExtra("target_fragment", this.a);
    if (this.c != null)
      localIntent.putExtras(this.c);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    return localIntent;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.uri.UriIntentBuilder.FragmentUriBuilder
 * JD-Core Version:    0.6.0
 */