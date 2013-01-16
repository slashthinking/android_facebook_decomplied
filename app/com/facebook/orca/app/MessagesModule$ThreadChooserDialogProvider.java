package com.facebook.orca.app;

import android.content.Context;
import com.facebook.orca.annotations.CurrentFolderType;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.threadlist.ThreadChooserDialog;
import com.facebook.orca.threadlist.ThreadListAdapter;
import com.facebook.orca.threads.FolderType;

class MessagesModule$ThreadChooserDialogProvider extends AbstractProvider<ThreadChooserDialog>
{
  private MessagesModule$ThreadChooserDialogProvider(MessagesModule paramMessagesModule)
  {
  }

  public ThreadChooserDialog a()
  {
    return new ThreadChooserDialog((Context)b(Context.class), (ThreadListAdapter)b(ThreadListAdapter.class), (DataCache)b(DataCache.class), (OrcaServiceOperation)b(OrcaServiceOperation.class), a(FolderType.class, CurrentFolderType.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.ThreadChooserDialogProvider
 * JD-Core Version:    0.6.0
 */