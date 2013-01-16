package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager extends ViewGroup
{
  private static final int[] a = { 16842931 };
  private static final Comparator<ViewPager.ItemInfo> b = new ViewPager.1();
  private static final Interpolator c = new ViewPager.2();
  private boolean A;
  private int B;
  private int C;
  private int D;
  private float E;
  private float F;
  private float G;
  private int H = -1;
  private VelocityTracker I;
  private int J;
  private int K;
  private int L;
  private int M;
  private boolean N;
  private long O;
  private EdgeEffectCompat P;
  private EdgeEffectCompat Q;
  private boolean R = true;
  private boolean S = false;
  private boolean T;
  private int U;
  private ViewPager.OnPageChangeListener V;
  private ViewPager.OnPageChangeListener W;
  private ViewPager.OnAdapterChangeListener Z;
  private int aa = 0;
  private final ArrayList<ViewPager.ItemInfo> d = new ArrayList();
  private final ViewPager.ItemInfo e = new ViewPager.ItemInfo();
  private final Rect f = new Rect();
  private PagerAdapter g;
  private int h;
  private int i = -1;
  private Parcelable j = null;
  private ClassLoader k = null;
  private Scroller l;
  private ViewPager.PagerObserver m;
  private int n;
  private Drawable o;
  private int p;
  private int q;
  private float r = -3.402824E+38F;
  private float s = 3.4028235E+38F;
  private int t;
  private int u;
  private boolean v;
  private boolean w;
  private boolean x;
  private int y = 1;
  private boolean z;

  public ViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.L) && (Math.abs(paramInt2) > this.J))
      if (paramInt2 <= 0);
    while (true)
    {
      if (this.d.size() > 0)
      {
        ViewPager.ItemInfo localItemInfo1 = (ViewPager.ItemInfo)this.d.get(0);
        ViewPager.ItemInfo localItemInfo2 = (ViewPager.ItemInfo)this.d.get(-1 + this.d.size());
        paramInt1 = Math.max(localItemInfo1.b, Math.min(paramInt1, localItemInfo2.b));
      }
      return paramInt1;
      paramInt1++;
      continue;
      paramInt1 = (int)(0.5F + (paramFloat + paramInt1));
    }
  }

  private Rect a(Rect paramRect, View paramView)
  {
    if (paramRect == null);
    for (Rect localRect1 = new Rect(); ; localRect1 = paramRect)
    {
      if (paramView == null)
        localRect1.set(0, 0, 0, 0);
      for (Rect localRect2 = localRect1; ; localRect2 = localRect1)
      {
        return localRect2;
        localRect1.left = paramView.getLeft();
        localRect1.right = paramView.getRight();
        localRect1.top = paramView.getTop();
        localRect1.bottom = paramView.getBottom();
        ViewGroup localViewGroup;
        for (ViewParent localViewParent = paramView.getParent(); ((localViewParent instanceof ViewGroup)) && (localViewParent != this); localViewParent = localViewGroup.getParent())
        {
          localViewGroup = (ViewGroup)localViewParent;
          localRect1.left += localViewGroup.getLeft();
          localRect1.right += localViewGroup.getRight();
          localRect1.top += localViewGroup.getTop();
          localRect1.bottom += localViewGroup.getBottom();
        }
      }
    }
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.d.isEmpty()))
    {
      int i2 = paramInt1 + paramInt3;
      int i3 = paramInt2 + paramInt4;
      int i4 = (int)(getScrollX() / i3 * i2);
      scrollTo(i4, getScrollY());
      if (!this.l.isFinished())
      {
        int i5 = this.l.getDuration() - this.l.timePassed();
        ViewPager.ItemInfo localItemInfo2 = b(this.h);
        this.l.startScroll(i4, 0, (int)(localItemInfo2.e * paramInt1), 0, i5);
      }
      return;
    }
    ViewPager.ItemInfo localItemInfo1 = b(this.h);
    float f1;
    if (localItemInfo1 != null)
      f1 = Math.min(localItemInfo1.e, this.s);
    while (true)
    {
      int i1 = (int)(f1 * paramInt1);
      if (i1 == getScrollX())
        break;
      k();
      scrollTo(i1, getScrollY());
      break;
      f1 = 0.0F;
    }
  }

  private void a(ViewPager.ItemInfo paramItemInfo1, int paramInt, ViewPager.ItemInfo paramItemInfo2)
  {
    int i1 = this.g.b();
    int i2 = getWidth();
    float f1;
    int i12;
    float f9;
    int i15;
    int i16;
    if (i2 > 0)
    {
      f1 = this.n / i2;
      if (paramItemInfo2 == null)
        break label371;
      i12 = paramItemInfo2.b;
      if (i12 < paramItemInfo1.b)
      {
        f9 = f1 + (paramItemInfo2.e + paramItemInfo2.d);
        i15 = i12 + 1;
        i16 = 0;
      }
    }
    else
    {
      while (true)
      {
        if ((i15 > paramItemInfo1.b) || (i16 >= this.d.size()))
          break label371;
        ViewPager.ItemInfo localItemInfo4 = (ViewPager.ItemInfo)this.d.get(i16);
        while (true)
          if ((i15 > localItemInfo4.b) && (i16 < -1 + this.d.size()))
          {
            i16++;
            localItemInfo4 = (ViewPager.ItemInfo)this.d.get(i16);
            continue;
            f1 = 0.0F;
            break;
          }
        while (i15 < localItemInfo4.b)
        {
          f9 += f1 + this.g.d(i15);
          i15++;
        }
        localItemInfo4.e = f9;
        f9 += f1 + localItemInfo4.d;
        i15++;
      }
    }
    if (i12 > paramItemInfo1.b)
    {
      int i13 = -1 + this.d.size();
      float f8 = paramItemInfo2.e;
      for (int i14 = i12 - 1; (i14 >= paramItemInfo1.b) && (i13 >= 0); i14--)
      {
        for (ViewPager.ItemInfo localItemInfo3 = (ViewPager.ItemInfo)this.d.get(i13); (i14 < localItemInfo3.b) && (i13 > 0); localItemInfo3 = (ViewPager.ItemInfo)this.d.get(i13))
          i13--;
        while (i14 > localItemInfo3.b)
        {
          f8 -= f1 + this.g.d(i14);
          i14--;
        }
        f8 -= f1 + localItemInfo3.d;
        localItemInfo3.e = f8;
      }
    }
    label371: int i3 = this.d.size();
    float f2 = paramItemInfo1.e;
    int i4 = -1 + paramItemInfo1.b;
    float f3;
    float f4;
    if (paramItemInfo1.b == 0)
    {
      f3 = paramItemInfo1.e;
      this.r = f3;
      if (paramItemInfo1.b != i1 - 1)
        break label522;
      f4 = paramItemInfo1.e + paramItemInfo1.d - 1.0F;
      label437: this.s = f4;
    }
    label522: int i10;
    for (int i5 = paramInt - 1; ; i5 = i10)
    {
      if (i5 < 0)
        break label579;
      ViewPager.ItemInfo localItemInfo2 = (ViewPager.ItemInfo)this.d.get(i5);
      float f7 = f2;
      while (true)
        if (i4 > localItemInfo2.b)
        {
          PagerAdapter localPagerAdapter2 = this.g;
          int i11 = i4 - 1;
          f7 -= f1 + localPagerAdapter2.d(i4);
          i4 = i11;
          continue;
          f3 = -3.402824E+38F;
          break;
          f4 = 3.4028235E+38F;
          break label437;
        }
      f2 = f7 - (f1 + localItemInfo2.d);
      localItemInfo2.e = f2;
      if (localItemInfo2.b == 0)
        this.r = f2;
      i10 = i5 - 1;
      i4--;
    }
    label579: float f5 = f1 + (paramItemInfo1.e + paramItemInfo1.d);
    int i6 = 1 + paramItemInfo1.b;
    int i8;
    for (int i7 = paramInt + 1; i7 < i3; i7 = i8)
    {
      ViewPager.ItemInfo localItemInfo1 = (ViewPager.ItemInfo)this.d.get(i7);
      float f6 = f5;
      while (i6 < localItemInfo1.b)
      {
        PagerAdapter localPagerAdapter1 = this.g;
        int i9 = i6 + 1;
        f6 += f1 + localPagerAdapter1.d(i6);
        i6 = i9;
      }
      if (localItemInfo1.b == i1 - 1)
        this.s = (f6 + localItemInfo1.d - 1.0F);
      localItemInfo1.e = f6;
      f5 = f6 + (f1 + localItemInfo1.d);
      i8 = i7 + 1;
      i6++;
    }
    this.S = false;
  }

  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.a(paramMotionEvent);
    if (MotionEventCompat.b(paramMotionEvent, i1) == this.H)
      if (i1 != 0)
        break label56;
    label56: for (int i2 = 1; ; i2 = 0)
    {
      this.F = MotionEventCompat.c(paramMotionEvent, i2);
      this.H = MotionEventCompat.b(paramMotionEvent, i2);
      if (this.I != null)
        this.I.clear();
      return;
    }
  }

  private boolean a(float paramFloat1, float paramFloat2)
  {
    if (((paramFloat1 < this.C) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.C) && (paramFloat2 < 0.0F)));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private boolean c(float paramFloat)
  {
    int i1 = 1;
    float f1 = this.F - paramFloat;
    this.F = paramFloat;
    float f2 = f1 + getScrollX();
    int i2 = getWidth();
    float f3 = i2 * this.r;
    float f4 = i2 * this.s;
    ViewPager.ItemInfo localItemInfo1 = (ViewPager.ItemInfo)this.d.get(0);
    ViewPager.ItemInfo localItemInfo2 = (ViewPager.ItemInfo)this.d.get(-1 + this.d.size());
    if (localItemInfo1.b != 0)
      f3 = localItemInfo1.e * i2;
    for (int i3 = 0; ; i3 = i1)
    {
      float f5;
      if (localItemInfo2.b != -1 + this.g.b())
      {
        f5 = localItemInfo2.e * i2;
        i1 = 0;
      }
      while (true)
      {
        boolean bool;
        if (f2 < f3)
        {
          bool = false;
          if (i3 != 0)
          {
            float f6 = f3 - f2;
            bool = this.P.a(Math.abs(f6) / i2);
          }
        }
        while (true)
        {
          this.F += f3 - (int)f3;
          scrollTo((int)f3, getScrollY());
          d((int)f3);
          return bool;
          if (f2 > f5)
          {
            bool = false;
            if (i1 != 0)
            {
              float f7 = f2 - f5;
              bool = this.Q.a(Math.abs(f7) / i2);
            }
            f3 = f5;
            continue;
          }
          f3 = f2;
          bool = false;
        }
        f5 = f4;
      }
    }
  }

  private boolean d(int paramInt)
  {
    int i5;
    if (this.d.size() == 0)
    {
      this.T = false;
      a(0, 0.0F, 0);
      boolean bool = this.T;
      i5 = 0;
      if (!bool)
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    else
    {
      ViewPager.ItemInfo localItemInfo = l();
      int i1 = getWidth();
      int i2 = i1 + this.n;
      float f1 = this.n / i1;
      int i3 = localItemInfo.b;
      float f2 = (paramInt / i1 - localItemInfo.e) / (f1 + localItemInfo.d);
      int i4 = (int)(f2 * i2);
      this.T = false;
      a(i3, f2, i4);
      if (!this.T)
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      i5 = 1;
    }
    return i5;
  }

  private void j()
  {
    for (int i1 = 0; i1 < getChildCount(); i1++)
    {
      if (((ViewPager.LayoutParams)getChildAt(i1).getLayoutParams()).a)
        continue;
      removeViewAt(i1);
      i1--;
    }
  }

  private void k()
  {
    if (this.aa == 2);
    int i3;
    for (int i1 = 1; ; i1 = 0)
    {
      if (i1 != 0)
      {
        setScrollingCacheEnabled(false);
        this.l.abortAnimation();
        int i4 = getScrollX();
        int i5 = getScrollY();
        int i6 = this.l.getCurrX();
        int i7 = this.l.getCurrY();
        if ((i4 != i6) || (i5 != i7))
          scrollTo(i6, i7);
        setScrollState(0);
      }
      this.x = false;
      int i2 = 0;
      i3 = i1;
      while (i2 < this.d.size())
      {
        ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.d.get(i2);
        if (localItemInfo.c)
        {
          localItemInfo.c = false;
          i3 = 1;
        }
        i2++;
      }
    }
    if (i3 != 0)
      c();
  }

  private ViewPager.ItemInfo l()
  {
    int i1 = getWidth();
    float f1;
    float f2;
    label31: float f3;
    float f4;
    int i2;
    int i3;
    int i4;
    Object localObject;
    label49: ViewPager.ItemInfo localItemInfo1;
    ViewPager.ItemInfo localItemInfo3;
    int i5;
    if (i1 > 0)
    {
      f1 = getScrollX() / i1;
      if (i1 <= 0)
        break label210;
      f2 = this.n / i1;
      f3 = 0.0F;
      f4 = 0.0F;
      i2 = -1;
      i3 = 0;
      i4 = 1;
      localObject = null;
      if (i3 < this.d.size())
      {
        localItemInfo1 = (ViewPager.ItemInfo)this.d.get(i3);
        if ((i4 != 0) || (localItemInfo1.b == i2 + 1))
          break label261;
        localItemInfo3 = this.e;
        localItemInfo3.e = (f2 + (f3 + f4));
        localItemInfo3.b = (i2 + 1);
        localItemInfo3.d = this.g.d(localItemInfo3.b);
        i5 = i3 - 1;
      }
    }
    for (ViewPager.ItemInfo localItemInfo2 = localItemInfo3; ; localItemInfo2 = localItemInfo1)
    {
      float f5 = localItemInfo2.e;
      float f6 = f2 + (f5 + localItemInfo2.d);
      if ((i4 != 0) || (f1 >= f5))
      {
        if ((f1 < f6) || (i5 == -1 + this.d.size()))
          localObject = localItemInfo2;
      }
      else
      {
        return localObject;
        f1 = 0.0F;
        break;
        label210: f2 = 0.0F;
        break label31;
      }
      int i6 = localItemInfo2.b;
      float f7 = localItemInfo2.d;
      int i7 = i5 + 1;
      f4 = f5;
      i2 = i6;
      f3 = f7;
      localObject = localItemInfo2;
      i3 = i7;
      i4 = 0;
      break label49;
      label261: i5 = i3;
    }
  }

  private void m()
  {
    this.z = false;
    this.A = false;
    if (this.I != null)
    {
      this.I.recycle();
      this.I = null;
    }
  }

  private void setScrollState(int paramInt)
  {
    if (this.aa == paramInt);
    while (true)
    {
      return;
      this.aa = paramInt;
      if (this.V == null)
        continue;
      this.V.b(paramInt);
    }
  }

  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.w != paramBoolean)
      this.w = paramBoolean;
  }

  float a(float paramFloat)
  {
    return (float)Math.sin((float)(0.47123891676382D * (paramFloat - 0.5F)));
  }

  ViewPager.ItemInfo a(int paramInt1, int paramInt2)
  {
    ViewPager.ItemInfo localItemInfo = new ViewPager.ItemInfo();
    localItemInfo.b = paramInt1;
    localItemInfo.a = this.g.a(this, paramInt1);
    localItemInfo.d = this.g.d(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.d.size()))
      this.d.add(localItemInfo);
    while (true)
    {
      return localItemInfo;
      this.d.add(paramInt2, localItemInfo);
    }
  }

  ViewPager.ItemInfo a(View paramView)
  {
    int i1 = 0;
    ViewPager.ItemInfo localItemInfo;
    if (i1 < this.d.size())
    {
      localItemInfo = (ViewPager.ItemInfo)this.d.get(i1);
      if (!this.g.a(paramView, localItemInfo.a));
    }
    while (true)
    {
      return localItemInfo;
      i1++;
      break;
      localItemInfo = null;
    }
  }

  ViewPager.OnPageChangeListener a(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.W;
    this.W = paramOnPageChangeListener;
    return localOnPageChangeListener;
  }

  void a()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.l = new Scroller(localContext, c);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    this.D = ViewConfigurationCompat.a(localViewConfiguration);
    this.J = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.K = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.P = new EdgeEffectCompat(localContext);
    this.Q = new EdgeEffectCompat(localContext);
    float f1 = localContext.getResources().getDisplayMetrics().density;
    this.L = (int)(25.0F * f1);
    this.M = (int)(2.0F * f1);
    this.B = (int)(f1 * 16.0F);
    ViewCompat.a(this, new ViewPager.MyAccessibilityDelegate(this));
    if (ViewCompat.c(this) == 0)
      ViewCompat.b(this, 1);
  }

  void a(int paramInt)
  {
    ViewPager.ItemInfo localItemInfo12;
    if (this.h != paramInt)
    {
      localItemInfo12 = b(this.h);
      this.h = paramInt;
    }
    for (ViewPager.ItemInfo localItemInfo1 = localItemInfo12; ; localItemInfo1 = null)
    {
      if (this.g == null)
        label33: return;
      int i2;
      int i3;
      int i4;
      int i5;
      ViewPager.ItemInfo localItemInfo2;
      if ((!this.x) && (getWindowToken() != null))
      {
        this.g.a(this);
        int i1 = this.y;
        i2 = Math.max(0, this.h - i1);
        i3 = this.g.b();
        i4 = Math.min(i3 - 1, i1 + this.h);
        i5 = 0;
        if (i5 >= this.d.size())
          break label1065;
        localItemInfo2 = (ViewPager.ItemInfo)this.d.get(i5);
        if (localItemInfo2.b >= this.h)
          if (localItemInfo2.b != this.h)
            break label1065;
      }
      while (true)
      {
        if ((localItemInfo2 == null) && (i3 > 0));
        for (ViewPager.ItemInfo localItemInfo3 = a(this.h, i5); ; localItemInfo3 = localItemInfo2)
        {
          ViewPager.ItemInfo localItemInfo7;
          label202: float f2;
          int i12;
          int i13;
          int i14;
          float f3;
          int i15;
          if (localItemInfo3 != null)
          {
            int i10 = i5 - 1;
            if (i10 < 0)
              break label489;
            localItemInfo7 = (ViewPager.ItemInfo)this.d.get(i10);
            float f1 = 2.0F - localItemInfo3.d;
            int i11 = -1 + this.h;
            f2 = 0.0F;
            i12 = i11;
            i13 = i5;
            i14 = i10;
            if (i12 >= 0)
            {
              if ((f2 < f1) || (i12 >= i2))
                break label575;
              if (localItemInfo7 != null)
                break label495;
            }
            f3 = localItemInfo3.d;
            i15 = i13 + 1;
            if (f3 < 2.0F)
              if (i15 >= this.d.size())
                break label680;
          }
          float f4;
          int i17;
          int i18;
          label325: Object localObject1;
          label384: label680: for (Object localObject2 = (ViewPager.ItemInfo)this.d.get(i15); ; localObject2 = null)
          {
            int i16 = 1 + this.h;
            f4 = f3;
            i17 = i15;
            i18 = i16;
            if (i18 < i3)
            {
              if ((f4 < 2.0F) || (i18 <= i4))
                break label791;
              if (localObject2 != null)
                break label686;
            }
            a(localItemInfo3, i13, localItemInfo1);
            PagerAdapter localPagerAdapter = this.g;
            int i6 = this.h;
            if (localItemInfo3 == null)
              break label928;
            localObject1 = localItemInfo3.a;
            localPagerAdapter.b(this, i6, localObject1);
            this.g.b(this);
            int i7 = getChildCount();
            for (int i8 = 0; i8 < i7; i8++)
            {
              View localView3 = getChildAt(i8);
              ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)localView3.getLayoutParams();
              if ((localLayoutParams.a) || (localLayoutParams.c != 0.0F))
                continue;
              ViewPager.ItemInfo localItemInfo6 = a(localView3);
              if (localItemInfo6 == null)
                continue;
              localLayoutParams.c = localItemInfo6.d;
            }
            i5++;
            break;
            label489: localItemInfo7 = null;
            break label202;
            label495: if ((i12 == localItemInfo7.b) && (!localItemInfo7.c))
            {
              this.d.remove(i14);
              this.g.a(this, i12, localItemInfo7.a);
              i14--;
              i13--;
              if (i14 < 0)
                break label569;
              localItemInfo7 = (ViewPager.ItemInfo)this.d.get(i14);
            }
            while (true)
            {
              i12--;
              break;
              label569: localItemInfo7 = null;
              continue;
              label575: if ((localItemInfo7 != null) && (i12 == localItemInfo7.b))
              {
                f2 += localItemInfo7.d;
                i14--;
                if (i14 >= 0)
                {
                  localItemInfo7 = (ViewPager.ItemInfo)this.d.get(i14);
                  continue;
                }
                localItemInfo7 = null;
                continue;
              }
              f2 += a(i12, i14 + 1).d;
              i13++;
              if (i14 >= 0)
              {
                localItemInfo7 = (ViewPager.ItemInfo)this.d.get(i14);
                continue;
              }
              localItemInfo7 = null;
            }
          }
          label686: ViewPager.ItemInfo localItemInfo11;
          label755: Object localObject3;
          float f6;
          if ((i18 == ((ViewPager.ItemInfo)localObject2).b) && (!((ViewPager.ItemInfo)localObject2).c))
          {
            this.d.remove(i17);
            this.g.a(this, i18, ((ViewPager.ItemInfo)localObject2).a);
            if (i17 < this.d.size())
            {
              localItemInfo11 = (ViewPager.ItemInfo)this.d.get(i17);
              float f10 = f4;
              localObject3 = localItemInfo11;
              f6 = f10;
            }
          }
          while (true)
          {
            i18++;
            float f7 = f6;
            localObject2 = localObject3;
            f4 = f7;
            break label325;
            localItemInfo11 = null;
            break label755;
            label791: if ((localObject2 != null) && (i18 == ((ViewPager.ItemInfo)localObject2).b))
            {
              float f8 = f4 + ((ViewPager.ItemInfo)localObject2).d;
              i17++;
              if (i17 < this.d.size());
              for (ViewPager.ItemInfo localItemInfo10 = (ViewPager.ItemInfo)this.d.get(i17); ; localItemInfo10 = null)
              {
                localObject3 = localItemInfo10;
                f6 = f8;
                break;
              }
            }
            ViewPager.ItemInfo localItemInfo8 = a(i18, i17);
            i17++;
            float f5 = f4 + localItemInfo8.d;
            if (i17 < this.d.size());
            for (ViewPager.ItemInfo localItemInfo9 = (ViewPager.ItemInfo)this.d.get(i17); ; localItemInfo9 = null)
            {
              localObject3 = localItemInfo9;
              f6 = f5;
              break;
            }
            label928: localObject1 = null;
            break label384;
            if (!hasFocus())
              break;
            View localView1 = findFocus();
            if (localView1 != null);
            for (ViewPager.ItemInfo localItemInfo4 = b(localView1); ; localItemInfo4 = null)
            {
              if ((localItemInfo4 != null) && (localItemInfo4.b == this.h))
                break label1041;
              for (int i9 = 0; ; i9++)
              {
                if (i9 >= getChildCount())
                  break label1035;
                View localView2 = getChildAt(i9);
                ViewPager.ItemInfo localItemInfo5 = a(localView2);
                if ((localItemInfo5 != null) && (localItemInfo5.b == this.h) && (localView2.requestFocus(2)))
                  break;
              }
              label1035: break label33;
            }
            label1041: break label33;
            break label33;
            float f9 = f4;
            localObject3 = localObject2;
            f6 = f9;
          }
        }
        label1065: localItemInfo2 = null;
      }
    }
  }

  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.U > 0)
    {
      int i1 = getScrollX();
      int i2 = getPaddingLeft();
      int i3 = getPaddingRight();
      int i4 = getWidth();
      int i5 = getChildCount();
      int i6 = 0;
      while (i6 < i5)
      {
        View localView = getChildAt(i6);
        ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
        int i9;
        int i10;
        if (!localLayoutParams.a)
        {
          int i17 = i3;
          i9 = i2;
          i10 = i17;
          i6++;
          int i12 = i10;
          i2 = i9;
          i3 = i12;
          continue;
        }
        int i7;
        switch (0x7 & localLayoutParams.b)
        {
        case 2:
        case 4:
        default:
          i7 = i2;
          int i16 = i3;
          i9 = i2;
          i10 = i16;
        case 3:
        case 1:
        case 5:
        }
        while (true)
        {
          int i11 = i7 + i1 - localView.getLeft();
          if (i11 == 0)
            break;
          localView.offsetLeftAndRight(i11);
          break;
          int i14 = i2 + localView.getWidth();
          int i15 = i2;
          i10 = i3;
          i9 = i14;
          i7 = i15;
          continue;
          i7 = Math.max((i4 - localView.getMeasuredWidth()) / 2, i2);
          int i13 = i3;
          i9 = i2;
          i10 = i13;
          continue;
          i7 = i4 - i3 - localView.getMeasuredWidth();
          int i8 = i3 + localView.getMeasuredWidth();
          i9 = i2;
          i10 = i8;
        }
      }
    }
    if (this.V != null)
      this.V.a(paramInt1, paramFloat, paramInt2);
    if (this.W != null)
      this.W.a(paramInt1, paramFloat, paramInt2);
    this.T = true;
  }

  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
      setScrollingCacheEnabled(false);
    int i1;
    int i2;
    int i3;
    int i4;
    while (true)
    {
      return;
      i1 = getScrollX();
      i2 = getScrollY();
      i3 = paramInt1 - i1;
      i4 = paramInt2 - i2;
      if ((i3 != 0) || (i4 != 0))
        break;
      k();
      c();
      setScrollState(0);
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    int i5 = getWidth();
    int i6 = i5 / 2;
    float f1 = Math.min(1.0F, 1.0F * Math.abs(i3) / i5);
    float f2 = i6 + i6 * a(f1);
    int i7 = Math.abs(paramInt3);
    if (i7 > 0);
    float f3;
    for (int i8 = 4 * Math.round(1000.0F * Math.abs(f2 / i7)); ; i8 = (int)(100.0F * (1.0F + Math.abs(i3) / (f3 + this.n))))
    {
      int i9 = Math.min(i8, 600);
      this.l.startScroll(i1, i2, i3, i4, i9);
      ViewCompat.b(this);
      break;
      f3 = i5 * this.g.d(this.h);
    }
  }

  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }

  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((this.g == null) || (this.g.b() <= 0))
      setScrollingCacheEnabled(false);
    while (true)
    {
      return;
      if ((paramBoolean2) || (this.h != paramInt1) || (this.d.size() == 0))
        break;
      setScrollingCacheEnabled(false);
    }
    if (paramInt1 < 0)
      paramInt1 = 0;
    while (true)
    {
      int i1 = this.y;
      if ((paramInt1 <= i1 + this.h) && (paramInt1 >= this.h - i1))
        break;
      for (int i2 = 0; i2 < this.d.size(); i2++)
        ((ViewPager.ItemInfo)this.d.get(i2)).c = true;
      if (paramInt1 < this.g.b())
        continue;
      paramInt1 = -1 + this.g.b();
    }
    int i3;
    label159: ViewPager.ItemInfo localItemInfo;
    if (this.h != paramInt1)
    {
      i3 = 1;
      a(paramInt1);
      localItemInfo = b(paramInt1);
      if (localItemInfo == null)
        break label328;
    }
    label328: for (int i4 = (int)(getWidth() * Math.max(this.r, Math.min(localItemInfo.e, this.s))); ; i4 = 0)
    {
      if (paramBoolean1)
      {
        a(i4, 0, paramInt2);
        if ((i3 != 0) && (this.V != null))
          this.V.a(paramInt1);
        if ((i3 == 0) || (this.W == null))
          break;
        this.W.a(paramInt1);
        break;
        i3 = 0;
        break label159;
      }
      if ((i3 != 0) && (this.V != null))
        this.V.a(paramInt1);
      if ((i3 != 0) && (this.W != null))
        this.W.a(paramInt1);
      k();
      scrollTo(i4, 0);
      break;
    }
  }

  public boolean a(KeyEvent paramKeyEvent)
  {
    int i1 = paramKeyEvent.getAction();
    boolean bool1 = false;
    if (i1 == 0)
    {
      int i2 = paramKeyEvent.getKeyCode();
      bool1 = false;
      switch (i2)
      {
      default:
      case 21:
      case 22:
      case 61:
      }
    }
    while (true)
    {
      return bool1;
      bool1 = c(17);
      continue;
      bool1 = c(66);
      continue;
      int i3 = Build.VERSION.SDK_INT;
      bool1 = false;
      if (i3 < 11)
        continue;
      if (KeyEventCompat.a(paramKeyEvent))
      {
        bool1 = c(2);
        continue;
      }
      boolean bool2 = KeyEventCompat.a(paramKeyEvent, 1);
      bool1 = false;
      if (!bool2)
        continue;
      bool1 = c(1);
    }
  }

  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    int i3;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i1 = paramView.getScrollX();
      int i2 = paramView.getScrollY();
      i3 = -1 + localViewGroup.getChildCount();
      if (i3 >= 0)
      {
        View localView = localViewGroup.getChildAt(i3);
        if ((paramInt2 + i1 < localView.getLeft()) || (paramInt2 + i1 >= localView.getRight()) || (paramInt3 + i2 < localView.getTop()) || (paramInt3 + i2 >= localView.getBottom()) || (!a(localView, bool, paramInt1, paramInt2 + i1 - localView.getLeft(), paramInt3 + i2 - localView.getTop())));
      }
    }
    while (true)
    {
      return bool;
      i3--;
      break;
      if ((paramBoolean) && (ViewCompat.a(paramView, -paramInt1)))
        continue;
      bool = false;
    }
  }

  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i1 = paramArrayList.size();
    int i2 = getDescendantFocusability();
    if (i2 != 393216)
      for (int i3 = 0; i3 < getChildCount(); i3++)
      {
        View localView = getChildAt(i3);
        if (localView.getVisibility() != 0)
          continue;
        ViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo == null) || (localItemInfo.b != this.h))
          continue;
        localView.addFocusables(paramArrayList, paramInt1, paramInt2);
      }
    if (((i2 == 262144) && (i1 != paramArrayList.size())) || (!isFocusable()));
    while (true)
    {
      return;
      if ((((paramInt2 & 0x1) != 1) || (!isInTouchMode()) || (isFocusableInTouchMode())) && (paramArrayList != null))
      {
        paramArrayList.add(this);
        continue;
      }
    }
  }

  public void addTouchables(ArrayList<View> paramArrayList)
  {
    for (int i1 = 0; i1 < getChildCount(); i1++)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() != 0)
        continue;
      ViewPager.ItemInfo localItemInfo = a(localView);
      if ((localItemInfo == null) || (localItemInfo.b != this.h))
        continue;
      localView.addTouchables(paramArrayList);
    }
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams));
    for (ViewGroup.LayoutParams localLayoutParams = generateLayoutParams(paramLayoutParams); ; localLayoutParams = paramLayoutParams)
    {
      ViewPager.LayoutParams localLayoutParams1 = (ViewPager.LayoutParams)localLayoutParams;
      localLayoutParams1.a |= paramView instanceof ViewPager.Decor;
      if (this.v)
      {
        if ((localLayoutParams1 != null) && (localLayoutParams1.a))
          throw new IllegalStateException("Cannot add pager decor view during layout");
        localLayoutParams1.d = true;
        addViewInLayout(paramView, paramInt, localLayoutParams);
      }
      while (true)
      {
        return;
        super.addView(paramView, paramInt, localLayoutParams);
      }
    }
  }

  ViewPager.ItemInfo b(int paramInt)
  {
    int i1 = 0;
    ViewPager.ItemInfo localItemInfo;
    if (i1 < this.d.size())
    {
      localItemInfo = (ViewPager.ItemInfo)this.d.get(i1);
      if (localItemInfo.b != paramInt);
    }
    while (true)
    {
      return localItemInfo;
      i1++;
      break;
      localItemInfo = null;
    }
  }

  ViewPager.ItemInfo b(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent != this)
      if ((localViewParent != null) && ((localViewParent instanceof View)));
    for (ViewPager.ItemInfo localItemInfo = null; ; localItemInfo = a(paramView))
    {
      return localItemInfo;
      paramView = (View)localViewParent;
      break;
    }
  }

  void b()
  {
    int i1;
    int i3;
    int i4;
    int i5;
    int i6;
    label53: ViewPager.ItemInfo localItemInfo;
    int i9;
    int i10;
    int i11;
    int i12;
    int i13;
    if ((this.d.size() < 1 + 2 * this.y) && (this.d.size() < this.g.b()))
    {
      i1 = 1;
      int i2 = this.h;
      i3 = 0;
      i4 = i2;
      i5 = i1;
      i6 = 0;
      if (i6 >= this.d.size())
        break label299;
      localItemInfo = (ViewPager.ItemInfo)this.d.get(i6);
      i9 = this.g.a(localItemInfo.a);
      if (i9 != -1)
        break label143;
      i10 = i6;
      i11 = i3;
      i12 = i4;
      i13 = i5;
    }
    while (true)
    {
      int i14 = i10 + 1;
      i5 = i13;
      i4 = i12;
      i3 = i11;
      i6 = i14;
      break label53;
      i1 = 0;
      break;
      label143: int i15;
      if (i9 == -2)
      {
        this.d.remove(i6);
        i15 = i6 - 1;
        if (i3 == 0)
        {
          this.g.a(this);
          i3 = 1;
        }
        this.g.a(this, localItemInfo.b, localItemInfo.a);
        if (this.h == localItemInfo.b)
        {
          int i16 = Math.max(0, Math.min(this.h, -1 + this.g.b()));
          i10 = i15;
          i11 = i3;
          i12 = i16;
          i13 = 1;
          continue;
        }
      }
      else
      {
        if (localItemInfo.b != i9)
        {
          if (localItemInfo.b == this.h)
            i4 = i9;
          localItemInfo.b = i9;
          i10 = i6;
          i11 = i3;
          i12 = i4;
          i13 = 1;
          continue;
          label299: if (i3 != 0)
            this.g.b(this);
          Collections.sort(this.d, b);
          if (i5 != 0)
          {
            int i7 = getChildCount();
            for (int i8 = 0; i8 < i7; i8++)
            {
              ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)getChildAt(i8).getLayoutParams();
              if (localLayoutParams.a)
                continue;
              localLayoutParams.c = 0.0F;
            }
            a(i4, false, true);
            requestLayout();
          }
          return;
        }
        i10 = i6;
        i11 = i3;
        i12 = i4;
        i13 = i5;
        continue;
      }
      i10 = i15;
      i11 = i3;
      i12 = i4;
      i13 = 1;
    }
  }

  public void b(float paramFloat)
  {
    if (!this.N)
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    this.F = (paramFloat + this.F);
    float f1 = getScrollX() - paramFloat;
    int i1 = getWidth();
    float f2 = i1 * this.r;
    float f3 = i1 * this.s;
    ViewPager.ItemInfo localItemInfo1 = (ViewPager.ItemInfo)this.d.get(0);
    ViewPager.ItemInfo localItemInfo2 = (ViewPager.ItemInfo)this.d.get(-1 + this.d.size());
    float f4;
    if (localItemInfo1.b != 0)
      f4 = localItemInfo1.e * i1;
    while (true)
    {
      float f5;
      if (localItemInfo2.b != -1 + this.g.b())
        f5 = localItemInfo2.e * i1;
      while (true)
      {
        if (f1 < f4);
        while (true)
        {
          this.F += f4 - (int)f4;
          scrollTo((int)f4, getScrollY());
          d((int)f4);
          long l1 = SystemClock.uptimeMillis();
          MotionEvent localMotionEvent = MotionEvent.obtain(this.O, l1, 2, this.F, 0.0F, 0);
          this.I.addMovement(localMotionEvent);
          localMotionEvent.recycle();
          return;
          if (f1 > f5)
          {
            f4 = f5;
            continue;
          }
          f4 = f1;
        }
        f5 = f3;
      }
      f4 = f2;
    }
  }

  void c()
  {
    a(this.h);
  }

  public boolean c(int paramInt)
  {
    View localView1 = findFocus();
    if (localView1 == this)
      localView1 = null;
    View localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    boolean bool;
    if ((localView2 != null) && (localView2 != localView1))
      if (paramInt == 17)
      {
        int i3 = a(this.f, localView2).left;
        int i4 = a(this.f, localView1).left;
        if ((localView1 != null) && (i3 >= i4))
          bool = g();
      }
    while (true)
    {
      if (bool)
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
      return bool;
      bool = localView2.requestFocus();
      continue;
      if (paramInt == 66)
      {
        int i1 = a(this.f, localView2).left;
        int i2 = a(this.f, localView1).left;
        if ((localView1 != null) && (i1 <= i2))
        {
          bool = h();
          continue;
        }
        bool = localView2.requestFocus();
        continue;
        if ((paramInt == 17) || (paramInt == 1))
        {
          bool = g();
          continue;
        }
        if ((paramInt == 66) || (paramInt == 2))
        {
          bool = h();
          continue;
        }
      }
      bool = false;
    }
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (((paramLayoutParams instanceof ViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams)));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void computeScroll()
  {
    if ((!this.l.isFinished()) && (this.l.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.l.getCurrX();
      int i4 = this.l.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        if (!d(i3))
        {
          this.l.abortAnimation();
          scrollTo(0, i4);
        }
      }
      ViewCompat.b(this);
    }
    while (true)
    {
      return;
      k();
    }
  }

  public boolean d()
  {
    boolean bool = this.z;
    int i1 = 0;
    if (bool)
      return i1;
    this.N = true;
    setScrollState(1);
    this.F = 0.0F;
    this.E = 0.0F;
    if (this.I == null)
      this.I = VelocityTracker.obtain();
    while (true)
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
      this.I.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      this.O = l1;
      i1 = 1;
      break;
      this.I.clear();
    }
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent)));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    int i1 = getChildCount();
    for (int i2 = 0; ; i2++)
    {
      int i3 = 0;
      if (i2 < i1)
      {
        View localView = getChildAt(i2);
        if (localView.getVisibility() != 0)
          continue;
        ViewPager.ItemInfo localItemInfo = a(localView);
        if ((localItemInfo == null) || (localItemInfo.b != this.h) || (!localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent)))
          continue;
        i3 = 1;
      }
      return i3;
    }
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i1 = ViewCompat.a(this);
    boolean bool2;
    if ((i1 == 0) || ((i1 == 1) && (this.g != null) && (this.g.b() > 1)))
    {
      boolean bool1 = this.P.a();
      bool2 = false;
      if (!bool1)
      {
        int i5 = paramCanvas.save();
        int i6 = getHeight() - getPaddingTop() - getPaddingBottom();
        int i7 = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i6 + getPaddingTop(), this.r * i7);
        this.P.a(i6, i7);
        bool2 = false | this.P.a(paramCanvas);
        paramCanvas.restoreToCount(i5);
      }
      if (!this.Q.a())
      {
        int i2 = paramCanvas.save();
        int i3 = getWidth();
        int i4 = getHeight() - getPaddingTop() - getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(1.0F + this.s) * i3);
        this.Q.a(i4, i3);
        bool2 |= this.Q.a(paramCanvas);
        paramCanvas.restoreToCount(i2);
      }
    }
    while (true)
    {
      if (bool2)
        ViewCompat.b(this);
      return;
      this.P.b();
      this.Q.b();
      bool2 = false;
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.o;
    if ((localDrawable != null) && (localDrawable.isStateful()))
      localDrawable.setState(getDrawableState());
  }

  public void e()
  {
    if (!this.N)
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    VelocityTracker localVelocityTracker = this.I;
    localVelocityTracker.computeCurrentVelocity(1000, this.K);
    int i1 = (int)VelocityTrackerCompat.a(localVelocityTracker, this.H);
    this.x = true;
    int i2 = getWidth();
    int i3 = getScrollX();
    ViewPager.ItemInfo localItemInfo = l();
    a(a(localItemInfo.b, (i3 / i2 - localItemInfo.e) / localItemInfo.d, i1, (int)(this.F - this.E)), true, true, i1);
    m();
    this.N = false;
  }

  public boolean f()
  {
    return this.N;
  }

  boolean g()
  {
    boolean bool = true;
    if (this.h > 0)
      setCurrentItem(-1 + this.h, bool);
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewPager.LayoutParams();
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewPager.LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }

  public PagerAdapter getAdapter()
  {
    return this.g;
  }

  public int getCurrentItem()
  {
    return this.h;
  }

  public int getOffscreenPageLimit()
  {
    return this.y;
  }

  public int getPageMargin()
  {
    return this.n;
  }

  boolean h()
  {
    boolean bool = true;
    if ((this.g != null) && (this.h < -1 + this.g.b()))
      setCurrentItem(1 + this.h, bool);
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.R = true;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1;
    int i2;
    float f1;
    ViewPager.ItemInfo localItemInfo;
    float f2;
    int i3;
    int i4;
    int i5;
    int i6;
    if ((this.n > 0) && (this.o != null) && (this.d.size() > 0) && (this.g != null))
    {
      i1 = getScrollX();
      i2 = getWidth();
      f1 = this.n / i2;
      localItemInfo = (ViewPager.ItemInfo)this.d.get(0);
      f2 = localItemInfo.e;
      i3 = this.d.size();
      i4 = localItemInfo.b;
      i5 = ((ViewPager.ItemInfo)this.d.get(i3 - 1)).b;
      i6 = 0;
    }
    for (int i7 = i4; ; i7++)
    {
      float f4;
      if (i7 < i5)
      {
        while ((i7 > localItemInfo.b) && (i6 < i3))
        {
          ArrayList localArrayList = this.d;
          i6++;
          localItemInfo = (ViewPager.ItemInfo)localArrayList.get(i6);
        }
        if (i7 != localItemInfo.b)
          break label271;
        f4 = (localItemInfo.e + localItemInfo.d) * i2;
        f2 = f1 + (localItemInfo.e + localItemInfo.d);
      }
      while (true)
      {
        if (f4 + this.n > i1)
        {
          this.o.setBounds((int)f4, this.p, (int)(0.5F + (f4 + this.n)), this.q);
          this.o.draw(paramCanvas);
        }
        if (f4 <= i1 + i2)
          break;
        return;
        label271: float f3 = this.g.d(i7);
        f4 = (f2 + f3) * i2;
        f2 += f3 + f1;
      }
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = 0xFF & paramMotionEvent.getAction();
    boolean bool1;
    if ((i1 == 3) || (i1 == 1))
    {
      this.z = false;
      this.A = false;
      this.H = -1;
      VelocityTracker localVelocityTracker = this.I;
      bool1 = false;
      if (localVelocityTracker != null)
      {
        this.I.recycle();
        this.I = null;
      }
    }
    boolean bool2;
    do
    {
      while (true)
      {
        return bool1;
        if (i1 == 0)
          break label92;
        if (!this.z)
          break;
        bool1 = true;
      }
      bool2 = this.A;
      bool1 = false;
    }
    while (bool2);
    label92: switch (i1)
    {
    default:
    case 2:
    case 0:
    case 6:
    }
    while (true)
    {
      if (this.I == null)
        this.I = VelocityTracker.obtain();
      this.I.addMovement(paramMotionEvent);
      bool1 = this.z;
      break;
      int i2 = this.H;
      if (i2 == -1)
        continue;
      int i3 = MotionEventCompat.a(paramMotionEvent, i2);
      float f2 = MotionEventCompat.c(paramMotionEvent, i3);
      float f3 = f2 - this.F;
      float f4 = Math.abs(f3);
      float f5 = MotionEventCompat.d(paramMotionEvent, i3);
      float f6 = Math.abs(f5 - this.G);
      if ((f3 != 0.0F) && (!a(this.F, f3)) && (a(this, false, (int)f3, (int)f2, (int)f5)))
      {
        this.F = f2;
        this.E = f2;
        this.G = f5;
        this.A = true;
        bool1 = false;
        break;
      }
      float f7;
      if ((f4 > this.D) && (f4 > f6))
      {
        this.z = true;
        setScrollState(1);
        if (f3 > 0.0F)
        {
          f7 = this.E + this.D;
          label338: this.F = f7;
          setScrollingCacheEnabled(true);
        }
      }
      while ((this.z) && (c(f2)))
      {
        ViewCompat.b(this);
        break;
        f7 = this.E - this.D;
        break label338;
        if (f6 <= this.D)
          continue;
        this.A = true;
      }
      float f1 = paramMotionEvent.getX();
      this.E = f1;
      this.F = f1;
      this.G = paramMotionEvent.getY();
      this.H = MotionEventCompat.b(paramMotionEvent, 0);
      this.A = false;
      this.l.computeScrollOffset();
      if ((this.aa == 2) && (Math.abs(this.l.getFinalX() - this.l.getCurrX()) > this.M))
      {
        this.l.abortAnimation();
        this.x = false;
        c();
        this.z = true;
        setScrollState(1);
        continue;
      }
      k();
      this.z = false;
      continue;
      a(paramMotionEvent);
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.v = true;
    c();
    this.v = false;
    int i1 = getChildCount();
    int i2 = paramInt3 - paramInt1;
    int i3 = paramInt4 - paramInt2;
    int i4 = getPaddingLeft();
    int i5 = getPaddingTop();
    int i6 = getPaddingRight();
    int i7 = getPaddingBottom();
    int i8 = getScrollX();
    int i9 = 0;
    int i10 = 0;
    View localView2;
    int i20;
    label172: int i21;
    int i23;
    int i24;
    label224: int i13;
    int i14;
    int i15;
    if (i10 < i1)
    {
      localView2 = getChildAt(i10);
      if (localView2.getVisibility() == 8)
        break label653;
      ViewPager.LayoutParams localLayoutParams2 = (ViewPager.LayoutParams)localView2.getLayoutParams();
      if (!localLayoutParams2.a)
        break label653;
      int i17 = 0x7 & localLayoutParams2.b;
      int i18 = 0x70 & localLayoutParams2.b;
      switch (i17)
      {
      case 2:
      case 4:
      default:
        i20 = i4;
        switch (i18)
        {
        default:
          i21 = i5;
          int i29 = i7;
          i23 = i5;
          i24 = i29;
          int i25 = i20 + i8;
          localView2.layout(i25, i21, i25 + localView2.getMeasuredWidth(), i21 + localView2.getMeasuredHeight());
          i13 = i9 + 1;
          i14 = i23;
          i7 = i24;
          i15 = i6;
        case 48:
        case 16:
        case 80:
        }
      case 3:
      case 1:
      case 5:
      }
    }
    for (int i16 = i4; ; i16 = i4)
    {
      i10++;
      i4 = i16;
      i6 = i15;
      i5 = i14;
      i9 = i13;
      break;
      int i30 = i4 + localView2.getMeasuredWidth();
      i20 = i4;
      i4 = i30;
      break label172;
      i20 = Math.max((i2 - localView2.getMeasuredWidth()) / 2, i4);
      break label172;
      int i19 = i2 - i6 - localView2.getMeasuredWidth();
      i6 += localView2.getMeasuredWidth();
      i20 = i19;
      break label172;
      int i27 = i5 + localView2.getMeasuredHeight();
      int i28 = i5;
      i24 = i7;
      i23 = i27;
      i21 = i28;
      break label224;
      i21 = Math.max((i3 - localView2.getMeasuredHeight()) / 2, i5);
      int i26 = i7;
      i23 = i5;
      i24 = i26;
      break label224;
      i21 = i3 - i7 - localView2.getMeasuredHeight();
      int i22 = i7 + localView2.getMeasuredHeight();
      i23 = i5;
      i24 = i22;
      break label224;
      for (int i11 = 0; i11 < i1; i11++)
      {
        View localView1 = getChildAt(i11);
        if (localView1.getVisibility() == 8)
          continue;
        ViewPager.LayoutParams localLayoutParams1 = (ViewPager.LayoutParams)localView1.getLayoutParams();
        if (localLayoutParams1.a)
          continue;
        ViewPager.ItemInfo localItemInfo = a(localView1);
        if (localItemInfo == null)
          continue;
        int i12 = i4 + (int)(i2 * localItemInfo.e);
        if (localLayoutParams1.d)
        {
          localLayoutParams1.d = false;
          localView1.measure(View.MeasureSpec.makeMeasureSpec((int)((i2 - i4 - i6) * localLayoutParams1.c), 1073741824), View.MeasureSpec.makeMeasureSpec(i3 - i5 - i7, 1073741824));
        }
        localView1.layout(i12, i5, i12 + localView1.getMeasuredWidth(), i5 + localView1.getMeasuredHeight());
      }
      this.p = i5;
      this.q = (i3 - i7);
      this.U = i9;
      this.R = false;
      return;
      label653: i13 = i9;
      i14 = i5;
      i15 = i6;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    int i1 = getMeasuredWidth();
    this.C = Math.min(i1 / 10, this.B);
    int i2 = i1 - getPaddingLeft() - getPaddingRight();
    int i3 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i4 = getChildCount();
    int i5 = 0;
    View localView2;
    ViewPager.LayoutParams localLayoutParams2;
    int i10;
    int i11;
    int i12;
    label167: int i13;
    label182: label192: int i14;
    int i15;
    if (i5 < i4)
    {
      localView2 = getChildAt(i5);
      if (localView2.getVisibility() != 8)
      {
        localLayoutParams2 = (ViewPager.LayoutParams)localView2.getLayoutParams();
        if ((localLayoutParams2 != null) && (localLayoutParams2.a))
        {
          int i8 = 0x7 & localLayoutParams2.b;
          int i9 = 0x70 & localLayoutParams2.b;
          i10 = -2147483648;
          i11 = -2147483648;
          if ((i9 != 48) && (i9 != 80))
            break label294;
          i12 = 1;
          if ((i8 != 3) && (i8 != 5))
            break label300;
          i13 = 1;
          if (i12 == 0)
            break label306;
          i10 = 1073741824;
          if (localLayoutParams2.width == -2)
            break label478;
          i14 = 1073741824;
          if (localLayoutParams2.width == -1)
            break label471;
          i15 = localLayoutParams2.width;
        }
      }
    }
    while (true)
    {
      if (localLayoutParams2.height != -2)
      {
        i11 = 1073741824;
        if (localLayoutParams2.height == -1);
      }
      for (int i16 = localLayoutParams2.height; ; i16 = i3)
      {
        localView2.measure(View.MeasureSpec.makeMeasureSpec(i15, i14), View.MeasureSpec.makeMeasureSpec(i16, i11));
        if (i12 != 0)
          i3 -= localView2.getMeasuredHeight();
        while (true)
        {
          i5++;
          break;
          label294: i12 = 0;
          break label167;
          label300: i13 = 0;
          break label182;
          label306: if (i13 == 0)
            break label192;
          i11 = 1073741824;
          break label192;
          if (i13 == 0)
            continue;
          i2 -= localView2.getMeasuredWidth();
        }
        this.t = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        this.u = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        this.v = true;
        c();
        this.v = false;
        int i6 = getChildCount();
        for (int i7 = 0; i7 < i6; i7++)
        {
          View localView1 = getChildAt(i7);
          if (localView1.getVisibility() == 8)
            continue;
          ViewPager.LayoutParams localLayoutParams1 = (ViewPager.LayoutParams)localView1.getLayoutParams();
          if ((localLayoutParams1 != null) && (localLayoutParams1.a))
            continue;
          localView1.measure(View.MeasureSpec.makeMeasureSpec((int)(i2 * localLayoutParams1.c), 1073741824), this.u);
        }
        return;
      }
      label471: i15 = i2;
      continue;
      label478: i14 = i10;
      i15 = i2;
    }
  }

  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i1 = 1;
    int i2 = -1;
    int i3 = getChildCount();
    int i4;
    if ((paramInt & 0x2) != 0)
    {
      i2 = i1;
      i4 = 0;
      if (i4 == i3)
        break label106;
      View localView = getChildAt(i4);
      if (localView.getVisibility() != 0)
        break label96;
      ViewPager.ItemInfo localItemInfo = a(localView);
      if ((localItemInfo == null) || (localItemInfo.b != this.h) || (!localView.requestFocus(paramInt, paramRect)))
        break label96;
    }
    while (true)
    {
      return i1;
      i4 = i3 - 1;
      i3 = i2;
      break;
      label96: i4 += i2;
      break;
      label106: i1 = 0;
    }
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ViewPager.SavedState))
      super.onRestoreInstanceState(paramParcelable);
    while (true)
    {
      return;
      ViewPager.SavedState localSavedState = (ViewPager.SavedState)paramParcelable;
      super.onRestoreInstanceState(localSavedState.getSuperState());
      if (this.g != null)
      {
        this.g.a(localSavedState.b, localSavedState.c);
        a(localSavedState.a, false, true);
        continue;
      }
      this.i = localSavedState.a;
      this.j = localSavedState.b;
      this.k = localSavedState.c;
    }
  }

  public Parcelable onSaveInstanceState()
  {
    ViewPager.SavedState localSavedState = new ViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.h;
    if (this.g != null)
      localSavedState.b = this.g.a();
    return localSavedState;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
      a(paramInt1, paramInt3, this.n, this.n);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1;
    if (this.N)
      i1 = 1;
    while (true)
    {
      return i1;
      if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
      {
        i1 = 0;
        continue;
      }
      if ((this.g != null) && (this.g.b() != 0))
        break;
      i1 = 0;
    }
    if (this.I == null)
      this.I = VelocityTracker.obtain();
    this.I.addMovement(paramMotionEvent);
    int i2 = 0xFF & paramMotionEvent.getAction();
    boolean bool1 = false;
    switch (i2)
    {
    case 4:
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    case 5:
    case 6:
    }
    while (true)
    {
      if (bool1)
        ViewCompat.b(this);
      i1 = 1;
      break;
      this.l.abortAnimation();
      this.x = false;
      c();
      this.z = true;
      setScrollState(1);
      float f5 = paramMotionEvent.getX();
      this.E = f5;
      this.F = f5;
      this.H = MotionEventCompat.b(paramMotionEvent, 0);
      bool1 = false;
      continue;
      float f4;
      if (!this.z)
      {
        int i7 = MotionEventCompat.a(paramMotionEvent, this.H);
        float f1 = MotionEventCompat.c(paramMotionEvent, i7);
        float f2 = Math.abs(f1 - this.F);
        float f3 = Math.abs(MotionEventCompat.d(paramMotionEvent, i7) - this.G);
        if ((f2 > this.D) && (f2 > f3))
        {
          this.z = true;
          if (f1 - this.E <= 0.0F)
            break label355;
          f4 = this.E + this.D;
        }
      }
      while (true)
      {
        this.F = f4;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        boolean bool4 = this.z;
        bool1 = false;
        if (!bool4)
          break;
        bool1 = false | c(MotionEventCompat.c(paramMotionEvent, MotionEventCompat.a(paramMotionEvent, this.H)));
        break;
        label355: f4 = this.E - this.D;
      }
      boolean bool3 = this.z;
      bool1 = false;
      if (!bool3)
        continue;
      VelocityTracker localVelocityTracker = this.I;
      localVelocityTracker.computeCurrentVelocity(1000, this.K);
      int i4 = (int)VelocityTrackerCompat.a(localVelocityTracker, this.H);
      this.x = true;
      int i5 = getWidth();
      int i6 = getScrollX();
      ViewPager.ItemInfo localItemInfo = l();
      a(a(localItemInfo.b, (i6 / i5 - localItemInfo.e) / localItemInfo.d, i4, (int)(MotionEventCompat.c(paramMotionEvent, MotionEventCompat.a(paramMotionEvent, this.H)) - this.E)), true, true, i4);
      this.H = -1;
      m();
      bool1 = this.P.c() | this.Q.c();
      continue;
      boolean bool2 = this.z;
      bool1 = false;
      if (!bool2)
        continue;
      a(this.h, true, true);
      this.H = -1;
      m();
      bool1 = this.P.c() | this.Q.c();
      continue;
      int i3 = MotionEventCompat.a(paramMotionEvent);
      this.F = MotionEventCompat.c(paramMotionEvent, i3);
      this.H = MotionEventCompat.b(paramMotionEvent, i3);
      bool1 = false;
      continue;
      a(paramMotionEvent);
      this.F = MotionEventCompat.c(paramMotionEvent, MotionEventCompat.a(paramMotionEvent, this.H));
      bool1 = false;
    }
  }

  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    if (this.g != null)
    {
      this.g.b(this.m);
      this.g.a(this);
      for (int i1 = 0; i1 < this.d.size(); i1++)
      {
        ViewPager.ItemInfo localItemInfo = (ViewPager.ItemInfo)this.d.get(i1);
        this.g.a(this, localItemInfo.b, localItemInfo.a);
      }
      this.g.b(this);
      this.d.clear();
      j();
      this.h = 0;
      scrollTo(0, 0);
    }
    PagerAdapter localPagerAdapter = this.g;
    this.g = paramPagerAdapter;
    if (this.g != null)
    {
      if (this.m == null)
        this.m = new ViewPager.PagerObserver(this, null);
      this.g.a(this.m);
      this.x = false;
      this.R = true;
      if (this.i < 0)
        break label235;
      this.g.a(this.j, this.k);
      a(this.i, false, true);
      this.i = -1;
      this.j = null;
      this.k = null;
    }
    while (true)
    {
      if ((this.Z != null) && (localPagerAdapter != paramPagerAdapter))
        this.Z.a(localPagerAdapter, paramPagerAdapter);
      return;
      label235: c();
    }
  }

  public void setCurrentItem(int paramInt)
  {
    this.x = false;
    if (!this.R);
    for (boolean bool = true; ; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }

  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.x = false;
    a(paramInt, paramBoolean, false);
  }

  public void setOffscreenPageLimit(int paramInt)
  {
    if (paramInt < 1)
    {
      Log.w("ViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to " + 1);
      paramInt = 1;
    }
    if (paramInt != this.y)
    {
      this.y = paramInt;
      c();
    }
  }

  void setOnAdapterChangeListener(ViewPager.OnAdapterChangeListener paramOnAdapterChangeListener)
  {
    this.Z = paramOnAdapterChangeListener;
  }

  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.V = paramOnPageChangeListener;
  }

  public void setPageMargin(int paramInt)
  {
    int i1 = this.n;
    this.n = paramInt;
    int i2 = getWidth();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }

  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }

  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.o = paramDrawable;
    if (paramDrawable != null)
      refreshDrawableState();
    if (paramDrawable == null);
    for (boolean bool = true; ; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }

  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.o));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPager
 * JD-Core Version:    0.6.0
 */