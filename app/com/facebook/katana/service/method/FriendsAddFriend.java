package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.activity.findfriends.HowFound;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.util.StringUtils;
import com.fasterxml.jackson.core.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FriendsAddFriend extends ApiMethod
  implements ApiMethodCallback
{
  protected List<Long> a;

  protected FriendsAddFriend(Context paramContext, Intent paramIntent, String paramString1, Long paramLong, String paramString2, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "POST", "facebook.friends_add", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.a = new ArrayList();
    this.a.add(paramLong);
    this.e.put("uid", String.valueOf(paramLong));
    a(paramString1, paramString2);
  }

  protected FriendsAddFriend(Context paramContext, Intent paramIntent, String paramString1, List<Long> paramList, String paramString2, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "POST", "facebook.friends_add", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.a = paramList;
    this.e.put("uids", StringUtils.a(",", new Object[] { paramList }));
    this.e.put("ci_how_found", HowFound.a());
    a(paramString1, paramString2);
  }

  public static String a(AppSession paramAppSession, Context paramContext, Long paramLong, String paramString)
  {
    return paramAppSession.a(paramContext, new FriendsAddFriend(paramContext, null, paramAppSession.b().sessionKey, paramLong, paramString, null), 1001, 1020, null);
  }

  public static String a(AppSession paramAppSession, Context paramContext, List<Long> paramList, String paramString)
  {
    return paramAppSession.a(paramContext, new FriendsAddFriend(paramContext, null, paramAppSession.b().sessionKey, paramList, paramString, null), 1001, 1020, null);
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).b(paramAppSession, paramString1, paramInt, paramString2, paramException, this.a);
  }

  protected void a(JsonParser paramJsonParser)
  {
    JsonResponseVerifier.a(paramJsonParser);
  }

  protected void a(String paramString1, String paramString2)
  {
    this.e.put("call_id", Long.toString(System.currentTimeMillis()));
    this.e.put("session_key", paramString1);
    if (paramString2 != null)
      this.e.put("message", paramString2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FriendsAddFriend
 * JD-Core Version:    0.6.0
 */