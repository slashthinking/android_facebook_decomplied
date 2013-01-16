package com.facebook.orca.nux;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThreadTitleNuxView extends NuxPopover
{
  private Button d;
  private Button e;

  public ThreadTitleNuxView(Context paramContext)
  {
    super(paramContext);
  }

  public ThreadTitleNuxView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ThreadTitleNuxView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a()
  {
    setContentView(2130903387);
    this.d = ((Button)getView(2131297383));
    this.e = ((Button)getView(2131297384));
  }

  public void setOnMoreClickListener(View.OnClickListener paramOnClickListener)
  {
    this.d.setOnClickListener(paramOnClickListener);
  }

  public void setOnOkayClickListener(View.OnClickListener paramOnClickListener)
  {
    this.e.setOnClickListener(paramOnClickListener);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.ThreadTitleNuxView
 * JD-Core Version:    0.6.0
 */