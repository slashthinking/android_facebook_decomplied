package com.facebook.orca.compose;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.RelativeLayout;
import com.facebook.orca.common.ui.util.CompoundTouchDelegate;
import com.facebook.orca.common.ui.util.TouchDelegateUtils;

public class ComposeRootView extends RelativeLayout
{
  private View a;
  private View b;
  private View c;
  private TouchDelegate d;
  private View.OnKeyListener e;

  public ComposeRootView(Context paramContext)
  {
    super(paramContext);
  }

  public ComposeRootView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ComposeRootView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a(int paramInt1, int paramInt2)
  {
    this.d = TouchDelegateUtils.a(this.b, paramInt1, paramInt2, 5);
    TouchDelegate localTouchDelegate1 = TouchDelegateUtils.a(this.a, 5);
    TouchDelegate localTouchDelegate2 = TouchDelegateUtils.a(this.c, paramInt1, paramInt2);
    TouchDelegate[] arrayOfTouchDelegate = new TouchDelegate[3];
    arrayOfTouchDelegate[0] = this.d;
    arrayOfTouchDelegate[1] = localTouchDelegate1;
    arrayOfTouchDelegate[2] = localTouchDelegate2;
    setTouchDelegate(new CompoundTouchDelegate(this, arrayOfTouchDelegate));
  }

  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0) && (this.e != null) && (this.e.onKey(this, paramKeyEvent.getKeyCode(), paramKeyEvent)));
    for (boolean bool = true; ; bool = super.dispatchKeyEventPreIme(paramKeyEvent))
      return bool;
  }

  public TouchDelegate getEmojiAttachmentTouchDelegate()
  {
    return this.d;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = findViewById(2131297201);
    this.a = findViewById(2131297204);
    this.c = findViewById(2131297202);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
      a(paramInt2, paramInt4);
  }

  public void setPreImeKeyListener(View.OnKeyListener paramOnKeyListener)
  {
    this.e = paramOnKeyListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.ComposeRootView
 * JD-Core Version:    0.6.0
 */