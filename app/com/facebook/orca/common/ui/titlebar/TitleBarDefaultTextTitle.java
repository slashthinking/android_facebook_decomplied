package com.facebook.orca.common.ui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.widget.CustomViewGroup;

public class TitleBarDefaultTextTitle extends CustomViewGroup
{
  private TextView a;
  private View b;
  private ProgressBar c;

  public TitleBarDefaultTextTitle(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public TitleBarDefaultTextTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public TitleBarDefaultTextTitle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    setContentView(2130903427);
    this.b = getView(2131297521);
    this.c = ((ProgressBar)getView(2131297522));
    this.a = ((TextView)getView(2131297520));
  }

  public void setProgressBarVisibility(int paramInt)
  {
    if (paramInt == 0)
    {
      this.b.setVisibility(0);
      this.c.setVisibility(0);
    }
    while (true)
    {
      return;
      if (paramInt == 4)
      {
        this.b.setVisibility(4);
        this.c.setVisibility(4);
        continue;
      }
      this.b.setVisibility(8);
    }
  }

  public void setText(String paramString)
  {
    this.a.setText(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.TitleBarDefaultTextTitle
 * JD-Core Version:    0.6.0
 */