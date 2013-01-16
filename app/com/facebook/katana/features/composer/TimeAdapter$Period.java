package com.facebook.katana.features.composer;

import android.content.Context;
import java.util.Calendar;

public enum TimeAdapter$Period
{
  private final long SECONDS_IN_DAY = 86400L;
  private final int mGranularity;
  private final int mPeriodNameRes;

  static
  {
    TOMORROW = new Period("TOMORROW", 2, 2131362183, 2);
    SATURDAY = new Period("SATURDAY", 3, 2131362188, 2);
    SUNDAY = new Period("SUNDAY", 4, 2131362189, 2);
    Period[] arrayOfPeriod = new Period[5];
    arrayOfPeriod[0] = NOW;
    arrayOfPeriod[1] = TONIGHT;
    arrayOfPeriod[2] = TOMORROW;
    arrayOfPeriod[3] = SATURDAY;
    arrayOfPeriod[4] = SUNDAY;
    $VALUES = arrayOfPeriod;
  }

  private TimeAdapter$Period(int paramInt1, int paramInt2)
  {
    this.mPeriodNameRes = paramInt1;
    this.mGranularity = paramInt2;
  }

  public static TimeAdapter createPeriodsTimeAdapter(Context paramContext)
  {
    return new TimeAdapter(paramContext, values());
  }

  public int getGranularity()
  {
    return this.mGranularity;
  }

  public long getTimestamp()
  {
    int i = 7;
    Calendar localCalendar = Calendar.getInstance();
    long l1 = localCalendar.getTimeInMillis() / 1000L;
    long l2;
    switch (TimeAdapter.1.a[ordinal()])
    {
    default:
      l2 = l1;
    case 1:
      while (true)
      {
        return l2;
        l2 = l1 + 86400L;
      }
    case 2:
    case 3:
    }
    int j = localCalendar.get(i);
    if (this == SATURDAY);
    while (true)
    {
      l2 = l1 + 86400L * ((7 + (i - j)) % 7);
      break;
      i = 1;
    }
  }

  public String localizedString(Context paramContext)
  {
    return paramContext.getString(this.mPeriodNameRes);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.composer.TimeAdapter.Period
 * JD-Core Version:    0.6.0
 */