package com.facebook.feed.flyout;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.GraphQLProfile;
import java.util.List;

public class FlyoutAggrEntParams
  implements Parcelable
{
  public static final Parcelable.Creator<FlyoutAggrEntParams> CREATOR = new FlyoutAggrEntParams.1();
  public final List<GraphQLProfile> a;

  public FlyoutAggrEntParams(Parcel paramParcel)
  {
    this.a = paramParcel.readArrayList(GraphQLProfile.class.getClassLoader());
  }

  public FlyoutAggrEntParams(List<GraphQLProfile> paramList)
  {
    this.a = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FlyoutAggrEntParams
 * JD-Core Version:    0.6.0
 */