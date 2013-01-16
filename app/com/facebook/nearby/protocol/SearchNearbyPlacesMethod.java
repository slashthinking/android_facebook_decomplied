package com.facebook.nearby.protocol;

import android.content.res.Resources;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.module.GraphQLJacksonInitializer;
import com.facebook.nearby.model.NearbyTopic;
import com.facebook.nearby.model.TypeaheadPlace;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;

public class SearchNearbyPlacesMethod
  implements ApiMethod<SearchNearbyPlacesParams, SearchNearbyPlacesResult>
{
  private static final Class<?> a = FetchNearbyPlacesMethod.class;
  private final Clock b;
  private final Resources c;
  private final ObjectMapper d;
  private final GraphQLHelper e;

  public SearchNearbyPlacesMethod(Clock paramClock, Resources paramResources, ObjectMapper paramObjectMapper, GraphQLHelper paramGraphQLHelper)
  {
    this.b = paramClock;
    this.c = paramResources;
    this.d = paramObjectMapper;
    this.e = paramGraphQLHelper;
    new GraphQLJacksonInitializer(this.d).i_();
  }

  private ImmutableList<NearbyTopic> a(JsonNode paramJsonNode)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramJsonNode.iterator();
    while (localIterator.hasNext())
    {
      JsonNode localJsonNode = (JsonNode)localIterator.next();
      JsonParser localJsonParser = new JsonFactory().createJsonParser(localJsonNode.get("node").toString());
      localJsonParser.setCodec(this.d);
      localBuilder.b(new NearbyTopic((GraphQLPlace)localJsonParser.readValueAs(GraphQLPlace.class)));
    }
    return localBuilder.b();
  }

  public static String a(String paramString)
  {
    return Strings.nullToEmpty(paramString).replaceAll("\\\\", "\\\\\\\\").replaceAll("\\(", "\\\\(").replaceAll(",", "\\\\,").replaceAll("\\.", "\\\\.").replaceAll("\\)", "\\\\)").replaceAll("\\<", "\\\\<").replaceAll("\\>", "\\\\>");
  }

  private ImmutableList<TypeaheadPlace> b(JsonNode paramJsonNode)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramJsonNode.iterator();
    while (localIterator.hasNext())
    {
      JsonNode localJsonNode = (JsonNode)localIterator.next();
      JsonParser localJsonParser = new JsonFactory().createJsonParser(localJsonNode.get("node").toString());
      localJsonParser.setCodec(this.d);
      localBuilder.b(new TypeaheadPlace((GraphQLPlace)localJsonParser.readValueAs(GraphQLPlace.class)));
    }
    return localBuilder.b();
  }

  public SearchNearbyPlacesResult a(SearchNearbyPlacesParams paramSearchNearbyPlacesParams, ApiResponse paramApiResponse)
  {
    ImmutableList localImmutableList1 = null;
    String str1 = Strings.nullToEmpty(paramSearchNearbyPlacesParams.b).trim();
    JsonNode localJsonNode1 = paramApiResponse.c();
    JsonNode localJsonNode2 = localJsonNode1.get(str1).get("result_sections").get("edges");
    String str2 = localJsonNode1.get(str1).get("search_session_id").toString();
    if ((localJsonNode2 == null) || (localJsonNode2.size() != 2))
      throw new RuntimeException("error in result_section edges node " + localJsonNode1.toString());
    int i = 0;
    ImmutableList localImmutableList2 = null;
    if (i < localJsonNode2.size())
    {
      JsonNode localJsonNode3 = localJsonNode2.get(i).get("node");
      JsonNode localJsonNode4 = localJsonNode3.get("results").get("edges");
      String str3 = JSONUtil.b(localJsonNode3.get("result_category"));
      if (str3.equals("TOPICS"))
        localImmutableList2 = a(localJsonNode4);
      while (true)
      {
        i++;
        break;
        if (!str3.equals("PLACES"))
          break label201;
        localImmutableList1 = b(localJsonNode4);
      }
      label201: throw new RuntimeException("unexpected result_category value: " + str3);
    }
    if (localImmutableList2 == null)
      throw new RuntimeException("missing TOPICS node in response: " + localJsonNode1.toString());
    if (localImmutableList1 == null)
      throw new RuntimeException("missing PLACES node in response: " + localJsonNode1.toString());
    return new SearchNearbyPlacesResult(DataFreshnessResult.FROM_SERVER, this.b.a(), str2, Strings.nullToEmpty(paramSearchNearbyPlacesParams.b), localImmutableList2, localImmutableList1);
  }

  public ApiRequest a(SearchNearbyPlacesParams paramSearchNearbyPlacesParams)
  {
    int i = this.c.getDimensionPixelSize(2131230739);
    String str1 = paramSearchNearbyPlacesParams.a.a();
    String str2 = a(paramSearchNearbyPlacesParams.b);
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = str2;
    arrayOfObject[1] = str1;
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(i);
    String str3 = StringUtil.a("nearby_search(%s){search_session_id,result_sections.%s{edges{node{result_category,results{edges{node{id,name,categories,address,location,average_rating,profile_picture.size(%d,%d)}}}}}}}", arrayOfObject);
    return this.e.a("nearby_search_places", str3, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.protocol.SearchNearbyPlacesMethod
 * JD-Core Version:    0.6.0
 */