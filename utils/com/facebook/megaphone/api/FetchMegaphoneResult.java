package com.facebook.megaphone.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.MegaphoneStory;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;

public class FetchMegaphoneResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchMegaphoneResult> CREATOR = new FetchMegaphoneResult.1();
  public final MegaphoneStory a;

  public FetchMegaphoneResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ((MegaphoneStory)paramParcel.readParcelable(MegaphoneStory.class.getClassLoader()));
  }

  public FetchMegaphoneResult(MegaphoneStory paramMegaphoneStory, DataFreshnessResult paramDataFreshnessResult, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramMegaphoneStory;
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

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.api.FetchMegaphoneResult
 * JD-Core Version:    0.6.2
 */