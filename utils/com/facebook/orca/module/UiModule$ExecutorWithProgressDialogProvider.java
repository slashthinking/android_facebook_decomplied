package com.facebook.orca.module;

import android.content.Context;
import com.facebook.common.util.ExecutorWithProgressDialog;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.annotations.ForUiThread;
import com.facebook.orca.inject.AbstractProvider;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Executor;

class UiModule$ExecutorWithProgressDialogProvider extends AbstractProvider<ExecutorWithProgressDialog>
{
  private UiModule$ExecutorWithProgressDialogProvider(UiModule paramUiModule)
  {
  }

  public ExecutorWithProgressDialog a()
  {
    return new ExecutorWithProgressDialog((Context)b(Context.class), (ListeningExecutorService)b(ListeningExecutorService.class, DefaultExecutorService.class), (Executor)b(Executor.class, ForUiThread.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.module.UiModule.ExecutorWithProgressDialogProvider
 * JD-Core Version:    0.6.2
 */