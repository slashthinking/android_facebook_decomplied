package com.facebook.feed.flyout;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.feed.protocol.FeedbackLoggingParams;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.FeedbackBuilder;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Strings;

public class FlyoutParams
  implements Parcelable
{
  public static final Parcelable.Creator<FlyoutParams> CREATOR = new FlyoutParams.1();
  public final boolean a;
  public final boolean b;
  public final boolean c;
  public final String d;
  public final String e;
  public final FeedbackLoggingParams f;
  public final long g;

  public FlyoutParams(Parcel paramParcel)
  {
    this.a = a(paramParcel.readInt());
    this.b = a(paramParcel.readInt());
    this.c = a(paramParcel.readInt());
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.g = paramParcel.readLong();
    this.f = ((FeedbackLoggingParams)paramParcel.readParcelable(FeedbackLoggingParams.class.getClassLoader()));
  }

  public FlyoutParams(Feedback paramFeedback, FeedbackLoggingParams paramFeedbackLoggingParams)
  {
    this(paramFeedback, paramFeedbackLoggingParams, null, null);
  }

  private FlyoutParams(Feedback paramFeedback, FeedbackLoggingParams paramFeedbackLoggingParams, ArrayNode paramArrayNode, String paramString)
  {
    this.a = paramFeedback.canViewerLike;
    this.b = paramFeedback.canViewerComment;
    this.c = paramFeedback.doesViewerLike;
    this.d = paramFeedback.legacyApiPostId;
    this.e = paramFeedback.id;
    if (paramFeedback.getFetchTimeMs() != -1L)
    {
      this.g = paramFeedback.getFetchTimeMs();
      if (paramFeedbackLoggingParams == null)
        break label83;
      this.f = paramFeedbackLoggingParams;
    }
    while (true)
    {
      return;
      this.g = System.currentTimeMillis();
      break;
      label83: if ((paramArrayNode != null) && (paramArrayNode.size() > 0))
      {
        if (!Strings.isNullOrEmpty(paramString))
        {
          this.f = new FeedbackLoggingParams(paramArrayNode, paramString);
          continue;
        }
        this.f = new FeedbackLoggingParams(paramArrayNode, null);
        continue;
      }
      this.f = null;
    }
  }

  public FlyoutParams(String paramString)
  {
    this(new FeedbackBuilder().b(paramString).n(), null, null, null);
  }

  public static FlyoutParams a(Feedback paramFeedback, FeedbackLoggingParams paramFeedbackLoggingParams)
  {
    if (paramFeedback == null);
    for (FlyoutParams localFlyoutParams = null; ; localFlyoutParams = new FlyoutParams(paramFeedback, paramFeedbackLoggingParams))
      return localFlyoutParams;
  }

  public static Feedback a(FlyoutParams paramFlyoutParams)
  {
    return new FeedbackBuilder().b(paramFlyoutParams.e).a(paramFlyoutParams.d).b(paramFlyoutParams.b).c(paramFlyoutParams.c).a(paramFlyoutParams.a).a(paramFlyoutParams.g).n();
  }

  private Integer a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
      return Integer.valueOf(i);
  }

  private String a(String paramString)
  {
    if (paramString != null);
    while (true)
    {
      return paramString;
      paramString = "";
    }
  }

  private boolean a(int paramInt)
  {
    int i = 1;
    if (paramInt == i);
    while (true)
    {
      return i;
      i = 0;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a(this.a).intValue());
    paramParcel.writeInt(a(this.b).intValue());
    paramParcel.writeInt(a(this.c).intValue());
    paramParcel.writeString(this.d);
    paramParcel.writeString(a(this.e));
    paramParcel.writeLong(this.g);
    paramParcel.writeParcelable(this.f, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FlyoutParams
 * JD-Core Version:    0.6.0
 */