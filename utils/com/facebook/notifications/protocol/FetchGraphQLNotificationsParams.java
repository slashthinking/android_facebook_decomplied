package com.facebook.notifications.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.DataFreshnessParam;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;

public class FetchGraphQLNotificationsParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchGraphQLNotificationsParams> CREATOR = new FetchGraphQLNotificationsParams.1();
  private final DataFreshnessParam a;
  private final int b;
  private final String c;
  private final String d;
  private final long e;
  private final List<String> f;

  public FetchGraphQLNotificationsParams(Parcel paramParcel)
  {
    this.a = DataFreshnessParam.valueOf(paramParcel.readString());
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readLong();
    this.f = new ArrayList();
    paramParcel.readList(this.f, null);
  }

  public FetchGraphQLNotificationsParams(FetchGraphQLNotificationsParamsBuilder paramFetchGraphQLNotificationsParamsBuilder)
  {
    this.a = paramFetchGraphQLNotificationsParamsBuilder.a();
    this.b = paramFetchGraphQLNotificationsParamsBuilder.b();
    this.c = paramFetchGraphQLNotificationsParamsBuilder.c();
    this.d = paramFetchGraphQLNotificationsParamsBuilder.d();
    this.e = paramFetchGraphQLNotificationsParamsBuilder.e();
    this.f = paramFetchGraphQLNotificationsParamsBuilder.f();
  }

  public DataFreshnessParam a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public long e()
  {
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof FetchGraphQLNotificationsParams;
    boolean bool2 = false;
    if (bool1)
    {
      FetchGraphQLNotificationsParams localFetchGraphQLNotificationsParams = (FetchGraphQLNotificationsParams)paramObject;
      boolean bool3 = Objects.equal(this.a, localFetchGraphQLNotificationsParams.a);
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = Objects.equal(this.d, localFetchGraphQLNotificationsParams.d);
        bool2 = false;
        if (bool4)
        {
          boolean bool5 = Objects.equal(this.c, localFetchGraphQLNotificationsParams.c);
          bool2 = false;
          if (bool5)
          {
            boolean bool6 = Objects.equal(Integer.valueOf(this.b), Integer.valueOf(localFetchGraphQLNotificationsParams.b));
            bool2 = false;
            if (bool6)
            {
              boolean bool7 = Objects.equal(Long.valueOf(this.e), Long.valueOf(localFetchGraphQLNotificationsParams.e));
              bool2 = false;
              if (bool7)
              {
                boolean bool8 = this.f.equals(localFetchGraphQLNotificationsParams.f);
                bool2 = false;
                if (bool8)
                  bool2 = true;
              }
            }
          }
        }
      }
    }
    return bool2;
  }

  public List<String> f()
  {
    return this.f;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.toString());
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeList(this.f);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.FetchGraphQLNotificationsParams
 * JD-Core Version:    0.6.2
 */