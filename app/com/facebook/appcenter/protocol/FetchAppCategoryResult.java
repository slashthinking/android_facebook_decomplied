package com.facebook.appcenter.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.appcenter.graphql.model.AppCenterCategory;
import com.facebook.appcenter.graphql.model.AppCenterCategoryList;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.google.common.base.Preconditions;
import java.util.List;

public class FetchAppCategoryResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchAppCategoryResult> CREATOR = new FetchAppCategoryResult.1();
  private final AppCenterCategoryList a;

  public FetchAppCategoryResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ((AppCenterCategoryList)paramParcel.readParcelable(AppCenterCategoryList.class.getClassLoader()));
  }

  public FetchAppCategoryResult(AppCenterCategoryList paramAppCenterCategoryList, DataFreshnessResult paramDataFreshnessResult, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramAppCenterCategoryList;
  }

  public List<AppCenterCategory> a()
  {
    Preconditions.checkNotNull(this.a);
    return this.a.applicationCategories;
  }

  public AppCenterCategoryList b()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.a, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.protocol.FetchAppCategoryResult
 * JD-Core Version:    0.6.0
 */