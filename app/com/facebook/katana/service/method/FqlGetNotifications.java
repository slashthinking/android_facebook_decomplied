package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.notifications.model.FacebookNotification;
import com.fasterxml.jackson.core.JsonParser;
import java.util.List;

public class FqlGetNotifications extends FqlGeneratedQuery
{
  private List<FacebookNotification> a;

  public FqlGetNotifications(Context paramContext, Intent paramIntent, String paramString, long paramLong, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramString, paramServiceOperationListener, "notification", a(paramLong), FacebookNotification.class);
  }

  private static String a(long paramLong)
  {
    return "(recipient_id=%1) AND is_hidden = 0 AND is_mobile_ready ORDER BY created_time DESC LIMIT 30".replaceFirst("%1", "" + paramLong);
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.a = JMParser.b(paramJsonParser, FacebookNotification.class);
  }

  public List<FacebookNotification> g()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetNotifications
 * JD-Core Version:    0.6.0
 */