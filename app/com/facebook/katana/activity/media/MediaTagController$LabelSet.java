package com.facebook.katana.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.katana.model.FacebookTagLabel;
import java.util.ListIterator;
import java.util.Map;

abstract interface MediaTagController$LabelSet<T extends FacebookTagLabel> extends Iterable<T>
{
  public abstract void a(T paramT);

  public abstract View.OnClickListener b(T paramT);

  public abstract ListIterator<T> f();

  public abstract Map<T, ViewGroup> g();

  public abstract Map<View, T> h();

  public abstract View.OnClickListener i();

  public abstract int j();

  public abstract void k();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaTagController.LabelSet
 * JD-Core Version:    0.6.0
 */