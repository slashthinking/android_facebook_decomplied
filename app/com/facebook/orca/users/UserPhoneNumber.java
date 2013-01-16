package com.facebook.orca.users;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import com.facebook.common.util.TriState;

public class UserPhoneNumber extends UserIdentifier
  implements Parcelable
{
  public static final Parcelable.Creator<UserPhoneNumber> CREATOR = new UserPhoneNumber.1();
  private final UserIdentifierKey a;
  private final String b;
  private final int c;
  private final TriState d;

  private UserPhoneNumber(Parcel paramParcel)
  {
    this.a = new UserIdentifierKey(UserIdentifier.IdentifierType.PHONE, paramParcel.readString());
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = TriState.valueOf(paramParcel.readString());
  }

  public UserPhoneNumber(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, TriState.UNSET);
  }

  public UserPhoneNumber(String paramString1, String paramString2, int paramInt, TriState paramTriState)
  {
    this.a = new UserIdentifierKey(UserIdentifier.IdentifierType.PHONE, paramString2);
    this.b = paramString1;
    this.c = paramInt;
    this.d = paramTriState;
  }

  public String a()
  {
    return this.b;
  }

  public String a(Resources paramResources)
  {
    CharSequence localCharSequence = ContactsContract.CommonDataKinds.Phone.getTypeLabel(paramResources, this.c, null);
    if (localCharSequence != null);
    for (String str = this.b + " (" + localCharSequence + ")"; ; str = this.b)
      return str;
  }

  public String b()
  {
    return this.a.b;
  }

  public UserIdentifierKey c()
  {
    return this.a;
  }

  public String d()
  {
    return this.a.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public UserIdentifier.IdentifierType e()
  {
    return UserIdentifier.IdentifierType.PHONE;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    UserPhoneNumber localUserPhoneNumber;
    do
    {
      while (true)
      {
        return i;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
        {
          i = 0;
          continue;
        }
        localUserPhoneNumber = (UserPhoneNumber)paramObject;
        if (this.c != localUserPhoneNumber.c)
        {
          i = 0;
          continue;
        }
        if (this.b != null)
        {
          if (this.b.equals(localUserPhoneNumber.b));
        }
        else
          do
          {
            i = 0;
            break;
          }
          while (localUserPhoneNumber.b != null);
        if (this.d == localUserPhoneNumber.d)
          break;
        i = 0;
      }
      if (this.a == null)
        break;
    }
    while (this.a.equals(localUserPhoneNumber.a));
    while (true)
    {
      i = 0;
      break;
      if (localUserPhoneNumber.a == null)
        break;
    }
  }

  public int f()
  {
    return this.c;
  }

  public TriState g()
  {
    return this.d;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.a != null)
    {
      i = this.a.hashCode();
      j = i * 31;
      if (this.b == null)
        break label85;
    }
    label85: for (int k = this.b.hashCode(); ; k = 0)
    {
      int m = 31 * (31 * (k + j) + this.c);
      TriState localTriState = this.d;
      int n = 0;
      if (localTriState != null)
        n = this.d.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(d());
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d.name());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.UserPhoneNumber
 * JD-Core Version:    0.6.0
 */