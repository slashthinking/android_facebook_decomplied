package android.support.v4.app;

import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction
  implements Runnable
{
  final FragmentManagerImpl a;
  BackStackRecord.Op b;
  BackStackRecord.Op c;
  int d;
  int e;
  int f;
  int g;
  int h;
  int i;
  int j;
  boolean k;
  boolean l = true;
  String m;
  boolean n;
  int o;
  int p;
  CharSequence q;
  int r;
  CharSequence s;

  public BackStackRecord(FragmentManagerImpl paramFragmentManagerImpl)
  {
    this.a = paramFragmentManagerImpl;
  }

  private void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    paramFragment.C = this.a;
    if (paramString != null)
    {
      if ((paramFragment.H != null) && (!paramString.equals(paramFragment.H)))
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.H + " now " + paramString);
      paramFragment.H = paramString;
    }
    if (paramInt1 != 0)
    {
      if ((paramFragment.F != 0) && (paramFragment.F != paramInt1))
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.F + " now " + paramInt1);
      paramFragment.F = paramInt1;
      paramFragment.G = paramInt1;
    }
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.c = paramInt2;
    localOp.d = paramFragment;
    a(localOp);
  }

  public int a()
  {
    return a(false);
  }

  int a(boolean paramBoolean)
  {
    if (this.n)
      throw new IllegalStateException("commit already called");
    if (FragmentManagerImpl.a)
      Log.v("BackStackEntry", "Commit: " + this);
    this.n = true;
    if (this.k);
    for (this.o = this.a.a(this); ; this.o = -1)
    {
      this.a.a(this, paramBoolean);
      return this.o;
    }
  }

  public FragmentTransaction a(int paramInt)
  {
    this.i = paramInt;
    return this;
  }

  public FragmentTransaction a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, 0, 0);
  }

  public FragmentTransaction a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
    return this;
  }

  public FragmentTransaction a(int paramInt, Fragment paramFragment)
  {
    a(paramInt, paramFragment, null, 1);
    return this;
  }

  public FragmentTransaction a(int paramInt, Fragment paramFragment, String paramString)
  {
    a(paramInt, paramFragment, paramString, 1);
    return this;
  }

  public FragmentTransaction a(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.c = 3;
    localOp.d = paramFragment;
    a(localOp);
    return this;
  }

  public FragmentTransaction a(Fragment paramFragment, String paramString)
  {
    a(0, paramFragment, paramString, 1);
    return this;
  }

  public FragmentTransaction a(String paramString)
  {
    if (!this.l)
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    this.k = true;
    this.m = paramString;
    return this;
  }

  void a(BackStackRecord.Op paramOp)
  {
    if (this.b == null)
    {
      this.c = paramOp;
      this.b = paramOp;
    }
    while (true)
    {
      paramOp.e = this.e;
      paramOp.f = this.f;
      paramOp.g = this.g;
      paramOp.h = this.h;
      this.d = (1 + this.d);
      return;
      paramOp.b = this.c;
      this.c.a = paramOp;
      this.c = paramOp;
    }
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mName=");
    paramPrintWriter.print(this.m);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.o);
    paramPrintWriter.print(" mCommitted=");
    paramPrintWriter.println(this.n);
    if (this.i != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTransition=#");
      paramPrintWriter.print(Integer.toHexString(this.i));
      paramPrintWriter.print(" mTransitionStyle=#");
      paramPrintWriter.println(Integer.toHexString(this.j));
    }
    if ((this.e != 0) || (this.f != 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mEnterAnim=#");
      paramPrintWriter.print(Integer.toHexString(this.e));
      paramPrintWriter.print(" mExitAnim=#");
      paramPrintWriter.println(Integer.toHexString(this.f));
    }
    if ((this.g != 0) || (this.h != 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mPopEnterAnim=#");
      paramPrintWriter.print(Integer.toHexString(this.g));
      paramPrintWriter.print(" mPopExitAnim=#");
      paramPrintWriter.println(Integer.toHexString(this.h));
    }
    if ((this.p != 0) || (this.q != null))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mBreadCrumbTitleRes=#");
      paramPrintWriter.print(Integer.toHexString(this.p));
      paramPrintWriter.print(" mBreadCrumbTitleText=");
      paramPrintWriter.println(this.q);
    }
    if ((this.r != 0) || (this.s != null))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
      paramPrintWriter.print(Integer.toHexString(this.r));
      paramPrintWriter.print(" mBreadCrumbShortTitleText=");
      paramPrintWriter.println(this.s);
    }
    if (this.b != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      String str = paramString + "    ";
      for (BackStackRecord.Op localOp = this.b; localOp != null; localOp = localOp.a)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  Op #");
        paramPrintWriter.print(0);
        paramPrintWriter.println(":");
        paramPrintWriter.print(str);
        paramPrintWriter.print("cmd=");
        paramPrintWriter.print(localOp.c);
        paramPrintWriter.print(" fragment=");
        paramPrintWriter.println(localOp.d);
        if ((localOp.e != 0) || (localOp.f != 0))
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("enterAnim=#");
          paramPrintWriter.print(Integer.toHexString(localOp.e));
          paramPrintWriter.print(" exitAnim=#");
          paramPrintWriter.println(Integer.toHexString(localOp.f));
        }
        if ((localOp.g != 0) || (localOp.h != 0))
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("popEnterAnim=#");
          paramPrintWriter.print(Integer.toHexString(localOp.g));
          paramPrintWriter.print(" popExitAnim=#");
          paramPrintWriter.println(Integer.toHexString(localOp.h));
        }
        if ((localOp.i == null) || (localOp.i.size() <= 0))
          continue;
        int i1 = 0;
        if (i1 >= localOp.i.size())
          continue;
        paramPrintWriter.print(str);
        if (localOp.i.size() == 1)
          paramPrintWriter.print("Removed: ");
        while (true)
        {
          paramPrintWriter.println(localOp.i.get(i1));
          i1++;
          break;
          paramPrintWriter.println("Removed:");
          paramPrintWriter.print(str);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(0);
          paramPrintWriter.print(": ");
        }
      }
    }
  }

  public int b()
  {
    return a(true);
  }

  public FragmentTransaction b(int paramInt, Fragment paramFragment)
  {
    return b(paramInt, paramFragment, null);
  }

  public FragmentTransaction b(int paramInt, Fragment paramFragment, String paramString)
  {
    if (paramInt == 0)
      throw new IllegalArgumentException("Must use non-zero containerViewId");
    a(paramInt, paramFragment, paramString, 2);
    return this;
  }

  public FragmentTransaction b(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.c = 4;
    localOp.d = paramFragment;
    a(localOp);
    return this;
  }

  void b(int paramInt)
  {
    if (!this.k);
    while (true)
    {
      return;
      if (FragmentManagerImpl.a)
        Log.v("BackStackEntry", "Bump nesting in " + this + " by " + paramInt);
      for (BackStackRecord.Op localOp = this.b; localOp != null; localOp = localOp.a)
      {
        if (localOp.d != null)
        {
          Fragment localFragment2 = localOp.d;
          localFragment2.B = (paramInt + localFragment2.B);
          if (FragmentManagerImpl.a)
            Log.v("BackStackEntry", "Bump nesting of " + localOp.d + " to " + localOp.d.B);
        }
        if (localOp.i == null)
          continue;
        for (int i1 = -1 + localOp.i.size(); i1 >= 0; i1--)
        {
          Fragment localFragment1 = (Fragment)localOp.i.get(i1);
          localFragment1.B = (paramInt + localFragment1.B);
          if (!FragmentManagerImpl.a)
            continue;
          Log.v("BackStackEntry", "Bump nesting of " + localFragment1 + " to " + localFragment1.B);
        }
      }
    }
  }

  public void b(boolean paramBoolean)
  {
    if (FragmentManagerImpl.a)
      Log.v("BackStackEntry", "popFromBackStack: " + this);
    b(-1);
    BackStackRecord.Op localOp = this.c;
    if (localOp != null)
    {
      switch (localOp.c)
      {
      default:
        throw new IllegalArgumentException("Unknown cmd: " + localOp.c);
      case 1:
        Fragment localFragment8 = localOp.d;
        localFragment8.P = localOp.h;
        this.a.a(localFragment8, FragmentManagerImpl.e(this.i), this.j);
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
      while (true)
      {
        localOp = localOp.b;
        break;
        Fragment localFragment6 = localOp.d;
        if (localFragment6 != null)
        {
          localFragment6.P = localOp.h;
          this.a.a(localFragment6, FragmentManagerImpl.e(this.i), this.j);
        }
        if (localOp.i == null)
          continue;
        for (int i1 = 0; i1 < localOp.i.size(); i1++)
        {
          Fragment localFragment7 = (Fragment)localOp.i.get(i1);
          localFragment7.P = localOp.g;
          this.a.a(localFragment7, false);
        }
        Fragment localFragment5 = localOp.d;
        localFragment5.P = localOp.g;
        this.a.a(localFragment5, false);
        continue;
        Fragment localFragment4 = localOp.d;
        localFragment4.P = localOp.g;
        this.a.c(localFragment4, FragmentManagerImpl.e(this.i), this.j);
        continue;
        Fragment localFragment3 = localOp.d;
        localFragment3.P = localOp.h;
        this.a.b(localFragment3, FragmentManagerImpl.e(this.i), this.j);
        continue;
        Fragment localFragment2 = localOp.d;
        localFragment2.P = localOp.g;
        this.a.e(localFragment2, FragmentManagerImpl.e(this.i), this.j);
        continue;
        Fragment localFragment1 = localOp.d;
        localFragment1.P = localOp.g;
        this.a.d(localFragment1, FragmentManagerImpl.e(this.i), this.j);
      }
    }
    if (paramBoolean)
      this.a.a(this.a.n, FragmentManagerImpl.e(this.i), this.j, true);
    if (this.o >= 0)
    {
      this.a.d(this.o);
      this.o = -1;
    }
  }

  public FragmentTransaction c(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.c = 5;
    localOp.d = paramFragment;
    a(localOp);
    return this;
  }

  public String c()
  {
    return this.m;
  }

  public FragmentTransaction d(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.c = 6;
    localOp.d = paramFragment;
    a(localOp);
    return this;
  }

  public FragmentTransaction e(Fragment paramFragment)
  {
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    localOp.c = 7;
    localOp.d = paramFragment;
    a(localOp);
    return this;
  }

  public void run()
  {
    if (FragmentManagerImpl.a)
      Log.v("BackStackEntry", "Run: " + this);
    if ((this.k) && (this.o < 0))
      throw new IllegalStateException("addToBackStack() called after commit()");
    b(1);
    BackStackRecord.Op localOp = this.b;
    if (localOp != null)
    {
      switch (localOp.c)
      {
      default:
        throw new IllegalArgumentException("Unknown cmd: " + localOp.c);
      case 1:
        Fragment localFragment9 = localOp.d;
        localFragment9.P = localOp.e;
        this.a.a(localFragment9, false);
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
      while (true)
      {
        localOp = localOp.a;
        break;
        Fragment localFragment6 = localOp.d;
        Fragment localFragment7;
        if (this.a.g != null)
        {
          int i1 = 0;
          localFragment7 = localFragment6;
          if (i1 < this.a.g.size())
          {
            Fragment localFragment8 = (Fragment)this.a.g.get(i1);
            if (FragmentManagerImpl.a)
              Log.v("BackStackEntry", "OP_REPLACE: adding=" + localFragment7 + " old=" + localFragment8);
            if ((localFragment7 == null) || (localFragment8.G == localFragment7.G))
            {
              if (localFragment8 != localFragment7)
                break label318;
              localFragment7 = null;
              localOp.d = null;
            }
            while (true)
            {
              i1++;
              break;
              label318: if (localOp.i == null)
                localOp.i = new ArrayList();
              localOp.i.add(localFragment8);
              localFragment8.P = localOp.f;
              if (this.k)
              {
                localFragment8.B = (1 + localFragment8.B);
                if (FragmentManagerImpl.a)
                  Log.v("BackStackEntry", "Bump nesting of " + localFragment8 + " to " + localFragment8.B);
              }
              this.a.a(localFragment8, this.i, this.j);
            }
          }
        }
        else
        {
          localFragment7 = localFragment6;
        }
        if (localFragment7 == null)
          continue;
        localFragment7.P = localOp.e;
        this.a.a(localFragment7, false);
        continue;
        Fragment localFragment5 = localOp.d;
        localFragment5.P = localOp.f;
        this.a.a(localFragment5, this.i, this.j);
        continue;
        Fragment localFragment4 = localOp.d;
        localFragment4.P = localOp.f;
        this.a.b(localFragment4, this.i, this.j);
        continue;
        Fragment localFragment3 = localOp.d;
        localFragment3.P = localOp.e;
        this.a.c(localFragment3, this.i, this.j);
        continue;
        Fragment localFragment2 = localOp.d;
        localFragment2.P = localOp.f;
        this.a.d(localFragment2, this.i, this.j);
        continue;
        Fragment localFragment1 = localOp.d;
        localFragment1.P = localOp.e;
        this.a.e(localFragment1, this.i, this.j);
      }
    }
    this.a.a(this.a.n, this.i, this.j, true);
    if (this.k)
      this.a.b(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.BackStackRecord
 * JD-Core Version:    0.6.0
 */