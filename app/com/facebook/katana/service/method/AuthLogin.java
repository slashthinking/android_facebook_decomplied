package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.BuildConstants;
import com.facebook.common.json.jsonmirror.JMAutogen;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.types.JMDict;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.provider.KeyValueManager;
import com.facebook.katana.util.StringUtils;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import java.util.Map;

public class AuthLogin extends ApiMethod
{
  private FacebookSessionInfo a;
  private final ServiceOperationListener b;

  public AuthLogin(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", "auth.login", Constants.URL.b(paramContext), null);
    this.e.put("email", paramString1);
    this.e.put("password", paramString2);
    if (paramString3 != null)
      this.e.put("credentials_type", paramString3);
    this.e.put("generate_session_cookies", "1");
    this.e.put("error_detail_type", "detailed_button");
    String str = KeyValueManager.a(paramContext, "machine_id", "");
    if (StringUtils.c(str))
      this.e.put("generate_machine_id", "1");
    while (true)
    {
      this.q = new AuthLogin.LoginListener(this, null);
      this.b = paramServiceOperationListener;
      return;
      this.e.put("machine_id", str);
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    AuthLogin.FacebookApiSessionInfo localFacebookApiSessionInfo = (AuthLogin.FacebookApiSessionInfo)JMParser.a(paramJsonParser, AuthLogin.FacebookApiSessionInfo.class);
    if (localFacebookApiSessionInfo.mErrorCode != -1)
    {
      if (StringUtils.c(localFacebookApiSessionInfo.errorData))
        throw new FacebookApiException(localFacebookApiSessionInfo.mErrorCode, localFacebookApiSessionInfo.mErrorMsg);
      throw new FacebookApiException(localFacebookApiSessionInfo.mErrorCode, localFacebookApiSessionInfo.mErrorMsg, localFacebookApiSessionInfo.errorData);
    }
    if ((localFacebookApiSessionInfo.sessionKey != null) && (localFacebookApiSessionInfo.userId != -1L))
    {
      JMDict localJMDict = JMAutogen.a(FacebookSessionInfo.class);
      this.a = localFacebookApiSessionInfo;
      localJMDict.a(this.a, "username", (String)this.e.get("email"));
      if ((BuildConstants.a()) && (this.a.username == null))
        ErrorReporting.a("LoginNullUsername", "AuthLogin created SessionInfo with null username.  Params: " + this.e);
      return;
    }
    throw new IOException("Session info not found");
  }

  protected boolean a()
  {
    return false;
  }

  protected String f()
  {
    return "62f8ce9f74b12f84c123cc23437a4a32";
  }

  public FacebookSessionInfo g()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.AuthLogin
 * JD-Core Version:    0.6.0
 */