package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.UserServerSetting;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.StringUtils.StringProcessor;
import com.facebook.katana.util.TraceLogger;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Iterator;
import java.util.List;

public class FqlGetUserServerSettings extends FqlGeneratedQuery
  implements ApiMethodCallback
{
  private static final Class<?> h = FqlGetUserServerSettings.class;
  protected NetworkRequestCallback<String, String> a;
  public final String b;
  public final String f;
  protected String g;

  public FqlGetUserServerSettings(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2, String paramString3, NetworkRequestCallback<String, String> paramNetworkRequestCallback)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "user_settings", a(paramString2, paramString3), UserServerSetting.class);
    this.a = paramNetworkRequestCallback;
    this.b = paramString2;
    this.f = paramString3;
  }

  protected static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("project=").append(StringUtils.a.a(paramString1)).append(" AND ").append("setting=").append(StringUtils.a.a(paramString2));
    return localStringBuilder.toString();
  }

  public static void a(AppSession paramAppSession, Context paramContext, String paramString1, String paramString2, NetworkRequestCallback<String, String> paramNetworkRequestCallback)
  {
    paramAppSession.a(paramContext, b(paramAppSession, paramContext, paramString1, paramString2, paramNetworkRequestCallback), 1001, 1020, null);
  }

  public static FqlGetUserServerSettings b(AppSession paramAppSession, Context paramContext, String paramString1, String paramString2, NetworkRequestCallback<String, String> paramNetworkRequestCallback)
  {
    if ((paramAppSession != null) && (paramAppSession.c()));
    for (String str = paramAppSession.b().sessionKey; ; str = null)
      return new FqlGetUserServerSettings(paramContext, null, str, null, paramString1, paramString2, paramNetworkRequestCallback);
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if ((paramInt == 200) && (this.g != null));
    for (boolean bool = true; ; bool = false)
    {
      TraceLogger localTraceLogger = this.a.b();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Boolean.valueOf(bool);
      arrayOfObject[1] = this.f;
      localTraceLogger.a("executing callback (valid: %s, settingName: %s)", arrayOfObject);
      this.a.a(paramContext, bool, this.f, this.g, this.g);
      return;
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.a.b().a("got response");
    Iterator localIterator = JMParser.b(paramJsonParser, UserServerSetting.class).iterator();
    while (localIterator.hasNext())
    {
      UserServerSetting localUserServerSetting = (UserServerSetting)localIterator.next();
      if ((!localUserServerSetting.mProjectName.equals(this.b)) || (!localUserServerSetting.mSettingName.equals(this.f)))
        continue;
      this.g = localUserServerSetting.mValue;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetUserServerSettings
 * JD-Core Version:    0.6.0
 */