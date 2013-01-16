package com.facebook.orca.cache;

import android.os.Bundle;
import com.facebook.orca.app.OrcaActivityBroadcaster;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.server.MarkThreadParams;
import com.facebook.orca.server.MarkThreadParams.Mark;
import com.facebook.orca.threads.ThreadSummary;
import javax.inject.Provider;

public class ReadThreadManager
{
  private final OrcaActivityBroadcaster a;
  private final Provider<OrcaServiceOperation> b;
  private final ThreadsCache c;

  public ReadThreadManager(OrcaActivityBroadcaster paramOrcaActivityBroadcaster, Provider<OrcaServiceOperation> paramProvider, ThreadsCache paramThreadsCache)
  {
    this.a = paramOrcaActivityBroadcaster;
    this.b = paramProvider;
    this.c = paramThreadsCache;
  }

  public void a(ThreadSummary paramThreadSummary)
  {
    String str = paramThreadSummary.a();
    this.c.a(str, paramThreadSummary.b());
    OrcaServiceOperation localOrcaServiceOperation = (OrcaServiceOperation)this.b.b();
    localOrcaServiceOperation.b(true);
    MarkThreadParams localMarkThreadParams = new MarkThreadParams(str, MarkThreadParams.Mark.READ, true, paramThreadSummary.b());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("markThreadParams", localMarkThreadParams);
    localOrcaServiceOperation.a("mark_thread", localBundle);
    this.a.c(str);
  }

  public void a(String paramString, long paramLong)
  {
    this.c.a(paramString, paramLong);
    OrcaServiceOperation localOrcaServiceOperation = (OrcaServiceOperation)this.b.b();
    localOrcaServiceOperation.b(true);
    MarkThreadParams localMarkThreadParams = new MarkThreadParams(paramString, MarkThreadParams.Mark.READ, false, paramLong);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("markThreadParams", localMarkThreadParams);
    localOrcaServiceOperation.a("mark_thread", localBundle);
    this.a.c(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.ReadThreadManager
 * JD-Core Version:    0.6.0
 */