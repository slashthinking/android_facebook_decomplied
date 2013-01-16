package com.facebook.analytics;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AnalyticsServiceEvent
  implements Parcelable, AnalyticsEvent
{
  public static final Parcelable.Creator<AnalyticsServiceEvent> CREATOR;
  private static final Class<?> a = AnalyticsServiceEvent.class;
  private static final String[] b = { "type", "time", "uid", "bkgd", "data" };
  private final String c;
  private final long d;
  private final String e;
  private final boolean f;
  private final JsonNode g;
  private final Map<String, String> h = Maps.a();

  static
  {
    CREATOR = new AnalyticsServiceEvent.1();
  }

  private AnalyticsServiceEvent(Parcel paramParcel)
  {
    try
    {
      localJsonNode = new ObjectMapper().readTree(paramParcel.readString());
      String[] arrayOfString = b;
      int i = arrayOfString.length;
      j = 0;
      if (j < i)
      {
        String str = arrayOfString[j];
        if (!localJsonNode.has(str))
          throw new ParcelFormatException("Missing required field " + str);
      }
    }
    catch (JsonProcessingException localJsonProcessingException)
    {
      JsonNode localJsonNode;
      while (true)
      {
        int j;
        throw new ParcelFormatException("Failed to process event " + localJsonProcessingException.toString());
        j++;
      }
      this.c = localJsonNode.get("type").textValue();
      this.d = localJsonNode.get("time").longValue();
      this.e = localJsonNode.get("uid").textValue();
      this.f = localJsonNode.get("bkgd").booleanValue();
      this.g = localJsonNode.get("data");
      if (localJsonNode.has("tags"))
      {
        Iterator localIterator = localJsonNode.get("tags").fields();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          this.h.put(localEntry.getKey(), ((JsonNode)localEntry.getValue()).textValue());
        }
      }
    }
    catch (IOException localIOException)
    {
      throw new ParcelFormatException("Failed to process event " + localIOException.toString());
    }
  }

  public AnalyticsServiceEvent(HoneyAnalyticsEvent paramHoneyAnalyticsEvent)
  {
    this.c = paramHoneyAnalyticsEvent.a();
    this.d = paramHoneyAnalyticsEvent.b();
    this.e = paramHoneyAnalyticsEvent.c();
    this.f = paramHoneyAnalyticsEvent.d();
    Iterator localIterator = paramHoneyAnalyticsEvent.f().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.h.put(str, paramHoneyAnalyticsEvent.b(str));
    }
    this.g = paramHoneyAnalyticsEvent.e();
  }

  public String a()
  {
    return this.c;
  }

  public boolean a(String paramString)
  {
    return this.h.containsKey(paramString);
  }

  public long b()
  {
    return this.d;
  }

  public String b(String paramString)
  {
    return (String)this.h.get(paramString);
  }

  public String c()
  {
    return this.e;
  }

  public boolean d()
  {
    return this.f;
  }

  public int describeContents()
  {
    return 0;
  }

  public JsonNode e()
  {
    return this.g;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ObjectNode localObjectNode1 = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode1.put("type", a());
    localObjectNode1.put("time", b());
    localObjectNode1.put("uid", c());
    localObjectNode1.put("bkgd", d());
    localObjectNode1.put("data", e());
    if (this.h.size() > 0)
    {
      ObjectNode localObjectNode2 = new ObjectNode(JsonNodeFactory.instance);
      Iterator localIterator = this.h.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localObjectNode2.put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      localObjectNode1.put("tags", localObjectNode2);
    }
    paramParcel.writeString(localObjectNode1.toString());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsServiceEvent
 * JD-Core Version:    0.6.0
 */