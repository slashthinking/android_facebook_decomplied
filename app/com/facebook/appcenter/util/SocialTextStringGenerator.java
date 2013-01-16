package com.facebook.appcenter.util;

import android.content.res.Resources;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfileList;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.MissingFormatArgumentException;

public class SocialTextStringGenerator
{
  private Resources a;

  public SocialTextStringGenerator(Resources paramResources)
  {
    this.a = paramResources;
  }

  public String a()
  {
    return this.a.getString(2131362040) + "▼";
  }

  public String a(GraphQLProfileList paramGraphQLProfileList, boolean paramBoolean)
  {
    Object localObject;
    if ((paramGraphQLProfileList == null) || (paramGraphQLProfileList.profiles == null) || (paramGraphQLProfileList.profiles.size() == 0))
      localObject = "";
    while (true)
    {
      return localObject;
      List localList = paramGraphQLProfileList.profiles;
      int i = localList.size();
      int j;
      if (paramBoolean)
      {
        j = 2131427340;
        if (i != 1);
      }
      else
      {
        try
        {
          Resources localResources2 = this.a;
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = ((GraphQLProfile)localList.get(0)).name;
          String str2 = localResources2.getQuantityString(j, 1, arrayOfObject2);
          localObject = str2;
          continue;
          j = 2131427339;
        }
        catch (MissingFormatArgumentException localMissingFormatArgumentException)
        {
          localObject = "";
        }
        continue;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      for (int k = 0; k < -1 + localList.size(); k++)
      {
        GraphQLProfile localGraphQLProfile = (GraphQLProfile)localList.get(k);
        Preconditions.checkNotNull(localGraphQLProfile);
        Preconditions.checkNotNull(localGraphQLProfile.name);
        localStringBuilder.append(localGraphQLProfile.name);
        if (k == -2 + localList.size())
          continue;
        localStringBuilder.append(", ");
      }
      String str1 = ((GraphQLProfile)localList.get(-1 + localList.size())).name;
      Resources localResources1 = this.a;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = localStringBuilder.toString();
      arrayOfObject1[1] = str1;
      localObject = localResources1.getQuantityString(j, 2, arrayOfObject1);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.util.SocialTextStringGenerator
 * JD-Core Version:    0.6.0
 */