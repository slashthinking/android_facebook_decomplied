package com.facebook.uri;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.orca.inject.FbInjector;
import java.util.Iterator;
import java.util.Set;

public class FbUriIntentHandler
{
  public Intent a(Context paramContext, String paramString)
  {
    Iterator localIterator = FbInjector.a(paramContext).c(UriIntentBuilder.class).iterator();
    Intent localIntent;
    do
    {
      if (!localIterator.hasNext())
        break;
      localIntent = ((UriIntentBuilder)localIterator.next()).a(paramContext, paramString);
    }
    while (localIntent == null);
    while (true)
    {
      return localIntent;
      localIntent = null;
    }
  }

  public boolean a(Context paramContext, String paramString, Bundle paramBundle)
  {
    Intent localIntent = a(paramContext, paramString);
    if (localIntent != null)
    {
      if (paramBundle != null)
        localIntent.putExtras(paramBundle);
      paramContext.startActivity(localIntent);
    }
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.uri.FbUriIntentHandler
 * JD-Core Version:    0.6.0
 */