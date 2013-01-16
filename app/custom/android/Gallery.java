package custom.android;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Transformation;
import android.widget.Scroller;
import android.widget.SpinnerAdapter;

public class Gallery extends AbsSpinner
  implements GestureDetector.OnGestureListener
{
  private int F;
  private int G;
  private float H;
  private int I;
  private GestureDetector J;
  private int K;
  private View L;
  private Gallery.FlingRunnable M;
  private Runnable N;
  private boolean O;
  private View P;
  private boolean Q;
  private boolean R;
  private boolean S;
  private boolean T;
  private AdapterView.AdapterContextMenuInfo U;
  private boolean V;
  private boolean W;

  public Gallery(Context paramContext)
  {
    this(paramContext, null);
  }

  public Gallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130771982);
  }

  // ERROR //
  public Gallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 44	custom/android/AbsSpinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 46	custom/android/Gallery:F	I
    //   12: aload_0
    //   13: sipush 400
    //   16: putfield 48	custom/android/Gallery:G	I
    //   19: aload_0
    //   20: new 50	custom/android/Gallery$FlingRunnable
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 53	custom/android/Gallery$FlingRunnable:<init>	(Lcustom/android/Gallery;)V
    //   28: putfield 55	custom/android/Gallery:M	Lcustom/android/Gallery$FlingRunnable;
    //   31: aload_0
    //   32: new 57	custom/android/Gallery$1
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 58	custom/android/Gallery$1:<init>	(Lcustom/android/Gallery;)V
    //   40: putfield 60	custom/android/Gallery:N	Ljava/lang/Runnable;
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 62	custom/android/Gallery:Q	Z
    //   48: aload_0
    //   49: iconst_1
    //   50: putfield 64	custom/android/Gallery:R	Z
    //   53: aload_0
    //   54: new 66	android/view/GestureDetector
    //   57: dup
    //   58: aload_1
    //   59: aload_0
    //   60: invokespecial 69	android/view/GestureDetector:<init>	(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V
    //   63: putfield 71	custom/android/Gallery:J	Landroid/view/GestureDetector;
    //   66: aload_0
    //   67: getfield 71	custom/android/Gallery:J	Landroid/view/GestureDetector;
    //   70: iconst_1
    //   71: invokevirtual 75	android/view/GestureDetector:setIsLongpressEnabled	(Z)V
    //   74: aload_1
    //   75: aload_2
    //   76: getstatic 81	com/facebook/R$styleable:Gallery	[I
    //   79: iload_3
    //   80: iconst_0
    //   81: invokevirtual 87	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   84: astore 4
    //   86: aload 4
    //   88: iconst_1
    //   89: iconst_m1
    //   90: invokevirtual 93	android/content/res/TypedArray:getInt	(II)I
    //   93: istore 5
    //   95: iload 5
    //   97: iflt +9 -> 106
    //   100: aload_0
    //   101: iload 5
    //   103: invokevirtual 97	custom/android/Gallery:setGravity	(I)V
    //   106: aload 4
    //   108: iconst_2
    //   109: iconst_m1
    //   110: invokevirtual 93	android/content/res/TypedArray:getInt	(II)I
    //   113: istore 6
    //   115: iload 6
    //   117: ifle +9 -> 126
    //   120: aload_0
    //   121: iload 6
    //   123: invokevirtual 100	custom/android/Gallery:setAnimationDuration	(I)V
    //   126: aload_0
    //   127: aload 4
    //   129: iconst_4
    //   130: iconst_0
    //   131: invokevirtual 103	android/content/res/TypedArray:getDimensionPixelOffset	(II)I
    //   134: invokevirtual 106	custom/android/Gallery:setSpacing	(I)V
    //   137: aload_0
    //   138: aload 4
    //   140: iconst_3
    //   141: ldc 107
    //   143: invokevirtual 111	android/content/res/TypedArray:getFloat	(IF)F
    //   146: invokevirtual 115	custom/android/Gallery:setUnselectedAlpha	(F)V
    //   149: aload 4
    //   151: invokevirtual 119	android/content/res/TypedArray:recycle	()V
    //   154: sipush 1024
    //   157: istore 7
    //   159: ldc 121
    //   161: ldc 123
    //   163: invokevirtual 129	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   166: astore 18
    //   168: ldc 121
    //   170: ldc 131
    //   172: invokevirtual 129	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   175: astore 19
    //   177: aload 18
    //   179: iconst_1
    //   180: invokevirtual 136	java/lang/reflect/Field:setAccessible	(Z)V
    //   183: aload 19
    //   185: iconst_1
    //   186: invokevirtual 136	java/lang/reflect/Field:setAccessible	(Z)V
    //   189: aload 18
    //   191: aload_0
    //   192: invokevirtual 139	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   195: istore 7
    //   197: aload 19
    //   199: aload_0
    //   200: invokevirtual 139	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   203: istore 20
    //   205: iload 20
    //   207: istore 10
    //   209: ldc 121
    //   211: ldc 141
    //   213: invokevirtual 129	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   216: astore 15
    //   218: aload 15
    //   220: iconst_1
    //   221: invokevirtual 136	java/lang/reflect/Field:setAccessible	(Z)V
    //   224: aload 15
    //   226: aload_0
    //   227: iload 10
    //   229: iload 7
    //   231: aload 15
    //   233: aload_0
    //   234: invokevirtual 139	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   237: ior
    //   238: ior
    //   239: invokestatic 147	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   242: invokevirtual 151	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   245: return
    //   246: astore 16
    //   248: ldc 152
    //   250: aload 16
    //   252: invokevirtual 156	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
    //   255: aload 16
    //   257: invokestatic 162	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   260: pop
    //   261: sipush 2048
    //   264: istore 10
    //   266: goto -57 -> 209
    //   269: astore 8
    //   271: ldc 152
    //   273: aload 8
    //   275: invokevirtual 163	java/lang/IllegalAccessException:getMessage	()Ljava/lang/String;
    //   278: aload 8
    //   280: invokestatic 162	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   283: pop
    //   284: sipush 2048
    //   287: istore 10
    //   289: goto -80 -> 209
    //   292: astore 13
    //   294: ldc 152
    //   296: aload 13
    //   298: invokevirtual 156	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
    //   301: aload 13
    //   303: invokestatic 162	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   306: pop
    //   307: goto -62 -> 245
    //   310: astore 11
    //   312: ldc 152
    //   314: aload 11
    //   316: invokevirtual 163	java/lang/IllegalAccessException:getMessage	()Ljava/lang/String;
    //   319: aload 11
    //   321: invokestatic 162	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   324: pop
    //   325: goto -80 -> 245
    //
    // Exception table:
    //   from	to	target	type
    //   159	205	246	java/lang/NoSuchFieldException
    //   159	205	269	java/lang/IllegalAccessException
    //   209	245	292	java/lang/NoSuchFieldException
    //   209	245	310	java/lang/IllegalAccessException
  }

  private int a(View paramView, boolean paramBoolean)
  {
    int i;
    int j;
    label19: int k;
    if (paramBoolean)
    {
      i = getMeasuredHeight();
      if (!paramBoolean)
        break label70;
      j = paramView.getMeasuredHeight();
      switch (this.I)
      {
      default:
        k = 0;
      case 48:
      case 16:
      case 80:
      }
    }
    while (true)
    {
      return k;
      i = getHeight();
      break;
      label70: j = paramView.getHeight();
      break label19;
      k = this.i.top;
      continue;
      int m = i - this.i.bottom - this.i.top - j;
      k = this.i.top + m / 2;
      continue;
      k = i - this.i.bottom - j;
    }
  }

  private View a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    View localView1 = this.j.a();
    View localView2 = this.a.getView(paramInt1, localView1, this);
    a(localView2, paramInt2, paramInt3, paramBoolean);
    return localView2;
  }

  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Gallery.LayoutParams localLayoutParams1 = (Gallery.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams1 == null);
    for (Gallery.LayoutParams localLayoutParams2 = (Gallery.LayoutParams)generateDefaultLayoutParams(); ; localLayoutParams2 = localLayoutParams1)
    {
      int i;
      int k;
      int m;
      int n;
      int i1;
      if (paramBoolean)
      {
        i = -1;
        addViewInLayout(paramView, i, localLayoutParams2);
        boolean bool = false;
        if (paramInt1 == 0)
          bool = true;
        paramView.setSelected(bool);
        int j = ViewGroup.getChildMeasureSpec(this.b, this.i.top + this.i.bottom, localLayoutParams2.height);
        paramView.measure(ViewGroup.getChildMeasureSpec(this.c, this.i.left + this.i.right, localLayoutParams2.width), j);
        k = a(paramView, true);
        m = k + paramView.getMeasuredHeight();
        n = paramView.getMeasuredWidth();
        if (!paramBoolean)
          break label177;
        int i2 = n + paramInt2;
        i1 = paramInt2;
        paramInt2 = i2;
      }
      while (true)
      {
        paramView.layout(i1, k, paramInt2, m);
        return;
        i = 0;
        break;
        label177: i1 = paramInt2 - n;
      }
    }
  }

  private void a(boolean paramBoolean)
  {
    int i = 0;
    int j = getChildCount();
    int i4;
    int n;
    View localView2;
    if (paramBoolean)
    {
      int i3 = getPaddingLeft();
      i4 = 0;
      n = 0;
      i = 0;
      if (i4 < j)
      {
        localView2 = getChildAt(i4);
        int i5 = localView2.getRight();
        i = 0;
        if (i5 < i3)
          break label78;
      }
    }
    label178: 
    while (true)
    {
      detachViewsFromParent(i, n);
      if (paramBoolean)
        this.k = (n + this.k);
      return;
      label78: int i6 = n + 1;
      this.j.a(localView2);
      i4++;
      n = i6;
      break;
      int k = getWidth() - getPaddingRight();
      int m = j - 1;
      n = 0;
      while (true)
      {
        if (m < 0)
          break label178;
        View localView1 = getChildAt(m);
        if (localView1.getLeft() <= k)
          break;
        int i1 = n + 1;
        this.j.a(localView1);
        int i2 = m - 1;
        n = i1;
        i = m;
        m = i2;
      }
    }
  }

  private boolean b(View paramView, int paramInt, long paramLong)
  {
    if (this.u != null);
    for (boolean bool = this.u.a(this, this.L, this.K, paramLong); ; bool = false)
    {
      if (!bool)
      {
        this.U = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
        bool = super.showContextMenuForChild(this);
      }
      if (bool)
        performHapticFeedback(0);
      return bool;
    }
  }

  private void c(int paramInt)
  {
    for (int i = -1 + getChildCount(); i >= 0; i--)
      getChildAt(i).offsetLeftAndRight(paramInt);
  }

  private static int d(View paramView)
  {
    return paramView.getLeft() + paramView.getWidth() / 2;
  }

  private boolean d(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if (localView != null)
    {
      int j = getCenterOfGallery() - d(localView);
      this.M.b(j);
    }
    for (int i = 1; ; i = 0)
      return i;
  }

  private void e(View paramView)
  {
    if (paramView != null)
      paramView.setPressed(true);
    setPressed(true);
  }

  private int getCenterOfGallery()
  {
    int i = getPaddingLeft();
    int j = getPaddingRight();
    return i + (getWidth() - i - j) / 2;
  }

  private void n()
  {
    if ((getChildCount() == 0) || (this.P == null));
    while (true)
    {
      return;
      int i = d(this.P);
      int j = getCenterOfGallery() - i;
      if (j != 0)
      {
        this.M.b(j);
        continue;
      }
      o();
    }
  }

  private void o()
  {
    if (this.S)
    {
      this.S = false;
      super.e();
    }
    invalidate();
    b(0, false);
  }

  private void p()
  {
    View localView1 = this.P;
    if (this.P == null);
    int i;
    do
    {
      return;
      i = getCenterOfGallery();
    }
    while ((localView1.getLeft() <= i) && (localView1.getRight() >= i));
    int j = 2147483647;
    int k = 0;
    int m = -1 + getChildCount();
    View localView2;
    if (m >= 0)
    {
      localView2 = getChildAt(m);
      if ((localView2.getLeft() > i) || (localView2.getRight() < i));
    }
    while (true)
    {
      int n = m + this.k;
      if (n == this.y)
        break;
      setSelectedPositionInt(n);
      setNextSelectedPositionInt(n);
      g();
      break;
      int i1 = Math.min(Math.abs(localView2.getLeft() - i), Math.abs(localView2.getRight() - i));
      if (i1 < j)
        k = m;
      while (true)
      {
        m--;
        j = i1;
        break;
        i1 = j;
      }
      m = k;
    }
  }

  private void q()
  {
    int i = this.F;
    int j = getPaddingLeft();
    View localView1 = getChildAt(0);
    int m;
    int k;
    if (localView1 != null)
    {
      m = -1 + this.k;
      k = localView1.getLeft() - i;
    }
    while ((k > j) && (m >= 0))
    {
      View localView2 = a(m, m - this.y, k, false);
      this.k = m;
      k = localView2.getLeft() - i;
      m--;
      continue;
      k = getRight() - getLeft() - getPaddingRight();
      this.O = true;
      m = 0;
    }
  }

  private void r()
  {
    int i = this.F;
    int j = getRight() - getLeft() - getPaddingRight();
    int k = getChildCount();
    int m = this.A;
    View localView = getChildAt(k - 1);
    int n;
    int i1;
    if (localView != null)
    {
      n = k + this.k;
      i1 = i + localView.getRight();
    }
    while ((i1 < j) && (n < m))
    {
      i1 = i + a(n, n - this.y, i1, true).getRight();
      n++;
      continue;
      n = -1 + this.A;
      this.k = n;
      i1 = getPaddingLeft();
      this.O = true;
    }
  }

  private void s()
  {
    for (int i = -1 + getChildCount(); i >= 0; i--)
      getChildAt(i).setPressed(false);
    setPressed(false);
  }

  private void t()
  {
    View localView1 = this.P;
    View localView2 = getChildAt(this.y - this.k);
    this.P = localView2;
    if (localView2 == null);
    while (true)
    {
      return;
      localView2.setSelected(true);
      localView2.setFocusable(true);
      if (hasFocus())
        localView2.requestFocus();
      if (localView1 == null)
        continue;
      localView1.setSelected(false);
      localView1.setFocusable(false);
    }
  }

  int a(View paramView)
  {
    return paramView.getMeasuredHeight();
  }

  int a(boolean paramBoolean, int paramInt)
  {
    int i;
    View localView;
    int m;
    if (paramBoolean)
    {
      i = -1 + this.A;
      localView = getChildAt(i - this.k);
      if (localView != null)
        break label39;
      m = paramInt;
    }
    label39: int j;
    int k;
    do
    {
      return m;
      i = 0;
      break;
      j = d(localView);
      k = getCenterOfGallery();
      if (!paramBoolean)
        break label92;
      m = 0;
    }
    while (j <= k);
    label66: int n = k - j;
    if (paramBoolean);
    for (int i1 = Math.max(n, paramInt); ; i1 = Math.min(n, paramInt))
    {
      m = i1;
      break;
      label92: if (j < k)
        break label66;
      m = 0;
      break;
    }
  }

  void b(int paramInt)
  {
    if (getChildCount() == 0)
      return;
    boolean bool;
    if (paramInt < 0)
    {
      bool = true;
      label14: int i = a(bool, paramInt);
      if (i != paramInt)
      {
        Gallery.FlingRunnable.a(this.M, false);
        o();
      }
      c(i);
      a(bool);
      if (!bool)
        break label72;
      r();
    }
    while (true)
    {
      p();
      invalidate();
      break;
      bool = false;
      break label14;
      label72: q();
    }
  }

  void b(int paramInt, boolean paramBoolean)
  {
    int i = this.i.left;
    int j = getRight() - getLeft() - this.i.left - this.i.right;
    if (this.v)
      f();
    if (this.A == 0)
      a();
    while (true)
    {
      return;
      if (this.w >= 0)
        setSelectedPositionInt(this.w);
      b();
      detachAllViewsFromParent();
      this.k = this.y;
      View localView = a(this.y, 0, 0, true);
      localView.offsetLeftAndRight(i + j / 2 - localView.getWidth() / 2);
      r();
      q();
      invalidate();
      g();
      this.v = false;
      this.p = false;
      setNextSelectedPositionInt(this.y);
      t();
    }
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof Gallery.LayoutParams;
  }

  protected int computeHorizontalScrollExtent()
  {
    return 1;
  }

  protected int computeHorizontalScrollOffset()
  {
    return this.y;
  }

  protected int computeHorizontalScrollRange()
  {
    return this.A;
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.dispatch(this, null, null);
  }

  protected void dispatchSetPressed(boolean paramBoolean)
  {
    if (this.P != null)
      this.P.setPressed(paramBoolean);
  }

  public void dispatchSetSelected(boolean paramBoolean)
  {
  }

  void e()
  {
    if (!this.S)
      super.e();
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new Gallery.LayoutParams(-2, -2);
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new Gallery.LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new Gallery.LayoutParams(paramLayoutParams);
  }

  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = this.y - this.k;
    if (i < 0);
    while (true)
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1)
      {
        paramInt2 = i;
        continue;
      }
      if (paramInt2 < i)
        continue;
      paramInt2++;
    }
  }

  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    paramTransformation.clear();
    float f;
    if (paramView == this.P)
      f = 1.0F;
    while (true)
    {
      paramTransformation.setAlpha(f);
      return true;
      f = this.H;
    }
  }

  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.U;
  }

  void j()
  {
    this.W = false;
    if (Gallery.FlingRunnable.a(this.M).isFinished())
      n();
    s();
  }

  void k()
  {
    j();
  }

  boolean l()
  {
    if ((this.A > 0) && (this.y > 0))
      d(-1 + (this.y - this.k));
    for (int i = 1; ; i = 0)
      return i;
  }

  boolean m()
  {
    if ((this.A > 0) && (this.y < -1 + this.A))
      d(1 + (this.y - this.k));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.W = true;
    this.M.a(false);
    this.K = a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if (this.K >= 0)
    {
      this.L = getChildAt(this.K - this.k);
      this.L.setPressed(true);
    }
    this.V = true;
    return true;
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.Q)
    {
      removeCallbacks(this.N);
      if (!this.S)
        this.S = true;
    }
    this.M.a((int)(-paramFloat1));
    return true;
  }

  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (this.P != null))
      this.P.requestFocus(paramInt);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    switch (paramInt)
    {
    default:
    case 21:
    case 22:
    case 23:
    case 66:
    }
    while (true)
    {
      i = super.onKeyDown(paramInt, paramKeyEvent);
      while (true)
      {
        return i;
        if (!l())
          continue;
        playSoundEffect(i);
        continue;
        if (!m())
          continue;
        playSoundEffect(3);
      }
      this.T = i;
    }
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default:
    case 23:
    case 66:
    }
    for (boolean bool = super.onKeyUp(paramInt, paramKeyEvent); ; bool = true)
    {
      return bool;
      if ((this.T) && (this.A > 0))
      {
        e(this.P);
        postDelayed(new Gallery.2(this), ViewConfiguration.getPressedStateDuration());
        a(getChildAt(this.y - this.k), this.y, this.a.getItemId(this.y));
      }
      this.T = false;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.W)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      this.r = true;
      b(0, false);
      this.r = false;
    }
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.K < 0);
    while (true)
    {
      return;
      performHapticFeedback(0);
      long l = a(this.K);
      b(this.L, this.K, l);
    }
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    if (!this.Q)
      if (this.V)
      {
        if (!this.S)
          this.S = true;
        postDelayed(this.N, 250L);
      }
    while (true)
    {
      b(-1 * (int)paramFloat1);
      this.V = false;
      return true;
      if (!this.S)
        continue;
      this.S = false;
    }
  }

  public void onShowPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.K >= 0)
    {
      d(this.K - this.k);
      if ((this.R) || (this.K == this.y))
        a(this.L, this.K, this.a.getItemId(this.K));
    }
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.J.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i == 1)
      j();
    while (true)
    {
      return bool;
      if (i != 3)
        continue;
      k();
    }
  }

  public void setAnimationDuration(int paramInt)
  {
    this.G = paramInt;
  }

  public void setCallbackDuringFling(boolean paramBoolean)
  {
    this.Q = paramBoolean;
  }

  public void setCallbackOnUnselectedItemClick(boolean paramBoolean)
  {
    this.R = paramBoolean;
  }

  public void setGravity(int paramInt)
  {
    if (this.I != paramInt)
    {
      this.I = paramInt;
      requestLayout();
    }
  }

  void setSelectedPositionInt(int paramInt)
  {
    super.setSelectedPositionInt(paramInt);
    t();
  }

  public void setSpacing(int paramInt)
  {
    this.F = paramInt;
  }

  public void setUnselectedAlpha(float paramFloat)
  {
    this.H = paramFloat;
  }

  public boolean showContextMenu()
  {
    if ((isPressed()) && (this.y >= 0));
    for (boolean bool = b(getChildAt(this.y - this.k), this.y, this.z); ; bool = false)
      return bool;
  }

  public boolean showContextMenuForChild(View paramView)
  {
    int i = c(paramView);
    if (i < 0);
    for (boolean bool = false; ; bool = b(paramView, i, this.a.getItemId(i)))
      return bool;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     custom.android.Gallery
 * JD-Core Version:    0.6.0
 */