package com.facebook.katana;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.katana.util.FacebookPlatform;

final class IntentUriHandler$1
  implements IntentUriHandler.UriHandler
{
  public Intent a(Context paramContext, Bundle paramBundle)
  {
    return new Intent("android.intent.action.VIEW", Uri.parse(FacebookPlatform.a(paramContext, paramBundle.getString("destination"))));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.IntentUriHandler.1
 * JD-Core Version:    0.6.0
 */