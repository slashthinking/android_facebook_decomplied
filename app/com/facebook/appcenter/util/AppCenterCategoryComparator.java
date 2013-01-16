package com.facebook.appcenter.util;

import com.facebook.appcenter.graphql.model.AppCenterCategory;
import com.google.common.primitives.Ints;
import java.util.Comparator;

public class AppCenterCategoryComparator
  implements Comparator<AppCenterCategory>
{
  public static final Comparator<AppCenterCategory> a = new AppCenterCategoryComparator();

  public int a(AppCenterCategory paramAppCenterCategory1, AppCenterCategory paramAppCenterCategory2)
  {
    return Ints.a(paramAppCenterCategory1.a, paramAppCenterCategory2.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.util.AppCenterCategoryComparator
 * JD-Core Version:    0.6.0
 */