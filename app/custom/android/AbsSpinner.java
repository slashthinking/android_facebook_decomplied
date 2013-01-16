package custom.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import com.facebook.R.styleable;

public abstract class AbsSpinner extends AdapterView<SpinnerAdapter>
{
  private DataSetObserver F;
  private Rect G;
  SpinnerAdapter a;
  int b;
  int c;
  boolean d;
  int e = 0;
  int f = 0;
  int g = 0;
  int h = 0;
  final Rect i = new Rect();
  final AbsSpinner.RecycleBin j = new AbsSpinner.RecycleBin(this);

  public AbsSpinner(Context paramContext)
  {
    super(paramContext);
    j();
  }

  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    j();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AbsSpinner, paramInt, 0);
    CharSequence[] arrayOfCharSequence = localTypedArray.getTextArray(0);
    if (arrayOfCharSequence != null)
    {
      ArrayAdapter localArrayAdapter = new ArrayAdapter(paramContext, 2130903556, arrayOfCharSequence);
      localArrayAdapter.setDropDownViewResource(2130903555);
      setAdapter(localArrayAdapter);
    }
    localTypedArray.recycle();
  }

  private void j()
  {
    setFocusable(true);
    setWillNotDraw(false);
  }

  public int a(int paramInt1, int paramInt2)
  {
    Rect localRect = this.G;
    if (localRect == null)
    {
      this.G = new Rect();
      localRect = this.G;
    }
    int k = -1 + getChildCount();
    if (k >= 0)
    {
      View localView = getChildAt(k);
      if (localView.getVisibility() == 0)
      {
        localView.getHitRect(localRect);
        if (!localRect.contains(paramInt1, paramInt2));
      }
    }
    for (int m = k + this.k; ; m = -1)
    {
      return m;
      k--;
      break;
    }
  }

  int a(View paramView)
  {
    return paramView.getMeasuredHeight();
  }

  void a()
  {
    this.v = false;
    this.p = false;
    removeAllViewsInLayout();
    this.C = -1;
    this.D = -9223372036854775808L;
    setSelectedPositionInt(-1);
    setNextSelectedPositionInt(-1);
    invalidate();
  }

  void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != this.C)
    {
      this.d = true;
      int k = paramInt - this.y;
      setNextSelectedPositionInt(paramInt);
      b(k, paramBoolean);
      this.d = false;
    }
  }

  int b(View paramView)
  {
    return paramView.getMeasuredWidth();
  }

  void b()
  {
    int k = getChildCount();
    AbsSpinner.RecycleBin localRecycleBin = this.j;
    int m = this.k;
    for (int n = 0; n < k; n++)
    {
      View localView = getChildAt(n);
      localRecycleBin.a(m + n, localView);
    }
  }

  abstract void b(int paramInt, boolean paramBoolean);

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }

  public SpinnerAdapter getAdapter()
  {
    return this.a;
  }

  public int getCount()
  {
    return this.A;
  }

  public View getSelectedView()
  {
    if ((this.A > 0) && (this.y >= 0));
    for (View localView = getChildAt(this.y - this.k); ; localView = null)
      return localView;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = getPaddingLeft();
    int n = getPaddingRight();
    int i1 = getPaddingBottom();
    int i2 = getPaddingTop();
    Rect localRect1 = this.i;
    int i3;
    label70: int i4;
    label96: int i5;
    label122: int i9;
    int i8;
    int i7;
    if (m > this.e)
    {
      localRect1.left = m;
      Rect localRect2 = this.i;
      if (i2 <= this.f)
        break label397;
      i3 = i2;
      localRect2.top = i3;
      Rect localRect3 = this.i;
      if (n <= this.g)
        break label406;
      i4 = n;
      localRect3.right = i4;
      Rect localRect4 = this.i;
      if (i1 <= this.h)
        break label415;
      i5 = i1;
      localRect4.bottom = i5;
      if (this.v)
        f();
      int i6 = getSelectedItemPosition();
      if ((i6 < 0) || (this.a == null))
        break label424;
      View localView = this.j.a();
      if (localView == null)
        localView = this.a.getView(i6, null, this);
      if (localView != null)
        this.j.a(localView);
      if (localView == null)
        break label424;
      if (localView.getLayoutParams() == null)
      {
        this.d = true;
        localView.setLayoutParams(generateDefaultLayoutParams());
        this.d = false;
      }
      measureChild(localView, paramInt1, paramInt2);
      i9 = a(localView) + this.i.top + this.i.bottom;
      i8 = b(localView) + this.i.left + this.i.right;
      i7 = 0;
    }
    while (true)
    {
      if (i7 != 0)
      {
        i9 = this.i.top + this.i.bottom;
        if (k == 0)
          i8 = this.i.left + this.i.right;
      }
      int i10 = Math.max(i9, getSuggestedMinimumHeight());
      int i11 = Math.max(i8, getSuggestedMinimumWidth());
      int i12 = resolveSize(i10, paramInt2);
      setMeasuredDimension(resolveSize(i11, paramInt1), i12);
      this.b = paramInt2;
      this.c = paramInt1;
      return;
      m = this.e;
      break;
      label397: i3 = this.f;
      break label70;
      label406: i4 = this.g;
      break label96;
      label415: i5 = this.h;
      break label122;
      label424: i7 = 1;
      i8 = 0;
      i9 = 0;
    }
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AbsSpinner.SavedState localSavedState = (AbsSpinner.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.a >= 0L)
    {
      this.v = true;
      this.p = true;
      this.n = localSavedState.a;
      this.m = localSavedState.b;
      this.q = 0;
      requestLayout();
    }
  }

  public Parcelable onSaveInstanceState()
  {
    AbsSpinner.SavedState localSavedState = new AbsSpinner.SavedState(super.onSaveInstanceState());
    localSavedState.a = getSelectedItemId();
    if (localSavedState.a >= 0L);
    for (localSavedState.b = getSelectedItemPosition(); ; localSavedState.b = -1)
      return localSavedState;
  }

  public void requestLayout()
  {
    if (!this.d)
      super.requestLayout();
  }

  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    int k = -1;
    if (this.a != null)
    {
      this.a.unregisterDataSetObserver(this.F);
      a();
    }
    this.a = paramSpinnerAdapter;
    this.C = k;
    this.D = -9223372036854775808L;
    if (this.a != null)
    {
      this.B = this.A;
      this.A = this.a.getCount();
      d();
      this.F = new AdapterView.AdapterDataSetObserver(this);
      this.a.registerDataSetObserver(this.F);
      if (this.A > 0)
        k = 0;
      setSelectedPositionInt(k);
      setNextSelectedPositionInt(k);
      if (this.A == 0)
        g();
    }
    while (true)
    {
      requestLayout();
      return;
      d();
      a();
      g();
    }
  }

  public void setSelection(int paramInt)
  {
    setNextSelectedPositionInt(paramInt);
    requestLayout();
    invalidate();
  }

  public void setSelection(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.k <= paramInt) && (paramInt <= -1 + (this.k + getChildCount())));
    for (boolean bool = true; ; bool = false)
    {
      a(paramInt, bool);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     custom.android.AbsSpinner
 * JD-Core Version:    0.6.0
 */