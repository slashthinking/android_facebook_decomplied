package com.facebook.photos.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class UrlImageGrid extends LinearLayout
{
  protected Context a;
  protected UrlImageGridAdapter b;
  protected GridView c;
  protected View d;
  protected TextView e;

  public UrlImageGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }

  protected abstract UrlImageGridAdapter a();

  public void a(UrlImageGrid.UI_STATE paramUI_STATE)
  {
    switch (UrlImageGrid.1.a[paramUI_STATE.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      this.c.setVisibility(8);
      continue;
      this.c.setVisibility(0);
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      continue;
      this.e.setVisibility(0);
      this.d.setVisibility(8);
      this.c.setVisibility(8);
    }
  }

  public void b()
  {
    a(UrlImageGrid.UI_STATE.LOADING);
    this.b.a(1, 40);
  }

  public UrlImageGridAdapter getAdapter()
  {
    return this.b;
  }

  protected abstract int getEmptyTextResourceId();

  protected abstract int getEmptyTextStringId();

  protected abstract int getGridResourceId();

  protected abstract int getProgressResourceId();

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = findViewById(getProgressResourceId());
    this.e = ((TextView)findViewById(getEmptyTextResourceId()));
    this.e.setText(getEmptyTextStringId());
    this.c = ((GridView)findViewById(getGridResourceId()));
    this.b = a();
    this.c.setAdapter(this.b);
    this.c.setOnScrollListener(new UrlImageGrid.ScrollListener(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.grid.UrlImageGrid
 * JD-Core Version:    0.6.0
 */