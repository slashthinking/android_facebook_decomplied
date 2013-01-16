package com.facebook.katana;

import android.content.Intent;
import android.view.View;

public class MyTabHost$TabSpec
{
  public final String a;
  public final View b;
  private MyTabHost.ContentStrategy d;

  private MyTabHost$TabSpec(MyTabHost paramMyTabHost, String paramString, View paramView)
  {
    this.a = paramString;
    this.b = paramView;
    paramView.setTag(paramString);
  }

  public TabSpec a(Intent paramIntent)
  {
    this.d = new MyTabHost.IntentContentStrategy(this.c, this.a, paramIntent, null);
    return this;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.MyTabHost.TabSpec
 * JD-Core Version:    0.6.0
 */