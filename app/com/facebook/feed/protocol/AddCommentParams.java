package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.FeedComment;

public class AddCommentParams
  implements Parcelable
{
  public static final Parcelable.Creator<AddCommentParams> CREATOR = new AddCommentParams.1();
  public final String a;
  public final String b;
  public final FeedComment c;
  public FeedbackLoggingParams d;

  public AddCommentParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = ((FeedComment)paramParcel.readParcelable(FeedComment.class.getClassLoader()));
    this.d = ((FeedbackLoggingParams)paramParcel.readParcelable(FeedbackLoggingParams.class.getClassLoader()));
  }

  public AddCommentParams(String paramString1, String paramString2, FeedComment paramFeedComment)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramFeedComment;
    this.d = null;
  }

  public AddCommentParams(String paramString1, String paramString2, FeedComment paramFeedComment, FeedbackLoggingParams paramFeedbackLoggingParams)
  {
    this(paramString1, paramString2, paramFeedComment);
    this.d = paramFeedbackLoggingParams;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.c, paramInt);
    paramParcel.writeParcelable(this.d, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.AddCommentParams
 * JD-Core Version:    0.6.0
 */