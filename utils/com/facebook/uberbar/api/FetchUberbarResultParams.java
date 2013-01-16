package com.facebook.uberbar.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ipc.data.uberbar.UberbarResult.Type;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

public final class FetchUberbarResultParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchUberbarResultParams> CREATOR = new FetchUberbarResultParams.1();
  public final String a;
  public final int b;
  public final List<UberbarResult.Type> c;

  private FetchUberbarResultParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    ArrayList localArrayList = Lists.a();
    paramParcel.readTypedList(localArrayList, null);
    this.c = localArrayList;
  }

  public FetchUberbarResultParams(String paramString, int paramInt, List<UberbarResult.Type> paramList)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof FetchUberbarResultParams;
    boolean bool2 = false;
    if (!bool1);
    while (true)
    {
      return bool2;
      FetchUberbarResultParams localFetchUberbarResultParams = (FetchUberbarResultParams)paramObject;
      boolean bool3 = Objects.equal(this.a, localFetchUberbarResultParams.a);
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = Objects.equal(this.c, localFetchUberbarResultParams.c);
        bool2 = false;
        if (bool4)
        {
          boolean bool5 = Objects.equal(Integer.valueOf(this.b), Integer.valueOf(localFetchUberbarResultParams.b));
          bool2 = false;
          if (bool5)
            bool2 = true;
        }
      }
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = Integer.valueOf(this.b);
    arrayOfObject[2] = this.c;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return Objects.toStringHelper(FetchUberbarResultParams.class).add("query", this.a).add("photoSize", Integer.valueOf(this.b)).add("filter", this.c).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeList(this.c);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.api.FetchUberbarResultParams
 * JD-Core Version:    0.6.2
 */