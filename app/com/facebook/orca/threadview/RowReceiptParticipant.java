package com.facebook.orca.threadview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.threads.ParticipantInfo;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import java.util.Comparator;

public class RowReceiptParticipant
  implements Parcelable
{
  public static final Parcelable.Creator<RowReceiptParticipant> CREATOR;
  public static final Comparator<RowReceiptParticipant> a = new RowReceiptParticipant.1();
  private final ParticipantInfo b;
  private final long c;

  static
  {
    CREATOR = new RowReceiptParticipant.2();
  }

  public RowReceiptParticipant(Parcel paramParcel)
  {
    this.b = ((ParticipantInfo)paramParcel.readValue(ParticipantInfo.class.getClassLoader()));
    this.c = paramParcel.readLong();
  }

  public RowReceiptParticipant(ParticipantInfo paramParticipantInfo, long paramLong)
  {
    this.b = paramParticipantInfo;
    this.c = paramLong;
  }

  public ParticipantInfo a()
  {
    return this.b;
  }

  public long b()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return Objects.toStringHelper(RowReceiptParticipant.class).add("participantInfo", this.b).add("readTimestampMs", Long.valueOf(this.c)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.b);
    paramParcel.writeLong(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.RowReceiptParticipant
 * JD-Core Version:    0.6.0
 */