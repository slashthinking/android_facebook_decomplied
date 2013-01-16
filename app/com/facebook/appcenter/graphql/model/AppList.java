package com.facebook.appcenter.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import java.util.List;

public class AppList
  implements Parcelable
{

  @JsonProperty("recommended_applications")
  public final GraphQLNodes<AppDetail> recommendedApplications = null;

  public List<AppDetail> a()
  {
    return this.recommendedApplications.a();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject)
      bool = true;
    while (true)
    {
      return bool;
      if ((paramObject == null) || (!(paramObject instanceof AppList)))
      {
        bool = false;
        continue;
      }
      AppList localAppList = (AppList)paramObject;
      bool = Objects.equal(this.recommendedApplications, localAppList.recommendedApplications);
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.recommendedApplications;
    return Objects.hashCode(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.recommendedApplications, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.graphql.model.AppList
 * JD-Core Version:    0.6.0
 */