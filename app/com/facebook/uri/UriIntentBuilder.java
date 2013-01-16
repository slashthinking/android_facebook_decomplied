package com.facebook.uri;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.util.Log;
import java.lang.annotation.Annotation;

public abstract class UriIntentBuilder
{
  private UriTemplateMap<UriIntentBuilder.IUriTemplateIntentBuilder> a = new UriTemplateMap();

  public Intent a(Context paramContext, String paramString)
  {
    boolean bool = a();
    Intent localIntent = null;
    if (!bool);
    while (true)
    {
      return localIntent;
      try
      {
        UriTemplateMap.UriMatch localUriMatch = this.a.a(paramString);
        localIntent = null;
        if (localUriMatch == null)
          continue;
        localIntent = ((UriIntentBuilder.IUriTemplateIntentBuilder)localUriMatch.a).a(paramContext, localUriMatch.b);
      }
      catch (UriTemplateMap.InvalidUriException localInvalidUriException)
      {
        localIntent = null;
      }
    }
  }

  protected void a(String paramString, Class<? extends Activity> paramClass)
  {
    a(paramString, paramClass, null);
  }

  protected void a(String paramString, Class<? extends Annotation> paramClass, int paramInt)
  {
    a(paramString, paramClass, paramInt, null);
  }

  protected void a(String paramString, Class<? extends Annotation> paramClass, int paramInt, Bundle paramBundle)
  {
    try
    {
      this.a.a(paramString, new UriIntentBuilder.FragmentUriBuilder(paramInt, paramClass, paramBundle));
      return;
    }
    catch (UriTemplateMap.InvalidUriTemplateException localInvalidUriTemplateException)
    {
      while (true)
        Log.a(getClass(), "Invalid uri template: " + paramString, localInvalidUriTemplateException);
    }
  }

  protected void a(String paramString, Class<? extends Activity> paramClass, Bundle paramBundle)
  {
    try
    {
      this.a.a(paramString, new UriIntentBuilder.UriBuilder(paramClass, paramBundle));
      return;
    }
    catch (UriTemplateMap.InvalidUriTemplateException localInvalidUriTemplateException)
    {
      while (true)
        Log.a(getClass(), "Invalid uri template: " + paramString, localInvalidUriTemplateException);
    }
  }

  protected abstract boolean a();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.uri.UriIntentBuilder
 * JD-Core Version:    0.6.0
 */