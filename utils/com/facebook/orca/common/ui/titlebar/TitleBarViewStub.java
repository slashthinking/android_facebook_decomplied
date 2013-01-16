package com.facebook.orca.common.ui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.facebook.R.styleable;
import com.facebook.app.Product;
import com.facebook.orca.inject.FbInjector;
import java.lang.ref.WeakReference;

public class TitleBarViewStub extends View
{
  private WeakReference<View> a;
  private String b;
  private Boolean c;
  private Boolean d;
  private Boolean e;
  private Product f;

  public TitleBarViewStub(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public TitleBarViewStub(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TitleBarViewStub(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.f = ((Product)FbInjector.a(paramContext).a(Product.class));
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TitleBarViewStub, paramInt, 0);
    this.b = localTypedArray.getString(0);
    this.c = a(localTypedArray, 1);
    this.d = a(localTypedArray, 2);
    this.e = a(localTypedArray, 4);
    localTypedArray.recycle();
    setWillNotDraw(true);
  }

  private View a()
  {
    ViewParent localViewParent = getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
    {
      ViewGroup localViewGroup = (ViewGroup)localViewParent;
      LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
      View localView;
      FbTitleBar localFbTitleBar;
      label77: int i;
      if ((this.f == Product.FB4A) && (Boolean.TRUE.equals(this.e)))
      {
        localView = localLayoutInflater.inflate(2130903609, localViewGroup, false);
        if (!(localView instanceof FbTitleBar))
          break label199;
        localFbTitleBar = (FbTitleBar)localView;
        if (this.b != null)
          localFbTitleBar.setTitle(this.b);
        if (this.c != null)
          localFbTitleBar.setHasProgressBar(this.c.booleanValue());
        if (this.d != null)
          localFbTitleBar.setHasBackButton(this.d.booleanValue());
        i = localViewGroup.indexOfChild(this);
        localViewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
        if (localLayoutParams == null)
          break label214;
        localViewGroup.addView(localView, i, localLayoutParams);
      }
      while (true)
      {
        this.a = new WeakReference(localView);
        return localView;
        localView = localLayoutInflater.inflate(2130903608, localViewGroup, false);
        break;
        label199: localFbTitleBar = (FbTitleBar)localView.findViewById(2131296299);
        break label77;
        label214: localViewGroup.addView(localView, i);
      }
    }
    throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
  }

  private Boolean a(TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt));
    for (Boolean localBoolean = Boolean.valueOf(paramTypedArray.getBoolean(paramInt, false)); ; localBoolean = null)
      return localBoolean;
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
  }

  public void draw(Canvas paramCanvas)
  {
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(0, 0);
  }

  public void setVisibility(int paramInt)
  {
    if (this.a != null)
    {
      View localView = (View)this.a.get();
      if (localView != null)
        localView.setVisibility(paramInt);
    }
    while (true)
    {
      return;
      throw new IllegalStateException("setVisibility called on un-referenced view");
      super.setVisibility(paramInt);
      if ((paramInt == 0) || (paramInt == 4))
        a();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.titlebar.TitleBarViewStub
 * JD-Core Version:    0.6.2
 */