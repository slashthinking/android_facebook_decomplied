package com.facebook.orca.compose;

import com.facebook.orca.prefs.UiCounters;
import com.facebook.orca.prefs.UiCounters.Listener;

public class LocationNuxController
{
  private final UiCounters a;
  private LocationNuxView b;
  private LocationDisabledNuxView c;
  private UiCounters.Listener d;
  private LocationNuxController.State e = LocationNuxController.State.OFF;
  private boolean f;
  private boolean g;
  private boolean h;
  private ComposeMode i = ComposeMode.SHRUNK;

  public LocationNuxController(UiCounters paramUiCounters)
  {
    this.a = paramUiCounters;
  }

  private void a(LocationNuxController.State paramState)
  {
    if (paramState == this.e);
    while (true)
    {
      return;
      if (this.e == LocationNuxController.State.LOCATION_NUX_SHOWING)
        this.b.a(false);
      while (true)
      {
        this.e = paramState;
        if (this.e != LocationNuxController.State.LOCATION_NUX_SHOWING)
          break label74;
        this.b.a(true);
        break;
        if (this.e != LocationNuxController.State.LOCATION_DISABLED_NUX_SHOWING)
          continue;
        this.c.a(false);
      }
      label74: if (this.e != LocationNuxController.State.LOCATION_DISABLED_NUX_SHOWING)
        continue;
      this.c.a(true);
    }
  }

  private LocationNuxController.State b()
  {
    LocationNuxController.State localState;
    if ((this.i == ComposeMode.SHRUNK) || (!this.h))
      localState = LocationNuxController.State.OFF;
    while (true)
    {
      return localState;
      if ((!this.f) && (this.g) && (this.a.a("dismissed_location_disabled_nux") == 0) && (this.a.a("send_clicked_with_location_disabled_nux") == 0))
      {
        localState = LocationNuxController.State.LOCATION_DISABLED_NUX_SHOWING;
        continue;
      }
      if ((this.a.a("dismissed_location_nux") == 0) && (this.a.a("send_clicked") == 0) && (this.a.a("enabled_shared_location_in_message") == 0) && (this.a.a("disabled_shared_location_in_message") == 0))
      {
        localState = LocationNuxController.State.LOCATION_NUX_SHOWING;
        continue;
      }
      localState = LocationNuxController.State.OFF;
    }
  }

  public void a()
  {
    if (this.e == LocationNuxController.State.LOCATION_DISABLED_NUX_SHOWING)
      this.a.c("send_clicked_with_location_disabled_nux");
  }

  public void a(ComposeMode paramComposeMode)
  {
    this.i = paramComposeMode;
    a(b());
  }

  public void a(LocationNuxView paramLocationNuxView, LocationDisabledNuxView paramLocationDisabledNuxView)
  {
    this.b = paramLocationNuxView;
    this.c = paramLocationDisabledNuxView;
    this.d = new LocationNuxController.1(this);
    this.a.a(this.d);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.f = paramBoolean1;
    this.g = paramBoolean2;
    this.h = paramBoolean3;
    a(b());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.LocationNuxController
 * JD-Core Version:    0.6.0
 */