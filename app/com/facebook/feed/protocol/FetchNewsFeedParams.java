package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.feed.model.NewsFeedType;
import com.facebook.orca.server.DataFreshnessParam;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class FetchNewsFeedParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchNewsFeedParams> CREATOR = new FetchNewsFeedParams.1();
  private final DataFreshnessParam a;
  private final NewsFeedType b;
  private final int c;
  private final String d;
  private final String e;
  private final FetchNewsFeedParams.ViewMode f;

  protected FetchNewsFeedParams(Parcel paramParcel)
  {
    this.a = DataFreshnessParam.valueOf(paramParcel.readString());
    this.b = NewsFeedType.valueOf(paramParcel.readString());
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = FetchNewsFeedParams.ViewMode.valueOf(paramParcel.readString());
  }

  FetchNewsFeedParams(FetchNewsFeedParamsBuilder paramFetchNewsFeedParamsBuilder)
  {
    this.a = paramFetchNewsFeedParamsBuilder.e();
    this.b = paramFetchNewsFeedParamsBuilder.f();
    this.c = paramFetchNewsFeedParamsBuilder.g();
    this.d = paramFetchNewsFeedParamsBuilder.i();
    this.e = paramFetchNewsFeedParamsBuilder.h();
    this.f = paramFetchNewsFeedParamsBuilder.d();
  }

  public static FetchNewsFeedParamsBuilder newBuilder()
  {
    return new FetchNewsFeedParamsBuilder();
  }

  public int b()
  {
    return this.c;
  }

  public String c()
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

  public DataFreshnessParam e()
  {
    return this.a;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof FetchNewsFeedParams;
    int i = 0;
    if (bool1)
    {
      FetchNewsFeedParams localFetchNewsFeedParams = (FetchNewsFeedParams)paramObject;
      boolean bool2 = Objects.equal(localFetchNewsFeedParams.e(), e());
      i = 0;
      if (bool2)
      {
        boolean bool3 = Objects.equal(localFetchNewsFeedParams.d(), d());
        i = 0;
        if (bool3)
        {
          boolean bool4 = Objects.equal(localFetchNewsFeedParams.c(), c());
          i = 0;
          if (bool4)
          {
            boolean bool5 = Objects.equal(localFetchNewsFeedParams.f(), f());
            i = 0;
            if (bool5)
            {
              boolean bool6 = Objects.equal(Integer.valueOf(localFetchNewsFeedParams.b()), Integer.valueOf(b()));
              i = 0;
              if (bool6)
              {
                boolean bool7 = Objects.equal(localFetchNewsFeedParams.g(), g());
                i = 0;
                if (bool7)
                  i = 1;
              }
            }
          }
        }
      }
    }
    return i;
  }

  public NewsFeedType f()
  {
    return this.b;
  }

  public FetchNewsFeedParams.ViewMode g()
  {
    return this.f;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = e();
    arrayOfObject[1] = Integer.valueOf(b());
    arrayOfObject[2] = f();
    arrayOfObject[3] = d();
    arrayOfObject[4] = c();
    arrayOfObject[5] = g();
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("Freshness", this.a.toString()).add("Type", this.b.toString()).add("FirstItems", Integer.valueOf(this.c)).add("Before", this.d).add("After", this.e).add("ViewMode", this.f.toString()).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.toString());
    paramParcel.writeString(this.b.toString());
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f.toString());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchNewsFeedParams
 * JD-Core Version:    0.6.0
 */