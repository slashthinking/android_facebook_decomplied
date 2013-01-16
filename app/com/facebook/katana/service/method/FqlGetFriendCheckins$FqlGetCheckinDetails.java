package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.katana.model.FacebookCheckinDetails;
import com.fasterxml.jackson.core.JsonParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class FqlGetFriendCheckins$FqlGetCheckinDetails extends FqlGeneratedQuery
{
  Map<Long, FacebookCheckinDetails> a;

  public FqlGetFriendCheckins$FqlGetCheckinDetails(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "location_post", paramString2, FacebookCheckinDetails.class);
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, FacebookCheckinDetails.class);
    this.a = new HashMap();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FacebookCheckinDetails localFacebookCheckinDetails = (FacebookCheckinDetails)localIterator.next();
      this.a.put(Long.valueOf(localFacebookCheckinDetails.mCheckinId), localFacebookCheckinDetails);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetFriendCheckins.FqlGetCheckinDetails
 * JD-Core Version:    0.6.0
 */