package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentState> CREATOR = new FragmentState.1();
  final String a;
  final int b;
  final int c;
  final boolean d;
  final int e;
  final int f;
  final String g;
  final boolean h;
  final boolean i;
  final Bundle j;
  Bundle k;
  Fragment l;

  public FragmentState(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    boolean bool2;
    boolean bool3;
    if (paramParcel.readInt() != 0)
    {
      bool2 = bool1;
      this.d = bool2;
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.g = paramParcel.readString();
      if (paramParcel.readInt() == 0)
        break label118;
      bool3 = bool1;
      label78: this.h = bool3;
      if (paramParcel.readInt() == 0)
        break label124;
    }
    while (true)
    {
      this.i = bool1;
      this.j = paramParcel.readBundle();
      this.k = paramParcel.readBundle();
      return;
      bool2 = false;
      break;
      label118: bool3 = false;
      break label78;
      label124: bool1 = false;
    }
  }

  public FragmentState(Fragment paramFragment)
  {
    this.a = paramFragment.getClass().getName();
    this.b = paramFragment.o;
    this.c = paramFragment.p;
    this.d = paramFragment.y;
    this.e = paramFragment.F;
    this.f = paramFragment.G;
    this.g = paramFragment.H;
    this.h = paramFragment.K;
    this.i = paramFragment.J;
    this.j = paramFragment.r;
  }

  public Fragment a(FragmentHost paramFragmentHost)
  {
    if (this.l != null);
    for (Fragment localFragment = this.l; ; localFragment = this.l)
    {
      return localFragment;
      if (this.j != null)
        this.j.setClassLoader(paramFragmentHost.a().getClassLoader());
      this.l = Fragment.a(paramFragmentHost.a(), this.a, this.j);
      if (this.k != null)
      {
        this.k.setClassLoader(paramFragmentHost.a().getClassLoader());
        this.l.m = this.k;
      }
      this.l.a(this.b);
      this.l.p = this.c;
      this.l.y = this.d;
      this.l.A = true;
      this.l.F = this.e;
      this.l.G = this.f;
      this.l.H = this.g;
      this.l.K = this.h;
      this.l.J = this.i;
      this.l.C = paramFragmentHost.h();
      if (!FragmentManagerImpl.a)
        continue;
      Log.v("FragmentManager", "Instantiated fragment " + this.l);
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    int n;
    int i1;
    if (this.d)
    {
      n = m;
      paramParcel.writeInt(n);
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
      paramParcel.writeString(this.g);
      if (!this.h)
        break label117;
      i1 = m;
      label76: paramParcel.writeInt(i1);
      if (!this.i)
        break label123;
    }
    while (true)
    {
      paramParcel.writeInt(m);
      paramParcel.writeBundle(this.j);
      paramParcel.writeBundle(this.k);
      return;
      n = 0;
      break;
      label117: i1 = 0;
      break label76;
      label123: m = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentState
 * JD-Core Version:    0.6.0
 */