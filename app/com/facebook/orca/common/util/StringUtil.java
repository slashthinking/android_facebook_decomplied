package com.facebook.orca.common.util;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class StringUtil
{
  public static String a(String paramString, int paramInt)
  {
    if ((Strings.isNullOrEmpty(paramString)) || (paramInt == 0) || (paramString.length() < paramInt));
    while (true)
    {
      return paramString;
      paramString = paramString.substring(0, paramInt - (-1 + Character.charCount(Character.codePointAt(paramString, paramInt - 1))));
    }
  }

  public static String a(String paramString, Object[] paramArrayOfObject)
  {
    return StringLocaleUtil.a(paramString, paramArrayOfObject);
  }

  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      String str = new String(paramArrayOfByte, Charsets.UTF_8.name());
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new RuntimeException("UTF-8 not supported");
  }

  public static boolean a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean a(String paramString1, String paramString2)
  {
    return Objects.equal(c(paramString1), c(paramString2));
  }

  public static CharSequence b(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    if ((i <= 0) || (!Character.isWhitespace(paramCharSequence.charAt(i - 1))))
      if (i != paramCharSequence.length())
        break label44;
    while (true)
    {
      return paramCharSequence;
      i--;
      break;
      label44: paramCharSequence = paramCharSequence.subSequence(0, i);
    }
  }

  public static String b(String paramString)
  {
    if (paramString != null);
    while (true)
    {
      return paramString;
      paramString = "";
    }
  }

  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool1;
    if (paramString1 == null)
      if (paramString2 != null)
      {
        boolean bool3 = "".equals(paramString2);
        bool1 = false;
        if (!bool3);
      }
      else
      {
        bool1 = true;
      }
    while (true)
    {
      return bool1;
      if (paramString2 == null)
      {
        if (paramString1 != null)
        {
          boolean bool2 = "".equals(paramString1);
          bool1 = false;
          if (!bool2)
            continue;
        }
        bool1 = true;
        continue;
      }
      bool1 = paramString1.equals(paramString2);
    }
  }

  public static String c(String paramString)
  {
    if (a(paramString))
      paramString = null;
    return paramString;
  }

  public static byte[] d(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes(Charsets.UTF_8.name());
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new RuntimeException("UTF-8 not supported");
  }

  public static long e(String paramString)
  {
    long l = 1125899906842597L;
    int i = paramString.length();
    for (int j = 0; j < i; j++)
      l = l * 31L + paramString.charAt(j);
    return l;
  }

  public static boolean f(String paramString)
  {
    int j;
    if (a(paramString))
      j = 1;
    while (true)
    {
      return j;
      for (int i = 0; ; i++)
      {
        if (i >= paramString.length())
          break label42;
        boolean bool = Character.isWhitespace(paramString.charAt(i));
        j = 0;
        if (!bool)
          break;
      }
      label42: j = 1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.StringUtil
 * JD-Core Version:    0.6.0
 */