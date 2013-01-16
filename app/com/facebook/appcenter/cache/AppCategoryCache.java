package com.facebook.appcenter.cache;

import com.facebook.appcenter.graphql.model.AppCenterCategory;
import com.facebook.appcenter.graphql.model.AppCenterCategoryList;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import java.util.concurrent.ConcurrentMap;

public class AppCategoryCache
{
  private final ConcurrentMap<String, AppCenterCategory> a = new MapMaker().b(100).n();
  private AppCenterCategoryList b = null;

  public AppCenterCategoryList a()
  {
    return this.b;
  }

  public String a(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    AppCenterCategory localAppCenterCategory = (AppCenterCategory)this.a.get(paramString);
    Preconditions.checkNotNull(localAppCenterCategory);
    return localAppCenterCategory.name;
  }

  public void a(AppCenterCategoryList paramAppCenterCategoryList)
  {
    this.b = paramAppCenterCategoryList;
  }

  public void a(String paramString, AppCenterCategory paramAppCenterCategory)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramAppCenterCategory);
    this.a.put(paramString, paramAppCenterCategory);
  }

  public int b()
  {
    return this.a.size();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.cache.AppCategoryCache
 * JD-Core Version:    0.6.0
 */