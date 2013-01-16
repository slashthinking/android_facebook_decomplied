package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.katana.util.Utils;
import java.util.HashMap;
import java.util.Map;

public class FacebookNotifications
  implements JMStaticKeysDictDestination
{
  private static final String UNREAD = "unread";
  private static final String UNSEEN = "unseen";

  @JMAutogen.InferredType(jsonFieldName="messages")
  private Map<String, Long> mMessagesCounts = new HashMap();

  @JMAutogen.InferredType(jsonFieldName="notification_counts")
  private Map<String, Long> mNotificationsCounts = new HashMap();

  @JMAutogen.InferredType(jsonFieldName="pokes")
  private final Map<String, Long> mPokesCounts = new HashMap();

  @JMAutogen.InferredType(jsonFieldName="friend_requests_counts")
  private Map<String, Long> mRequestsCounts = new HashMap();

  @JMAutogen.InferredType(jsonFieldName="shares")
  private final Map<String, Long> mSharesCounts = new HashMap();

  public int a()
  {
    return ((Long)Utils.a(this.mRequestsCounts, "unread", Long.valueOf(0L))).intValue();
  }

  public void a(int paramInt)
  {
    this.mMessagesCounts = new HashMap(this.mMessagesCounts);
    this.mMessagesCounts.put("unseen", Long.valueOf(paramInt));
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.mRequestsCounts = new HashMap(this.mRequestsCounts);
    this.mRequestsCounts.put("unread", Long.valueOf(paramInt1));
    this.mRequestsCounts.put("unseen", Long.valueOf(paramInt2));
  }

  public int b()
  {
    return ((Long)Utils.a(this.mRequestsCounts, "unseen", Long.valueOf(0L))).intValue();
  }

  public void b(int paramInt)
  {
    this.mRequestsCounts = new HashMap(this.mRequestsCounts);
    this.mRequestsCounts.put("unseen", Long.valueOf(paramInt));
  }

  public int c()
  {
    return ((Long)Utils.a(this.mNotificationsCounts, "unseen", Long.valueOf(0L))).intValue();
  }

  public int d()
  {
    return ((Long)Utils.a(this.mMessagesCounts, "unseen", Long.valueOf(0L))).intValue();
  }

  public void e()
  {
    this.mRequestsCounts = new HashMap(this.mRequestsCounts);
    this.mRequestsCounts.put("unseen", Long.valueOf(0L));
  }

  public void f()
  {
    this.mNotificationsCounts = new HashMap(this.mNotificationsCounts);
    this.mNotificationsCounts.put("unseen", Long.valueOf(0L));
  }

  public void g()
  {
    this.mMessagesCounts = new HashMap(this.mMessagesCounts);
    this.mMessagesCounts.put("unseen", Long.valueOf(0L));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookNotifications
 * JD-Core Version:    0.6.0
 */