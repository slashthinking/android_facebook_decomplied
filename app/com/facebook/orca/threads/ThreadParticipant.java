package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class ThreadParticipant
  implements Parcelable
{
  public static final Parcelable.Creator<ThreadParticipant> CREATOR = new ThreadParticipant.1();
  private final ParticipantInfo a;
  private final String b;
  private final NotificationSetting c;
  private final long d;
  private final String e;

  private ThreadParticipant(Parcel paramParcel)
  {
    this.a = ((ParticipantInfo)paramParcel.readParcelable(ParticipantInfo.class.getClassLoader()));
    this.b = paramParcel.readString();
    this.c = ((NotificationSetting)paramParcel.readParcelable(NotificationSetting.class.getClassLoader()));
    this.d = paramParcel.readLong();
    this.e = paramParcel.readString();
  }

  ThreadParticipant(ThreadParticipantBuilder paramThreadParticipantBuilder)
  {
    this.a = paramThreadParticipantBuilder.a();
    this.b = paramThreadParticipantBuilder.b();
    this.c = paramThreadParticipantBuilder.c();
    this.d = paramThreadParticipantBuilder.d();
    this.e = paramThreadParticipantBuilder.e();
  }

  public ParticipantInfo a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.a.b();
  }

  public boolean c()
  {
    return this.a.c();
  }

  public UserKey d()
  {
    return this.a.e();
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.a.a();
  }

  public String f()
  {
    return this.a.d();
  }

  public String g()
  {
    return this.b;
  }

  public NotificationSetting h()
  {
    return this.c;
  }

  public long i()
  {
    return this.d;
  }

  public String j()
  {
    return this.e;
  }

  public String toString()
  {
    return Objects.toStringHelper(ThreadParticipant.class).add("participantInfo", this.a).add("threadId", this.b).add("lastReadReceiptTimestampMs", Long.valueOf(this.d)).add("lastDeliveredReceiptMsgId", this.e).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.c, paramInt);
    paramParcel.writeLong(this.d);
    paramParcel.writeString(this.e);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ThreadParticipant
 * JD-Core Version:    0.6.0
 */