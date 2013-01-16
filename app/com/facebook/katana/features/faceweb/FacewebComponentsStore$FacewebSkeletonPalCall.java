package com.facebook.katana.features.faceweb;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.base.BuildConstants;
import com.facebook.common.json.jsonmirror.JMAutogen.DynamicKeyDictType;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.json.jsonmirror.types.JMForcedString;
import com.facebook.katana.webview.FacewebPalCall;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.io.Serializable;
import java.util.Map;

public class FacewebComponentsStore$FacewebSkeletonPalCall
  implements JMStaticKeysDictDestination, FacewebPalCall, Serializable
{
  private static final long serialVersionUID = 9191065373181002164L;

  @JMAutogen.InferredType(jsonFieldName="method")
  public String mMethod;

  @JMAutogen.DynamicKeyDictType(jsonFieldName="params", valueElementType=JMForcedString.class)
  public Map<String, Object> mParams;

  public long a(String paramString1, String paramString2, long paramLong)
  {
    String str = a(paramString1, paramString2);
    if (TextUtils.isEmpty(str));
    do
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
        }
      }
    while (!BuildConstants.a());
    throw new NumberFormatException("Failed to parse long from " + str);
  }

  public String a()
  {
    return this.mMethod;
  }

  public String a(String paramString1, String paramString2)
  {
    String str1 = (String)this.mParams.get(paramString2);
    if ((str1 != null) && (paramString1 != null) && (str1.length() > 1) && (str1.charAt(0) == '@'))
    {
      String str2 = str1.substring(1);
      str1 = Uri.parse(paramString1).getQueryParameter(str2);
      if (str1 == null)
        break label63;
    }
    while (true)
    {
      return str1;
      label63: str1 = "";
    }
  }

  public String a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = b(paramString1, paramString2);
    String str = null;
    if (bool)
      str = a(paramString1, paramString2);
    if (str != null)
      paramString3 = str;
    return paramString3;
  }

  public boolean b(String paramString1, String paramString2)
  {
    return this.mParams.containsKey(paramString2);
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.mMethod;
    arrayOfObject[1] = this.mParams;
    return StringLocaleUtil.a("PalCall<method=%s, params=%s>", arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.faceweb.FacewebComponentsStore.FacewebSkeletonPalCall
 * JD-Core Version:    0.6.0
 */