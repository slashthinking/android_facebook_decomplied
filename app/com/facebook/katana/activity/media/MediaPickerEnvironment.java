package com.facebook.katana.activity.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class MediaPickerEnvironment
  implements Parcelable
{
  public static final Parcelable.Creator<MediaPickerEnvironment> CREATOR;
  public static final MediaPickerEnvironment a = new MediaPickerEnvironment(false, -1L, true, null, false, true);
  private final boolean b;
  private final long c;
  private final boolean d;
  private final String e;
  private final boolean f;
  private final boolean g;

  static
  {
    CREATOR = new MediaPickerEnvironment.1();
  }

  private MediaPickerEnvironment(Parcel paramParcel)
  {
    int j;
    int k;
    label32: int m;
    if (paramParcel.readInt() == i)
    {
      j = i;
      this.b = j;
      if (paramParcel.readInt() != i)
        break label90;
      k = i;
      this.d = k;
      this.c = paramParcel.readLong();
      this.e = paramParcel.readString();
      if (paramParcel.readInt() != i)
        break label96;
      m = i;
      label65: this.f = m;
      if (paramParcel.readInt() != i)
        break label102;
    }
    while (true)
    {
      this.g = i;
      return;
      j = 0;
      break;
      label90: k = 0;
      break label32;
      label96: m = 0;
      break label65;
      label102: i = 0;
    }
  }

  private MediaPickerEnvironment(MediaPickerEnvironment.Builder paramBuilder)
  {
    this.b = MediaPickerEnvironment.Builder.a(paramBuilder);
    this.c = MediaPickerEnvironment.Builder.b(paramBuilder);
    this.d = MediaPickerEnvironment.Builder.c(paramBuilder);
    this.e = MediaPickerEnvironment.Builder.d(paramBuilder);
    this.f = MediaPickerEnvironment.Builder.e(paramBuilder);
    this.g = MediaPickerEnvironment.Builder.f(paramBuilder);
  }

  private MediaPickerEnvironment(boolean paramBoolean1, long paramLong, boolean paramBoolean2, String paramString, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.b = paramBoolean1;
    this.c = paramLong;
    this.d = paramBoolean2;
    this.e = paramString;
    this.f = paramBoolean3;
    this.g = paramBoolean4;
  }

  public boolean a()
  {
    return this.b;
  }

  public long b()
  {
    return this.c;
  }

  public boolean c()
  {
    return this.d;
  }

  public String d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean e()
  {
    return this.f;
  }

  public boolean f()
  {
    return this.g;
  }

  public String toString()
  {
    return "MediaPickerEnvironment(" + this.b + ", " + this.c + ")";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    int j;
    int k;
    label28: int m;
    if (this.b)
    {
      j = i;
      paramParcel.writeInt(j);
      if (!this.d)
        break label85;
      k = i;
      paramParcel.writeInt(k);
      paramParcel.writeLong(this.c);
      paramParcel.writeString(this.e);
      if (!this.f)
        break label91;
      m = i;
      label60: paramParcel.writeInt(m);
      if (!this.g)
        break label97;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      return;
      j = 0;
      break;
      label85: k = 0;
      break label28;
      label91: m = 0;
      break label60;
      label97: i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaPickerEnvironment
 * JD-Core Version:    0.6.0
 */