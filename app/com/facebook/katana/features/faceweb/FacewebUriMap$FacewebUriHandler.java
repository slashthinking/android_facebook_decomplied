package com.facebook.katana.features.faceweb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.katana.IntentUriHandler.UriHandler;
import com.facebook.katana.activity.FbFragmentChromeActivity;
import com.facebook.katana.util.Utils;
import java.util.Iterator;
import java.util.Set;

public class FacewebUriMap$FacewebUriHandler
  implements IntentUriHandler.UriHandler
{
  public final String a;

  public FacewebUriMap$FacewebUriHandler(String paramString)
  {
    this.a = paramString;
  }

  public Intent a(Context paramContext, Bundle paramBundle)
  {
    String str1 = this.a;
    Iterator localIterator = paramBundle.keySet().iterator();
    String str3;
    for (String str2 = str1; localIterator.hasNext(); str2 = str2.replaceAll("<" + str3 + ">", Utils.a(paramBundle, str3)))
      str3 = (String)localIterator.next();
    Intent localIntent = new Intent(paramContext, FbFragmentChromeActivity.class);
    localIntent.putExtra("mobile_page", str2);
    return localIntent;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.faceweb.FacewebUriMap.FacewebUriHandler
 * JD-Core Version:    0.6.0
 */