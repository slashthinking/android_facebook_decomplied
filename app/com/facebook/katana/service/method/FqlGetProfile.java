package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.util.StringUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FqlGetProfile extends FqlGetProfileGeneric<FacebookProfile>
  implements ApiMethodCallback
{
  private static final Class<?> f = FqlGetProfile.class;

  public FqlGetProfile(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, paramString2, FacebookProfile.class);
  }

  public FqlGetProfile(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, Map<Long, FacebookProfile> paramMap)
  {
    this(paramContext, paramIntent, paramString, paramServiceOperationListener, a(paramMap));
  }

  public static String a(Context paramContext, long paramLong)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      HashMap localHashMap = new HashMap();
      localHashMap.put(Long.valueOf(paramLong), null);
      str = localAppSession.a(paramContext, new FqlGetProfile(paramContext, null, localAppSession.b().sessionKey, null, localHashMap), 1001, 84, null);
    }
  }

  public static String a(Context paramContext, long paramLong, String paramString)
  {
    AppSession localAppSession = AppSession.a(paramContext, false);
    String str = "id IN ( SELECT uid FROM user where uid IN " + "( SELECT uid FROM group_member WHERE gid=" + paramLong + ") AND (strpos(lower(first_name),\"" + paramString + "\") == 0 OR strpos(lower(last_name),\"" + paramString + "\") == 0) LIMIT " + 50 + ")";
    return localAppSession.a(paramContext, new FqlGetProfile(paramContext, null, localAppSession.b().sessionKey, null, str), 1001, 601, null);
  }

  private static String a(Map<Long, FacebookProfile> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder(" id IN(");
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramMap.keySet();
    StringUtils.a(localStringBuilder, ",", null, arrayOfObject);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }

  public static String b(Context paramContext, long paramLong)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str1 = null;
    if (localAppSession == null);
    while (true)
    {
      return str1;
      String str2 = "id IN (SELECT uid FROM group_member WHERE gid=" + paramLong + ")";
      str1 = localAppSession.a(paramContext, new FqlGetProfile(paramContext, null, localAppSession.b().sessionKey, null, str2), 1001, 601, null);
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    switch (paramIntent.getIntExtra("extended_type", -1))
    {
    default:
    case 84:
    case 601:
    }
    while (true)
    {
      return;
      Iterator localIterator2 = this.a.values().iterator();
      boolean bool = localIterator2.hasNext();
      FacebookProfile localFacebookProfile = null;
      if (bool)
        localFacebookProfile = (FacebookProfile)localIterator2.next();
      Iterator localIterator3 = paramAppSession.d().iterator();
      while (localIterator3.hasNext())
        ((AppSessionListener)localIterator3.next()).a(paramAppSession, paramString1, paramInt, paramString2, paramException, localFacebookProfile);
      continue;
      Iterator localIterator1 = paramAppSession.d().iterator();
      while (localIterator1.hasNext())
        ((AppSessionListener)localIterator1.next()).d(paramAppSession, paramString1, paramInt, paramString2, paramException, this.a);
    }
  }

  public Map<Long, FacebookProfile> g()
  {
    return Collections.unmodifiableMap(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetProfile
 * JD-Core Version:    0.6.0
 */