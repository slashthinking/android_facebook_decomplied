package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.FeedStory;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;

public class FetchSingleStoryResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchSingleStoryResult> CREATOR = new FetchSingleStoryResult.1();
  public final FeedStory a;

  public FetchSingleStoryResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ((FeedStory)paramParcel.readParcelable(FeedStory.class.getClassLoader()));
  }

  public FetchSingleStoryResult(FeedStory paramFeedStory, DataFreshnessResult paramDataFreshnessResult, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramFeedStory;
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
 * Qualified Name:     com.facebook.feed.protocol.FetchSingleStoryResult
 * JD-Core Version:    0.6.0
 */