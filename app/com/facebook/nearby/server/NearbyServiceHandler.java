package com.facebook.nearby.server;

import android.os.Bundle;
import com.facebook.nearby.protocol.FetchNearbyPlacesMethod;
import com.facebook.nearby.protocol.FetchNearbyPlacesParams;
import com.facebook.nearby.protocol.FetchNearbyPlacesResult;
import com.facebook.nearby.protocol.SearchNearbyPlacesMethod;
import com.facebook.nearby.protocol.SearchNearbyPlacesParams;
import com.facebook.nearby.protocol.SearchNearbyPlacesResult;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import javax.inject.Provider;

public class NearbyServiceHandler
  implements OrcaServiceHandler
{
  private final Provider<SingleMethodRunner> a;
  private final FetchNearbyPlacesMethod b;
  private final SearchNearbyPlacesMethod c;

  public NearbyServiceHandler(Provider<SingleMethodRunner> paramProvider, FetchNearbyPlacesMethod paramFetchNearbyPlacesMethod, SearchNearbyPlacesMethod paramSearchNearbyPlacesMethod)
  {
    this.a = paramProvider;
    this.b = paramFetchNearbyPlacesMethod;
    this.c = paramSearchNearbyPlacesMethod;
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    FetchNearbyPlacesParams localFetchNearbyPlacesParams = (FetchNearbyPlacesParams)paramOperationParams.b().getParcelable("fetchNearbyPlacesParams");
    return OperationResult.a((FetchNearbyPlacesResult)((SingleMethodRunner)this.a.b()).a(this.b, localFetchNearbyPlacesParams));
  }

  private OperationResult c(OperationParams paramOperationParams)
  {
    SearchNearbyPlacesParams localSearchNearbyPlacesParams = (SearchNearbyPlacesParams)paramOperationParams.b().getParcelable("searchNearbyPlacesParams");
    return OperationResult.a((SearchNearbyPlacesResult)((SingleMethodRunner)this.a.b()).a(this.c, localSearchNearbyPlacesParams));
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    if ("fetch_nearby_places".equals(str));
    for (OperationResult localOperationResult = b(paramOperationParams); ; localOperationResult = c(paramOperationParams))
    {
      return localOperationResult;
      if (!"search_nearby_places".equals(str))
        break;
    }
    throw new Exception("unknown operation type: " + str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.server.NearbyServiceHandler
 * JD-Core Version:    0.6.0
 */