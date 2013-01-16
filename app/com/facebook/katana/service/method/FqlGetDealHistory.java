package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.ipc.katana.model.FacebookDealHistory;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FqlGetDealHistory extends FqlGeneratedQuery
{
  private static final Class<?> b = FqlGetDealHistory.class;
  protected Map<Long, FacebookDealHistory> a;

  public FqlGetDealHistory(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "checkin_promotion_claim_history", paramString2, FacebookDealHistory.class);
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, FacebookDealHistory.class);
    this.a = new LinkedHashMap();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FacebookDealHistory localFacebookDealHistory = (FacebookDealHistory)localIterator.next();
      this.a.put(Long.valueOf(localFacebookDealHistory.mDealId), localFacebookDealHistory);
    }
  }

  public Map<Long, FacebookDealHistory> g()
  {
    return Collections.unmodifiableMap(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetDealHistory
 * JD-Core Version:    0.6.0
 */