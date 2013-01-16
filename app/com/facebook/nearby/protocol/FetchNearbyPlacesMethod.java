package com.facebook.nearby.protocol;

import android.content.res.Resources;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.nearby.model.NearbyPlaces;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.core.JsonParser;

public class FetchNearbyPlacesMethod
  implements ApiMethod<FetchNearbyPlacesParams, FetchNearbyPlacesResult>
{
  private static final Class<?> a = FetchNearbyPlacesMethod.class;
  private final FbErrorReporter b;
  private final Clock c;
  private final GraphQLHelper d;
  private final Resources e;

  public FetchNearbyPlacesMethod(FbErrorReporter paramFbErrorReporter, Clock paramClock, GraphQLHelper paramGraphQLHelper, Resources paramResources)
  {
    this.b = paramFbErrorReporter;
    this.c = paramClock;
    this.d = paramGraphQLHelper;
    this.e = paramResources;
  }

  public FetchNearbyPlacesResult a(FetchNearbyPlacesParams paramFetchNearbyPlacesParams, ApiResponse paramApiResponse)
  {
    NearbyPlaces localNearbyPlaces = (NearbyPlaces)this.d.a("nearby_fetch_places", 2, paramApiResponse.d()).readValueAs(NearbyPlaces.class);
    if (localNearbyPlaces == null)
      throw new Exception("Invalid JSON result");
    return new FetchNearbyPlacesResult(DataFreshnessResult.FROM_SERVER, this.c.a(), localNearbyPlaces.searchSessionId, localNearbyPlaces.edges);
  }

  public ApiRequest a(FetchNearbyPlacesParams paramFetchNearbyPlacesParams)
  {
    int i = this.e.getDimensionPixelSize(2131230739);
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(20);
    arrayOfObject[1] = paramFetchNearbyPlacesParams.a();
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(i);
    String str = StringUtil.a("me(){nearby_places.first(%s).%s{search_session_id,edges{node{id,name,url,location,profile_picture.size(%d,%d),address,categories,average_rating,raters{count},page_visits{count},page_likers{count}},social_context{text,ranges,aggregated_ranges}}}}", arrayOfObject);
    return this.d.a("nearby_fetch_places", str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.protocol.FetchNearbyPlacesMethod
 * JD-Core Version:    0.6.0
 */