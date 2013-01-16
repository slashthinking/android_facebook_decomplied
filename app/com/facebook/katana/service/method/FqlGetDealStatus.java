package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.ipc.katana.model.FacebookDealStatus;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FqlGetDealStatus extends FqlGeneratedQuery
{
  private static final Class<?> b = FqlGetDealStatus.class;
  protected Map<Long, FacebookDealStatus> a;

  public FqlGetDealStatus(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "checkin_promotion_claim_status", paramString2, FacebookDealStatus.class);
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, FacebookDealStatus.class);
    this.a = new LinkedHashMap();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FacebookDealStatus localFacebookDealStatus = (FacebookDealStatus)localIterator.next();
      this.a.put(Long.valueOf(localFacebookDealStatus.mDealId), localFacebookDealStatus);
    }
  }

  public Map<Long, FacebookDealStatus> g()
  {
    return Collections.unmodifiableMap(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetDealStatus
 * JD-Core Version:    0.6.0
 */