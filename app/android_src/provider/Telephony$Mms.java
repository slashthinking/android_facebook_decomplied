package android_src.provider;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Telephony$Mms
  implements Telephony.BaseMmsColumns
{
  public static final Uri a = Uri.parse("content://mms");
  public static final Uri b = Uri.withAppendedPath(a, "report-request");
  public static final Uri c = Uri.withAppendedPath(a, "report-status");
  public static final Pattern d = Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");
  public static final Pattern e = Pattern.compile("\\s*\"([^\"]*)\"\\s*");

  public static String a(String paramString)
  {
    Matcher localMatcher = d.matcher(paramString);
    if (localMatcher.matches())
      paramString = localMatcher.group(2);
    return paramString;
  }

  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    String str;
    for (boolean bool = false; ; bool = Patterns.EMAIL_ADDRESS.matcher(str).matches())
    {
      return bool;
      str = a(paramString);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.provider.Telephony.Mms
 * JD-Core Version:    0.6.0
 */