package com.facebook.friends.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class PersonYouMayKnow
  implements Parcelable
{
  public static final Parcelable.Creator<PersonYouMayKnow> CREATOR = new PersonYouMayKnow.1();

  @JsonIgnore
  public final boolean a;

  @JsonProperty("mutual_friends")
  private final PersonYouMayKnow.MutualFriendCount mutualFriendsCount;

  @JsonProperty("name")
  public final String name;

  @JsonProperty("profile_picture")
  public final PersonYouMayKnow.ProfilePicture profilePicture;

  @JsonProperty("id")
  public final long userId;

  PersonYouMayKnow()
  {
    this(0L, null, null, 0, false);
  }

  public PersonYouMayKnow(long paramLong, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    this.userId = paramLong;
    this.name = paramString1;
    this.profilePicture = new PersonYouMayKnow.ProfilePicture(paramString2, null);
    this.mutualFriendsCount = new PersonYouMayKnow.MutualFriendCount(paramInt, null);
    this.a = paramBoolean;
  }

  public PersonYouMayKnow(Parcel paramParcel)
  {
    this.userId = paramParcel.readLong();
    this.name = paramParcel.readString();
    this.profilePicture = new PersonYouMayKnow.ProfilePicture(paramParcel.readString(), null);
    this.mutualFriendsCount = new PersonYouMayKnow.MutualFriendCount(paramParcel.readInt(), null);
    if (paramParcel.readByte() == i);
    while (true)
    {
      this.a = i;
      return;
      i = 0;
    }
  }

  @JsonIgnore
  public int a()
  {
    return PersonYouMayKnow.MutualFriendCount.a(this.mutualFriendsCount);
  }

  public PersonYouMayKnow a(boolean paramBoolean)
  {
    if (this.a == paramBoolean);
    while (true)
    {
      return this;
      this = new PersonYouMayKnow(this.userId, this.name, PersonYouMayKnow.ProfilePicture.a(this.profilePicture), PersonYouMayKnow.MutualFriendCount.a(this.mutualFriendsCount), paramBoolean);
    }
  }

  @JsonIgnore
  public String b()
  {
    return PersonYouMayKnow.ProfilePicture.a(this.profilePicture);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof PersonYouMayKnow;
    int i = 0;
    if (bool1)
    {
      Class localClass1 = paramObject.getClass();
      Class localClass2 = getClass();
      i = 0;
      if (localClass1 == localClass2)
        break label34;
    }
    while (true)
    {
      return i;
      label34: PersonYouMayKnow localPersonYouMayKnow = (PersonYouMayKnow)paramObject;
      boolean bool2 = Objects.equal(Long.valueOf(this.userId), Long.valueOf(localPersonYouMayKnow.userId));
      i = 0;
      if (!bool2)
        continue;
      boolean bool3 = Objects.equal(this.name, localPersonYouMayKnow.name);
      i = 0;
      if (!bool3)
        continue;
      boolean bool4 = Objects.equal(PersonYouMayKnow.ProfilePicture.a(this.profilePicture), PersonYouMayKnow.ProfilePicture.a(localPersonYouMayKnow.profilePicture));
      i = 0;
      if (!bool4)
        continue;
      boolean bool5 = Objects.equal(Integer.valueOf(PersonYouMayKnow.MutualFriendCount.a(this.mutualFriendsCount)), Integer.valueOf(PersonYouMayKnow.MutualFriendCount.a(localPersonYouMayKnow.mutualFriendsCount)));
      i = 0;
      if (!bool5)
        continue;
      i = 1;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Long.valueOf(this.userId);
    arrayOfObject[1] = this.name;
    arrayOfObject[2] = PersonYouMayKnow.ProfilePicture.a(this.profilePicture);
    arrayOfObject[3] = Integer.valueOf(PersonYouMayKnow.MutualFriendCount.a(this.mutualFriendsCount));
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).addValue(Long.valueOf(this.userId)).addValue(this.name).addValue(this.profilePicture).addValue(this.mutualFriendsCount).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.userId);
    paramParcel.writeString(this.name);
    paramParcel.writeString(b());
    paramParcel.writeInt(a());
    if (this.a);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.model.PersonYouMayKnow
 * JD-Core Version:    0.6.0
 */