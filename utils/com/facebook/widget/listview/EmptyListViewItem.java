package com.facebook.widget.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.R.styleable;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomViewGroup;

public class EmptyListViewItem extends CustomViewGroup
{
  private LayoutInflater a;
  private View b;
  private RelativeLayout c;
  private ProgressBar d;
  private TextView e;

  public EmptyListViewItem(Context paramContext)
  {
    super(paramContext);
    a(null);
  }

  public EmptyListViewItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }

  public EmptyListViewItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }

  private void a(AttributeSet paramAttributeSet)
  {
    this.a = ((LayoutInflater)getInjector().a(LayoutInflater.class));
    this.b = this.a.inflate(2130903344, this);
    this.c = ((RelativeLayout)this.b.findViewById(2131297291));
    this.d = ((ProgressBar)this.b.findViewById(2131297292));
    this.e = ((TextView)this.b.findViewById(2131297293));
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.EmptyListViewItem);
    if (localTypedArray.peekValue(0) != null)
      this.e.setTextColor(localTypedArray.getColor(0, 0));
    if (localTypedArray.peekValue(1) != null)
      this.c.setBackgroundDrawable(new ColorDrawable(localTypedArray.getColor(1, 0)));
    localTypedArray.recycle();
  }

  public void a(boolean paramBoolean)
  {
    ProgressBar localProgressBar = this.d;
    if (paramBoolean);
    for (int i = 0; ; i = 4)
    {
      localProgressBar.setVisibility(i);
      return;
    }
  }

  public boolean a()
  {
    if (this.d.getVisibility() == 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.c.setBackgroundDrawable(paramDrawable);
  }

  public void setMessage(int paramInt)
  {
    this.e.setText(paramInt);
  }

  public void setMessage(CharSequence paramCharSequence)
  {
    this.e.setText(paramCharSequence);
  }

  public void setMovementMethod(MovementMethod paramMovementMethod)
  {
    this.e.setMovementMethod(paramMovementMethod);
  }

  public void setTextColor(int paramInt)
  {
    this.e.setTextColor(paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.listview.EmptyListViewItem
 * JD-Core Version:    0.6.2
 */