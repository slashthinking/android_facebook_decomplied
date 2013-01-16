package com.facebook.orca.common.ui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.facebook.widget.CustomViewGroup;

public class TitleBarBackButton extends CustomViewGroup
{
  private ImageButton a;

  public TitleBarBackButton(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public TitleBarBackButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TitleBarBackButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903425);
    this.a = ((ImageButton)getView(2131297517));
    this.a.setOnClickListener(new TitleBarBackButton.1(this));
  }

  public void setColorScheme(TitleBar.ColorScheme paramColorScheme)
  {
    switch (TitleBarBackButton.2.a[paramColorScheme.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      this.a.setBackgroundResource(2130838742);
      continue;
      this.a.setBackgroundResource(2130838746);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.TitleBarBackButton
 * JD-Core Version:    0.6.0
 */