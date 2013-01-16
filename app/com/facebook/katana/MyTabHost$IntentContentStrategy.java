package com.facebook.katana;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

class MyTabHost$IntentContentStrategy
  implements MyTabHost.ContentStrategy
{
  private final String b;
  private final Intent c;
  private View d;

  private MyTabHost$IntentContentStrategy(MyTabHost paramMyTabHost, String paramString, Intent paramIntent)
  {
    this.b = paramString;
    this.c = paramIntent;
  }

  public View a()
  {
    if (this.a.b == null)
      throw new IllegalStateException("Did you forget to call 'public void setup(LocalActivityManager activityGroup)'?");
    Window localWindow = this.a.b.startActivity(this.b, this.c);
    if (localWindow != null);
    for (View localView = localWindow.getDecorView(); ; localView = null)
    {
      if ((this.d != localView) && (this.d != null) && (this.d.getParent() != null))
        MyTabHost.a(this.a).removeView(this.d);
      this.d = localView;
      if (this.d != null)
      {
        this.d.setVisibility(0);
        this.d.setFocusableInTouchMode(true);
        ((ViewGroup)this.d).setDescendantFocusability(262144);
      }
      return this.d;
    }
  }

  public void b()
  {
    if (this.d != null)
      this.d.setVisibility(8);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.MyTabHost.IntentContentStrategy
 * JD-Core Version:    0.6.0
 */