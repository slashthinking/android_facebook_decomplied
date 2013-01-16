package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.models.ContactDetails;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;

public class FetchContactResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchContactResult> CREATOR;
  public static final FetchContactResult a = new FetchContactResult(DataFreshnessResult.NO_DATA, -1L, null, null);
  private final ContactSummary b;
  private final ContactDetails c;

  static
  {
    CREATOR = new FetchContactResult.1();
  }

  private FetchContactResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.b = ((ContactSummary)paramParcel.readParcelable(ContactSummary.class.getClassLoader()));
    this.c = ((ContactDetails)paramParcel.readParcelable(ContactDetails.class.getClassLoader()));
  }

  public FetchContactResult(DataFreshnessResult paramDataFreshnessResult, long paramLong, ContactSummary paramContactSummary, ContactDetails paramContactDetails)
  {
    super(paramDataFreshnessResult, paramLong);
    this.b = paramContactSummary;
    this.c = paramContactDetails;
  }

  public ContactSummary a()
  {
    return this.b;
  }

  public ContactDetails b()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "FetchContactResult (ts " + f() + ") (contactSummary " + this.b + ") (freshness " + e() + ")";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeParcelable(this.c, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchContactResult
 * JD-Core Version:    0.6.0
 */