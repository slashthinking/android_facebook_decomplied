package com.facebook.appcenter.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.appcenter.graphql.model.AppCenterPermission;
import java.util.Iterator;
import java.util.List;

public class GrantAppGdpParams
  implements Parcelable
{
  public static final Parcelable.Creator<GrantAppGdpParams> CREATOR = new GrantAppGdpParams.1();
  private final String a;
  private final String b;
  private final String c;

  public GrantAppGdpParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }

  public GrantAppGdpParams(String paramString1, List<AppCenterPermission> paramList, String paramString2)
  {
    this.a = paramString1;
    if ((paramList != null) && (paramList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append(((AppCenterPermission)localIterator.next()).name);
        localStringBuilder.append(',');
      }
      localStringBuilder.setLength(-1 + localStringBuilder.length());
      this.b = localStringBuilder.toString();
      if (paramString2 == null)
        break label141;
    }
    label141: for (this.c = ("{\"value\":\"" + paramString2 + "\"}"); ; this.c = null)
    {
      return;
      this.b = null;
      break;
    }
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.service.GrantAppGdpParams
 * JD-Core Version:    0.6.0
 */