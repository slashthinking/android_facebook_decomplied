package com.facebook.katana.util;

import android.content.Context;
import com.facebook.ipc.util.Entities;
import com.facebook.katana.model.FacebookApiException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public class StringUtils
{
  public static StringUtils.StringProcessor a;
  public static StringUtils.StringProcessor b;
  private static final char[] c = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private static final Pattern d = Pattern.compile(" +");

  static
  {
    a = new StringUtils.1();
    b = new StringUtils.2();
  }

  public static String a(int paramInt)
  {
    if (paramInt < 1);
    char[] arrayOfChar;
    for (String str = null; ; str = new String(arrayOfChar))
    {
      return str;
      arrayOfChar = new char[paramInt];
      for (int i = 0; i < arrayOfChar.length; i++)
        arrayOfChar[i] = c[Utils.a.nextInt(c.length)];
    }
  }

  public static String a(Context paramContext, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if (paramInt == 0)
      if (paramException != null)
      {
        if (!(paramException instanceof FacebookApiException))
          break label67;
        FacebookApiException localFacebookApiException = (FacebookApiException)paramException;
        Object[] arrayOfObject3 = new Object[3];
        arrayOfObject3[0] = paramString1;
        arrayOfObject3[1] = Integer.valueOf(localFacebookApiException.a());
        arrayOfObject3[2] = localFacebookApiException.b();
        paramString1 = paramContext.getString(2131362913, arrayOfObject3);
      }
    while (true)
    {
      return paramString1;
      label67: Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramString1;
      arrayOfObject2[1] = paramException.getMessage();
      paramString1 = paramContext.getString(2131362914, arrayOfObject2);
      continue;
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = paramString1;
      arrayOfObject1[1] = Integer.valueOf(paramInt);
      arrayOfObject1[2] = paramString2;
      paramString1 = paramContext.getString(2131362913, arrayOfObject1);
    }
  }

  public static String a(String paramString)
  {
    Object localObject = null;
    if (paramString != null);
    try
    {
      String str = new URI(paramString).getPath();
      localObject = str;
      return localObject;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      while (true)
        localObject = null;
    }
  }

  public static String a(String paramString, Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, paramString, null, paramArrayOfObject);
    return localStringBuilder.toString();
  }

  public static String a(Map<String, Serializable> paramMap)
  {
    Object localObject;
    String str1;
    label52: String str2;
    label78: String str3;
    if (paramMap.containsKey("street"))
    {
      localObject = ((Serializable)paramMap.get("street")).toString();
      if (!paramMap.containsKey("city"))
        break label175;
      str1 = ((Serializable)paramMap.get("city")).toString();
      if (!paramMap.containsKey("state"))
        break label180;
      str2 = ((Serializable)paramMap.get("state")).toString();
      boolean bool = paramMap.containsKey("zip");
      str3 = null;
      if (bool)
        str3 = ((Serializable)paramMap.get("zip")).toString();
      if ((c((String)localObject)) || (c(str1)) || (c(str2)) || (c(str3)))
        break label185;
      localObject = String.format("%s\n%s %s %s", new Object[] { localObject, str1, str2, str3 });
    }
    while (true)
    {
      return localObject;
      localObject = null;
      break;
      label175: str1 = null;
      break label52;
      label180: str2 = null;
      break label78;
      label185: if ((!c((String)localObject)) && (!c(str1)) && (!c(str2)))
      {
        localObject = String.format("%s\n%s %s", new Object[] { localObject, str1, str2 });
        continue;
      }
      if ((!c((String)localObject)) && (!c(str1)) && (!c(str3)))
      {
        localObject = String.format("%s\n%s %s", new Object[] { localObject, str1, str3 });
        continue;
      }
      if ((!c((String)localObject)) && (!c(str1)))
      {
        localObject = String.format("%s\n%s", new Object[] { localObject, str1 });
        continue;
      }
      if ((!c((String)localObject)) && (!c(str3)))
      {
        localObject = String.format("%s\n%s", new Object[] { localObject, str3 });
        continue;
      }
      if ((!c(str1)) && (!c(str2)))
      {
        localObject = String.format("%s, %s", new Object[] { str1, str2 });
        continue;
      }
      if ((!c(str1)) && (!c(str3)))
      {
        localObject = String.format("%s %s", new Object[] { str1, str3 });
        continue;
      }
      if (!c((String)localObject))
        continue;
      if (!c(str1))
      {
        localObject = str1;
        continue;
      }
      if (!c(str3))
      {
        localObject = str3;
        continue;
      }
      localObject = "";
    }
  }

  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('\'');
    int i = paramString.length();
    for (int j = 0; j < i; j++)
    {
      char c1 = paramString.charAt(j);
      if ((c1 == '\'') || (c1 == '\\'))
        paramStringBuilder.append('\\');
      paramStringBuilder.append(c1);
    }
    paramStringBuilder.append('\'');
    return paramStringBuilder;
  }

  public static void a(StringBuilder paramStringBuilder, String paramString, StringUtils.StringProcessor paramStringProcessor, Object[] paramArrayOfObject)
  {
    int i = 1;
    int j = paramArrayOfObject.length;
    int k = 0;
    if (k < j)
    {
      Object localObject = paramArrayOfObject[k];
      if (i != 0)
      {
        i = 0;
        label31: if (!(localObject instanceof Collection))
          break label70;
        a(paramStringBuilder, paramString, paramStringProcessor, ((Collection)localObject).toArray());
      }
      while (true)
      {
        k++;
        break;
        paramStringBuilder.append(paramString);
        break label31;
        label70: if ((localObject instanceof Object[]))
        {
          a(paramStringBuilder, paramString, paramStringProcessor, (Object[])(Object[])localObject);
          continue;
        }
        if (paramStringProcessor != null)
        {
          paramStringBuilder.append(paramStringProcessor.a(localObject));
          continue;
        }
        paramStringBuilder.append(localObject.toString());
      }
    }
  }

  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool;
    if (paramString1 == null)
      if (paramString2 == null)
        bool = true;
    while (true)
    {
      return bool;
      bool = false;
      continue;
      bool = paramString1.equals(paramString2);
    }
  }

  public static String b(String paramString)
  {
    if (paramString == null);
    String str1;
    for (String str2 = null; ; str2 = Entities.c.b(str1.replaceAll("<(.|\n)*?>", "")).trim())
    {
      return str2;
      str1 = paramString.replaceAll("<br", "\n<br").replaceAll("<div", "\n<div");
    }
  }

  public static boolean c(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int i = 0;
    if (i < paramString.length())
    {
      char c1 = paramString.charAt(i);
      if (c1 == '&')
        localStringBuilder.append("&amp;");
      while (true)
      {
        i++;
        break;
        if ((c1 >= ' ') && (c1 <= '~'))
        {
          localStringBuilder.append(c1);
          continue;
        }
        localStringBuilder.append("&#");
        localStringBuilder.append(Integer.toString(c1));
        localStringBuilder.append(";");
      }
    }
    return localStringBuilder.toString();
  }

  public static String e(String paramString)
  {
    if (paramString == null);
    StringBuilder localStringBuilder;
    for (String str = null; ; str = localStringBuilder.toString())
    {
      return str;
      localStringBuilder = new StringBuilder(paramString.length());
      String[] arrayOfString = paramString.split("\\s");
      int i = arrayOfString.length;
      int j = 0;
      if (j >= i)
        continue;
      if (arrayOfString[j].length() == 0);
      while (true)
      {
        j++;
        break;
        if (j > 0)
          localStringBuilder.append(" ");
        localStringBuilder.append(Character.toUpperCase(arrayOfString[j].charAt(0))).append(arrayOfString[j].substring(1));
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.StringUtils
 * JD-Core Version:    0.6.0
 */