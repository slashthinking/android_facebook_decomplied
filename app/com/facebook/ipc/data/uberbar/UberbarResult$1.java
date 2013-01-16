package com.facebook.ipc.data.uberbar;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

final class UberbarResult$1
  implements Parcelable.Creator<UberbarResult>
{
  public UberbarResult a(Parcel paramParcel)
  {
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    UberbarResult.FriendStatus localFriendStatus;
    Uri localUri1;
    Uri localUri2;
    Uri localUri3;
    String str3;
    String str4;
    String str5;
    if (str2.equals(""))
    {
      localFriendStatus = null;
      localUri1 = (Uri)paramParcel.readParcelable(null);
      localUri2 = (Uri)paramParcel.readParcelable(null);
      localUri3 = (Uri)paramParcel.readParcelable(null);
      str3 = paramParcel.readString();
      str4 = paramParcel.readString();
      str5 = paramParcel.readString();
      if (!str5.equals(""))
        break label161;
    }
    label161: for (UberbarResult.Type localType = null; ; localType = UberbarResult.Type.valueOf(str5))
    {
      long l = paramParcel.readLong();
      ArrayList localArrayList = paramParcel.readArrayList(null);
      return UberbarResult.newBuilder().a(str1).a(localFriendStatus).a(localUri1).b(localUri2).c(localUri3).b(str3).c(str4).a(localType).a(l).a(localArrayList).a();
      localFriendStatus = UberbarResult.FriendStatus.valueOf(str2);
      break;
    }
  }

  public UberbarResult[] a(int paramInt)
  {
    return new UberbarResult[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.data.uberbar.UberbarResult.1
 * JD-Core Version:    0.6.0
 */