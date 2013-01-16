package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMAutogen.ListType;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.util.ErrorReporting;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.orca.model.SessionCookie;
import com.fasterxml.jackson.core.JsonFactory;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookSessionInfo
  implements JMStaticKeysDictDestination
{
  public static final String ERROR_DATA = "error_data";
  public static final String FILTER_KEY = "filter";
  public static final String MACHINE_ID = "machine_id";
  public static final String OAUTH_TOKEN_KEY = "access_token";
  public static final String PROFILE_KEY = "profile";
  public static final String SECRET_KEY = "secret";
  public static final String SESSION_COOKIES_FROM_AUTH_LOGIN = "session_cookies";
  public static final String SESSION_KEY = "session_key";
  public static final String USERNAME_KEY = "username";
  public static final String USER_ID_KEY = "uid";
  public static final FacebookSessionInfo sInvalidSessionInfo = new FacebookSessionInfo();

  @JMAutogen.InferredType(jsonFieldName="error_data")
  public final String errorData;

  @JMAutogen.InferredType(jsonFieldName="filter")
  private String mFilterKey;

  @JMAutogen.InferredType(jsonFieldName="profile")
  private FacebookUser mMyself;

  @JMAutogen.ListType(b={SessionCookie.class}, jsonFieldName="session_cookies")
  private List<SessionCookie> mSessionCookies;

  @JMAutogen.InferredType(jsonFieldName="machine_id")
  public final String machineID;

  @JMAutogen.InferredType(jsonFieldName="access_token")
  public final String oAuthToken;

  @JMAutogen.InferredType(jsonFieldName="session_key")
  public final String sessionKey;

  @JMAutogen.InferredType(jsonFieldName="secret")
  public final String sessionSecret;

  @JMAutogen.InferredType(jsonFieldName="uid")
  public final long userId;

  @JMAutogen.InferredType(jsonFieldName="username")
  public final String username;

  protected FacebookSessionInfo()
  {
    this.username = null;
    this.sessionKey = null;
    this.sessionSecret = null;
    this.oAuthToken = null;
    this.machineID = null;
    this.errorData = null;
    this.userId = -1L;
    this.mSessionCookies = null;
  }

  public FacebookSessionInfo(FacebookSessionInfo paramFacebookSessionInfo, String paramString)
  {
    this.username = paramFacebookSessionInfo.username;
    this.sessionKey = paramFacebookSessionInfo.sessionKey;
    this.sessionSecret = paramFacebookSessionInfo.sessionSecret;
    this.oAuthToken = paramString;
    this.userId = paramFacebookSessionInfo.userId;
    this.machineID = paramFacebookSessionInfo.machineID;
    this.errorData = paramFacebookSessionInfo.errorData;
    this.mFilterKey = paramFacebookSessionInfo.mFilterKey;
    this.mMyself = paramFacebookSessionInfo.mMyself;
    this.mSessionCookies = paramFacebookSessionInfo.b();
  }

  public static FacebookSessionInfo a(String paramString)
  {
    FacebookSessionInfo localFacebookSessionInfo = (FacebookSessionInfo)JMParser.a(new JsonFactory().createJsonParser(paramString), FacebookSessionInfo.class);
    if (!a(localFacebookSessionInfo))
    {
      String str = localFacebookSessionInfo.d().toString();
      ErrorReporting.a("ParsedMissingFacebookUser-t1862267", "Input " + paramString + " parsed to " + str, false);
    }
    return localFacebookSessionInfo;
  }

  public static boolean a(FacebookSessionInfo paramFacebookSessionInfo)
  {
    if ((paramFacebookSessionInfo != null) && (paramFacebookSessionInfo != sInvalidSessionInfo) && (paramFacebookSessionInfo.userId != -1L) && (paramFacebookSessionInfo.sessionKey != null) && (paramFacebookSessionInfo.sessionSecret != null) && (paramFacebookSessionInfo.oAuthToken != null) && (paramFacebookSessionInfo.mMyself != null));
    for (int i = 1; ; i = 0)
      return i;
  }

  public FacebookUser a()
  {
    return this.mMyself;
  }

  public void a(FacebookUser paramFacebookUser)
  {
    if (paramFacebookUser == null)
      ErrorReporting.a("SettingFacebookUserToNull-t1862267", "The profile in sessioninfo is being set to null!", true);
    while (true)
    {
      return;
      this.mMyself = paramFacebookUser;
    }
  }

  public List<SessionCookie> b()
  {
    if (this.mSessionCookies != null);
    for (List localList = Collections.unmodifiableList(this.mSessionCookies); ; localList = null)
      return localList;
  }

  public void c()
  {
    this.mSessionCookies = null;
  }

  public JSONObject d()
  {
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("username", this.username);
      localJSONObject.put("uid", this.userId);
      localJSONObject.put("session_key", this.sessionKey);
      localJSONObject.put("secret", this.sessionSecret);
      localJSONObject.put("access_token", this.oAuthToken);
      localJSONObject.put("machine_id", this.machineID);
      if (this.errorData != null)
        localJSONObject.put("error_data", this.errorData);
      if (this.mMyself != null)
        localJSONObject.put("profile", this.mMyself.b());
      if (this.mFilterKey != null)
        localJSONObject.put("filter", this.mFilterKey);
      if (this.mSessionCookies != null)
        localJSONObject.put("session_cookies", this.mSessionCookies);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        JSONObject localJSONObject = new JSONObject();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookSessionInfo
 * JD-Core Version:    0.6.0
 */