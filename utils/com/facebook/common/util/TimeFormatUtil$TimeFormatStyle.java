package com.facebook.common.util;

public enum TimeFormatUtil$TimeFormatStyle
{
  static
  {
    STREAM_RELATIVE_STYLE = new TimeFormatStyle("STREAM_RELATIVE_STYLE", 2);
    MONTH_DAY_YEAR_STYLE = new TimeFormatStyle("MONTH_DAY_YEAR_STYLE", 3);
    EVENTS_RELATIVE_STYLE = new TimeFormatStyle("EVENTS_RELATIVE_STYLE", 4);
    EVENTS_RELATIVE_DATE_STYLE = new TimeFormatStyle("EVENTS_RELATIVE_DATE_STYLE", 5);
    DATE_PICKER_STYLE = new TimeFormatStyle("DATE_PICKER_STYLE", 6);
    TimeFormatStyle[] arrayOfTimeFormatStyle = new TimeFormatStyle[7];
    arrayOfTimeFormatStyle[0] = HOUR_MINUTE_STYLE;
    arrayOfTimeFormatStyle[1] = WEEK_DAY_STYLE;
    arrayOfTimeFormatStyle[2] = STREAM_RELATIVE_STYLE;
    arrayOfTimeFormatStyle[3] = MONTH_DAY_YEAR_STYLE;
    arrayOfTimeFormatStyle[4] = EVENTS_RELATIVE_STYLE;
    arrayOfTimeFormatStyle[5] = EVENTS_RELATIVE_DATE_STYLE;
    arrayOfTimeFormatStyle[6] = DATE_PICKER_STYLE;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.TimeFormatUtil.TimeFormatStyle
 * JD-Core Version:    0.6.2
 */