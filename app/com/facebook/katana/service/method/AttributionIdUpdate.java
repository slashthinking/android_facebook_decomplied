package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.orca.FbandroidPrefKeys;
import com.facebook.orca.prefs.PrefKey;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AttributionIdUpdate extends GraphApiMethod
  implements ApiMethodCallback
{
  private final String a;
  private final SharedPreferences f;

  public AttributionIdUpdate(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    super(paramContext, paramString1, "POST", paramLong + "/" + "attributions", Constants.URL.d(paramContext));
    this.e.put("attribution", paramString2);
    this.e.put("fb_device", paramString3);
    this.a = paramString2;
    this.f = PreferenceManager.getDefaultSharedPreferences(paramContext);
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (paramInt == 200)
    {
      SharedPreferences.Editor localEditor = this.f.edit();
      localEditor.putString(FbandroidPrefKeys.i.a(), this.a);
      localEditor.putBoolean(FbandroidPrefKeys.k.a(), true);
      localEditor.putLong(FbandroidPrefKeys.j.a(), System.currentTimeMillis());
      localEditor.commit();
    }
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).k(paramAppSession, paramString1, paramInt, paramString2, paramException);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.AttributionIdUpdate
 * JD-Core Version:    0.6.0
 */