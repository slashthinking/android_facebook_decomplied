package custom.android;

import android.content.Context;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

public abstract class AdapterView<T extends Adapter> extends ViewGroup
{
  int A;
  int B;
  int C = -1;
  long D = -9223372036854775808L;
  boolean E = false;
  private int a;
  private View b;
  private boolean c;
  private boolean d;
  private AdapterView<T>.SelectionNotifier e;
  int k = 0;
  int l;
  int m;
  long n = -9223372036854775808L;
  long o;
  boolean p = false;
  int q;
  boolean r = false;
  AdapterView.OnItemSelectedListener s;
  AdapterView.OnItemClickListener t;
  AdapterView.OnItemLongClickListener u;
  boolean v;
  int w = -1;
  long x = -9223372036854775808L;
  int y = -1;
  long z = -9223372036854775808L;

  public AdapterView(Context paramContext)
  {
    super(paramContext);
  }

  public AdapterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public AdapterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a()
  {
    if (this.s == null);
    while (true)
    {
      return;
      int i = getSelectedItemPosition();
      if (i >= 0)
      {
        View localView = getSelectedView();
        this.s.a(this, localView, i, getAdapter().getItemId(i));
        continue;
      }
      this.s.a(this);
    }
  }

  private void a(boolean paramBoolean)
  {
    if (c())
      paramBoolean = false;
    if (paramBoolean)
      if (this.b != null)
      {
        this.b.setVisibility(0);
        setVisibility(8);
        if (this.v)
          onLayout(false, getLeft(), getTop(), getRight(), getBottom());
      }
    while (true)
    {
      return;
      setVisibility(0);
      break;
      if (this.b != null)
        this.b.setVisibility(8);
      setVisibility(0);
    }
  }

  public long a(int paramInt)
  {
    Adapter localAdapter = getAdapter();
    long l1;
    if ((localAdapter == null) || (paramInt < 0))
      l1 = -9223372036854775808L;
    while (true)
    {
      return l1;
      l1 = localAdapter.getItemId(paramInt);
    }
  }

  public boolean a(View paramView, int paramInt, long paramLong)
  {
    AdapterView.OnItemClickListener localOnItemClickListener = this.t;
    int i = 0;
    if (localOnItemClickListener != null)
    {
      playSoundEffect(0);
      this.t.a(this, paramView, paramInt, paramLong);
      i = 1;
    }
    return i;
  }

  public void addView(View paramView)
  {
    throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
  }

