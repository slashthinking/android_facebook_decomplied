package com.facebook.diagnostics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.annotations.GitHash;
import com.facebook.debug.LogPrefixer;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FPSView extends View
{
  private static final Class<?> a = FPSView.class;
  private static final String[] b = { "mpf_8_or_less", "mpf_between_8_and_16", "mpf_between_16_and_24", "mpf_between_24_and_32", "mpf_between_32_and_64", "mpf_more_than_64" };
  private static final String[] c = { "fps_55_or_more", "fps_between_55_and_50", "fps_between_50_and_45", "fps_between_45_and_40", "fps_between_40_and_35", "fps_between_35_and_30", "fps_between_30_and_20", "fps_between_20_and_10", "fps_10_or_less" };
  private static final int[] d = { 8, 16, 24, 32, 64 };
  private static final int[] e = { 55, 45, 40, 35, 30, 20, 10 };
  private long f = -1L;
  private long g = -1L;
  private long h = -1L;
  private long i = -1L;
  private int j;
  private int k = -1;
  private boolean l = false;
  private final String m;
  private int[] n;
  private int[] o;
  private boolean p = false;
  private boolean q = true;
  private List<Long> r;
  private final Paint s;
  private final AnalyticsLogger t;
  private final PerformanceLogger u;
  private String v;

  public FPSView(Context paramContext)
  {
    super(paramContext);
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.t = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.u = ((PerformanceLogger)localFbInjector.a(PerformanceLogger.class));
    this.m = ((String)localFbInjector.a(String.class, GitHash.class));
    this.s = new Paint();
    this.s.setColor(-65536);
    this.s.setAntiAlias(true);
    this.s.setTextSize(22.0F);
    this.r = Lists.a();
    this.n = new int[b.length];
    this.o = new int[c.length];
    Arrays.fill(this.n, 0);
    Arrays.fill(this.o, 0);
  }

  private void a(int paramInt)
  {
    if (!this.l);
    while (true)
    {
      return;
      for (int i1 = 0; ; i1++)
      {
        if (i1 >= e.length)
          break label52;
        if (paramInt >= e[i1])
        {
          int[] arrayOfInt2 = this.o;
          arrayOfInt2[i1] = (1 + arrayOfInt2[i1]);
          break;
        }
      }
      label52: int[] arrayOfInt1 = this.o;
      int i2 = -1 + this.o.length;
      arrayOfInt1[i2] = (1 + arrayOfInt1[i2]);
    }
  }

  private void a(long paramLong)
  {
    if (!this.l);
    while (true)
    {
      return;
      for (int i1 = 0; ; i1++)
      {
        if (i1 >= d.length)
          break label54;
        if (paramLong <= d[i1])
        {
          int[] arrayOfInt2 = this.n;
          arrayOfInt2[i1] = (1 + arrayOfInt2[i1]);
          break;
        }
      }
      label54: int[] arrayOfInt1 = this.n;
      int i2 = -1 + this.n.length;
      arrayOfInt1[i2] = (1 + arrayOfInt1[i2]);
    }
  }

  private static int b(int paramInt)
  {
    int i1;
    if (paramInt >= 45)
      i1 = -16711936;
    while (true)
    {
      return i1;
      if (paramInt >= 30)
        i1 = -256;
      else
        i1 = -65536;
    }
  }

  public void a()
  {
    this.r.clear();
    this.f = -1L;
    Arrays.fill(this.n, 0);
    Arrays.fill(this.o, 0);
  }

  public void b()
  {
    Activity localActivity = (Activity)getContext();
    if (localActivity == null);
    while (true)
    {
      return;
      this.l = false;
      int[] arrayOfInt1 = this.n;
      int i1 = arrayOfInt1.length;
      int i2 = 0;
      int i9;
      for (int i3 = 0; i2 < i1; i3 = i9)
      {
        i9 = i3 + arrayOfInt1[i2];
        i2++;
      }
      int[] arrayOfInt2 = this.o;
      int i4 = arrayOfInt2.length;
      int i5 = 0;
      int i6 = 0;
      while (i5 < i4)
      {
        i6 += arrayOfInt2[i5];
        i5++;
      }
      if ((i3 != 0) && (i6 != 0))
      {
        String str1 = localActivity.getClass().getSimpleName();
        HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("frames_per_second");
        localHoneyClientEvent.b("current_activity", str1);
        for (int i7 = 0; i7 < b.length; i7++)
        {
          localHoneyClientEvent.a(b[i7], this.n[i7]);
          localHoneyClientEvent.a(b[i7] + "_pct", 100.0D * (this.n[i7] / i3));
        }
        for (int i8 = 0; i8 < c.length; i8++)
        {
          localHoneyClientEvent.a(c[i8], this.o[i8]);
          localHoneyClientEvent.a(c[i8] + "_pct", 100.0D * (this.o[i8] / i6));
        }
        if ((this.m != null) && (this.m.length() > 0))
          localHoneyClientEvent.b("githash", this.m);
        this.t.a(localHoneyClientEvent);
        String str2 = StringUtil.a("%s:%s", new Object[] { "FPS", str1 });
        String str3 = StringUtil.a("%s:%s", new Object[] { "MPF", str1 });
        this.u.a(str2);
        this.u.a(str2, 100.0D * (this.o[0] / i6));
        this.u.b(str2);
        this.u.a(str3);
        this.u.a(str3, 100.0D * (this.n[0] / i3));
        this.u.b(str3);
        a();
      }
    }
  }

  public boolean getEnableFrameCounter()
  {
    return this.q;
  }

  public boolean getEnableOutputToLogcat()
  {
    return this.p;
  }

  public boolean getEnableRecordingData()
  {
    return this.l;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    long l1 = SystemClock.elapsedRealtime();
    if (this.g == -1L)
    {
      this.g = l1;
      this.h = l1;
      this.j = 0;
    }
    if (this.f == -1L)
      this.f = SystemClock.elapsedRealtime();
    setBackgroundColor(17170445);
    long l2 = l1 - this.g;
    long l3 = l1 - this.h;
    if (l2 > 1000L)
    {
      this.g = l1;
      this.k = this.j;
      this.j = 0;
      a(this.k);
    }
    a(l3);
    this.r.add(Long.valueOf(l3));
    if ((this.f > 5000L) && (l2 > 1000L))
    {
      int i1 = this.r.size();
      if (i1 > 2)
      {
        this.r = Lists.a(this.r.subList(i1 / 2, i1 - 1));
        this.i = ((Long)Collections.max(this.r)).longValue();
      }
    }
    this.s.setColor(b(this.k));
    if (this.q)
    {
      this.v = (String.valueOf(this.k) + " fps " + String.valueOf(l3) + " ms/f " + String.valueOf(this.i) + " max");
      paramCanvas.drawText(this.v, 20.0F, 93.0F, this.s);
    }
    if (this.p)
      Log.v(LogPrefixer.a(a), this.v);
    this.h = l1;
    this.j = (1 + this.j);
  }

  public void setEnableFrameCounter(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }

  public void setEnableOutputToLogcat(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public void setEnableRecordingData(boolean paramBoolean)
  {
    if (this.l == paramBoolean);
    while (true)
    {
      return;
      this.l = paramBoolean;
      if (this.l)
        a();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.diagnostics.FPSView
 * JD-Core Version:    0.6.2
 */