package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSession.PreloadStep;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.features.composer.ComposerUserSettings;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

final class PostLoginSyncRequest$PostLoginMultiQuery extends FqlMultiQuery
  implements ApiMethodCallback
{
  public PostLoginSyncRequest$PostLoginMultiQuery(Context paramContext, String paramString)
  {
    super(paramContext, null, paramString, a(paramContext), null);
  }

  private static LinkedHashMap<String, FqlQuery> a(Context paramContext)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    LinkedHashMap localLinkedHashMap;
    if (localAppSession == null)
      localLinkedHashMap = null;
    while (true)
    {
      return localLinkedHashMap;
      FqlGetGatekeeperSettings localFqlGetGatekeeperSettings = Gatekeeper.a(paramContext, localAppSession);
      FqlGetUserServerSettings localFqlGetUserServerSettings = ComposerUserSettings.a(paramContext, localAppSession, "composer_tour_completed");
      localLinkedHashMap = new LinkedHashMap();
      localLinkedHashMap.put("gkSync", localFqlGetGatekeeperSettings);
      localLinkedHashMap.put("userSetting", localFqlGetUserServerSettings);
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = PostLoginSyncRequest.a().iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ApiMethodCallback localApiMethodCallback = (ApiMethodCallback)c(str);
      Intent localIntent;
      if ("gkSync".equals(str))
      {
        localIntent = new Intent(paramIntent);
        localIntent.putExtra("extended_type", 402);
        paramAppSession.a(AppSession.PreloadStep.FETCH_GATEKEEPERS);
      }
      while (true)
      {
        localApiMethodCallback.a(paramAppSession, paramContext, localIntent, paramString1, paramInt, paramString2, paramException);
        break;
        localIntent = paramIntent;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PostLoginSyncRequest.PostLoginMultiQuery
 * JD-Core Version:    0.6.0
 */