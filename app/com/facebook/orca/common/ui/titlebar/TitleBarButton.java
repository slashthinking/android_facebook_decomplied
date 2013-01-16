package com.facebook.orca.common.ui.titlebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.R.styleable;
import com.facebook.widget.CustomFrameLayout;

public class TitleBarButton extends CustomFrameLayout
{
  private final ImageButton a;
  private final ProgressBar b;
  private final TextView c;
  private final View d;
  private Drawable e;
  private String f;
  private int g;
  private boolean h;

  public TitleBarButton(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public TitleBarButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TitleBarButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TitleBarButton);
    int i = localTypedArray.getResourceId(1, -1);
    if (i != -1)
      this.e = localTypedArray.getResources().getDrawable(i);
    this.g = localTypedArray.getInt(0, 1);
    localTypedArray.recycle();
    setContentView(2130903426);
    this.a = ((ImageButton)b(2131297517));
    this.a.setImageDrawable(this.e);
    this.a.setOnClickListener(new TitleBarButton.1(this));
    this.c = ((TextView)b(2131297519));
    this.b = ((ProgressBar)b(2131297518));
    this.d = findViewById(2131297245);
    setDividerPosition(this.g);
  }

  private void a()
  {
    if (this.h)
    {
      this.b.setVisibility(0);
      this.a.setVisibility(8);
      this.c.setVisibility(8);
    }
    while (true)
    {
      return;
      this.b.setVisibility(8);
      if (this.f != null)
      {
        this.c.setVisibility(0);
        continue;
      }
      if (this.e == null)
        continue;
      this.a.setVisibility(0);
    }
  }

  public ImageButton getImageButton()
  {
    return this.a;
  }

  public void setColorScheme(TitleBar.ColorScheme paramColorScheme)
  {
    switch (TitleBarButton.2.a[paramColorScheme.ordinal()])
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

  public void setDividerPosition(int paramInt)
  {
    this.g = paramInt;
    ImageButton localImageButton;
    if ((paramInt & 0x1) == 1)
    {
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.d.getLayoutParams();
      localLayoutParams2.gravity = 3;
      this.d.setLayoutParams(localLayoutParams2);
      this.d.setVisibility(0);
      localImageButton = this.a;
      if (paramInt == 0)
        break label121;
    }
    label121: for (boolean bool = true; ; bool = false)
    {
      localImageButton.setEnabled(bool);
      return;
      if ((paramInt & 0x2) == 2)
      {
        FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.d.getLayoutParams();
        localLayoutParams1.gravity = 5;
        this.d.setLayoutParams(localLayoutParams1);
        this.d.setVisibility(0);
        break;
      }
      this.d.setVisibility(8);
      break;
    }
  }

  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.a.setEnabled(paramBoolean);
  }

  public void setImageDrawable(Drawable paramDrawable)
  {
    this.f = null;
    this.e = paramDrawable;
    this.a.setImageDrawable(paramDrawable);
    a();
  }

  public void setShowProgress(boolean paramBoolean)
  {
    this.h = paramBoolean;
    ProgressBar localProgressBar = this.b;
    int i;
    int j;
    label34: TextView localTextView;
    int k;
    if (paramBoolean)
    {
      i = 0;
      localProgressBar.setVisibility(i);
      ImageButton localImageButton = this.a;
      if (paramBoolean)
        break label68;
      j = 0;
      localImageButton.setVisibility(j);
      localTextView = this.c;
      k = 0;
      if (paramBoolean)
        break label75;
    }
    while (true)
    {
      localTextView.setVisibility(k);
      return;
      i = 8;
      break;
      label68: j = 8;
      break label34;
      label75: k = 8;
    }
  }

  public void setText(String paramString)
  {
    this.e = null;
    this.f = paramString;
    this.c.setText(paramString);
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.TitleBarButton
 * JD-Core Version:    0.6.0
 */