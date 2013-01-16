package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.friends.model.FriendRequest;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import java.util.List;

public class FetchFriendRequestsMethod$Result
  implements Parcelable
{
  public static final Parcelable.Creator<Result> CREATOR = new FetchFriendRequestsMethod.Result.1();

  @JsonProperty("edges")
  public final List<FriendRequest> friendRequests = Lists.a();

  @JsonProperty("page_info")
  public final GraphQLPageInfo pageInfo;

  public FetchFriendRequestsMethod$Result()
  {
    this.pageInfo = GraphQLPageInfo.a;
  }

  public FetchFriendRequestsMethod$Result(Parcel paramParcel)
  {
    paramParcel.readTypedList(this.friendRequests, FriendRequest.CREATOR);
    this.pageInfo = ((GraphQLPageInfo)paramParcel.readParcelable(GraphQLPageInfo.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.friendRequests);
    paramParcel.writeParcelable(this.pageInfo, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.FetchFriendRequestsMethod.Result
 * JD-Core Version:    0.6.0
 */