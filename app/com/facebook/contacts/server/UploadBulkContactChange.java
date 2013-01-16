package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.users.User;
import com.google.common.base.Preconditions;

public class UploadBulkContactChange
  implements Parcelable
{
  public static final Parcelable.Creator<UploadBulkContactChange> CREATOR = new UploadBulkContactChange.1();
  private final String a;
  private final User b;
  private final UploadBulkContactChange.Type c;

  public UploadBulkContactChange(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ((User)paramParcel.readParcelable(User.class.getClassLoader()));
    this.c = ((UploadBulkContactChange.Type)Enum.valueOf(UploadBulkContactChange.Type.class, paramParcel.readString()));
  }

  public UploadBulkContactChange(String paramString, User paramUser, UploadBulkContactChange.Type paramType)
  {
    boolean bool2;
    boolean bool3;
    if (paramString != null)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramUser == null)
        break label64;
      bool3 = bool1;
      label28: Preconditions.checkArgument(bool3);
      if (paramType == null)
        break label70;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      this.a = paramString;
      this.b = paramUser;
      this.c = paramType;
      return;
      bool2 = false;
      break;
      label64: bool3 = false;
      break label28;
      label70: bool1 = false;
    }
  }

  public String a()
  {
    return this.a;
  }

  public User b()
  {
    return this.b;
  }

  public UploadBulkContactChange.Type c()
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
    paramParcel.writeString(this.c.toString());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.UploadBulkContactChange
 * JD-Core Version:    0.6.0
 */