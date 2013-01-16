package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.ipc.katana.model.FacebookDeal;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FqlGetDeals extends FqlGeneratedQuery
{
  private static final Class<?> b = FqlGetDeals.class;
  protected Map<Long, FacebookDeal> a;

  public FqlGetDeals(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, String paramString2)
  {
    super(paramContext, paramIntent, paramString1, paramServiceOperationListener, "checkin_promotion", paramString2, FacebookDeal.class);
  }

  protected void a(JsonParser paramJsonParser)
  {
    List localList = JMParser.b(paramJsonParser, FacebookDeal.class);
    this.a = new LinkedHashMap();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FacebookDeal localFacebookDeal = (FacebookDeal)localIterator.next();
      this.a.put(Long.valueOf(localFacebookDeal.mPageId), localFacebookDeal);
    }
  }

  public Map<Long, FacebookDeal> g()
  {
    return Collections.unmodifiableMap(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetDeals
 * JD-Core Version:    0.6.0
 */