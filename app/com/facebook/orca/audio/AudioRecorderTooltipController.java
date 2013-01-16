package com.facebook.orca.audio;

import android.os.Handler;
import android.view.View;
import com.facebook.orca.common.ui.overlay.OverlayLayout;
import com.facebook.orca.common.ui.overlay.OverlayLayout.LayoutParams;

public class AudioRecorderTooltipController
{
  private final View a;
  private final Handler b;
  private boolean c;
  private AudioRecorderTooltipView d;
  private final Runnable e = new AudioRecorderTooltipController.1(this);

  public AudioRecorderTooltipController(View paramView)
  {
    this.a = paramView;
    this.b = new Handler();
  }

  private void g()
  {
    if ((this.d != null) || (this.c));
    while (true)
    {
      return;
      OverlayLayout localOverlayLayout = h();
      if (localOverlayLayout == null)
      {
        this.c = true;
        continue;
      }
      this.d = new AudioRecorderTooltipView(this.a.getContext());
      localOverlayLayout.addView(this.d);
      OverlayLayout.LayoutParams localLayoutParams = (OverlayLayout.LayoutParams)this.d.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.c = 514;
      localLayoutParams.a = true;
      localLayoutParams.b = this.a.getId();
      localLayoutParams.setMargins(0, 0, 0, 10);
      this.d.setVisibility(8);
      this.d.setLayoutParams(localLayoutParams);
    }
  }

  private OverlayLayout h()
  {
    View localView = this.a;
    do
    {
      if (!(localView.getParent() instanceof View))
        break;
      localView = (View)localView.getParent();
    }
    while (!(localView instanceof OverlayLayout));
    for (OverlayLayout localOverlayLayout = (OverlayLayout)localView; ; localOverlayLayout = null)
      return localOverlayLayout;
  }

  public void a()
  {
    g();
    this.d.setShowNux();
    e();
  }

  public void a(int paramInt)
  {
    if (this.d != null)
      this.d.a(paramInt);
  }

  public void a(AudioRecorderTooltipView.ViewStyle paramViewStyle)
  {
    if (this.d != null)
      this.d.setStyle(paramViewStyle);
  }

  public void b()
  {
    g();
    this.d.setShowTooltipHint();
    e();
    this.b.postDelayed(this.e, 1000L);
  }

  public void c()
  {
    g();
    if (this.d != null)
      this.d.a();
  }

  public void d()
  {
    f();
    if (this.d != null)
      this.d.b();
  }

  public void e()
  {
    this.b.removeCallbacks(this.e);
    g();
    if (this.c);
    while (true)
    {
      return;
      this.d.setVisibility(0);
    }
  }

  public void f()
  {
    if ((this.c) || (this.d == null));
    while (true)
    {
      return;
      this.d.setVisibility(8);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioRecorderTooltipController
 * JD-Core Version:    0.6.0
 */