package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.threads.Message;
import com.facebook.orca.users.UserWithIdentifier;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class CreateThreadParams
  implements Parcelable
{
  public static final Parcelable.Creator<CreateThreadParams> CREATOR = new CreateThreadParams.1();
  private final String a;
  private final Message b;
  private final ImmutableList<UserWithIdentifier> c;

  CreateThreadParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ((Message)paramParcel.readParcelable(Message.class.getClassLoader()));
    this.c = ImmutableList.a(paramParcel.readArrayList(UserWithIdentifier.class.getClassLoader()));
  }

  public CreateThreadParams(String paramString, Message paramMessage, List<UserWithIdentifier> paramList)
  {
    this.a = paramString;
    this.b = paramMessage;
    this.c = ImmutableList.a(paramList);
  }

  public Message a()
  {
    return this.b;
  }

  public String b()
  {
    return this.a;
  }

  public boolean c()
  {
    if (this.a != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public ImmutableList<UserWithIdentifier> d()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeList(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.CreateThreadParams
 * JD-Core Version:    0.6.0
 */