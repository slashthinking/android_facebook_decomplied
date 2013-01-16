package com.facebook.ipc.data.uberbar;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

public class UberbarResult
  implements Parcelable
{
  public static final Parcelable.Creator<UberbarResult> CREATOR = new UberbarResult.1();
  public final String a;
  public final UberbarResult.FriendStatus b;
  public final Uri c;
  public final Uri d;
  public final Uri e;
  public final String f;
  public final String g;
  public final UberbarResult.Type h;
  public final long i;
  public final List<String> j;

  public UberbarResult(UberbarResultBuilder paramUberbarResultBuilder)
  {
    this.a = paramUberbarResultBuilder.b();
    this.b = paramUberbarResultBuilder.c();
    this.c = paramUberbarResultBuilder.d();
    if (paramUberbarResultBuilder.e() == null);
    for (Uri localUri = Uri.parse("http://www.facebook.com/" + paramUberbarResultBuilder.j()); ; localUri = paramUberbarResultBuilder.e())
    {
      this.d = localUri;
      this.e = ((Uri)Preconditions.checkNotNull(paramUberbarResultBuilder.f()));
      this.f = paramUberbarResultBuilder.g();
      this.g = ((String)Preconditions.checkNotNull(paramUberbarResultBuilder.h()));
      this.h = ((UberbarResult.Type)Preconditions.checkNotNull(paramUberbarResultBuilder.i()));
      this.i = ((Long)Preconditions.checkNotNull(Long.valueOf(paramUberbarResultBuilder.j()))).longValue();
      this.j = paramUberbarResultBuilder.k();
      return;
    }
  }

  public static UberbarResultBuilder newBuilder()
  {
    return new UberbarResultBuilder();
  }

  public String a()
  {
    String str;
    if (this.j != null)
    {
      Iterator localIterator = this.j.iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        str = (String)localIterator.next();
      }
      while (str == null);
    }
    while (true)
    {
      return str;
      str = null;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof UberbarResult;
    int k = 0;
    if (!bool1);
    while (true)
    {
      return k;
      UberbarResult localUberbarResult = (UberbarResult)paramObject;
      boolean bool2 = Objects.equal(this.a, localUberbarResult.a);
      k = 0;
      if (!bool2)
        continue;
      boolean bool3 = Objects.equal(this.b, localUberbarResult.b);
      k = 0;
      if (!bool3)
        continue;
      boolean bool4 = Objects.equal(this.c, localUberbarResult.c);
      k = 0;
      if (!bool4)
        continue;
      boolean bool5 = Objects.equal(this.d, localUberbarResult.d);
      k = 0;
      if (!bool5)
        continue;
      boolean bool6 = Objects.equal(this.e, localUberbarResult.e);
      k = 0;
      if (!bool6)
        continue;
      boolean bool7 = Objects.equal(this.f, localUberbarResult.f);
      k = 0;
      if (!bool7)
        continue;
      boolean bool8 = Objects.equal(this.g, localUberbarResult.g);
      k = 0;
      if (!bool8)
        continue;
      boolean bool9 = Objects.equal(this.h, localUberbarResult.h);
      k = 0;
      if (!bool9)
        continue;
      boolean bool10 = Objects.equal(Long.valueOf(this.i), Long.valueOf(localUberbarResult.i));
      k = 0;
      if (!bool10)
        continue;
      boolean bool11 = Objects.equal(this.j, localUberbarResult.j);
      k = 0;
      if (!bool11)
        continue;
      k = 1;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = this.b;
    arrayOfObject[2] = this.c;
    arrayOfObject[3] = this.d;
    arrayOfObject[4] = this.e;
    arrayOfObject[5] = this.f;
    arrayOfObject[6] = this.g;
    arrayOfObject[7] = this.h;
    arrayOfObject[8] = Long.valueOf(this.i);
    arrayOfObject[9] = this.j;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return Objects.toStringHelper(UberbarResult.class).add("category", this.a).add("friendshipStatus", this.b).add("nativeAndroidUrl", this.c).add("path", this.d).add("photo", this.e).add("subtext", this.f).add("text", this.g).add("type", this.h).add("uid", Long.valueOf(this.i)).add("phoneNumbers", this.j).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    String str1;
    if (this.b == null)
    {
      str1 = "";
      paramParcel.writeString(str1);
      paramParcel.writeParcelable(this.c, paramInt);
      paramParcel.writeParcelable(this.d, paramInt);
      paramParcel.writeParcelable(this.e, paramInt);
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.g);
      if (this.h != null)
        break label111;
    }
    label111: for (String str2 = ""; ; str2 = this.h.name())
    {
      paramParcel.writeString(str2);
      paramParcel.writeLong(this.i);
      paramParcel.writeList(this.j);
      return;
      str1 = this.b.name();
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.data.uberbar.UberbarResult
 * JD-Core Version:    0.6.0
 */