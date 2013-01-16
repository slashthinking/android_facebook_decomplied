package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.model.FacebookCheckin;
import com.fasterxml.jackson.core.JsonParser;
import java.util.List;

class FqlGetFriendCheckins$FqlGetCheckins extends FqlGeneratedQuery
{
  List<FacebookCheckin> a;

  public FqlGetFriendCheckins$FqlGetCheckins(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramString, paramServiceOperationListener, "location_posts_activity", "filter='friend_activity'", FacebookCheckin.class);
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.a = JMParser.b(paramJsonParser, FacebookCheckin.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetFriendCheckins.FqlGetCheckins
 * JD-Core Version:    0.6.0
 */