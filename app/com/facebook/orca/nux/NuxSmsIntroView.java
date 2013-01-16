package com.facebook.orca.nux;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NuxSmsIntroView extends NuxPopover
{
  private Button d;
  private Button e;
  private TextView f;

  public NuxSmsIntroView(Context paramContext)
  {
    super(paramContext);
  }

  public NuxSmsIntroView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NuxSmsIntroView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a()
  {
    setContentView(2130903386);
    this.d = ((Button)getView(2131297382));
    this.e = ((Button)getView(2131297381));
    this.f = ((TextView)getView(2131297380));
  }

  public void b()
  {
    d();
    this.f.setMovementMethod(LinkMovementMethod.getInstance());
  }

  public void setBlurb(int paramInt)
  {
    d();
    this.f.setText(paramInt);
  }

  public void setBlurb(CharSequence paramCharSequence)
  {
    d();
    this.f.setText(paramCharSequence);
  }

  public void setOnSkipClickListener(View.OnClickListener paramOnClickListener)
  {
    d();
    this.e.setOnClickListener(paramOnClickListener);
  }

  public void setOnTryClickListener(View.OnClickListener paramOnClickListener)
  {
    d();
    this.d.setOnClickListener(paramOnClickListener);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.NuxSmsIntroView
 * JD-Core Version:    0.6.0
 */