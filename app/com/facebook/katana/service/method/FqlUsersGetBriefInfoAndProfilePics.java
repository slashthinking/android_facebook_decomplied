package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.FacebookUserWithLargeProfilePic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FqlUsersGetBriefInfoAndProfilePics extends FqlGetUsersProfile
  implements ApiMethodCallback
{
  public FqlUsersGetBriefInfoAndProfilePics(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, Map<Long, FacebookUser> paramMap)
  {
    super(paramContext, paramIntent, paramString, paramServiceOperationListener, paramMap, FacebookUserWithLargeProfilePic.class);
  }

  public static String a(AppSession paramAppSession, Context paramContext, Long[] paramArrayOfLong)
  {
    HashMap localHashMap = new HashMap();
    int i = paramArrayOfLong.length;
    for (int j = 0; j < i; j++)
      localHashMap.put(paramArrayOfLong[j], null);
    return paramAppSession.a(paramContext, new FqlUsersGetBriefInfoAndProfilePics(paramContext, null, paramAppSession.b().sessionKey, null, localHashMap), 1001, 1020, null);
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).h(paramAppSession, paramString1, paramInt, paramString2, paramException, new ArrayList(g().values()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlUsersGetBriefInfoAndProfilePics
 * JD-Core Version:    0.6.0
 */