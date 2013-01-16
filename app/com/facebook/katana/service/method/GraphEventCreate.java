package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.debug.Assert;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import com.fasterxml.jackson.core.JsonParser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONObject;

public class GraphEventCreate extends GraphApiMethod
  implements ApiMethodCallback
{
  private long a;

  public GraphEventCreate(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean, Calendar paramCalendar1, Calendar paramCalendar2, GraphEventCreate.PrivacyType paramPrivacyType)
  {
    super(paramContext, paramString1, "POST", "events", a(paramContext));
    this.e.put("name", paramString2);
    this.e.put("description", paramString3);
    this.e.put("start_time", a(paramCalendar1, paramBoolean));
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("events_timezone", Boolean.valueOf(true));
    this.e.put("migrations_override", localJSONObject.toString());
    if (paramCalendar2 != null)
    {
      Assert.a(false, paramBoolean);
      this.e.put("end_time", a(paramCalendar2, false));
    }
    boolean bool2;
    if (paramLong != -1L)
    {
      Assert.b(paramString4);
      if (paramLong > 0L)
      {
        bool2 = true;
        Assert.b(bool2);
        this.e.put("location_id", Long.toString(paramLong));
      }
    }
    do
    {
      this.e.put("privacy_type", paramPrivacyType.toString());
      return;
      bool2 = false;
      break;
    }
    while (paramString4 == null);
    if (paramLong == -1L);
    for (boolean bool1 = true; ; bool1 = false)
    {
      Assert.b(bool1);
      this.e.put("location", paramString4);
      break;
    }
  }

  private static String a(Context paramContext)
  {
    return Constants.URL.d(paramContext) + "me/" + "events" + "/";
  }

  public static String a(Context paramContext, String paramString1, String paramString2, long paramLong, String paramString3, boolean paramBoolean, Calendar paramCalendar1, Calendar paramCalendar2, GraphEventCreate.PrivacyType paramPrivacyType)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession == null);
    for (String str = null; ; str = localAppSession.a(paramContext, new GraphEventCreate(paramContext, localAppSession.b().oAuthToken, paramString1, paramString2, paramLong, paramString3, paramBoolean, paramCalendar1, paramCalendar2, paramPrivacyType), 1001, 1020, null))
      return str;
  }

  private String a(Calendar paramCalendar, boolean paramBoolean)
  {
    Assert.a(paramCalendar);
    if (paramBoolean);
    for (String str = new SimpleDateFormat("yyyy-MM-dd").format(paramCalendar.getTime()); ; str = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm':00'Z").format(paramCalendar.getTime()))
    {
      return str;
      paramCalendar.setTimeZone(Calendar.getInstance().getTimeZone());
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Iterator localIterator = paramAppSession.d().iterator();
    while (localIterator.hasNext())
      ((AppSessionListener)localIterator.next()).a(paramAppSession, paramString1, paramInt, paramString2, paramException, this.a);
  }

  protected void a(JsonParser paramJsonParser)
  {
    this.a = ((GraphEventCreate.GraphEventCreateResponse)JMParser.a(paramJsonParser, GraphEventCreate.GraphEventCreateResponse.class)).mEventId;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.GraphEventCreate
 * JD-Core Version:    0.6.0
 */