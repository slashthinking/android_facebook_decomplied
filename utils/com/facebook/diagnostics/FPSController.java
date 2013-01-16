package com.facebook.diagnostics;

import android.app.Activity;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MapMaker;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import javax.inject.Provider;

public class FPSController
{
  private final Provider<Set<FpsEnableFlag>> a;
  private final AndroidThreadUtil b;
  private final FPSController.ActivityListener c;
  private final ConcurrentMap<Activity, FPSView> d;
  private ImmutableSet<FpsEnableFlag> e;
  private boolean f;
  private volatile Activity g;
  private Activity h;
  private FPSController.FPSThread i;

  public FPSController(Provider<Set<FpsEnableFlag>> paramProvider, AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.a = paramProvider;
    this.b = paramAndroidThreadUtil;
    this.c = new FPSController.ActivityListener(this);
    this.d = new MapMaker().f().h().n();
  }

  private void d()
  {
    this.b.a();
    ImmutableSet localImmutableSet = i();
    int j;
    if ((localImmutableSet.contains(FpsEnableFlag.ENABLE)) && (this.g != null))
    {
      j = 1;
      if (j == 0)
        break label93;
      e();
      g();
      FPSView localFPSView = c();
      if (localFPSView != null)
      {
        localFPSView.setEnableRecordingData(localImmutableSet.contains(FpsEnableFlag.ENABLE_RECORD_DATA));
        localFPSView.setEnableFrameCounter(localImmutableSet.contains(FpsEnableFlag.ENABLE_FRAME_COUNTER));
        localFPSView.setEnableOutputToLogcat(localImmutableSet.contains(FpsEnableFlag.ENABLE_OUTPUT_TO_LOGCAT));
      }
    }
    while (true)
    {
      return;
      j = 0;
      break;
      label93: h();
      f();
    }
  }

  private void e()
  {
    this.b.a();
    if (this.g == null);
    while (true)
    {
      return;
      FPSView localFPSView = c();
      if (localFPSView == null)
      {
        localFPSView = new FPSView(this.g);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(500, 100, 48);
        this.g.getWindow().addContentView(localFPSView, localLayoutParams);
        this.d.put(this.g, localFPSView);
      }
      localFPSView.setVisibility(0);
      localFPSView.bringToFront();
    }
  }

  private void f()
  {
    FPSView localFPSView = c();
    if (localFPSView != null)
      localFPSView.setVisibility(4);
  }

  private void g()
  {
    this.b.a();
    if (this.i == null)
    {
      this.i = new FPSController.FPSThread(this);
      this.i.start();
    }
  }

  private void h()
  {
    this.b.a();
    if (this.i != null)
    {
      this.i.a = true;
      this.i = null;
    }
  }

  private ImmutableSet<FpsEnableFlag> i()
  {
    if (this.f);
    for (ImmutableSet localImmutableSet = ImmutableSet.a(FpsEnableFlag.ENABLE, FpsEnableFlag.ENABLE_RECORD_DATA); ; localImmutableSet = this.e)
      return localImmutableSet;
  }

  public FPSController.ActivityListener a()
  {
    return this.c;
  }

  public void b()
  {
    FPSView localFPSView = c();
    if (localFPSView != null)
      localFPSView.b();
  }

  FPSView c()
  {
    if (this.h == null);
    for (FPSView localFPSView = null; ; localFPSView = (FPSView)this.d.get(this.h))
      return localFPSView;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.diagnostics.FPSController
 * JD-Core Version:    0.6.2
 */