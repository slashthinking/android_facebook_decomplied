package com.facebook.pages.data.model;

import com.facebook.orca.common.util.StringUtil;

public class StoryInsightsDetailItem
{
  private final long a;
  private final long b;
  private final int c;
  private final String d;
  private final StoryInsightsDetailItem.StoryInsightsDetailItemType e;

  public StoryInsightsDetailItem(long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramInt;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(paramLong2);
    arrayOfObject[1] = paramString;
    this.d = StringUtil.a("%d %s", arrayOfObject);
    this.e = StoryInsightsDetailItem.StoryInsightsDetailItemType.BAR_CHART;
  }

  public StoryInsightsDetailItem(String paramString)
  {
    this.d = paramString;
    this.a = 0L;
    this.b = 0L;
    this.c = 0;
    this.e = StoryInsightsDetailItem.StoryInsightsDetailItemType.HEADER;
  }

  public long a()
  {
    return this.a;
  }

  public long b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public StoryInsightsDetailItem.StoryInsightsDetailItemType e()
  {
    return this.e;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.d;
    arrayOfObject[1] = Long.valueOf(this.b);
    return StringUtil.a("%s : %d", arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.model.StoryInsightsDetailItem
 * JD-Core Version:    0.6.0
 */