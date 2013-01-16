package com.facebook.orca.ops;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.ErrorCodeUtil;
import com.facebook.orca.server.OperationResult;

public class ServiceException extends Exception
  implements Parcelable
{
  public static final Parcelable.Creator<ServiceException> CREATOR = new ServiceException.1();
  private final ErrorCode errorCode;
  private final OperationResult result;

  private ServiceException(Parcel paramParcel)
  {
    this.errorCode = ((ErrorCode)paramParcel.readSerializable());
    this.result = ((OperationResult)paramParcel.readParcelable(OperationResult.class.getClassLoader()));
  }

  public ServiceException(OperationResult paramOperationResult)
  {
    super(paramOperationResult.d() + ": " + paramOperationResult.e());
    this.errorCode = paramOperationResult.d();
    this.result = paramOperationResult;
  }

  public static ServiceException a(Throwable paramThrowable)
  {
    return new ServiceException(OperationResult.a(ErrorCodeUtil.b(paramThrowable), ErrorCodeUtil.c(paramThrowable)));
  }

  public ErrorCode a()
  {
    return this.errorCode;
  }

  public OperationResult b()
  {
    return this.result;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeSerializable(this.errorCode);
    paramParcel.writeParcelable(this.result, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.ops.ServiceException
 * JD-Core Version:    0.6.0
 */