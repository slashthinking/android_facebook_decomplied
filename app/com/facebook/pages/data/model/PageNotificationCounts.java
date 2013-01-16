package com.facebook.pages.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class PageNotificationCounts
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<PageNotificationCounts> CREATOR = new PageNotificationCounts.1();

  @JMAutogen.InferredType(jsonFieldName="new_like_count")
  public final long newLikeCount;

  @JMAutogen.InferredType(jsonFieldName="unread_notif_count")
  public final long unreadNotifCount;

  @JMAutogen.InferredType(jsonFieldName="unseen_message_count")
  public final long unseenMessageCount;

  private PageNotificationCounts()
  {
    this.newLikeCount = 0L;
    this.unseenMessageCount = 0L;
    this.unreadNotifCount = 0L;
  }

  public PageNotificationCounts(Parcel paramParcel)
  {
    this.newLikeCount = paramParcel.readLong();
    this.unseenMessageCount = paramParcel.readLong();
    this.unreadNotifCount = paramParcel.readLong();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof PageNotificationCounts;
    int i = 0;
    if (!bool1);
    while (true)
    {
      return i;
      PageNotificationCounts localPageNotificationCounts = (PageNotificationCounts)paramObject;
      boolean bool2 = this.newLikeCount < localPageNotificationCounts.newLikeCount;
      i = 0;
      if (bool2)
        continue;
      boolean bool3 = this.unseenMessageCount < localPageNotificationCounts.unseenMessageCount;
      i = 0;
      if (bool3)
        continue;
      boolean bool4 = this.unreadNotifCount < localPageNotificationCounts.unreadNotifCount;
      i = 0;
      if (bool4)
        continue;
      i = 1;
    }
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("new like count", Long.valueOf(this.newLikeCount)).add("unseen message count", Long.valueOf(this.unseenMessageCount)).add("unread notification count", Long.valueOf(this.unreadNotifCount)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.newLikeCount);
    paramParcel.writeLong(this.unseenMessageCount);
    paramParcel.writeLong(this.unreadNotifCount);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.model.PageNotificationCounts
 * JD-Core Version:    0.6.0
 */