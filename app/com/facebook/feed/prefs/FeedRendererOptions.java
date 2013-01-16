package com.facebook.feed.prefs;

import com.facebook.base.BuildConstants;
import com.facebook.feed.common.FeedConstants;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.widget.UrlImage.LoadResolutionDuringScrollMode;

public class FeedRendererOptions
{
  public final boolean a;
  public final boolean b;
  public final boolean c;
  public final UrlImage.LoadResolutionDuringScrollMode d;
  public final boolean e;
  public final boolean f;
  public final boolean g;
  public final boolean h;
  public final boolean i;
  public final boolean j;
  public final boolean k;
  private final boolean l = true;
  private final boolean m = false;

  public FeedRendererOptions(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    if (BuildConstants.a())
    {
      this.a = paramOrcaSharedPreferences.a(FeedPrefKeys.i, true);
      this.b = paramOrcaSharedPreferences.a(FeedPrefKeys.j, true);
      this.c = paramOrcaSharedPreferences.a(FeedPrefKeys.k, true);
      this.d = UrlImage.LoadResolutionDuringScrollMode.valueOf(paramOrcaSharedPreferences.a(FeedPrefKeys.l, FeedConstants.a));
      this.e = paramOrcaSharedPreferences.a(FeedPrefKeys.v, true);
      this.f = paramOrcaSharedPreferences.a(FeedPrefKeys.w, true);
      this.g = paramOrcaSharedPreferences.a(FeedPrefKeys.x, true);
      this.h = paramOrcaSharedPreferences.a(FeedPrefKeys.y, true);
      this.i = paramOrcaSharedPreferences.a(FeedPrefKeys.z, true);
      this.j = paramOrcaSharedPreferences.a(FeedPrefKeys.A, true);
    }
    for (this.k = paramOrcaSharedPreferences.a(FeedPrefKeys.B, false); ; this.k = false)
    {
      return;
      this.a = true;
      this.b = true;
      this.c = true;
      this.d = UrlImage.LoadResolutionDuringScrollMode.valueOf(FeedConstants.a);
      this.e = true;
      this.f = true;
      this.g = true;
      this.h = true;
      this.i = true;
      this.j = true;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.prefs.FeedRendererOptions
 * JD-Core Version:    0.6.0
 */