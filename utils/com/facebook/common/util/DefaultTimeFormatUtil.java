package com.facebook.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateUtils;
import com.facebook.debug.Assert;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.FbInjector;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DefaultTimeFormatUtil
  implements TimeFormatUtil
{
  private static TimeFormatUtil a;
  private final Context b;
  private final Clock c;

  public DefaultTimeFormatUtil(Context paramContext, Clock paramClock)
  {
    this.b = paramContext.getApplicationContext();
    this.c = paramClock;
  }

  public static String a(Context paramContext, TimeFormatUtil.TimeFormatStyle paramTimeFormatStyle, long paramLong)
  {
    if (a == null)
      a = (TimeFormatUtil)FbInjector.a(paramContext).a(TimeFormatUtil.class);
    return a.a(paramTimeFormatStyle, paramLong);
  }

  public String a(TimeFormatUtil.TimeFormatStyle paramTimeFormatStyle, long paramLong)
  {
    Date localDate1 = new Date(paramLong);
    long l5;
    String str;
    if (paramTimeFormatStyle == TimeFormatUtil.TimeFormatStyle.EVENTS_RELATIVE_STYLE)
    {
      l5 = paramLong - this.c.a();
      if (l5 <= 0L)
        str = a(TimeFormatUtil.TimeFormatStyle.STREAM_RELATIVE_STYLE, paramLong);
    }
    while (true)
    {
      return str;
      if (l5 < 60000L)
      {
        str = this.b.getString(2131362178);
      }
      else if (l5 < 3600000L)
      {
        int m = (int)(l5 / 60000L);
        Resources localResources4 = this.b.getResources();
        Object[] arrayOfObject9 = new Object[1];
        arrayOfObject9[0] = Integer.valueOf(m);
        str = localResources4.getQuantityString(2131427350, m, arrayOfObject9);
      }
      else if (l5 < 86400000L)
      {
        Date localDate3 = new Date();
        if (localDate1.getDate() == localDate3.getDate())
        {
          int k = (int)(l5 / 3600000L);
          Resources localResources3 = this.b.getResources();
          Object[] arrayOfObject7 = new Object[1];
          arrayOfObject7[0] = Integer.valueOf(k);
          str = localResources3.getQuantityString(2131427349, k, arrayOfObject7);
        }
        else
        {
          Context localContext4 = this.b;
          Object[] arrayOfObject6 = new Object[1];
          arrayOfObject6[0] = DateUtils.formatDateTime(this.b, paramLong, 2561);
          str = localContext4.getString(2131362184, arrayOfObject6);
        }
      }
      else
      {
        Context localContext5 = this.b;
        Object[] arrayOfObject8 = new Object[2];
        arrayOfObject8[0] = DateUtils.formatDateTime(this.b, paramLong, 65560);
        arrayOfObject8[1] = DateUtils.formatDateTime(this.b, paramLong, 2561);
        str = localContext5.getString(2131362176, arrayOfObject8);
        continue;
        if (paramTimeFormatStyle == TimeFormatUtil.TimeFormatStyle.STREAM_RELATIVE_STYLE)
        {
          long l3 = this.c.a();
          long l4 = l3 - paramLong;
          Calendar localCalendar3 = Calendar.getInstance();
          localCalendar3.setTimeInMillis(paramLong);
          Calendar localCalendar4 = Calendar.getInstance();
          localCalendar4.setTimeInMillis(l3);
          if (l4 < 60000L)
          {
            str = this.b.getString(2131362178);
          }
          else if (l4 < 3600000L)
          {
            int j = (int)(l4 / 60000L);
            Resources localResources2 = this.b.getResources();
            Object[] arrayOfObject5 = new Object[1];
            arrayOfObject5[0] = Integer.valueOf(j);
            str = localResources2.getQuantityString(2131427348, j, arrayOfObject5);
          }
          else if (l4 < 86400000L)
          {
            Date localDate2 = new Date(l3);
            if (localDate1.getDate() == localDate2.getDate())
            {
              int i = (int)(l4 / 3600000L);
              Resources localResources1 = this.b.getResources();
              Object[] arrayOfObject2 = new Object[1];
              arrayOfObject2[0] = Integer.valueOf(i);
              str = localResources1.getQuantityString(2131427347, i, arrayOfObject2);
            }
            else
            {
              Context localContext1 = this.b;
              Object[] arrayOfObject1 = new Object[1];
              arrayOfObject1[0] = DateUtils.formatDateTime(this.b, paramLong, 2561);
              str = localContext1.getString(2131362186, arrayOfObject1);
            }
          }
          else if (l4 < 345600000L)
          {
            Context localContext3 = this.b;
            Object[] arrayOfObject4 = new Object[2];
            arrayOfObject4[0] = DateUtils.formatDateTime(this.b, paramLong, 32770);
            arrayOfObject4[1] = DateUtils.formatDateTime(this.b, paramLong, 2561);
            str = localContext3.getString(2131362185, arrayOfObject4);
          }
          else if (localCalendar3.get(1) == localCalendar4.get(1))
          {
            Context localContext2 = this.b;
            Object[] arrayOfObject3 = new Object[2];
            arrayOfObject3[0] = DateUtils.formatDateTime(this.b, paramLong, 65560);
            arrayOfObject3[1] = DateUtils.formatDateTime(this.b, paramLong, 2561);
            str = localContext2.getString(2131362176, arrayOfObject3);
          }
          else
          {
            str = DateUtils.formatDateTime(this.b, paramLong, 65556);
          }
        }
        else if (paramTimeFormatStyle == TimeFormatUtil.TimeFormatStyle.EVENTS_RELATIVE_DATE_STYLE)
        {
          Calendar localCalendar1 = Calendar.getInstance();
          localCalendar1.set(11, 0);
          localCalendar1.set(12, 0);
          localCalendar1.set(13, 0);
          localCalendar1.set(14, 0);
          Calendar localCalendar2 = Calendar.getInstance();
          localCalendar2.setTimeInMillis(paramLong);
          localCalendar2.set(11, 0);
          localCalendar2.set(12, 0);
          localCalendar2.set(13, 0);
          localCalendar2.set(14, 0);
          long l1 = localCalendar2.getTimeInMillis() - localCalendar1.getTimeInMillis();
          boolean bool1 = TimeZone.getDefault().inDaylightTime(localCalendar1.getTime());
          boolean bool2 = TimeZone.getDefault().inDaylightTime(localCalendar2.getTime());
          if ((bool1) && (!bool2));
          long l2;
          for (l1 -= 3600000L; ; l1 += 3600000L)
            do
            {
              l2 = l1 / 86400000L;
              Assert.a(0L, l1 % 86400000L);
              if (l2 >= 0L)
                break label912;
              str = DateUtils.formatDateTime(this.b, paramLong, 65556);
              break;
            }
            while ((bool1) || (!bool2));
          label912: if (l2 == 0L)
            str = this.b.getString(2131362182);
          else if (l2 == 1L)
            str = this.b.getString(2131362183);
          else if (l2 < 7L)
            str = DateUtils.formatDateTime(this.b, paramLong, 2);
          else
            str = DateUtils.formatDateTime(this.b, paramLong, 65556);
        }
        else if (paramTimeFormatStyle == TimeFormatUtil.TimeFormatStyle.HOUR_MINUTE_STYLE)
        {
          str = DateUtils.formatDateTime(this.b, paramLong, 2561);
        }
        else if (paramTimeFormatStyle == TimeFormatUtil.TimeFormatStyle.WEEK_DAY_STYLE)
        {
          str = DateUtils.formatDateTime(this.b, paramLong, 32770);
        }
        else if (paramTimeFormatStyle == TimeFormatUtil.TimeFormatStyle.MONTH_DAY_YEAR_STYLE)
        {
          str = DateUtils.formatDateTime(this.b, paramLong, 65556);
        }
        else
        {
          if (paramTimeFormatStyle != TimeFormatUtil.TimeFormatStyle.DATE_PICKER_STYLE)
            break;
          str = DateUtils.formatDateTime(this.b, paramLong, 98326);
        }
      }
    }
    throw new IllegalArgumentException("Unknown style");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.DefaultTimeFormatUtil
 * JD-Core Version:    0.6.2
 */