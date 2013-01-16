package com.facebook.appcenter.util;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.facebook.appcenter.graphql.model.AppCenterPermission;
import com.facebook.appcenter.graphql.model.AppCenterPermissionSummary;
import com.facebook.appcenter.model.AppPrivacyOption;
import com.facebook.appcenter.model.AppPrivacyOptionList;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppCenterInlineGDPHelper
{
  private Context a;
  private AppPrivacyOptionList b;

  public AppCenterInlineGDPHelper(Context paramContext, AppPrivacyOptionList paramAppPrivacyOptionList)
  {
    this.a = paramContext;
    this.b = paramAppPrivacyOptionList;
  }

  private SpannableStringBuilder a(AppCenterPermissionSummary paramAppCenterPermissionSummary, int paramInt, String paramString)
  {
    Preconditions.checkNotNull(paramAppCenterPermissionSummary);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    SpannableString localSpannableString = a(paramAppCenterPermissionSummary, paramInt);
    if (localSpannableString.toString().length() > 0)
    {
      localSpannableStringBuilder.append(localSpannableString);
      localSpannableStringBuilder.append(' ');
    }
    localSpannableStringBuilder.append(a(paramAppCenterPermissionSummary, paramString));
    return localSpannableStringBuilder;
  }

  private String a(List<String> paramList)
  {
    Preconditions.checkNotNull(paramList);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramList.size())
    {
      localStringBuilder.append((String)paramList.get(i));
      if (i < -2 + paramList.size())
        localStringBuilder.append(", ");
      while (true)
      {
        i++;
        break;
        if (i != -2 + paramList.size())
          continue;
        localStringBuilder.append(" ");
        localStringBuilder.append(this.a.getString(2131362060));
        localStringBuilder.append(" ");
      }
    }
    return localStringBuilder.toString();
  }

  private List<String> a(List<AppCenterPermission> paramList, String paramString)
  {
    Preconditions.checkNotNull(paramList);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AppCenterPermission localAppCenterPermission = (AppCenterPermission)localIterator.next();
      if (!localAppCenterPermission.name.startsWith(paramString))
        continue;
      localArrayList.add(localAppCenterPermission.text);
    }
    return localArrayList;
  }

  private void a(SpannableString paramSpannableString, int paramInt1, int paramInt2, String paramString)
  {
    Preconditions.checkNotNull(paramSpannableString);
    paramSpannableString.setSpan(new AppCenterInlineGDPHelper.URLSpanNoUnderline(paramString), paramInt1, paramInt2, 0);
  }

  private List<String> b(AppCenterPermissionSummary paramAppCenterPermissionSummary, String paramString)
  {
    Preconditions.checkNotNull(paramAppCenterPermissionSummary);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.a.getString(2131362059));
    localArrayList.addAll(a(paramAppCenterPermissionSummary.a(), "email"));
    localArrayList.addAll(a(paramAppCenterPermissionSummary.a(), "user"));
    localArrayList.addAll(a(paramAppCenterPermissionSummary.a(), "friends"));
    if (paramString != null)
      localArrayList.add(paramString);
    return localArrayList;
  }

  public int a(String paramString)
  {
    int i;
    if (paramString != null)
    {
      i = 0;
      if (i < this.b.size())
        if (!((AppPrivacyOption)this.b.get(i)).a().equalsIgnoreCase(paramString));
    }
    while (true)
    {
      return i;
      i++;
      break;
      i = AppPrivacyOptionList.a;
    }
  }

  public SpannableString a(AppCenterPermissionSummary paramAppCenterPermissionSummary, int paramInt)
  {
    Preconditions.checkNotNull(paramAppCenterPermissionSummary);
    SpannableString localSpannableString = new SpannableString("");
    if (paramAppCenterPermissionSummary.c().size() > 0)
    {
      AppPrivacyOption localAppPrivacyOption = (AppPrivacyOption)this.b.get(paramInt);
      String str1 = this.a.getString(localAppPrivacyOption.c());
      String str2 = StringLocaleUtil.b(this.a.getString(2131362061), new Object[] { str1 });
      int i = str2.indexOf(str1);
      int j = i + str1.length();
      localSpannableString = new SpannableString(str2);
      a(localSpannableString, i, j, null);
    }
    return localSpannableString;
  }

  public SpannableString a(String paramString1, String paramString2, String paramString3)
  {
    String str1 = this.a.getString(2131362069);
    String str2 = this.a.getString(2131362070);
    String str3 = StringLocaleUtil.b(this.a.getString(2131362071), new Object[] { paramString1, str1, str2 });
    int i = str3.indexOf(str1);
    int j = i + str1.length();
    int k = str3.indexOf(str2);
    int m = k + str2.length();
    SpannableString localSpannableString = new SpannableString(str3);
    a(localSpannableString, i, j, paramString2);
    a(localSpannableString, k, m, paramString3);
    return localSpannableString;
  }

  public String a(AppCenterPermissionSummary paramAppCenterPermissionSummary)
  {
    Preconditions.checkNotNull(paramAppCenterPermissionSummary);
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramAppCenterPermissionSummary.b().size(); i++)
    {
      localStringBuilder.append(" - ");
      localStringBuilder.append(((AppCenterPermission)paramAppCenterPermissionSummary.b().get(i)).text);
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }

  public String a(AppCenterPermissionSummary paramAppCenterPermissionSummary, String paramString)
  {
    Preconditions.checkNotNull(paramAppCenterPermissionSummary);
    String str;
    if (paramAppCenterPermissionSummary.b().size() == 0)
    {
      str = this.a.getString(2131362055);
      paramString = null;
    }
    while (true)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = a(b(paramAppCenterPermissionSummary, paramString));
      return StringLocaleUtil.b(str, arrayOfObject);
      str = this.a.getString(2131362056);
    }
  }

  public boolean a(boolean paramBoolean1, boolean paramBoolean2, AppCenterPermissionSummary paramAppCenterPermissionSummary)
  {
    int i = 1;
    if (paramBoolean1);
    for (i = 0; ; i = 0)
      do
        return i;
      while ((paramAppCenterPermissionSummary.d().size() > 0) || (!paramBoolean2));
  }

  public SpannableStringBuilder b(AppCenterPermissionSummary paramAppCenterPermissionSummary, int paramInt)
  {
    Preconditions.checkNotNull(paramAppCenterPermissionSummary);
    return a(paramAppCenterPermissionSummary, paramInt, this.a.getString(2131362058));
  }

  public SpannableStringBuilder c(AppCenterPermissionSummary paramAppCenterPermissionSummary, int paramInt)
  {
    Preconditions.checkNotNull(paramAppCenterPermissionSummary);
    return a(paramAppCenterPermissionSummary, paramInt, this.a.getString(2131362057));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.util.AppCenterInlineGDPHelper
 * JD-Core Version:    0.6.0
 */