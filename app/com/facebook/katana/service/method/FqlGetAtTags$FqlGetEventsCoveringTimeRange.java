package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookEvent;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.util.TimeUtils;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FqlGetAtTags$FqlGetEventsCoveringTimeRange extends FqlGeneratedQuery
  implements ApiMethodCallback
{
  private static final String a = FqlGetEventsCoveringTimeRange.class.getSimpleName();
  private Map<Long, FacebookEvent> b = new LinkedHashMap();

  public FqlGetAtTags$FqlGetEventsCoveringTimeRange(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    super(paramContext, paramIntent, paramString, paramServiceOperationListener, "event", a(paramLong1, paramInt, paramLong2, paramLong3), FacebookEvent.class);
  }

  public static FqlGetEventsCoveringTimeRange a(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, long paramLong, int paramInt)
  {
    long l = System.currentTimeMillis();
    return new FqlGetEventsCoveringTimeRange(paramContext, paramIntent, paramString, paramServiceOperationListener, paramLong, paramInt, l, l);
  }

  private static String a(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    long l1 = TimeUtils.a(paramLong2);
    long l2 = TimeUtils.a(paramLong3);
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Long.valueOf(l2 - 10800L);
    arrayOfObject[1] = Long.valueOf(10800L + l1);
    arrayOfObject[2] = Long.valueOf(paramLong1);
    arrayOfObject[3] = Long.valueOf(l1 - 1209600L);
    arrayOfObject[4] = Long.valueOf(l2 + 1209600L);
    arrayOfObject[5] = Integer.valueOf(paramInt);
    return StringLocaleUtil.a("%d < end_time AND %d > start_time AND eid IN (SELECT eid FROM event_member WHERE uid = %d AND %d < start_time AND %d > start_time AND rsvp_status IN ('attending', 'unsure')) ORDER BY end_time LIMIT %d", arrayOfObject);
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).c(paramAppSession, paramString1, paramInt, paramString2, paramException, this.b);
  }

  protected void a(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken1 = paramJsonParser.getCurrentToken();
    Assert.a(JsonToken.START_ARRAY, localJsonToken1);
    JsonToken localJsonToken2 = paramJsonParser.nextToken();
    if (localJsonToken2 != JsonToken.END_ARRAY)
    {
      if (localJsonToken2 == JsonToken.START_OBJECT)
      {
        FacebookEvent localFacebookEvent = FacebookEvent.a(paramJsonParser);
        this.b.put(Long.valueOf(localFacebookEvent.a()), localFacebookEvent);
      }
      while (true)
      {
        localJsonToken2 = paramJsonParser.nextToken();
        break;
        if (localJsonToken2 != JsonToken.START_ARRAY)
          continue;
        paramJsonParser.skipChildren();
      }
    }
  }

  public Map<Long, FacebookEvent> g()
  {
    return Collections.unmodifiableMap(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetAtTags.FqlGetEventsCoveringTimeRange
 * JD-Core Version:    0.6.0
 */