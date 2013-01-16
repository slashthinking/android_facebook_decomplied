package com.facebook.appcenter.data;

import com.facebook.appcenter.graphql.model.AppCenterCategory;
import com.facebook.appcenter.util.AppCenterCategoryComparator;
import com.facebook.common.collect.MapWithSecondaryOrdering;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AppCenterCategoryCollection
{
  private MapWithSecondaryOrdering<String, AppCenterCategory> a;

  public AppCenterCategoryCollection()
  {
    this(AppCenterCategoryComparator.a);
  }

  public AppCenterCategoryCollection(Comparator<AppCenterCategory> paramComparator)
  {
    this.a = new MapWithSecondaryOrdering(paramComparator);
  }

  public int a()
  {
    return this.a.size();
  }

  public AppCenterCategory a(int paramInt)
  {
    return (AppCenterCategory)this.a.a().get(paramInt);
  }

  public void a(List<AppCenterCategory> paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      AppCenterCategory localAppCenterCategory = (AppCenterCategory)paramList.get(i);
      localAppCenterCategory.a(i);
      this.a.put(Integer.toString(i), localAppCenterCategory);
    }
  }

  public String[] b()
  {
    String[] arrayOfString = new String[this.a.a().size()];
    Iterator localIterator = this.a.a().iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      AppCenterCategory localAppCenterCategory = (AppCenterCategory)localIterator.next();
      j = i + 1;
      arrayOfString[i] = localAppCenterCategory.label;
    }
    return arrayOfString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.data.AppCenterCategoryCollection
 * JD-Core Version:    0.6.0
 */