package com.facebook.orca.nux;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NuxIntroView extends NuxPopover
{
  private Button d;

  public NuxIntroView(Context paramContext)
  {
    super(paramContext);
  }

  public NuxIntroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NuxIntroView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a()
  {
    setContentView(2130903383);
    this.d = ((Button)getView(2131297376));
  }

  public void setOnNextClickListener(View.OnClickListener paramOnClickListener)
  {
    d();
    this.d.setOnClickListener(paramOnClickListener);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.NuxIntroView
 * JD-Core Version:    0.6.0
 */