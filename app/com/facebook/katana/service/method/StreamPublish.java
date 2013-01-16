package com.facebook.katana.service.method;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.util.Log;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.net.HttpOperation.ResponseInputStream;
import com.facebook.katana.util.StringUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StreamPublish extends ApiMethod
  implements ApiMethodCallback
{
  private static final Class<?> a = StreamPublish.class;
  private final Set<FacebookProfile> b;
  private final long f;
  private final String g;
  private final boolean h;
  private String i;
  private final FacebookProfile j;

  public StreamPublish(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, long paramLong, String paramString2, String paramString3, Set<FacebookProfile> paramSet, Set<Long> paramSet1, Long paramLong1, FacebookProfile paramFacebookProfile, String paramString4, boolean paramBoolean)
  {
    super(paramContext, paramIntent, "GET", "stream.publish", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.f = paramLong;
    this.g = paramString3;
    if ((paramSet != null) && (paramSet.size() > 0));
    for (this.b = Collections.unmodifiableSet(paramSet); ; this.b = null)
    {
      this.h = paramBoolean;
      this.j = paramFacebookProfile;
      this.e.put("call_id", String.valueOf(System.currentTimeMillis()));
      this.e.put("session_key", paramString1);
      this.e.put("target_id", String.valueOf(paramLong));
      this.e.put("message", paramString2);
      if ((paramSet1 != null) && (paramSet1.size() > 0))
        this.e.put("tags", a(paramSet1));
      if (paramLong1 != null)
        this.e.put("place", String.valueOf(paramLong1));
      if (paramFacebookProfile != null)
        this.e.put("uid", String.valueOf(paramFacebookProfile.mId));
      if (paramString4 != null)
        this.e.put("privacy", paramString4);
      return;
    }
  }

  public static String a(Context paramContext, long paramLong, String paramString1, String paramString2, Set<FacebookProfile> paramSet, boolean paramBoolean, FacebookProfile paramFacebookProfile)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession == null);
    for (String str = null; ; str = localAppSession.a(paramContext, new StreamPublish(paramContext, null, localAppSession.b().sessionKey, null, paramLong, paramString1, paramString2, paramSet, null, null, paramFacebookProfile, null, paramBoolean), 1001, 1020, null))
      return str;
  }

  public static String a(Set<Long> paramSet)
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    localStringBuilder.append(StringUtils.a(",", new Object[] { paramSet }));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    paramAppSession.b();
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).e(paramAppSession, paramString1, paramInt, paramString2, paramException);
    if (this.h);
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.facebook.katana.widget.publish.result");
      localIntent.putExtra("extra_error_code", paramInt);
      PendingIntent.getBroadcast(paramContext, 0, localIntent, 0).send();
      if (paramInt == 200)
        paramAppSession.a(paramContext, 1, false);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        Log.a(a, "widget update failed: ", localException);
    }
  }

  protected void a(HttpOperation.ResponseInputStream paramResponseInputStream)
  {
    String str = paramResponseInputStream.b();
    if (str.startsWith("{"))
      throw new FacebookApiException(FBJsonFactory.a.createJsonParser(str));
    this.i = a(str, '"');
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.StreamPublish
 * JD-Core Version:    0.6.0
 */