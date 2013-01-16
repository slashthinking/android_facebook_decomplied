package com.facebook.katana.features;

import android.content.Context;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSession.PreloadStep;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.util.TraceLogger;
import com.facebook.uri.UriTemplateMap;

class UriMapClient$1
  implements NetworkRequestCallback<String, String>
{
  public void a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    UriTemplateMap localUriTemplateMap = null;
    if (paramBoolean)
    {
      localUriTemplateMap = this.b.b(paramString3);
      if (("urimap".equals(this.b.c())) && ("android_faceweb".equals(this.b.b())))
      {
        AppSession localAppSession = AppSession.a(paramContext, false);
        if (localAppSession != null)
          localAppSession.a(AppSession.PreloadStep.FETCH_FACEWEB_URI_MAP);
        IntentUriHandler.j();
        this.a.b().a("clear IntentUriHandler.sCanHandleUriCache");
      }
    }
    this.a.b().a("passing callback up from shim layer");
    this.a.a(paramContext, paramBoolean, paramString1, paramString3, localUriTemplateMap);
  }

  public TraceLogger b()
  {
    return this.a.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.UriMapClient.1
 * JD-Core Version:    0.6.0
 */