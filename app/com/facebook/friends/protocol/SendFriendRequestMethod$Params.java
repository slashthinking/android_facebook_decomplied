package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SendFriendRequestMethod$Params
  implements Parcelable
{
  public static final Parcelable.Creator<Params> CREATOR = new SendFriendRequestMethod.Params.1();
  public final long a;
  public final SendFriendRequestMethod.HowFound b;
  public final SendFriendRequestMethod.PeopleYouMayKnowLocation c;

  public SendFriendRequestMethod$Params(long paramLong, SendFriendRequestMethod.HowFound paramHowFound, SendFriendRequestMethod.PeopleYouMayKnowLocation paramPeopleYouMayKnowLocation)
  {
    this.a = paramLong;
    this.b = paramHowFound;
    this.c = paramPeopleYouMayKnowLocation;
  }

  public SendFriendRequestMethod$Params(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = SendFriendRequestMethod.HowFound.valueOf(paramParcel.readString());
    if (paramParcel.readByte() == 1);
    for (SendFriendRequestMethod.PeopleYouMayKnowLocation localPeopleYouMayKnowLocation = SendFriendRequestMethod.PeopleYouMayKnowLocation.valueOf(paramParcel.readString()); ; localPeopleYouMayKnowLocation = null)
    {
      this.c = localPeopleYouMayKnowLocation;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b.name());
    if (this.c != null)
    {
      paramParcel.writeByte(1);
      paramParcel.writeString(this.c.name());
    }
    while (true)
    {
      return;
      paramParcel.writeByte(0);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.SendFriendRequestMethod.Params
 * JD-Core Version:    0.6.0
 */