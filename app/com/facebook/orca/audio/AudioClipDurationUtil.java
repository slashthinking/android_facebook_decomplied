package com.facebook.orca.audio;

import com.facebook.orca.debug.BLog;

public class AudioClipDurationUtil
{
  private static final Class<?> a = AudioClipDurationUtil.class;

  public static long a(String paramString)
  {
    long l = -1L;
    String[] arrayOfString = paramString.split("-");
    if (arrayOfString.length != 3)
      BLog.e(a, "Invalid fileName does not contain duration.");
    while (true)
    {
      return l;
      String str1 = arrayOfString[2];
      int i = str1.lastIndexOf('.');
      if (i < 0)
      {
        BLog.e(a, "Invalid fileName does not contain duration.");
        continue;
      }
      String str2 = str1.substring(0, i);
      try
      {
        int j = Integer.parseInt(str2);
        l = j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        BLog.e(a, "Invalid fileName does not contain duration.");
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioClipDurationUtil
 * JD-Core Version:    0.6.0
 */