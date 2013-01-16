package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableSet;

public class DeleteMessagesParams
  implements Parcelable
{
  public static final Parcelable.Creator<DeleteMessagesParams> CREATOR = new DeleteMessagesParams.1();
  private final String a;
  private final ImmutableSet<String> b;

  DeleteMessagesParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ImmutableSet.a(paramParcel.createStringArrayList());
  }

  public DeleteMessagesParams(String paramString, ImmutableSet<String> paramImmutableSet)
  {
    this.a = paramString;
    this.b = paramImmutableSet;
  }

  public String a()
  {
    return this.a;
  }

  public ImmutableSet<String> b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeList(this.b.h());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.DeleteMessagesParams
 * JD-Core Version:    0.6.0
 */