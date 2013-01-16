package com.facebook.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

public class SoftKeyboardStateAwareEditText extends EditText
  implements View.OnFocusChangeListener, SoftKeyboardStateAwareEditTextInterface
{
  private OnSoftKeyboardStateChangeListener a;
  private boolean b = false;

  public SoftKeyboardStateAwareEditText(Context paramContext)
  {
    super(paramContext);
    setOnFocusChangeListener(this);
  }

  public SoftKeyboardStateAwareEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnFocusChangeListener(this);
  }

  public SoftKeyboardStateAwareEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnFocusChangeListener(this);
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    boolean bool = true;
    if (this.a == null);
    do
    {
      return;
      if ((!paramBoolean) || (this.b))
        continue;
      this.a.a(this);
      if (!this.b);
      while (true)
      {
        this.b = bool;
        break;
        bool = false;
      }
    }
    while ((paramBoolean) || (!this.b));
    this.a.b(this);
    if (!this.b);
    while (true)
    {
      this.b = bool;
      break;
      bool = false;
    }
  }

  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1;
    if (this.a == null)
    {
      bool1 = super.onKeyPreIme(paramInt, paramKeyEvent);
      return bool1;
    }
    if ((paramInt == 4) && (this.b))
    {
      this.a.b(this);
      if (this.b)
        break label68;
    }
    label68: for (boolean bool2 = true; ; bool2 = false)
    {
      this.b = bool2;
      clearFocus();
      bool1 = super.onKeyPreIme(paramInt, paramKeyEvent);
      break;
    }
  }

  public void setOnSoftKeyboardVisibleListener(OnSoftKeyboardStateChangeListener paramOnSoftKeyboardStateChangeListener)
  {
    this.a = paramOnSoftKeyboardStateChangeListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.SoftKeyboardStateAwareEditText
 * JD-Core Version:    0.6.0
 */