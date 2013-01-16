package com.facebook.orca.compose;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.orca.common.ui.util.CompoundTouchDelegate;
import com.facebook.orca.common.ui.util.TouchDelegateUtils;

public class ComposeEditContainerView extends LinearLayout
{
  private View a;
  private View b;

  public ComposeEditContainerView(Context paramContext)
  {
    super(paramContext);
  }

  public ComposeEditContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a(int paramInt1, int paramInt2)
  {
    setTouchDelegate(new CompoundTouchDelegate(this, new TouchDelegate[] { TouchDelegateUtils.a(this.a, 10), TouchDelegateUtils.a(this.b, paramInt1, paramInt2) }));
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = findViewById(2131297206);
    this.b = findViewById(2131297202);
    setAddStatesFromChildren(true);
  }

  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
      a(paramInt2, paramInt4);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.ComposeEditContainerView
 * JD-Core Version:    0.6.0
 */