package com.facebook.orca.threads;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ThreadDateUtil
{
  private final SimpleDateFormat a;
  private final SimpleDateFormat b;
  private final SimpleDateFormat c;
  private final SimpleDateFormat d;
  private final SimpleDateFormat e;
  private final Context f;

  public ThreadDateUtil(Context paramContext)
  {
    this.f = paramContext;
    this.a = new SimpleDateFormat(paramContext.getString(2131362704));
    this.b = new SimpleDateFormat(paramContext.getString(2131362705));
    this.c = new SimpleDateFormat(paramContext.getString(2131362706));
    this.d = new SimpleDateFormat(paramContext.getString(2131362707));
    this.e = new SimpleDateFormat(paramContext.getString(2131362708));
  }

  private String[] e(long paramLong)
  {
    String[] arrayOfString = new String[2];
    long l = (System.currentTimeMillis() - paramLong) / 86400000L;
    Date localDate = new Date(paramLong);
    if (l < 180L)
      arrayOfString[0] = this.d.format(localDate);
    while (true)
    {
      arrayOfString[1] = android.text.format.DateFormat.getTimeFormat(this.f).format(localDate);
      return arrayOfString;
      arrayOfString[0] = this.e.format(localDate);
    }
  }

  public String a(long paramLong)
  {
    int i = (int)((System.currentTimeMillis() - paramLong) / 1000L / 60L / 60L);
    String str;
    if (i < 24)
      str = android.text.format.DateFormat.getTimeFormat(this.f).format(Long.valueOf(paramLong));
    while (true)
    {
      return str;
      Date localDate = new Date(paramLong);
      int j = i / 24;
      if (j < 4)
      {
        str = this.a.format(localDate);
        continue;
      }
      if (j < 180)
      {
        str = this.b.format(localDate);
        continue;
      }
      str = this.c.format(localDate);
    }
  }

  public boolean b(long paramLong)
  {
    int i = 1;
    Calendar localCalendar1 = GregorianCalendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong);
    Calendar localCalendar2 = GregorianCalendar.getInstance();
    if ((localCalendar1.get(i) == localCalendar2.get(i)) && (localCalendar1.get(2) == localCalendar2.get(2)) && (localCalendar1.get(5) == localCalendar2.get(5)));
    while (true)
    {
      return i;
      i = 0;
    }
  }

  public String c(long paramLong)
  {
    long l = System.currentTimeMillis();
    Date localDate = new Date(paramLong);
    String str;
    if (b(paramLong))
      str = android.text.format.DateFormat.getTimeFormat(this.f).format(localDate);
    while (true)
    {
      return str;
      int i = (int)((l - paramLong) / 1000L / 60L / 60L) / 24;
      if (i < 4)
      {
        Context localContext3 = this.f;
        Object[] arrayOfObject3 = new Object[2];
        arrayOfObject3[0] = this.a.format(localDate);
        arrayOfObject3[1] = android.text.format.DateFormat.getTimeFormat(this.f).format(localDate);
        str = localContext3.getString(2131362709, arrayOfObject3);
        continue;
      }
      if (i < 180)
      {
        Context localContext2 = this.f;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = this.b.format(localDate);
        arrayOfObject2[1] = android.text.format.DateFormat.getTimeFormat(this.f).format(localDate);
        str = localContext2.getString(2131362709, arrayOfObject2);
        continue;
      }
      Context localContext1 = this.f;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = this.c.format(localDate);
      arrayOfObject1[1] = android.text.format.DateFormat.getTimeFormat(this.f).format(localDate);
      str = localContext1.getString(2131362709, arrayOfObject1);
    }
  }

  public String d(long paramLong)
  {
    String[] arrayOfString = e(paramLong);
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(arrayOfString[0]);
    localStringBuilder.append(", ");
    localStringBuilder.append(arrayOfString[1]);
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ThreadDateUtil
 * JD-Core Version:    0.6.0
 */