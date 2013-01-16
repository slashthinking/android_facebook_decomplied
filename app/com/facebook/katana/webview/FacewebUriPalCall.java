package com.facebook.katana.webview;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.util.Log;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class FacewebUriPalCall
  implements FacewebPalCall
{
  public final UUID a;
  protected final Uri b;
  private final String c;

  public FacewebUriPalCall(Uri paramUri)
  {
    this.b = paramUri;
    List localList = this.b.getPathSegments();
    if (localList.size() == 3);
    for (this.a = UUID.fromString((String)localList.get(1)); ; this.a = null)
    {
      this.c = paramUri.getLastPathSegment();
      return;
    }
  }

  public static String a(String paramString1, String paramString2, UUID paramUUID1, UUID paramUUID2, String paramString3, Map<String, Serializable> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringLocaleUtil.a("'%s://%s/", new Object[] { paramString1, paramString2 }));
    if (paramUUID1 != null)
      localStringBuilder.append(paramUUID1.toString()).append("/");
    if (paramUUID2 != null)
      localStringBuilder.append(paramUUID2.toString()).append("/");
    localStringBuilder.append(paramString3).append("/'");
    Iterator localIterator = paramMap.entrySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int j;
      label138: Serializable localSerializable;
      if (i != 0)
      {
        localStringBuilder.append(" + '?' + ");
        j = 0;
        String str = (String)localEntry.getKey();
        localSerializable = (Serializable)localEntry.getValue();
        localStringBuilder.append("'").append(Uri.encode(str)).append("=' + ");
        if (!(localSerializable instanceof FacewebUriPalCall.JsVariable))
          break label231;
        localStringBuilder.append("encodeURIComponent(").append(localSerializable).append(")");
      }
      while (true)
      {
        i = j;
        break;
        localStringBuilder.append(" + '&' + ");
        j = i;
        break label138;
        label231: localStringBuilder.append("'").append(Uri.encode(localSerializable.toString())).append("'");
      }
    }
    return localStringBuilder.toString();
  }

  public long a(String paramString1, String paramString2, long paramLong)
  {
    String str = a(paramString1, paramString2);
    if (TextUtils.isEmpty(str));
    while (true)
    {
      return paramLong;
      try
      {
        long l = Long.parseLong(str);
        paramLong = l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.b("FacebookRpcCall", "failed to parse long: " + str);
      }
    }
  }

  public String a()
  {
    return this.c;
  }

  public String a(String paramString1, String paramString2)
  {
    Object localObject;
    if (this.b == null)
      localObject = null;
    while (true)
    {
      return localObject;
      String str1 = this.b.getQueryParameter(paramString2);
      if ((str1 != null) && (paramString1 != null) && (str1.length() > 1) && (str1.charAt(0) == '@'))
      {
        String str2 = str1.substring(1);
        localObject = Uri.parse(paramString1).getQueryParameter(str2);
        if (localObject != null)
          continue;
      }
      localObject = str1;
    }
  }

  public String a(String paramString1, String paramString2, String paramString3)
  {
    String str = a(paramString1, paramString2);
    if (str != null)
      paramString3 = str;
    return paramString3;
  }

  public Uri b()
  {
    return this.b;
  }

  public boolean b(String paramString1, String paramString2)
  {
    if (a(paramString1, paramString2) != null);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebUriPalCall
 * JD-Core Version:    0.6.0
 */