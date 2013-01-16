package com.facebook.katana.util.logging;

import com.facebook.katana.model.FacebookPushNotification.NotificationType;
import java.io.Serializable;

public class NotificationsLogger$NotificationLogObject
  implements Serializable
{
  private static final long serialVersionUID = 8392603941351594325L;
  private long mAlertID;
  private int mClientID;
  private boolean mHandledNatively;
  private boolean mIsUnread;
  private String mLoggingData;
  private FacebookPushNotification.NotificationType mNotifType;
  private String mObjectID;
  private String mObjectType;
  private String mRawType;
  private int mUnreadCount;

  public NotificationLogObject a(int paramInt)
  {
    this.mClientID = paramInt;
    return this;
  }

  public NotificationLogObject a(long paramLong)
  {
    this.mAlertID = paramLong;
    return this;
  }

  public NotificationLogObject a(FacebookPushNotification.NotificationType paramNotificationType)
  {
    this.mNotifType = paramNotificationType;
    return this;
  }

  public NotificationLogObject a(String paramString)
  {
    this.mRawType = paramString;
    return this;
  }

  public NotificationLogObject a(boolean paramBoolean)
  {
    this.mHandledNatively = paramBoolean;
    return this;
  }

  public String a()
  {
    return this.mRawType;
  }

  public NotificationLogObject b(int paramInt)
  {
    this.mUnreadCount = paramInt;
    return this;
  }

  public NotificationLogObject b(String paramString)
  {
    this.mObjectID = paramString;
    return this;
  }

  public NotificationLogObject b(boolean paramBoolean)
  {
    this.mIsUnread = paramBoolean;
    return this;
  }

  public String b()
  {
    if (this.mNotifType == null);
    for (String str = null; ; str = this.mNotifType.toString())
      return str;
  }

  public int c()
  {
    return this.mClientID;
  }

  public NotificationLogObject c(String paramString)
  {
    this.mObjectType = paramString;
    return this;
  }

  public int d()
  {
    return this.mUnreadCount;
  }

  public NotificationLogObject d(String paramString)
  {
    this.mLoggingData = paramString;
    return this;
  }

  public long e()
  {
    return this.mAlertID;
  }

  public String f()
  {
    return this.mObjectID;
  }

  public String g()
  {
    return this.mObjectType;
  }

  public String h()
  {
    return this.mLoggingData;
  }

  public boolean i()
  {
    return this.mHandledNatively;
  }

  public boolean j()
  {
    return this.mIsUnread;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.NotificationsLogger.NotificationLogObject
 * JD-Core Version:    0.6.0
 */