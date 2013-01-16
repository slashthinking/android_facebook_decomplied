package com.facebook.appcenter.util;

import com.facebook.appcenter.data.AppCenterCategoryCollection;
import com.facebook.appcenter.graphql.model.AppCenterCategory;
import java.util.ArrayList;

public class AppCenterMockData
{
  public static AppCenterCategoryCollection a()
  {
    int i = 0;
    String[] arrayOfString = { "Apps & Games", "Page Apps", "Games", "Entertainment", "Lifestyle", "Music", "News", "Photo & Video", "Sports", "Travel", "Utilities", "Facebook" };
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfString.length;
    int m;
    for (int k = 0; i < j; k = m)
    {
      String str = arrayOfString[i];
      m = k + 1;
      localArrayList.add(new AppCenterCategory(str, k, str));
      i++;
    }
    AppCenterCategoryCollection localAppCenterCategoryCollection = new AppCenterCategoryCollection();
    localAppCenterCategoryCollection.a(localArrayList);
    return localAppCenterCategoryCollection;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.util.AppCenterMockData
 * JD-Core Version:    0.6.0
 */