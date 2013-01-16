package com.facebook.appcenter.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class AppCenterCategoryList
  implements Parcelable
{
  public static final Parcelable.Creator<AppCenterCategoryList> CREATOR = new AppCenterCategoryList.1();

  @JsonProperty("application_categories")
  public final List<AppCenterCategory> applicationCategories;

  protected AppCenterCategoryList()
  {
    this.applicationCategories = null;
  }

  public AppCenterCategoryList(Parcel paramParcel)
  {
    this.applicationCategories = paramParcel.readArrayList(AppCenterCategory.class.getClassLoader());
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.applicationCategories);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.graphql.model.AppCenterCategoryList
 * JD-Core Version:    0.6.0
 */