package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new BackStackState.1();
  final int[] a;
  final int b;
  final int c;
  final String d;
  final int e;
  final int f;
  final CharSequence g;
  final int h;
  final CharSequence i;

  public BackStackState(Parcel paramParcel)
  {
    this.a = paramParcel.createIntArray();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.h = paramParcel.readInt();
    this.i = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
  }

  public BackStackState(FragmentManagerImpl paramFragmentManagerImpl, BackStackRecord paramBackStackRecord)
  {
    BackStackRecord.Op localOp1 = paramBackStackRecord.b;
    int j = 0;
    while (localOp1 != null)
    {
      if (localOp1.i != null)
        j += localOp1.i.size();
      localOp1 = localOp1.a;
    }
    this.a = new int[j + 7 * paramBackStackRecord.d];
    if (!paramBackStackRecord.k)
      throw new IllegalStateException("Not on back stack");
    BackStackRecord.Op localOp2 = paramBackStackRecord.b;
    int k = 0;
    if (localOp2 != null)
    {
      int[] arrayOfInt1 = this.a;
      int m = k + 1;
      arrayOfInt1[k] = localOp2.c;
      int[] arrayOfInt2 = this.a;
      int n = m + 1;
      int i1;
      if (localOp2.d != null)
        i1 = localOp2.d.o;
      int i5;
      while (true)
      {
        arrayOfInt2[m] = i1;
        int[] arrayOfInt3 = this.a;
        int i2 = n + 1;
        arrayOfInt3[n] = localOp2.e;
        int[] arrayOfInt4 = this.a;
        int i3 = i2 + 1;
        arrayOfInt4[i2] = localOp2.f;
        int[] arrayOfInt5 = this.a;
        int i4 = i3 + 1;
        arrayOfInt5[i3] = localOp2.g;
        int[] arrayOfInt6 = this.a;
        i5 = i4 + 1;
        arrayOfInt6[i4] = localOp2.h;
        if (localOp2.i == null)
          break;
        int i6 = localOp2.i.size();
        int[] arrayOfInt8 = this.a;
        int i7 = i5 + 1;
        arrayOfInt8[i5] = i6;
        int i8 = 0;
        while (true)
          if (i8 < i6)
          {
            int[] arrayOfInt9 = this.a;
            int i9 = i7 + 1;
            arrayOfInt9[i7] = ((Fragment)localOp2.i.get(i8)).o;
            i8++;
            i7 = i9;
            continue;
            i1 = -1;
            break;
          }
        k = i7;
      }
      while (true)
      {
        localOp2 = localOp2.a;
        break;
        int[] arrayOfInt7 = this.a;
        k = i5 + 1;
        arrayOfInt7[i5] = 0;
      }
    }
    this.b = paramBackStackRecord.i;
    this.c = paramBackStackRecord.j;
    this.d = paramBackStackRecord.m;
    this.e = paramBackStackRecord.o;
    this.f = paramBackStackRecord.p;
    this.g = paramBackStackRecord.q;
    this.h = paramBackStackRecord.r;
    this.i = paramBackStackRecord.s;
  }

  public BackStackRecord a(FragmentManagerImpl paramFragmentManagerImpl)
  {
    BackStackRecord localBackStackRecord = new BackStackRecord(paramFragmentManagerImpl);
    int j = 0;
    while (j < this.a.length)
    {
      BackStackRecord.Op localOp = new BackStackRecord.Op();
      int[] arrayOfInt1 = this.a;
      int k = j + 1;
      localOp.c = arrayOfInt1[j];
      if (FragmentManagerImpl.a)
        Log.v("FragmentManager", "BSE " + localBackStackRecord + " set base fragment #" + this.a[k]);
      int[] arrayOfInt2 = this.a;
      int m = k + 1;
      int n = arrayOfInt2[k];
      if (n >= 0);
      for (localOp.d = ((Fragment)paramFragmentManagerImpl.f.get(n)); ; localOp.d = null)
      {
        int[] arrayOfInt3 = this.a;
        int i1 = m + 1;
        localOp.e = arrayOfInt3[m];
        int[] arrayOfInt4 = this.a;
        int i2 = i1 + 1;
        localOp.f = arrayOfInt4[i1];
        int[] arrayOfInt5 = this.a;
        int i3 = i2 + 1;
        localOp.g = arrayOfInt5[i2];
        int[] arrayOfInt6 = this.a;
        int i4 = i3 + 1;
        localOp.h = arrayOfInt6[i3];
        int[] arrayOfInt7 = this.a;
        j = i4 + 1;
        int i5 = arrayOfInt7[i4];
        if (i5 <= 0)
          break;
        localOp.i = new ArrayList(i5);
        int i6 = 0;
        while (i6 < i5)
        {
          if (FragmentManagerImpl.a)
            Log.v("FragmentManager", "BSE " + localBackStackRecord + " set remove fragment #" + this.a[j]);
          ArrayList localArrayList = paramFragmentManagerImpl.f;
          int[] arrayOfInt8 = this.a;
          int i7 = j + 1;
          Fragment localFragment = (Fragment)localArrayList.get(arrayOfInt8[j]);
          localOp.i.add(localFragment);
          i6++;
          j = i7;
        }
      }
      localBackStackRecord.a(localOp);
    }
    localBackStackRecord.i = this.b;
    localBackStackRecord.j = this.c;
    localBackStackRecord.m = this.d;
    localBackStackRecord.o = this.e;
    localBackStackRecord.k = true;
    localBackStackRecord.p = this.f;
    localBackStackRecord.q = this.g;
    localBackStackRecord.r = this.h;
    localBackStackRecord.s = this.i;
    localBackStackRecord.b(1);
    return localBackStackRecord;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    TextUtils.writeToParcel(this.g, paramParcel, 0);
    paramParcel.writeInt(this.h);
    TextUtils.writeToParcel(this.i, paramParcel, 0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.6.0
 */