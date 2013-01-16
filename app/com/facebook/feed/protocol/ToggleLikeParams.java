package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLProfile;

public class ToggleLikeParams
  implements Parcelable
{
  public static final Parcelable.Creator<ToggleLikeParams> CREATOR = new ToggleLikeParams.1();
  public final String a;
  public final boolean b;
  public final GraphQLProfile c;
  public final FeedbackLoggingParams d;
  public final Feedback e;
  public final String f;
  public final String g;

  public ToggleLikeParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.c = ((GraphQLProfile)paramParcel.readParcelable(GraphQLProfile.class.getClassLoader()));
    if (paramParcel.readInt() == 1);
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      this.d = ((FeedbackLoggingParams)paramParcel.readParcelable(FeedbackLoggingParams.class.getClassLoader()));
      this.e = ((Feedback)paramParcel.readParcelable(Feedback.class.getClassLoader()));
      this.f = paramParcel.readString();
      this.g = paramParcel.readString();
      return;
    }
  }

  protected ToggleLikeParams(String paramString1, boolean paramBoolean, GraphQLProfile paramGraphQLProfile, FeedbackLoggingParams paramFeedbackLoggingParams, Feedback paramFeedback, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramBoolean;
    this.c = paramGraphQLProfile;
    this.d = paramFeedbackLoggingParams;
    this.e = paramFeedback;
    this.f = paramString2;
    this.g = paramString3;
  }

  public static ToggleLikeParams.Builder a()
  {
    return new ToggleLikeParams.Builder();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeParcelable(this.c, paramInt);
    if (this.b);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeParcelable(this.d, paramInt);
      paramParcel.writeParcelable(this.e, paramInt);
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.g);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.ToggleLikeParams
 * JD-Core Version:    0.6.0
 */