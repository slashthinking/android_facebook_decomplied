package com.facebook.katana;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.katana.util.FacebookPlatform;
import com.facebook.orca.common.util.StringLocaleUtil;

final class IntentUriHandler$2
  implements IntentUriHandler.UriHandler
{
  public Intent a(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle.getString("destination").equals("archived"));
    for (String str1 = "archived"; ; str1 = "other")
    {
      String str2 = FacebookPlatform.a(paramContext, Constants.URL.c(paramContext, StringLocaleUtil.a("/messages/?folder=%s", new Object[] { str1 })));
      return new Intent("android.intent.action.VIEW", Uri.parse(str2 + StringLocaleUtil.a("#!/messages/?folder=%s", new Object[] { str1 })));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.IntentUriHandler.2
 * JD-Core Version:    0.6.0
 */