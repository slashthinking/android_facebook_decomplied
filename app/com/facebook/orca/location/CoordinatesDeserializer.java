package com.facebook.orca.location;

import com.facebook.orca.common.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;

public class CoordinatesDeserializer
{
  public Coordinates a(JsonNode paramJsonNode)
  {
    CoordinatesBuilder localCoordinatesBuilder1 = Coordinates.newBuilder().a(Double.valueOf(JSONUtil.e(paramJsonNode.get("latitude")))).b(Double.valueOf(JSONUtil.e(paramJsonNode.get("longitude"))));
    Double localDouble;
    Float localFloat1;
    label87: Float localFloat2;
    label120: CoordinatesBuilder localCoordinatesBuilder4;
    if (paramJsonNode.has("altitude"))
    {
      localDouble = Double.valueOf(JSONUtil.e(paramJsonNode.get("altitude")));
      CoordinatesBuilder localCoordinatesBuilder2 = localCoordinatesBuilder1.c(localDouble);
      if (!paramJsonNode.has("accuracy"))
        break label209;
      localFloat1 = Float.valueOf((float)JSONUtil.e(paramJsonNode.get("accuracy")));
      CoordinatesBuilder localCoordinatesBuilder3 = localCoordinatesBuilder2.a(localFloat1);
      if (!paramJsonNode.has("altitudeAccuracy"))
        break label215;
      localFloat2 = Float.valueOf((float)JSONUtil.e(paramJsonNode.get("altitudeAccuracy")));
      localCoordinatesBuilder4 = localCoordinatesBuilder3.b(localFloat2);
      if (!paramJsonNode.has("heading"))
        break label221;
    }
    label209: label215: label221: for (Float localFloat3 = Float.valueOf((float)JSONUtil.e(paramJsonNode.get("heading"))); ; localFloat3 = null)
    {
      CoordinatesBuilder localCoordinatesBuilder5 = localCoordinatesBuilder4.c(localFloat3);
      boolean bool = paramJsonNode.has("speed");
      Float localFloat4 = null;
      if (bool)
        localFloat4 = Float.valueOf((float)JSONUtil.e(paramJsonNode.get("speed")));
      return localCoordinatesBuilder5.d(localFloat4).h();
      localDouble = null;
      break;
      localFloat1 = null;
      break label87;
      localFloat2 = null;
      break label120;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.location.CoordinatesDeserializer
 * JD-Core Version:    0.6.0
 */