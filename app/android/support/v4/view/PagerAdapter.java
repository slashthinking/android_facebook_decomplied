package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class PagerAdapter
{
  private DataSetObservable a = new DataSetObservable();

  public int a(Object paramObject)
  {
    return -1;
  }

  public Parcelable a()
  {
    return null;
  }

  public Object a(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
  }

  public Object a(ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramViewGroup, paramInt);
  }

  void a(DataSetObserver paramDataSetObserver)
  {
    this.a.registerObserver(paramDataSetObserver);
  }

  public void a(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
  }

  public void a(View paramView)
  {
  }

  public void a(View paramView, int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException("Required method destroyItem was not overridden");
  }

  public void a(ViewGroup paramViewGroup)
  {
    a(paramViewGroup);
  }

  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    a(paramViewGroup, paramInt, paramObject);
  }

  public abstract boolean a(View paramView, Object paramObject);

  public abstract int b();

  void b(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterObserver(paramDataSetObserver);
  }

  public void b(View paramView)
  {
  }

  public void b(View paramView, int paramInt, Object paramObject)
  {
  }

  public void b(ViewGroup paramViewGroup)
  {
    b(paramViewGroup);
  }

  public void b(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    b(paramViewGroup, paramInt, paramObject);
  }

  public CharSequence c(int paramInt)
  {
    return null;
  }

  public void c()
  {
    this.a.notifyChanged();
  }

  public float d(int paramInt)
  {
    return 1.0F;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.PagerAdapter
 * JD-Core Version:    0.6.0
 */