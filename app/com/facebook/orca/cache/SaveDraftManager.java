package com.facebook.orca.cache;

import android.os.Bundle;
import com.facebook.orca.compose.MessageDraft;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Provider;

public class SaveDraftManager
{
  private final Provider<OrcaServiceOperation> a;
  private final Map<String, MessageDraft> b;

  public SaveDraftManager(Provider<OrcaServiceOperation> paramProvider)
  {
    this.a = paramProvider;
    this.b = Maps.a();
  }

  public void a(String paramString, MessageDraft paramMessageDraft)
  {
    OrcaServiceOperation localOrcaServiceOperation = (OrcaServiceOperation)this.a.b();
    localOrcaServiceOperation.b(true);
    localOrcaServiceOperation.a(new SaveDraftManager.1(this, paramString));
    this.b.put(paramString, paramMessageDraft);
    Bundle localBundle = new Bundle();
    localBundle.putString("threadId", paramString);
    localBundle.putParcelable("draft", paramMessageDraft);
    localOrcaServiceOperation.a("save_draft", localBundle);
  }

  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }

  public MessageDraft b(String paramString)
  {
    return (MessageDraft)this.b.get(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.SaveDraftManager
 * JD-Core Version:    0.6.0
 */