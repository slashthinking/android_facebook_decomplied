package com.facebook.orca.login;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.orca.app.IntendedAudience;
import com.facebook.orca.auth.FirstPartySsoSessionInfo;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import javax.inject.Provider;

public class SsoLoginUtil
{
  private final Provider<Boolean> a;
  private final Provider<IntendedAudience> b;
  private final ObjectMapper c;

  private Intent a()
  {
    Intent localIntent = new Intent();
    if (this.b.b() == IntendedAudience.DEVELOPMENT)
      localIntent.setClassName("com.facebook.wakizashi", "com.facebook.katana.ProxyAuth");
    while (true)
    {
      return localIntent;
      localIntent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
    }
  }

  private boolean a(Context paramContext, Intent paramIntent)
  {
    ResolveInfo localResolveInfo = paramContext.getPackageManager().resolveActivity(paramIntent, 0);
    boolean bool = false;
    if (localResolveInfo == null);
    while (true)
    {
      return bool;
      Signature[] arrayOfSignature1 = a(paramContext, localResolveInfo.activityInfo.packageName);
      if (arrayOfSignature1 == null)
      {
        BLog.d("SSO", "No signatures found for fb4a, or error occurred while retrieving them");
        bool = false;
      }
      else
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(arrayOfSignature1.length);
        BLog.c("SSO", String.format("%d signatures found for fb4a", arrayOfObject1));
        Signature[] arrayOfSignature2 = a(paramContext, paramContext.getPackageName());
        if (arrayOfSignature2 == null)
        {
          BLog.d("SSO", "No signatures found for orca, or error occurred while retrieving them");
          bool = false;
        }
        else
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Integer.valueOf(arrayOfSignature2.length);
          BLog.c("SSO", String.format("%d signatures found for orca", arrayOfObject2));
          int i = arrayOfSignature1.length;
          label216: for (int j = 0; ; j++)
          {
            if (j >= i)
              break label222;
            Signature localSignature1 = arrayOfSignature1[j];
            int k = arrayOfSignature2.length;
            for (int m = 0; ; m++)
            {
              if (m >= k)
                break label216;
              Signature localSignature2 = arrayOfSignature2[m];
              if (Objects.equal(localSignature1.toCharsString(), localSignature2.toCharsString()))
              {
                BLog.c("SSO", "fb4a and orca signatures match!");
                bool = true;
                break;
              }
            }
          }
          label222: BLog.d("SSO", "No matching signatures found!");
          bool = false;
        }
      }
    }
  }

  private Signature[] a(Context paramContext, String paramString)
  {
    try
    {
      arrayOfSignature = paramContext.getPackageManager().getPackageInfo(paramString, 64).signatures;
      return arrayOfSignature;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        Signature[] arrayOfSignature = null;
    }
  }

  public boolean a(Context paramContext)
  {
    if ((((Boolean)this.a.b()).booleanValue()) && (b(paramContext)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean b(Context paramContext)
  {
    boolean bool = false;
    if (!a(paramContext, a()))
      BLog.e("SSO", "fb4a application package has no matching signatures");
    while (true)
    {
      return bool;
      FirstPartySsoSessionInfo localFirstPartySsoSessionInfo = d(paramContext);
      if (localFirstPartySsoSessionInfo == null)
        BLog.d("SSO", "User is not logged into FB4A, or there was an error retrieving the session.");
      bool = false;
      if (localFirstPartySsoSessionInfo != null)
        bool = true;
    }
  }

  public boolean c(Context paramContext)
  {
    return a(paramContext, a());
  }

  public FirstPartySsoSessionInfo d(Context paramContext)
  {
    FirstPartySsoSessionInfo localFirstPartySsoSessionInfo;
    try
    {
      Object localObject1;
      if (this.b.b() == IntendedAudience.DEVELOPMENT)
      {
        BLog.c("SSO", "Using wakizashi content provider URI");
        localObject1 = Uri.parse("content://com.facebook.wakizashi.provider.UserValuesProvider/user_values");
      }
      while (true)
      {
        Cursor localCursor = paramContext.getContentResolver().query((Uri)localObject1, new String[] { "name", "value" }, "name='active_session_info'", null, null);
        try
        {
          if (localCursor.moveToNext())
          {
            str = localCursor.getString(1);
            BLog.c("SSO", "fb4a session data obtained");
          }
          while (true)
          {
            localCursor.close();
            if (!StringUtil.a(str))
              break label172;
            BLog.e("SSO", "fb4a session information is empty!");
            localFirstPartySsoSessionInfo = null;
            break label230;
            BLog.c("SSO", "Using katana content provider URI");
            Uri localUri = Uri.parse("content://com.facebook.katana.provider.UserValuesProvider/user_values");
            localObject1 = localUri;
            break;
            BLog.d("SSO", "fb4a content provider has no session entry.");
            str = null;
          }
        }
        finally
        {
          localCursor.close();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      String str;
      BLog.d("SSO", "Exception occurred while resolving fb4a session.", localThrowable);
      localFirstPartySsoSessionInfo = null;
      break label230;
      label172: JsonNode localJsonNode1 = this.c.readTree(str);
      JsonNode localJsonNode2 = localJsonNode1.get("profile");
      localFirstPartySsoSessionInfo = new FirstPartySsoSessionInfo(JSONUtil.b(localJsonNode2.get("uid")), JSONUtil.b(localJsonNode2.get("name")), JSONUtil.b(localJsonNode1.get("access_token")));
    }
    label230: return localFirstPartySsoSessionInfo;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.SsoLoginUtil
 * JD-Core Version:    0.6.2
 */