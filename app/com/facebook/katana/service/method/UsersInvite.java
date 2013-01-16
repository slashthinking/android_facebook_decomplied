package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.activity.findfriends.HowFound;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.util.StringUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UsersInvite extends ApiMethod
  implements ApiMethodCallback
{
  protected List<String> a;

  public UsersInvite(Context paramContext, Intent paramIntent, String paramString1, List<String> paramList, String paramString2, String paramString3, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "POST", "users.invite", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.a = paramList;
    this.e.put("call_id", String.valueOf(System.currentTimeMillis()));
    this.e.put("session_key", paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    StringUtils.a(localStringBuilder, ",", new UsersInvite.1(this), new Object[] { paramList });
    this.e.put("emails", localStringBuilder.toString());
    if (paramString2 != null)
      this.e.put("message", paramString2);
    this.e.put("country_code", paramString3);
    this.e.put("ci_how_found", HowFound.a());
  }

  public static String a(AppSession paramAppSession, Context paramContext, List<String> paramList, String paramString1, String paramString2)
  {
    return paramAppSession.a(paramContext, new UsersInvite(paramContext, null, paramAppSession.b().sessionKey, paramList, paramString1, paramString2, null), 1001, 1020, null);
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).g(paramAppSession, paramString1, paramInt, paramString2, paramException, this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.UsersInvite
 * JD-Core Version:    0.6.0
 */