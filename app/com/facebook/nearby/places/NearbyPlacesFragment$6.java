package com.facebook.nearby.places;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import com.facebook.common.util.Toaster;
import com.facebook.nearby.analytics.NearbyAnalytics;
import com.facebook.nearby.protocol.FetchNearbyPlacesResult;
import com.facebook.nearby.protocol.SearchArea;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import java.util.List;
import java.util.concurrent.CancellationException;

class NearbyPlacesFragment$6 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    NearbyPlacesFragment.a(this.b, null);
    NearbyPlacesFragment.q(this.b);
    NearbyPlacesFragment.c(this.b).b(paramServiceException.getMessage());
    BLog.e(NearbyPlacesFragment.d(), "Error fetching nearby places", paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    Location localLocation = NearbyPlacesFragment.k(this.b).a();
    if (localLocation == null)
    {
      Toaster.a(this.b.p(), this.b.p().getResources().getString(2131361893));
      NearbyPlacesFragment.c(this.b).a(null);
    }
    while (true)
    {
      return;
      NearbyPlacesFragment.p(this.b);
      NearbyPlacesFragment.a(this.b, null);
      FetchNearbyPlacesResult localFetchNearbyPlacesResult = (FetchNearbyPlacesResult)paramOperationResult.h();
      NearbyPlacesFragment.a(this.b, NearbyPlacesFragment.b(this.b, localFetchNearbyPlacesResult.nearbyPlaces));
      NearbyPlacesFragment.a(this.b, localFetchNearbyPlacesResult.searchSessionId);
      NearbyPlacesFragment.l(this.b).a(NearbyPlacesFragment.m(this.b), localLocation);
      NearbyPlacesFragment.q(this.b);
      NearbyPlacesFragment.k(this.b).a(NearbyPlacesFragment.m(this.b), this.a, NearbyPlacesFragment.b(this.b));
      if (NearbyPlacesFragment.m(this.b).isEmpty())
        NearbyPlacesFragment.r(this.b);
      NearbyPlacesFragment.c(this.b).a(localFetchNearbyPlacesResult.nearbyPlaces.size(), NearbyPlacesFragment.b(this.b));
      if (NearbyPlacesFragment.m(this.b).isEmpty())
      {
        NearbyPlacesFragment.s(this.b);
        continue;
      }
      NearbyPlacesFragment.t(this.b);
    }
  }

  protected void a(CancellationException paramCancellationException)
  {
    super.a(paramCancellationException);
    NearbyPlacesFragment.c(this.b).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyPlacesFragment.6
 * JD-Core Version:    0.6.0
 */