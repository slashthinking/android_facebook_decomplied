package android_src.mms.ui;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android_src.mms.MmsConfig;
import android_src.provider.Telephony.Mms;
import java.util.HashMap;

public class MessageUtils
{
  private static final char[] a = { 45, 46, 44, 40, 41, 32, 47, 92, 42, 35, 43 };
  private static HashMap b = new HashMap(a.length);

  static
  {
    for (int i = 0; i < a.length; i++)
      b.put(Character.valueOf(a[i]), Character.valueOf(a[i]));
  }

  public static String a(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getLine1Number();
  }

  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (paramString == null);
    while (true)
    {
      return bool;
      int i = paramString.indexOf('@');
      bool = false;
      if (i >= 0)
        continue;
      bool = PhoneNumberUtils.compare(paramString, a(paramContext));
    }
  }

  public static boolean a(String paramString)
  {
    boolean bool1 = MmsConfig.l();
    int i = 0;
    if (!bool1);
    while (true)
    {
      return i;
      if (paramString == null);
      for (int j = 0; ; j = paramString.length())
      {
        int k = MmsConfig.m();
        i = 0;
        if (j < k)
          break;
        int m = MmsConfig.n();
        i = 0;
        if (j > m)
          break;
        boolean bool2 = Character.isLetter(paramString.charAt(0));
        i = 0;
        if (!bool2)
          break;
        for (int n = 1; ; n++)
        {
          if (n >= j)
            break label109;
          char c = paramString.charAt(n);
          if (Character.isLetterOrDigit(c))
            continue;
          i = 0;
          if (c != '.')
            break;
        }
      }
      label109: i = 1;
    }
  }

  public static String b(String paramString)
  {
    if (Telephony.Mms.b(paramString));
    while (true)
    {
      return paramString;
      String str = c(paramString);
      if (str != null)
      {
        paramString = str;
        continue;
      }
      if (a(paramString))
        continue;
      paramString = null;
    }
  }

  private static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramString.length();
    int j = 0;
    if (j < i)
    {
      char c = paramString.charAt(j);
      if ((c == '+') && (localStringBuilder.length() == 0))
        localStringBuilder.append(c);
      label72: 
      do
        while (true)
        {
          j++;
          break;
          if (!Character.isDigit(c))
            break label72;
          localStringBuilder.append(c);
        }
      while (b.get(Character.valueOf(c)) != null);
    }
    for (String str = null; ; str = localStringBuilder.toString())
      return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.ui.MessageUtils
 * JD-Core Version:    0.6.0
 */