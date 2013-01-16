package com.facebook.abtest.qe.protocol;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableBiMap.Builder;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Iterator;

public class SyncQuickExperimentResultHelper
{
  private static final Class<?> a = SyncQuickExperimentResultHelper.class;

  public SyncQuickExperimentResult a(JsonNode paramJsonNode, SyncQuickExperimentParams paramSyncQuickExperimentParams)
  {
    SyncQuickExperimentResult localSyncQuickExperimentResult = null;
    if (paramJsonNode != null)
    {
      localSyncQuickExperimentResult = null;
      if (paramSyncQuickExperimentParams != null)
        break label14;
    }
    label14: JsonNode localJsonNode1;
    do
    {
      return localSyncQuickExperimentResult;
      localJsonNode1 = paramJsonNode.get("data");
      localSyncQuickExperimentResult = null;
    }
    while (localJsonNode1 == null);
    boolean bool = localJsonNode1.get(0).get("in_experiment").booleanValue();
    String str1 = localJsonNode1.get(0).get("group").textValue();
    if (str1 == null);
    for (String str2 = "local_default_group"; ; str2 = str1)
    {
      ImmutableBiMap.Builder localBuilder = new ImmutableBiMap.Builder();
      JsonNode localJsonNode2 = localJsonNode1.get(0).get("params");
      Iterator localIterator = localJsonNode2.fieldNames();
      while (localIterator.hasNext())
      {
        String str3 = (String)localIterator.next();
        int i = localJsonNode2.get(str3).get("type").asInt();
        String str4 = localJsonNode2.get(str3).get("value").asText();
        if ((i == 1) || (i == 2))
          localBuilder.b(str3, str4);
      }
      localSyncQuickExperimentResult = new SyncQuickExperimentResult(paramSyncQuickExperimentParams.a(), str2, bool, localBuilder.b());
      break;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.protocol.SyncQuickExperimentResultHelper
 * JD-Core Version:    0.6.2
 */