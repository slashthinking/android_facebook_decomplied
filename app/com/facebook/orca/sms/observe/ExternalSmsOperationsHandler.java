package com.facebook.orca.sms.observe;

import android.os.Bundle;
import com.facebook.orca.app.OrcaDataManager;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.server.DeleteThreadParams;
import com.facebook.orca.sms.MmsSmsLogger;
import com.facebook.orca.threads.MessagingIdUtil;
import java.util.Iterator;
import java.util.Set;

public class ExternalSmsOperationsHandler
{
  private final MmsSmsLogger a;
  private final OrcaServiceOperation b;
  private final OrcaDataManager c;

  public ExternalSmsOperationsHandler(MmsSmsLogger paramMmsSmsLogger, OrcaServiceOperation paramOrcaServiceOperation, OrcaDataManager paramOrcaDataManager)
  {
    this.b = paramOrcaServiceOperation;
    this.c = paramOrcaDataManager;
    paramOrcaServiceOperation.a(true);
    this.a = paramMmsSmsLogger;
  }

  public void a(Set<Long> paramSet)
  {
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      DeleteThreadParams localDeleteThreadParams = new DeleteThreadParams(MessagingIdUtil.a(((Long)localIterator.next()).longValue()));
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("deleteThreadParams", localDeleteThreadParams);
      this.b.a("delete_thread", localBundle);
    }
    this.c.f();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.observe.ExternalSmsOperationsHandler
 * JD-Core Version:    0.6.0
 */