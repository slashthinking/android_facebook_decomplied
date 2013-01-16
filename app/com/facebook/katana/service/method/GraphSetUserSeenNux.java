package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.features.UserSeenNux;
import com.facebook.katana.features.UserSeenNux.Project;
import com.facebook.katana.model.FacebookSessionInfo;

public class GraphSetUserSeenNux extends GraphApiMethod
{
  private static final Class<?> a = GraphSetUserSeenNux.class;

  public GraphSetUserSeenNux(Context paramContext, String paramString1, String paramString2, String paramString3, UserSeenNux.Project paramProject)
  {
    super(paramContext, paramString1, paramString2, Long.toString(paramProject.projectId), paramString3);
  }

  private static String a(Context paramContext)
  {
    return Constants.URL.d(paramContext) + "me/" + "seen_nuxes" + "/";
  }

  public static String a(Context paramContext, UserSeenNux.Project paramProject)
  {
    return a(paramContext, paramProject, "POST");
  }

  private static String a(Context paramContext, UserSeenNux.Project paramProject, String paramString)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    String str = null;
    if (localAppSession == null);
    while (true)
    {
      return str;
      UserSeenNux.a(paramContext, paramProject);
      str = localAppSession.a(paramContext, new GraphSetUserSeenNux(paramContext, localAppSession.b().oAuthToken, paramString, a(paramContext), paramProject), 1000, 1000, null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.GraphSetUserSeenNux
 * JD-Core Version:    0.6.0
 */