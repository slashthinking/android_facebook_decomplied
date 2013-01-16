package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;

public class FetchThreadResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchThreadResult> CREATOR;
  public static final FetchThreadResult a = new FetchThreadResult(DataFreshnessResult.NO_DATA, null, null, ImmutableList.d(), null, -1L);
  private final ThreadSummary b;
  private final MessagesCollection c;
  private final ImmutableList<User> d;
  private final User e;

  static
  {
    CREATOR = new FetchThreadResult.1();
  }

  private FetchThreadResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.b = ((ThreadSummary)paramParcel.readParcelable(ThreadSummary.class.getClassLoader()));
    this.c = ((MessagesCollection)paramParcel.readParcelable(MessagesCollection.class.getClassLoader()));
    this.d = ImmutableList.a(paramParcel.readArrayList(User.class.getClassLoader()));
    this.e = ((User)paramParcel.readParcelable(User.class.getClassLoader()));
  }

  public FetchThreadResult(DataFreshnessResult paramDataFreshnessResult, FetchThreadResult paramFetchThreadResult)
  {
    this(paramDataFreshnessResult, paramFetchThreadResult.a(), paramFetchThreadResult.b(), paramFetchThreadResult.c(), paramFetchThreadResult.d(), paramFetchThreadResult.f());
  }

  public FetchThreadResult(DataFreshnessResult paramDataFreshnessResult, ThreadSummary paramThreadSummary, MessagesCollection paramMessagesCollection, ImmutableList<User> paramImmutableList, User paramUser, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.b = paramThreadSummary;
    this.c = paramMessagesCollection;
    this.d = paramImmutableList;
    this.e = paramUser;
  }

  public ThreadSummary a()
  {
    return this.b;
  }

  public MessagesCollection b()
  {
    return this.c;
  }

  public ImmutableList<User> c()
  {
    return this.d;
  }

  public User d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeParcelable(this.c, paramInt);
    paramParcel.writeList(this.d);
    paramParcel.writeParcelable(this.e, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchThreadResult
 * JD-Core Version:    0.6.0
 */