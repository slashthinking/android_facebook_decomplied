package com.facebook.katana.server.handler;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.katana.platform.Permissions;
import com.facebook.katana.server.protocol.AuthorizeAppMethod;
import com.facebook.katana.server.protocol.AuthorizeAppMethod.Params;
import com.facebook.katana.server.protocol.AuthorizeAppMethod.Result;
import com.facebook.katana.server.protocol.GetNativeGdpNuxStatusMethod;
import com.facebook.katana.server.protocol.GetPermissionsDescriptionMethod;
import com.facebook.katana.server.protocol.GetPermissionsDescriptionMethod.Params;
import com.facebook.katana.server.protocol.UpdateNativeGdpNuxStatusMethod;
import com.facebook.katana.server.protocol.UpdateNativeGdpNuxStatusMethod.Params;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Provider;

public class PlatformOperationHandler
  implements OrcaServiceHandler
{
  private static final Class<?> a = PlatformOperationHandler.class;
  private final Context b;
  private final ObjectMapper c;
  private final Provider<SingleMethodRunner> d;
  private final AuthorizeAppMethod e;
  private final GetPermissionsDescriptionMethod f;
  private final UpdateNativeGdpNuxStatusMethod g;
  private final GetNativeGdpNuxStatusMethod h;
  private Permissions i;

  public PlatformOperationHandler(Context paramContext, ObjectMapper paramObjectMapper, Provider<SingleMethodRunner> paramProvider, AuthorizeAppMethod paramAuthorizeAppMethod, GetPermissionsDescriptionMethod paramGetPermissionsDescriptionMethod, Permissions paramPermissions, UpdateNativeGdpNuxStatusMethod paramUpdateNativeGdpNuxStatusMethod, GetNativeGdpNuxStatusMethod paramGetNativeGdpNuxStatusMethod)
  {
    this.b = paramContext;
    this.c = paramObjectMapper;
    this.d = paramProvider;
    this.e = paramAuthorizeAppMethod;
    this.f = paramGetPermissionsDescriptionMethod;
    this.i = paramPermissions;
    this.g = paramUpdateNativeGdpNuxStatusMethod;
    this.h = paramGetNativeGdpNuxStatusMethod;
  }

  private String a(List<String> paramList, String paramString)
  {
    if (paramList.isEmpty());
    String str1;
    for (String str2 = ""; ; str2 = ((JsonNode)this.c.readValue(str1, JsonNode.class)).asText())
    {
      return str2;
      GetPermissionsDescriptionMethod.Params localParams = new GetPermissionsDescriptionMethod.Params(paramList, paramString, Locale.getDefault());
      str1 = (String)((SingleMethodRunner)this.d.b()).a(this.f, localParams);
    }
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    PlatformOperationHandler.GetAuthorizationStringParams localGetAuthorizationStringParams = (PlatformOperationHandler.GetAuthorizationStringParams)paramOperationParams.b().getParcelable("app_permissions");
    Preconditions.checkNotNull(localGetAuthorizationStringParams);
    ArrayList localArrayList = Lists.a();
    String str1 = localGetAuthorizationStringParams.a();
    String str2 = localGetAuthorizationStringParams.c();
    String str3 = this.i.a(localGetAuthorizationStringParams.b(), str2, localArrayList);
    String str4 = a(localArrayList, str2);
    String str5;
    if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)))
      str5 = this.b.getString(2131363488, new Object[] { str1, str3, str4 });
    while (true)
    {
      return OperationResult.a(str5);
      if (!TextUtils.isEmpty(str3))
      {
        str5 = this.b.getString(2131363489, new Object[] { str1, str3 });
        continue;
      }
      str5 = this.b.getString(2131363489, new Object[] { str1, str4 });
    }
  }

  private OperationResult c(OperationParams paramOperationParams)
  {
    AuthorizeAppMethod.Params localParams = (AuthorizeAppMethod.Params)paramOperationParams.b().getParcelable("app_info");
    return OperationResult.a((AuthorizeAppMethod.Result)((SingleMethodRunner)this.d.b()).a(this.e, localParams));
  }

  private OperationResult d(OperationParams paramOperationParams)
  {
    return OperationResult.a(((Integer)((SingleMethodRunner)this.d.b()).a(this.h, null)).toString());
  }

  private OperationResult e(OperationParams paramOperationParams)
  {
    BLog.b(a, "handleUpdateNexStatusOperation params:" + paramOperationParams);
    UpdateNativeGdpNuxStatusMethod.Params localParams = (UpdateNativeGdpNuxStatusMethod.Params)paramOperationParams.b().getParcelable("app_info");
    return OperationResult.a(((Integer)((SingleMethodRunner)this.d.b()).a(this.g, localParams)).toString());
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    OperationResult localOperationResult;
    if ("platform_get_authorization_string".equals(paramOperationParams.a()))
      localOperationResult = b(paramOperationParams);
    while (true)
    {
      return localOperationResult;
      if ("platform_authorize_app".equals(paramOperationParams.a()))
      {
        localOperationResult = c(paramOperationParams);
        continue;
      }
      if ("platform_get_native_gdp_nux_status".equals(paramOperationParams.a()))
      {
        localOperationResult = d(paramOperationParams);
        continue;
      }
      if (!"platform_update_native_gdp_nux_status".equals(paramOperationParams.a()))
        break;
      localOperationResult = e(paramOperationParams);
    }
    throw new Exception("Unknown operation");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.handler.PlatformOperationHandler
 * JD-Core Version:    0.6.0
 */