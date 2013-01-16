package com.facebook.orca.audio;

import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.facebook.orca.common.ui.overlay.OverlayLayout;
import com.facebook.orca.common.ui.overlay.OverlayLayout.LayoutParams;

public class AudioRecorderTopBarController
{
  private final LayoutInflater a;
  private final Resources b;
  private final Handler c;
  private View d;
  private boolean e;
  private TextView f;
  private final Runnable g = new AudioRecorderTopBarController.1(this);

  public AudioRecorderTopBarController(LayoutInflater paramLayoutInflater, Resources paramResources)
  {
    this.a = paramLayoutInflater;
    this.b = paramResources;
    this.c = new Handler();
  }

  private void a(String paramString)
  {
    this.c.removeCallbacks(this.g);
    e();
    if (this.e);
    while (true)
    {
      return;
      this.f.setText(paramString);
      this.f.setVisibility(0);
    }
  }

  private void e()
  {
    if ((this.f != null) || (this.e));
    while (true)
    {
      return;
      OverlayLayout localOverlayLayout = f();
      if (localOverlayLayout == null)
      {
        this.e = true;
        continue;
      }
      this.f = ((TextView)this.a.inflate(2130903316, null));
      localOverlayLayout.addView(this.f);
      OverlayLayout.LayoutParams localLayoutParams = (OverlayLayout.LayoutParams)this.f.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localLayoutParams.c = 516;
      localLayoutParams.a = true;
      localLayoutParams.b = localOverlayLayout.getId();
      this.f.setVisibility(8);
      this.f.setLayoutParams(localLayoutParams);
    }
  }

  private OverlayLayout f()
  {
    View localView = this.d;
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
    a(this.b.getString(2131362721));
    this.c.postDelayed(this.g, 2000L);
  }

  public void a(View paramView)
  {
    this.d = paramView;
  }

  public void b()
  {
    a(this.b.getString(2131362719));
  }

  public void c()
  {
    a(this.b.getString(2131362718));
  }

  public void d()
  {
    if ((this.e) || (this.f == null));
    while (true)
    {
      return;
      this.f.setVisibility(8);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.AudioRecorderTopBarController
 * JD-Core Version:    0.6.0
 */