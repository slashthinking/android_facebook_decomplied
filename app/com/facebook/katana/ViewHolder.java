package com.facebook.katana;

import android.view.View;
import android.widget.ImageView;

public class ViewHolder<T>
{
  public final ImageView a;
  private T b;

  public ViewHolder(View paramView, int paramInt)
  {
    this.a = ((ImageView)paramView.findViewById(paramInt));
  }

  public T a()
  {
    return this.b;
  }

  public void a(T paramT)
  {
    this.b = paramT;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ViewHolder
 * JD-Core Version:    0.6.0
 */