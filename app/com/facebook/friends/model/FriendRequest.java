package com.facebook.friends.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.friends.FriendRequestState;
import com.facebook.friends.FriendshipStatus;
import com.facebook.graphql.model.GraphQLProfile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

public class FriendRequest
  implements Parcelable
{
  public static final Parcelable.Creator<FriendRequest> CREATOR = new FriendRequest.1();

  @JsonIgnore
  public final boolean a;

  @JsonIgnore
  public final FriendRequestState b;

  @JsonProperty("node")
  public final GraphQLProfile profile;

  @JsonProperty("suggesters")
  public final List<GraphQLProfile> suggesters;

  @JsonProperty("time")
  public final long time;

  protected FriendRequest()
  {
    this.profile = null;
    this.time = 0L;
    this.suggesters = ImmutableList.d();
    this.a = false;
    this.b = FriendRequestState.NEEDS_RESPONSE;
  }

  public FriendRequest(Parcel paramParcel)
  {
    this.profile = ((GraphQLProfile)paramParcel.readParcelable(GraphQLProfile.class.getClassLoader()));
    this.time = paramParcel.readLong();
    this.suggesters = Lists.a();
    paramParcel.readTypedList(this.suggesters, GraphQLProfile.CREATOR);
    if (paramParcel.readByte() == 1);
    for (boolean bool = true; ; bool = false)
    {
      this.a = bool;
      this.b = FriendRequestState.valueOf(paramParcel.readString());
      return;
    }
  }

  public FriendRequest(GraphQLProfile paramGraphQLProfile, long paramLong, List<GraphQLProfile> paramList, boolean paramBoolean, FriendRequestState paramFriendRequestState)
  {
    this.profile = paramGraphQLProfile;
    this.time = paramLong;
    this.suggesters = paramList;
    this.a = paramBoolean;
    this.b = paramFriendRequestState;
  }

  public FriendRequest a(FriendRequestState paramFriendRequestState)
  {
    return new FriendRequest(this.profile, this.time, this.suggesters, this.a, paramFriendRequestState);
  }

  public boolean a()
  {
    if ((this.profile.friendshipStatus.equals(FriendshipStatus.CAN_REQUEST.toGqlString())) && (!this.suggesters.isEmpty()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.profile, paramInt);
    paramParcel.writeLong(this.time);
    paramParcel.writeTypedList(this.suggesters);
    if (this.a);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.b.name());
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.model.FriendRequest
 * JD-Core Version:    0.6.0
 */