package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.facebook.R.styleable;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.listview.recycle.RecyclableView;

public abstract class CustomViewStub extends View
{
  protected final Context a;
  private final int b;

  public CustomViewStub(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public CustomViewStub(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, null, 0);
  }

  public CustomViewStub(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CustomViewStub);
    this.b = localTypedArray.getInt(0, -1);
    localTypedArray.recycle();
  }

  public View a()
  {
    ViewParent localViewParent = getParent();
    if ((localViewParent == null) || (!(localViewParent instanceof ViewGroup)))
      throw new IllegalStateException("CustomViewStub has no parent or is in an invalid parent");
    View localView = getInflatedLayout();
    if (localView == null)
      throw new IllegalStateException("CustomViewStub.getInflatedLayout returned null");
    localView.setId(this.b);
    int i = ((ViewGroup)localViewParent).indexOfChild(this);
    ViewGroup.LayoutParams localLayoutParams;
    if (getLayoutParams() != null)
    {
      localLayoutParams = getLayoutParams();
      ((ViewGroup)localViewParent).removeViewAt(i);
      if ((!(localViewParent instanceof FbCustomViewGroup)) || (!(localView instanceof RecyclableView)))
        break label128;
      ((FbCustomViewGroup)localViewParent).attachRecyclableViewToParent(localView, i, localLayoutParams);
    }
    while (true)
    {
      return localView;
      localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
      break;
      label128: ((ViewGroup)localViewParent).addView(localView, i, localLayoutParams);
    }
  }

  protected abstract View getInflatedLayout();

  protected FbInjector getInjector()
  {
    return FbInjector.a(getContext());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.CustomViewStub
 * JD-Core Version:    0.6.2
 */