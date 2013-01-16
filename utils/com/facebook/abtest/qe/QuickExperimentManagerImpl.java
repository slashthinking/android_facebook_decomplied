package com.facebook.abtest.qe;

import com.facebook.abtest.qe.data.QuickExperimentInfo;
import com.facebook.abtest.qe.data.QuickExperimentInfoValidator;
import com.facebook.abtest.qe.db.QuickExperimentStorage;
import com.facebook.abtest.qe.registry.QuickExperimentNameHolder;
import com.facebook.abtest.qe.utils.LocaleUtil;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.Set;

public class QuickExperimentManagerImpl
  implements QuickExperimentManager
{
  private static final Class<?> a = QuickExperimentManagerImpl.class;
  private final ImmutableSet<String> b;
  private final QuickExperimentStorage c;
  private final AnalyticsLogger d;
  private final AndroidThreadUtil e;
  private final LocaleUtil f;
  private final FbErrorReporter g;

  public QuickExperimentManagerImpl(Set<QuickExperimentNameHolder> paramSet, QuickExperimentStorage paramQuickExperimentStorage, AnalyticsLogger paramAnalyticsLogger, AndroidThreadUtil paramAndroidThreadUtil, LocaleUtil paramLocaleUtil, FbErrorReporter paramFbErrorReporter)
  {
    ImmutableSet.Builder localBuilder = new ImmutableSet.Builder();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
      localBuilder.b(((QuickExperimentNameHolder)localIterator.next()).a());
    this.b = localBuilder.b();
    this.c = paramQuickExperimentStorage;
    this.d = paramAnalyticsLogger;
    this.e = paramAndroidThreadUtil;
    this.f = paramLocaleUtil;
    this.g = paramFbErrorReporter;
  }

  private QuickExperimentInfo a(String paramString)
  {
    this.e.b();
    return this.c.a(paramString);
  }

  private QuickExperimentInfo b(String paramString, QuickExperimentInfoValidator paramQuickExperimentInfoValidator)
  {
    QuickExperimentInfo localQuickExperimentInfo = a(paramString);
    if (a(paramString, localQuickExperimentInfo, paramQuickExperimentInfoValidator));
    while (true)
    {
      return localQuickExperimentInfo;
      localQuickExperimentInfo = QuickExperimentInfo.b(paramString);
    }
  }

  public ImmutableSet<String> a()
  {
    return this.b;
  }

  public ListenableFuture<QuickExperimentInfo> a(String paramString, QuickExperimentInfoValidator paramQuickExperimentInfoValidator)
  {
    return this.e.a(new QuickExperimentManagerImpl.1(this, paramString, paramQuickExperimentInfoValidator));
  }

  boolean a(String paramString, QuickExperimentInfo paramQuickExperimentInfo, QuickExperimentInfoValidator paramQuickExperimentInfoValidator)
  {
    boolean bool1 = false;
    boolean bool2;
    if (paramQuickExperimentInfo != null)
    {
      bool2 = true;
      if ((bool2) && (!paramQuickExperimentInfo.a().equals(paramString)))
      {
        this.g.a("QuickExperiment Name failure: " + paramString, "Storage returned value of " + paramQuickExperimentInfo);
        bool2 = false;
      }
      String str = this.f.a();
      if ((bool2) && (!paramQuickExperimentInfo.d().equals(str)))
      {
        this.g.a("QuickExperiment Locale failure: " + paramString, "Expected " + str + " , got " + paramQuickExperimentInfo.d());
        bool2 = false;
      }
      if ((!bool2) || (paramQuickExperimentInfoValidator.a(paramQuickExperimentInfo)))
        break label236;
      this.g.a("QuickExperiment Invalid: " + paramString, "Failed to validate object " + paramQuickExperimentInfo);
    }
    while (true)
    {
      return bool1;
      bool2 = false;
      break;
      label236: bool1 = bool2;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.QuickExperimentManagerImpl
 * JD-Core Version:    0.6.2
 */