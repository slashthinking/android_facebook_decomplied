package com.facebook.orca.cache;

import android.os.Bundle;
import com.facebook.orca.app.OrcaActivityBroadcaster;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.MarkThreadParams;
import com.facebook.orca.server.MarkThreadParams.Mark;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.threads.ThreadSummary;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Provider;

public class ArchiveThreadManager
{
  private final OrcaActivityBroadcaster a;
  private final Provider<OrcaServiceOperation> b;
  private final Set<String> c;

  public ArchiveThreadManager(OrcaActivityBroadcaster paramOrcaActivityBroadcaster, Provider<OrcaServiceOperation> paramProvider)
  {
    this.a = paramOrcaActivityBroadcaster;
    this.b = paramProvider;
    this.c = Sets.a();
  }

  private void a(ServiceException paramServiceException, String paramString)
  {
    this.c.remove(paramString);
    this.a.b(paramString);
  }

  private void a(OperationResult paramOperationResult, String paramString)
  {
    this.c.remove(paramString);
  }

  public void a(ThreadSummary paramThreadSummary)
  {
    String str = paramThreadSummary.a();
    OrcaServiceOperation localOrcaServiceOperation = (OrcaServiceOperation)this.b.b();
    localOrcaServiceOperation.a(new ArchiveThreadManager.1(this, str));
    localOrcaServiceOperation.b(true);
    MarkThreadParams localMarkThreadParams = new MarkThreadParams(str, MarkThreadParams.Mark.ARCHIVED, true, paramThreadSummary.b());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("markThreadParams", localMarkThreadParams);
    localOrcaServiceOperation.a("mark_thread", localBundle);
    this.c.add(paramThreadSummary.a());
  }

  public boolean a()
  {
    if (!this.c.isEmpty());
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean a(String paramString)
  {
    return this.c.contains(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.ArchiveThreadManager
 * JD-Core Version:    0.6.0
 */