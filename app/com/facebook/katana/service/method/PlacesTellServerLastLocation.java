package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.hardware.CellDiagnosticsSerializer;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.orca.common.util.LocationUtils;
import com.facebook.orca.inject.FbInjector;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

public class PlacesTellServerLastLocation extends ApiMethod
{
  private static final Class<?> a = PlacesTellServerLastLocation.class;
  private static final String b = a.getSimpleName();

  public PlacesTellServerLastLocation(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, Location paramLocation)
  {
    super(paramContext, paramIntent, "POST", "places.setLastLocation", Constants.URL.b(paramContext), paramServiceOperationListener);
    FbInjector localFbInjector = FbInjector.a(paramContext);
    CellDiagnosticsSerializer localCellDiagnosticsSerializer = (CellDiagnosticsSerializer)localFbInjector.a(CellDiagnosticsSerializer.class);
    UniqueIdForDeviceHolder localUniqueIdForDeviceHolder = (UniqueIdForDeviceHolder)localFbInjector.a(UniqueIdForDeviceHolder.class);
    this.e.put("call_id", Long.toString(System.currentTimeMillis()));
    this.e.put("session_key", paramString);
    this.e.put("coords", LocationUtils.a(paramLocation));
    this.e.put("marauder_device_id", localUniqueIdForDeviceHolder.b());
    Boolean localBoolean = Gatekeeper.a(paramContext, "android_track_celltower");
    if (Boolean.TRUE.equals(localBoolean))
    {
      JsonNode localJsonNode = localCellDiagnosticsSerializer.a();
      if (localJsonNode != null)
        this.e.put("cell_tower", localJsonNode.toString());
    }
  }

  public static boolean a(Context paramContext)
  {
    return a(paramContext, System.currentTimeMillis());
  }

  private static boolean a(Context paramContext, long paramLong)
  {
    if (paramLong >= 1800000L + b(paramContext));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean a(Context paramContext, Location paramLocation)
  {
    return a(paramContext, paramLocation.getTime());
  }

  private static long b(Context paramContext)
  {
    return paramContext.getSharedPreferences("last_location_prefs", 0).getLong("last_location_update_time", 0L);
  }

  public static String b(Context paramContext, Location paramLocation)
  {
    boolean bool = a(paramContext, paramLocation);
    String str = null;
    if (!bool);
    while (true)
    {
      return str;
      AppSession localAppSession = AppSession.b(paramContext, false);
      str = null;
      if (localAppSession == null)
        continue;
      PlacesTellServerLastLocation localPlacesTellServerLastLocation = new PlacesTellServerLastLocation(paramContext, null, localAppSession.b().sessionKey, null, paramLocation);
      b(paramContext, paramLocation.getTime());
      str = localAppSession.a(paramContext, localPlacesTellServerLastLocation, 1000, 0, null);
    }
  }

  private static void b(Context paramContext, long paramLong)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("last_location_prefs", 0).edit();
    localEditor.putLong("last_location_update_time", paramLong);
    localEditor.commit();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PlacesTellServerLastLocation
 * JD-Core Version:    0.6.0
 */