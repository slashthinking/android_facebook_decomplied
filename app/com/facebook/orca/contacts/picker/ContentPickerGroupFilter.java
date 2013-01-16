package com.facebook.orca.contacts.picker;

import com.facebook.orca.common.ui.widgets.CustomFilter.FilterResults;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.protocol.methods.FetchThreadListMethod;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.FetchThreadListParams;
import com.facebook.orca.server.FetchThreadListParamsBuilder;
import com.facebook.orca.server.FetchThreadListResult;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadsCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;

public class ContentPickerGroupFilter extends AbstractContactPickerListFilter
{
  private static final Class<?> b = ContentPickerGroupFilter.class;
  private final SingleMethodRunner c;
  private final FetchThreadListMethod d;

  public ContentPickerGroupFilter(SingleMethodRunner paramSingleMethodRunner, FetchThreadListMethod paramFetchThreadListMethod)
  {
    this.c = paramSingleMethodRunner;
    this.d = paramFetchThreadListMethod;
  }

  protected CustomFilter.FilterResults b(CharSequence paramCharSequence)
  {
    BLog.b(b, "starting filtering, constraint=" + paramCharSequence);
    CustomFilter.FilterResults localFilterResults1 = new CustomFilter.FilterResults();
    FetchThreadListParams localFetchThreadListParams = FetchThreadListParams.newBuilder().a(DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE).a(FolderName.b).a(true).f();
    ImmutableList.Builder localBuilder;
    CustomFilter.FilterResults localFilterResults2;
    try
    {
      FetchThreadListResult localFetchThreadListResult = (FetchThreadListResult)this.c.a(this.d, localFetchThreadListParams);
      localBuilder = ImmutableList.e();
      BLog.b(b, "got thread summaries: " + localFetchThreadListResult.b().e());
      Iterator localIterator = localFetchThreadListResult.b().b().iterator();
      while (localIterator.hasNext())
      {
        ThreadSummary localThreadSummary = (ThreadSummary)localIterator.next();
        if (localThreadSummary.g())
          continue;
        BLog.a(b, "adding group summary: " + localThreadSummary);
        localBuilder.b(this.a.a(localThreadSummary));
      }
    }
    catch (Exception localException)
    {
      BLog.d(b, "exception with filtering groups", localException);
      localFilterResults1.b = 0;
      localFilterResults1.a = ContactPickerFilterResult.b(paramCharSequence);
      localFilterResults2 = localFilterResults1;
    }
    while (true)
    {
      return localFilterResults2;
      ImmutableList localImmutableList = localBuilder.b();
      localFilterResults1.b = localImmutableList.size();
      localFilterResults1.a = ContactPickerFilterResult.a(paramCharSequence, localImmutableList);
      localFilterResults2 = localFilterResults1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContentPickerGroupFilter
 * JD-Core Version:    0.6.0
 */