package com.facebook.katana.view.tabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BlueTabIndicatorView extends LinearLayout
{
  private TextView a;

  public BlueTabIndicatorView(Context paramContext)
  {
    super(paramContext);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2130903066, this);
    setBackgroundResource(2130837568);
    this.a = ((TextView)findViewById(2131296408));
  }

  public void setText(String paramString)
  {
    this.a.setText(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.tabs.BlueTabIndicatorView
 * JD-Core Version:    0.6.0
 */