package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphQLProfile
  implements Parcelable, Dedupable
{
  public static final Parcelable.Creator<GraphQLProfile> CREATOR = new GraphQLProfile.1();

  @JsonProperty("birthdate")
  public final GraphQLBirthdate birthdate;

  @JsonProperty("can_viewer_send_gift")
  public boolean canViewerSendGift;

  @JsonProperty("does_viewer_like")
  public boolean doesViewerLike;

  @JsonProperty("facepile_large")
  public final GraphQLImage facepileLarge;

  @JsonProperty("facepile_single")
  public final GraphQLImage facepileSingle;

  @JsonProperty("facepile_small")
  public final GraphQLImage facepileSmall;

  @JsonProperty("friendship_status")
  public final String friendshipStatus;

  @JsonProperty("id")
  public final String id;

  @JsonProperty("mutual_friends")
  public final GraphQLMutualFriends mutualFriends;

  @JsonProperty("name")
  public final String name;

  @JsonProperty("__type__")
  public final GraphQLObjectType objectType;

  @JsonProperty("profile_picture")
  public final GraphQLImage profilePicture;

  protected GraphQLProfile()
  {
    this(new GraphQLProfile.Builder());
  }

  public GraphQLProfile(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.name = paramParcel.readString();
    this.friendshipStatus = paramParcel.readString();
    this.profilePicture = ((GraphQLImage)paramParcel.readParcelable(GraphQLImage.class.getClassLoader()));
    this.objectType = ((GraphQLObjectType)paramParcel.readParcelable(GraphQLObjectType.class.getClassLoader()));
    int j;
    if (paramParcel.readInt() == i)
    {
      j = i;
      this.doesViewerLike = j;
      if (paramParcel.readInt() != i)
        break label176;
    }
    while (true)
    {
      this.canViewerSendGift = i;
      this.mutualFriends = ((GraphQLMutualFriends)paramParcel.readParcelable(GraphQLMutualFriends.class.getClassLoader()));
      this.birthdate = ((GraphQLBirthdate)paramParcel.readParcelable(GraphQLBirthdate.class.getClassLoader()));
      this.facepileLarge = ((GraphQLImage)paramParcel.readParcelable(GraphQLImage.class.getClassLoader()));
      this.facepileSmall = ((GraphQLImage)paramParcel.readParcelable(GraphQLImage.class.getClassLoader()));
      this.facepileSingle = ((GraphQLImage)paramParcel.readParcelable(GraphQLImage.class.getClassLoader()));
      return;
      j = 0;
      break;
      label176: i = 0;
    }
  }

  protected GraphQLProfile(GraphQLProfile.Builder paramBuilder)
  {
    this.id = GraphQLProfile.Builder.a(paramBuilder);
    this.name = GraphQLProfile.Builder.b(paramBuilder);
    this.friendshipStatus = GraphQLProfile.Builder.c(paramBuilder);
    this.profilePicture = GraphQLProfile.Builder.d(paramBuilder);
    this.objectType = GraphQLProfile.Builder.e(paramBuilder);
    this.doesViewerLike = GraphQLProfile.Builder.f(paramBuilder);
    this.canViewerSendGift = GraphQLProfile.Builder.g(paramBuilder);
    this.mutualFriends = GraphQLProfile.Builder.h(paramBuilder);
    this.birthdate = GraphQLProfile.Builder.i(paramBuilder);
    this.facepileLarge = null;
    this.facepileSmall = null;
    this.facepileSingle = null;
  }

  @JsonIgnore
  public String a()
  {
    return this.id;
  }

  public String b()
  {
    return this.id;
  }

  public boolean c()
  {
    if ((this.profilePicture != null) && (this.profilePicture.uri != null));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.friendshipStatus);
    paramParcel.writeParcelable(this.profilePicture, paramInt);
    paramParcel.writeParcelable(this.objectType, paramInt);
    int j;
    if (this.doesViewerLike)
    {
      j = i;
      paramParcel.writeInt(j);
      if (!this.canViewerSendGift)
        break label124;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      paramParcel.writeParcelable(this.mutualFriends, paramInt);
      paramParcel.writeParcelable(this.birthdate, paramInt);
      paramParcel.writeParcelable(this.facepileLarge, paramInt);
      paramParcel.writeParcelable(this.facepileSmall, paramInt);
      paramParcel.writeParcelable(this.facepileSingle, paramInt);
      return;
      j = 0;
      break;
      label124: i = 0;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.model.GraphQLProfile
 * JD-Core Version:    0.6.2
 */