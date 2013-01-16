package com.facebook.appcenter.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;

public class HorizontalImageGalleryItemIndicator extends LinearLayout
{
  private int a = 7;
  private Drawable b;
  private Drawable c;
  private ArrayList<ImageView> d;
  private int e = 0;
  private int f = 0;
  private Context g;
  private AttributeSet h = null;

  public HorizontalImageGalleryItemIndicator(Context paramContext)
  {
    super(paramContext);
    this.g = paramContext;
    b();
  }

  public HorizontalImageGalleryItemIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.h = paramAttributeSet;
    this.g = paramContext;
  }

  private void b()
  {
    this.d = new ArrayList();
    this.b = new ShapeDrawable();
    this.c = new ShapeDrawable();
    this.b.setBounds(0, 0, this.a, this.a);
    this.c.setBounds(0, 0, this.a, this.a);
    OvalShape localOvalShape1 = new OvalShape();
    localOvalShape1.resize(this.a, this.a);
    OvalShape localOvalShape2 = new OvalShape();
    localOvalShape2.resize(this.a, this.a);
    ((ShapeDrawable)this.b).getPaint().setColor(this.g.getResources().getColor(2131165248));
    ((ShapeDrawable)this.c).getPaint().setColor(this.g.getResources().getColor(2131165249));
    ((ShapeDrawable)this.b).setShape(localOvalShape1);
    ((ShapeDrawable)this.c).setShape(localOvalShape2);
    this.a = (int)(this.a * getResources().getDisplayMetrics().density);
  }

  public void a()
  {
    this.e = 0;
    this.f = 0;
    this.d.clear();
    removeAllViewsInLayout();
  }

  public int getIndicatorDiameter()
  {
    return this.a;
  }

  protected void onFinishInflate()
  {
    b();
  }

  public void setCurrentPage(int paramInt)
  {
    if (paramInt < this.e)
    {
      ((ImageView)this.d.get(this.f)).setBackgroundDrawable(this.c);
      ((ImageView)this.d.get(paramInt)).setBackgroundDrawable(this.b);
      this.f = paramInt;
    }
  }

  public void setIndicatorDiameter(int paramInt)
  {
    this.a = paramInt;
    for (int i = 0; i < this.e; i++)
      ((ImageView)this.d.get(i)).setLayoutParams(new LinearLayout.LayoutParams(this.a, this.a));
  }

  public void setPageCount(int paramInt)
  {
    this.e = paramInt;
    for (int i = 0; i < paramInt; i++)
    {
      ImageView localImageView = new ImageView(this.g);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.a, this.a);
      localLayoutParams.setMargins(this.a / 2, this.a, this.a / 2, this.a);
      localImageView.setLayoutParams(localLayoutParams);
      localImageView.setBackgroundDrawable(this.c);
      this.d.add(localImageView);
      addView(localImageView);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.HorizontalImageGalleryItemIndicator
 * JD-Core Version:    0.6.0
 */