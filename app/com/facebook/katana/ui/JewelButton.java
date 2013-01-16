package com.facebook.katana.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.R.styleable;
import com.facebook.widget.CustomRelativeLayout;

public class JewelButton extends CustomRelativeLayout
{
  private final TextView a;
  private final ImageButton b;
  private final int c;
  private final int d;
  private int e;
  private boolean f = false;

  public JewelButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public JewelButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public JewelButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903260);
    this.a = ((TextView)findViewById(2131297038));
    this.b = ((ImageButton)findViewById(2131297037));
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.JewelButton);
    this.c = localTypedArray.getResourceId(1, -1);
    this.d = localTypedArray.getResourceId(0, -1);
    localTypedArray.recycle();
    this.b.setImageResource(this.c);
  }

  private CharSequence a(int paramInt)
  {
    if (paramInt >= 100);
    for (Object localObject = getContext().getText(2131363407); ; localObject = String.valueOf(paramInt))
      return localObject;
  }

  private void a()
  {
    ImageButton localImageButton = this.b;
    int i;
    TextView localTextView;
    if ((this.e > 0) || (this.f))
    {
      i = this.d;
      localImageButton.setImageResource(i);
      this.a.setText(a(this.e));
      localTextView = this.a;
      if (this.e != 0)
        break label75;
    }
    label75: for (int j = 8; ; j = 0)
    {
      localTextView.setVisibility(j);
      return;
      i = this.c;
      break;
    }
  }

  public void setActive(boolean paramBoolean)
  {
    this.f = paramBoolean;
    a();
  }

  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(paramOnClickListener);
  }

  public void setUnseenCount(int paramInt)
  {
    this.e = paramInt;
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.JewelButton
 * JD-Core Version:    0.6.0
 */