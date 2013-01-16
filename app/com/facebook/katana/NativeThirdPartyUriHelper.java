package com.facebook.katana;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.common.util.Log;
import com.facebook.orca.inject.FbInjector;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class NativeThirdPartyUriHelper
{
  private static final Class<?> a = NativeThirdPartyUriHelper.class;
  private static AnalyticsLogger b = null;

  public static Intent a(Context paramContext, Uri paramUri)
  {
    Intent localIntent;
    if ((!"fbrpc".equals(paramUri.getScheme())) || (!"facebook".equals(paramUri.getHost())) || (!"/nativethirdparty".equals(paramUri.getPath())))
      localIntent = null;
    while (true)
    {
      return localIntent;
      localIntent = d(paramContext, paramUri);
      if (localIntent != null)
        continue;
      localIntent = b(paramContext, paramUri);
      if (localIntent != null)
        continue;
      localIntent = c(paramContext, paramUri);
    }
  }

  private static Intent a(String paramString, Intent paramIntent)
  {
    if (paramString == null)
      paramIntent = null;
    while (true)
    {
      return paramIntent;
      try
      {
        long l = Long.parseLong(paramString);
        paramIntent.putExtra("app_id", l);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramIntent = null;
      }
    }
  }

  private static Uri a(String paramString)
  {
    if (paramString != null);
    for (Uri localUri = Uri.parse(paramString); ; localUri = null)
      return localUri;
  }

  private static List<String> a(Uri paramUri)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; ; i++)
    {
      String str = paramUri.getQueryParameter("key_hash" + i);
      if (str == null)
        return localArrayList;
      int j = str.indexOf('=');
      if (j >= 0)
        str = str.substring(0, j);
      localArrayList.add(str);
    }
  }

  public static void a(Context paramContext, Intent paramIntent)
  {
    if (!(paramIntent instanceof NativeThirdPartyUriHelper.FbrpcIntent));
    NativeThirdPartyUriHelper.FbrpcIntent localFbrpcIntent;
    long l;
    do
    {
      return;
      localFbrpcIntent = (NativeThirdPartyUriHelper.FbrpcIntent)paramIntent;
      l = paramIntent.getLongExtra("app_id", 0L);
    }
    while (l == 0L);
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("applaunch");
    localHoneyClientEvent.a("app_id", l);
    if (paramIntent.hasExtra("access_token"));
    for (String str = "app"; ; str = "market")
    {
      localHoneyClientEvent.b("target", str);
      Uri localUri1 = paramIntent.getData();
      if (localUri1 != null)
        localHoneyClientEvent.b("dest_uri", localUri1.toString());
      Uri localUri2 = localFbrpcIntent.a;
      if (localUri2 != null)
        localHoneyClientEvent.a("fbrpc", b(localUri2));
      if (b == null)
        b = (AnalyticsLogger)FbInjector.a(paramContext).a(AnalyticsLogger.class);
      b.a(paramContext, localHoneyClientEvent);
      break;
    }
  }

  private static boolean a(PackageInfo paramPackageInfo, List<String> paramList)
  {
    Signature[] arrayOfSignature = paramPackageInfo.signatures;
    int i = 0;
    if (arrayOfSignature == null)
      return i;
    while (true)
    {
      int k;
      int m;
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
        int j = arrayOfSignature.length;
        k = 0;
        i = 0;
        if (k >= j)
          break;
        Signature localSignature = arrayOfSignature[k];
        localMessageDigest.reset();
        localMessageDigest.update(localSignature.toByteArray());
        String str = Base64.encodeToString(localMessageDigest.digest(), 3);
        m = 0;
        if (m >= paramList.size())
          break label123;
        if (!str.equals(paramList.get(m)))
          break label117;
        i = 1;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        Log.a("Facebook-IntentUriHandler", "Failed to instantiate SHA-1 algorithm.");
        i = 0;
      }
      break;
      label117: m++;
      continue;
      label123: k++;
    }
  }

  private static Intent b(Context paramContext, Uri paramUri)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Uri localUri = a(paramUri.getQueryParameter("market_uri"));
    Intent localIntent = null;
    if (localUri == null);
    while (true)
    {
      return localIntent;
      NativeThirdPartyUriHelper.FbrpcIntent localFbrpcIntent = new NativeThirdPartyUriHelper.FbrpcIntent("android.intent.action.VIEW", localUri);
      localFbrpcIntent.a = paramUri;
      ResolveInfo localResolveInfo = localPackageManager.resolveActivity(localFbrpcIntent, 65536);
      localIntent = null;
      if (localResolveInfo == null)
        continue;
      localIntent = a(paramUri.getQueryParameter("app_id"), localFbrpcIntent);
    }
  }

  private static ObjectNode b(Uri paramUri)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    String str1 = paramUri.getEncodedQuery();
    if (str1 != null)
    {
      int j;
      for (int i = 0; i < str1.length(); i = j + 1)
      {
        j = str1.indexOf('&', i);
        if (j == -1)
          j = str1.length();
        int k = str1.indexOf('=', i);
        if ((k == -1) || (k > j))
          k = j;
        int m = k + 1;
        if (i >= k)
          continue;
        String str2 = Uri.decode(str1.substring(i, k));
        String str3 = "";
        if (m < j)
          str3 = Uri.decode(str1.substring(m, j));
        localObjectNode.put(str2, str3);
      }
    }
    return localObjectNode;
  }

  private static Intent c(Context paramContext, Uri paramUri)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    int i = 0;
    Uri localUri = a(paramUri.getQueryParameter("fallback_url" + i));
    i++;
    if (localUri == null);
    Intent localIntent;
    for (Object localObject = null; ; localObject = localIntent)
    {
      return localObject;
      localIntent = new Intent("android.intent.action.VIEW", localUri);
      if (localPackageManager.resolveActivity(localIntent, 65536) == null)
        break;
    }
  }

  private static Intent d(Context paramContext, Uri paramUri)
  {
    String str1 = paramUri.getQueryParameter("app_id");
    Uri localUri = a(paramUri.getQueryParameter("target_url"));
    String str2 = paramUri.getQueryParameter("access_token");
    String str3 = paramUri.getQueryParameter("expires_in");
    String str4 = paramUri.getQueryParameter("package_name");
    String str5 = paramUri.getQueryParameter("class_name");
    List localList = a(paramUri);
    Intent localIntent;
    if (TextUtils.isEmpty(str1))
    {
      Log.a(a, "Native application url did not specify app_id.");
      localIntent = null;
    }
    while (true)
    {
      return localIntent;
      if (localList.size() == 0)
      {
        Log.a(a, "Native application url did not specify Android key hash.");
        localIntent = null;
        continue;
      }
      if (TextUtils.isEmpty(str4) != TextUtils.isEmpty(str5))
      {
        Log.a(a, "Native application url specified only one of package_name and class_name.  Neither or both must be specified.");
        localIntent = null;
        continue;
      }
      NativeThirdPartyUriHelper.FbrpcIntent localFbrpcIntent = new NativeThirdPartyUriHelper.FbrpcIntent("com.facebook.application." + str1, localUri);
      localFbrpcIntent.a = paramUri;
      localFbrpcIntent.putExtra("access_token", str2);
      localFbrpcIntent.putExtra("expires_in", str3);
      localFbrpcIntent.addFlags(268435456);
      if (!TextUtils.isEmpty(str4))
        localFbrpcIntent.setComponent(new ComponentName(str4, str5));
      PackageManager localPackageManager = paramContext.getPackageManager();
      ResolveInfo localResolveInfo = localPackageManager.resolveActivity(localFbrpcIntent, 65536);
      if (localResolveInfo == null)
      {
        Log.d(a, "Native application is not installed.");
        localIntent = null;
        continue;
      }
      if (TextUtils.isEmpty(str4))
      {
        ActivityInfo localActivityInfo = localResolveInfo.activityInfo;
        if (localActivityInfo == null)
        {
          Log.a(a, "Native application url referenced ResolveInfo that has null activityInfo.");
          localIntent = null;
          continue;
        }
        str4 = localActivityInfo.packageName;
        if (str4 == null)
        {
          Log.a(a, "Native application url referenced ActivityInfo that has null packageName.");
          localIntent = null;
          continue;
        }
      }
      try
      {
        PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo(str4, 64);
        localPackageInfo1 = localPackageInfo2;
        if (localPackageInfo1 == null)
        {
          Log.a(a, "Could not getPackageInfo for package: '" + str4 + "'.");
          localIntent = null;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        PackageInfo localPackageInfo1;
        while (true)
          localPackageInfo1 = null;
        if (!a(localPackageInfo1, localList))
        {
          Log.a(a, "Could not verify signature for package: '" + str4 + "'.");
          localIntent = null;
          continue;
        }
        localIntent = a(str1, localFbrpcIntent);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.NativeThirdPartyUriHelper
 * JD-Core Version:    0.6.0
 */