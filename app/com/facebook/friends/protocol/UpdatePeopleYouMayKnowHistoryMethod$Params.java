package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UpdatePeopleYouMayKnowHistoryMethod$Params
  implements Parcelable
{
  public static final Parcelable.Creator<Params> CREATOR = new UpdatePeopleYouMayKnowHistoryMethod.Params.2();
  public final String a;
  public final UpdatePeopleYouMayKnowHistoryMethod.Event b;
  public final UpdatePeopleYouMayKnowHistoryMethod.Location c;

  public UpdatePeopleYouMayKnowHistoryMethod$Params(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = UpdatePeopleYouMayKnowHistoryMethod.Event.valueOf(paramParcel.readString());
    this.c = UpdatePeopleYouMayKnowHistoryMethod.Location.valueOf(paramParcel.readString());
  }

  public UpdatePeopleYouMayKnowHistoryMethod$Params(String paramString, UpdatePeopleYouMayKnowHistoryMethod.Event paramEvent, UpdatePeopleYouMayKnowHistoryMethod.Location paramLocation)
  {
    this.a = paramString;
    this.b = paramEvent;
    this.c = paramLocation;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b.name());
    paramParcel.writeString(this.c.name());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.UpdatePeopleYouMayKnowHistoryMethod.Params
 * JD-Core Version:    0.6.0
 */