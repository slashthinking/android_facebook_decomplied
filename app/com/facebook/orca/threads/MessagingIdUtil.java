package com.facebook.orca.threads;

public class MessagingIdUtil
{
  public static String a(long paramLong)
  {
    return "mms-sms." + paramLong;
  }

  public static String a(String paramString)
  {
    return "t_" + paramString;
  }

  public static String b(long paramLong)
  {
    return "smsid." + paramLong;
  }

  public static String b(String paramString)
  {
    return "m_" + paramString;
  }

  public static long c(String paramString)
  {
    if (paramString.startsWith("mms-sms."))
      return Long.parseLong(paramString.substring("mms-sms.".length()));
    throw new IllegalArgumentException("Not a valid MmsSms thread id: " + paramString);
  }

  public static String c(long paramLong)
  {
    return "mmsid." + paramLong;
  }

  public static long d(String paramString)
  {
    if (paramString.startsWith("smsid."))
      return Long.parseLong(paramString.substring("smsid.".length()));
    throw new IllegalArgumentException("Not a valid sms message id: " + paramString);
  }

  public static String d(long paramLong)
  {
    return "callid." + paramLong;
  }

  public static long e(String paramString)
  {
    if (paramString.startsWith("mmsid."))
      return Long.parseLong(paramString.substring("mmsid.".length()));
    throw new IllegalArgumentException("Not a valid mms message id: " + paramString);
  }

  public static boolean f(String paramString)
  {
    return paramString.startsWith("m_");
  }

  public static boolean g(String paramString)
  {
    return paramString.startsWith("mms-sms.");
  }

  public static boolean h(String paramString)
  {
    return paramString.startsWith("smsid.");
  }

  public static boolean i(String paramString)
  {
    return paramString.startsWith("mmsid.");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.MessagingIdUtil
 * JD-Core Version:    0.6.0
 */