  public void addView(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
  }

  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
  }

  int c(int paramInt, boolean paramBoolean)
  {
    return paramInt;
  }

  public int c(View paramView)
  {
    int i;
    try
    {
      while (true)
      {
        View localView = (View)paramView.getParent();
        boolean bool = localView.equals(this);
        if (bool)
          break;
        paramView = localView;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      i = -1;
    }
    while (true)
    {
      return i;
      int j = getChildCount();
      for (int i1 = 0; ; i1++)
      {
        if (i1 >= j)
          break label79;
        if (!getChildAt(i1).equals(paramView))
          continue;
        i = i1 + this.k;
        break;
      }
      label79: i = -1;
    }
  }

  boolean c()
  {
    return false;
  }

  protected boolean canAnimate()
  {
    if ((super.canAnimate()) && (this.A > 0));
    for (int i = 1; ; i = 0)
      return i;
  }

  void d()
  {
    Adapter localAdapter = getAdapter();
    int i;
    int j;
    label33: boolean bool1;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      if ((i != 0) && (!c()))
        break label115;
      j = 1;
      if ((j == 0) || (!this.d))
        break label120;
      bool1 = true;
      label47: super.setFocusableInTouchMode(bool1);
      if ((j == 0) || (!this.c))
        break label126;
    }
    label115: label120: label126: for (boolean bool2 = true; ; bool2 = false)
    {
      super.setFocusable(bool2);
      if (this.b != null)
      {
        boolean bool3;
        if (localAdapter != null)
        {
          boolean bool4 = localAdapter.isEmpty();
          bool3 = false;
          if (!bool4);
        }
        else
        {
          bool3 = true;
        }
        a(bool3);
      }
      return;
      i = 0;
      break;
      j = 0;
      break label33;
      bool1 = false;
      break label47;
    }
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 8)
      paramAccessibilityEvent.setEventType(4);
    View localView = getSelectedView();
    boolean bool = false;
    if (localView != null)
      bool = localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (!bool)
    {
      if (localView != null)
        paramAccessibilityEvent.setEnabled(localView.isEnabled());
      paramAccessibilityEvent.setItemCount(getCount());
      paramAccessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
    }
    return bool;
  }

  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }

  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }

  void e()
  {
    if (this.s != null)
    {
      if ((!this.r) && (!this.E))
        break label78;
      if (this.e == null)
        this.e = new AdapterView.SelectionNotifier(this, null);
      post(this.e);
    }
    while (true)
    {
      if ((this.y != -1) && (isShown()) && (!isInTouchMode()))
        sendAccessibilityEvent(4);
      return;
      label78: a();
    }
  }

  void f()
  {
    int i = this.A;
    int i1;
    int i3;
    int i4;
    label104: int j;
    if (i > 0)
      if (this.p)
      {
        this.p = false;
        int i5 = h();
        if ((i5 >= 0) && (c(i5, true) == i5))
        {
          setNextSelectedPositionInt(i5);
          i1 = 1;
          if (i1 == 0)
          {
            int i2 = getSelectedItemPosition();
            if (i2 >= i)
              i2 = i - 1;
            if (i2 < 0)
              i2 = 0;
            i3 = c(i2, true);
            if (i3 >= 0)
              break label164;
            i4 = c(i2, false);
            if (i4 >= 0)
            {
              setNextSelectedPositionInt(i4);
              g();
              j = 1;
            }
          }
        }
      }
    while (true)
    {
      if (j == 0)
      {
        this.y = -1;
        this.z = -9223372036854775808L;
        this.w = -1;
        this.x = -9223372036854775808L;
        this.p = false;
        g();
      }
      return;
      j = i1;
      continue;
      label164: i4 = i3;
      break label104;
      i1 = 0;
      break;
      j = 0;
    }
  }

  void g()
  {
    if ((this.y != this.C) || (this.z != this.D))
    {
      e();
      this.C = this.y;
      this.D = this.z;
    }
  }

  public abstract T getAdapter();

  @ViewDebug.CapturedViewProperty
  public int getCount()
  {
    return this.A;
  }

  public View getEmptyView()
  {
    return this.b;
  }

  public int getFirstVisiblePosition()
  {
    return this.k;
  }

  public int getLastVisiblePosition()
  {
    return -1 + (this.k + getChildCount());
  }

  public final AdapterView.OnItemClickListener getOnItemClickListener()
  {
    return this.t;
  }

  public final AdapterView.OnItemLongClickListener getOnItemLongClickListener()
  {
    return this.u;
  }

  public final AdapterView.OnItemSelectedListener getOnItemSelectedListener()
  {
    return this.s;
  }

  public Object getSelectedItem()
  {
    Adapter localAdapter = getAdapter();
    int i = getSelectedItemPosition();
    if ((localAdapter != null) && (localAdapter.getCount() > 0) && (i >= 0));
    for (Object localObject = localAdapter.getItem(i); ; localObject = null)
      return localObject;
  }

  @ViewDebug.CapturedViewProperty
  public long getSelectedItemId()
  {
    return this.x;
  }

  @ViewDebug.CapturedViewProperty
  public int getSelectedItemPosition()
  {
    return this.w;
  }

  public abstract View getSelectedView();

  int h()
  {
    int i = this.A;
    int i5;
    if (i == 0)
      i5 = -1;
    long l1;
    int i2;
    long l2;
    Adapter localAdapter;
    label84: int i8;
    int i6;
    int i7;
    int i3;
    while (true)
    {
      return i5;
      l1 = this.n;
      int j = this.m;
      if (l1 == -9223372036854775808L)
      {
        i5 = -1;
        continue;
      }
      int i1 = Math.max(0, j);
      i2 = Math.min(i - 1, i1);
      l2 = 100L + SystemClock.uptimeMillis();
      localAdapter = getAdapter();
      if (localAdapter == null)
      {
        i5 = -1;
        continue;
        if ((i8 == 0) && ((i6 == 0) || (i7 != 0)))
          break;
        int i9 = i3 + 1;
        i3 = i9;
        i5 = i9;
        i6 = 0;
      }
    }
    while (true)
    {
      if (SystemClock.uptimeMillis() <= l2)
      {
        if (localAdapter.getItemId(i5) == l1)
          break;
        if (i3 != i - 1)
          break label174;
        i7 = 1;
        label150: if (i4 != 0)
          break label180;
      }
      label174: label180: for (i8 = 1; ; i8 = 0)
      {
        if ((i7 == 0) || (i8 == 0))
          break label184;
        i5 = -1;
        break;
        i7 = 0;
        break label150;
      }
      label184: break label84;
      if ((i7 == 0) && ((i6 != 0) || (i8 != 0)))
        continue;
      int i10 = i4 - 1;
      int i4 = i10;
      i5 = i10;
      i6 = 1;
      continue;
      i3 = i2;
      i4 = i2;
      i5 = i2;
      i6 = 0;
    }
  }

  void i()
  {
    if (getChildCount() > 0)
    {
      this.p = true;
      this.o = this.a;
      if (this.y >= 0)
      {
        View localView2 = getChildAt(this.y - this.k);
        this.n = this.x;
        this.m = this.w;
        if (localView2 != null)
          this.l = localView2.getTop();
        this.q = 0;
      }
    }
    else
    {
      return;
    }
    View localView1 = getChildAt(0);
    Adapter localAdapter = getAdapter();
    if ((this.k >= 0) && (this.k < localAdapter.getCount()));
    for (this.n = localAdapter.getItemId(this.k); ; this.n = -1L)
    {
      this.m = this.k;
      if (localView1 != null)
        this.l = localView1.getTop();
      this.q = 1;
      break;
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.e);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = getHeight();
  }

  public void removeAllViews()
  {
    throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
  }

  public void removeView(View paramView)
  {
    throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
  }

  public void removeViewAt(int paramInt)
  {
    throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
  }

  public abstract void setAdapter(T paramT);

  public void setEmptyView(View paramView)
  {
    this.b = paramView;
    Adapter localAdapter = getAdapter();
    if ((localAdapter == null) || (localAdapter.isEmpty()));
    for (boolean bool = true; ; bool = false)
    {
      a(bool);
      return;
    }
  }

  public void setFocusable(boolean paramBoolean)
  {
    boolean bool1 = true;
    Adapter localAdapter = getAdapter();
    boolean bool2;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      bool2 = bool1;
      this.c = paramBoolean;
      if (!paramBoolean)
        this.d = false;
      if ((!paramBoolean) || ((bool2) && (!c())))
        break label65;
    }
    while (true)
    {
      super.setFocusable(bool1);
      return;
      bool2 = false;
      break;
      label65: bool1 = false;
    }
  }

  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    boolean bool1 = true;
    Adapter localAdapter = getAdapter();
    boolean bool2;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      bool2 = bool1;
      this.d = paramBoolean;
      if (paramBoolean)
        this.c = bool1;
      if ((!paramBoolean) || ((bool2) && (!c())))
        break label65;
    }
    while (true)
    {
      super.setFocusableInTouchMode(bool1);
      return;
      bool2 = false;
      break;
      label65: bool1 = false;
    }
  }

  void setNextSelectedPositionInt(int paramInt)
  {
    this.w = paramInt;
    this.x = a(paramInt);
    if ((this.p) && (this.q == 0) && (paramInt >= 0))
    {
      this.m = paramInt;
      this.n = this.x;
    }
  }

  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
  }

  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.t = paramOnItemClickListener;
  }

  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    if (!isLongClickable())
      setLongClickable(true);
    this.u = paramOnItemLongClickListener;
  }

  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.s = paramOnItemSelectedListener;
  }

  void setSelectedPositionInt(int paramInt)
  {
    this.y = paramInt;
    this.z = a(paramInt);
  }

  public abstract void setSelection(int paramInt);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     custom.android.AdapterView
 * JD-Core Version:    0.6.0
 */