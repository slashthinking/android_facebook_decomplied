package com.facebook.widget.animatablelistview;

import android.view.View;
import android.view.ViewGroup;

public abstract interface ItemBasedListAdapter<T>
{
  public abstract int a();

  public abstract View a(T paramT, View paramView, ViewGroup paramViewGroup);

  public abstract boolean a(T paramT);

  public abstract long b(T paramT);

  public abstract boolean b();

  public abstract int c(T paramT);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.animatablelistview.ItemBasedListAdapter
 * JD-Core Version:    0.6.2
 */