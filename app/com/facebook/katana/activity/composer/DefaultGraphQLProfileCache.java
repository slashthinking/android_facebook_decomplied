package com.facebook.katana.activity.composer;

import android.content.Context;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfile.Builder;
import com.facebook.graphql.model.GraphQLProfileCache;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.provider.ConnectionsProviderInjectable;

public class DefaultGraphQLProfileCache
  implements GraphQLProfileCache
{
  private final Context a;
  private final ConnectionsProviderInjectable b;

  public DefaultGraphQLProfileCache(Context paramContext, ConnectionsProviderInjectable paramConnectionsProviderInjectable)
  {
    this.a = paramContext;
    this.b = paramConnectionsProviderInjectable;
  }

  private GraphQLProfile a(long paramLong, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null));
    GraphQLProfile.Builder localBuilder;
    for (GraphQLProfile localGraphQLProfile = null; ; localGraphQLProfile = localBuilder.b())
    {
      return localGraphQLProfile;
      GraphQLImage localGraphQLImage = new GraphQLImage(paramString2, 0, 0);
      localBuilder = new GraphQLProfile.Builder();
      localBuilder.b(String.valueOf(paramLong));
      localBuilder.c(paramString1);
      localBuilder.a(localGraphQLImage);
      localBuilder.a(new GraphQLObjectType(GraphQLObjectType.ObjectType.User));
    }
  }

  public GraphQLProfile a()
  {
    monitorenter;
    try
    {
      AppSession localAppSession = AppSession.b(this.a, false);
      if (localAppSession == null);
      GraphQLProfile localGraphQLProfile;
      for (Object localObject2 = null; ; localObject2 = localGraphQLProfile)
      {
        return localObject2;
        FacebookUser localFacebookUser = localAppSession.b().a();
        localGraphQLProfile = a(localFacebookUser.mUserId, localFacebookUser.mDisplayName, localFacebookUser.mImageUrl);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public GraphQLProfile a(long paramLong)
  {
    monitorenter;
    try
    {
      FacebookProfile localFacebookProfile = this.b.a(this.a, paramLong);
      Object localObject2 = null;
      if (localFacebookProfile != null)
      {
        GraphQLProfile localGraphQLProfile = a(paramLong, localFacebookProfile.mDisplayName, localFacebookProfile.mImageUrl);
        localObject2 = localGraphQLProfile;
      }
      monitorexit;
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      monitorexit;
    }
    throw localObject1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.DefaultGraphQLProfileCache
 * JD-Core Version:    0.6.0
 */