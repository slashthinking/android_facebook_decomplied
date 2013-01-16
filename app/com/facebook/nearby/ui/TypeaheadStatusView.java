package com.facebook.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.widget.CustomFrameLayout;

public class TypeaheadStatusView extends CustomFrameLayout
{
  private static final Class<?> a = TypeaheadStatusView.class;
  private ProgressBar b;
  private TextView c;

  public TypeaheadStatusView(Context paramContext)
  {
    this(paramContext, null);
  }

  public TypeaheadStatusView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TypeaheadStatusView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903296);
    this.c = ((TextView)b(2131297158));
    this.b = ((ProgressBar)b(2131297157));
  }

  public void a()
  {
    this.b.setVisibility(0);
    this.c.setVisibility(8);
  }

  public void a(String paramString)
  {
    this.c.setText(paramString);
    this.c.setVisibility(0);
    this.b.setVisibility(8);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.ui.TypeaheadStatusView
 * JD-Core Version:    0.6.0
 */