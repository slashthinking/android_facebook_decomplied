package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;

public class NewMessageResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<NewMessageResult> CREATOR = new NewMessageResult.1();
  private final String a;
  private final Message b;
  private final MessagesCollection c;

  private NewMessageResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readString();
    this.b = ((Message)paramParcel.readParcelable(Message.class.getClassLoader()));
    this.c = ((MessagesCollection)paramParcel.readParcelable(MessagesCollection.class.getClassLoader()));
  }

  public NewMessageResult(DataFreshnessResult paramDataFreshnessResult, String paramString, Message paramMessage, MessagesCollection paramMessagesCollection, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramString;
    this.b = paramMessage;
    this.c = paramMessagesCollection;
  }

  public String a()
  {
    return this.a;
  }

  public Message b()
  {
    return this.b;
  }

  public MessagesCollection c()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeParcelable(this.c, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.NewMessageResult
 * JD-Core Version:    0.6.0
 */