package com.facebook.orca.database;

import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.location.Coordinates;
import com.facebook.orca.location.CoordinatesBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class DbCoordinatesSerialization
{
  private final ObjectMapper a;

  public DbCoordinatesSerialization(ObjectMapper paramObjectMapper)
  {
    this.a = paramObjectMapper;
  }

  Coordinates a(String paramString)
  {
    boolean bool1 = StringUtil.a(paramString);
    Coordinates localCoordinates = null;
    if (bool1)
      return localCoordinates;
    JsonNode localJsonNode = this.a.readTree(paramString);
    CoordinatesBuilder localCoordinatesBuilder1 = Coordinates.newBuilder().a(Double.valueOf(JSONUtil.e(localJsonNode.get("latitude")))).b(Double.valueOf(JSONUtil.e(localJsonNode.get("longitude"))));
    Float localFloat1;
    label86: Double localDouble;
    label120: Float localFloat2;
    label155: CoordinatesBuilder localCoordinatesBuilder4;
    if (localJsonNode.has("accuracy"))
    {
      localFloat1 = Float.valueOf((float)JSONUtil.e(localJsonNode.get("accuracy")));
      CoordinatesBuilder localCoordinatesBuilder2 = localCoordinatesBuilder1.a(localFloat1);
      if (!localJsonNode.has("altitude"))
        break label252;
      localDouble = Double.valueOf(JSONUtil.e(localJsonNode.get("altitude")));
      CoordinatesBuilder localCoordinatesBuilder3 = localCoordinatesBuilder2.c(localDouble);
      if (!localJsonNode.has("altitudeAccuracy"))
        break label258;
      localFloat2 = Float.valueOf((float)JSONUtil.e(localJsonNode.get("altitudeAccuracy")));
      localCoordinatesBuilder4 = localCoordinatesBuilder3.b(localFloat2);
      if (!localJsonNode.has("heading"))
        break label264;
    }
    label258: label264: for (Float localFloat3 = Float.valueOf((float)JSONUtil.e(localJsonNode.get("heading"))); ; localFloat3 = null)
    {
      CoordinatesBuilder localCoordinatesBuilder5 = localCoordinatesBuilder4.c(localFloat3);
      boolean bool2 = localJsonNode.has("speed");
      Float localFloat4 = null;
      if (bool2)
        localFloat4 = Float.valueOf((float)JSONUtil.e(localJsonNode.get("speed")));
      localCoordinates = localCoordinatesBuilder5.d(localFloat4).h();
      break;
      localFloat1 = null;
      break label86;
      label252: localDouble = null;
      break label120;
      localFloat2 = null;
      break label155;
    }
  }

  String a(Coordinates paramCoordinates)
  {
    if (paramCoordinates == null);
    ObjectNode localObjectNode;
    for (String str = null; ; str = localObjectNode.toString())
    {
      return str;
      localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("latitude", paramCoordinates.b());
      localObjectNode.put("longitude", paramCoordinates.c());
      if (paramCoordinates.g())
        localObjectNode.put("accuracy", paramCoordinates.f());
      if (paramCoordinates.e())
        localObjectNode.put("altitude", paramCoordinates.d());
      if (paramCoordinates.i())
        localObjectNode.put("altitudeAccuracy", paramCoordinates.h());
      if (paramCoordinates.k())
        localObjectNode.put("heading", paramCoordinates.j());
      if (!paramCoordinates.m())
        continue;
      localObjectNode.put("speed", paramCoordinates.l());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbCoordinatesSerialization
 * JD-Core Version:    0.6.0
 */