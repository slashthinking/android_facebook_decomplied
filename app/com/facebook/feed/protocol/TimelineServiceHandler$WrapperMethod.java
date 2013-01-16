package com.facebook.feed.protocol;

import android.os.Parcelable;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;

public class TimelineServiceHandler$WrapperMethod
  implements ApiMethod<Parcelable, Parcelable>
{
  ApiMethod a;
  UserInteractionController b;

  public TimelineServiceHandler$WrapperMethod(ApiMethod paramApiMethod, UserInteractionController paramUserInteractionController)
  {
    this.a = paramApiMethod;
    this.b = paramUserInteractionController;
  }

  public Parcelable a(Parcelable paramParcelable, ApiResponse paramApiResponse)
  {
    this.b.c();
    return (Parcelable)this.a.a(paramParcelable, paramApiResponse);
  }

  public ApiRequest a(Parcelable paramParcelable)
  {
    return this.a.a(paramParcelable);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.TimelineServiceHandler.WrapperMethod
 * JD-Core Version:    0.6.0
 */