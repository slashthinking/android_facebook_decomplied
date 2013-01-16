package com.facebook.orca.contacts.upload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Preconditions;

public final class ContactsUploadState
  implements Parcelable
{
  public static final Parcelable.Creator<ContactsUploadState> CREATOR = new ContactsUploadState.1();
  private final ContactsUploadState.Status a;
  private final int b;
  private final int c;
  private final int d;
  private final OperationResult e;
  private final ServiceException f;

  private ContactsUploadState(Parcel paramParcel)
  {
    this.a = ((ContactsUploadState.Status)Enum.valueOf(ContactsUploadState.Status.class, paramParcel.readString()));
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = ((OperationResult)paramParcel.readParcelable(OperationResult.class.getClassLoader()));
    this.f = ((ServiceException)paramParcel.readParcelable(ServiceException.class.getClassLoader()));
  }

  private ContactsUploadState(ContactsUploadState.Status paramStatus, int paramInt1, int paramInt2, int paramInt3, OperationResult paramOperationResult, ServiceException paramServiceException)
  {
    if (paramStatus != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.a = paramStatus;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramOperationResult;
      this.f = paramServiceException;
      return;
    }
  }

  public static ContactsUploadState a(int paramInt1, int paramInt2, int paramInt3)
  {
    return new ContactsUploadState(ContactsUploadState.Status.RUNNING, paramInt1, paramInt2, paramInt3, null, null);
  }

  public static ContactsUploadState a(ContactsUploadState paramContactsUploadState, ServiceException paramServiceException)
  {
    return new ContactsUploadState(ContactsUploadState.Status.FAILED, paramContactsUploadState.b(), paramContactsUploadState.c(), paramContactsUploadState.d(), null, paramServiceException);
  }

  public static ContactsUploadState a(ContactsUploadState paramContactsUploadState, OperationResult paramOperationResult)
  {
    return new ContactsUploadState(ContactsUploadState.Status.SUCCEEDED, paramContactsUploadState.b(), paramContactsUploadState.c(), paramContactsUploadState.d(), paramOperationResult, null);
  }

  public static ContactsUploadState e()
  {
    return new ContactsUploadState(ContactsUploadState.Status.NOT_STARTED, 0, 0, 0, null, null);
  }

  public static ContactsUploadState f()
  {
    return new ContactsUploadState(ContactsUploadState.Status.STARTED, 0, 0, 0, null, null);
  }

  public static ContactsUploadState g()
  {
    return new ContactsUploadState(ContactsUploadState.Status.FAILED, 0, 0, 0, null, null);
  }

  public ContactsUploadState.Status a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public int d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "ContactsUploadState (" + this.a + ") (processed/matched/total): " + this.b + "/" + this.c + "/" + this.d;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.toString());
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeParcelable(this.e, 0);
    paramParcel.writeParcelable(this.f, 0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.upload.ContactsUploadState
 * JD-Core Version:    0.6.0
 */