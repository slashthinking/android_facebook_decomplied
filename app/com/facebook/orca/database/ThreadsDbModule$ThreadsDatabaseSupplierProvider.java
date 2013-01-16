package com.facebook.orca.database;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class ThreadsDbModule$ThreadsDatabaseSupplierProvider extends AbstractProvider<ThreadsDatabaseSupplier>
{
  private ThreadsDbModule$ThreadsDatabaseSupplierProvider(ThreadsDbModule paramThreadsDbModule)
  {
  }

  public ThreadsDatabaseSupplier a()
  {
    return new ThreadsDatabaseSupplier((Context)b(Context.class, FromApplication.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (ThreadsDbSchemaPart)b(ThreadsDbSchemaPart.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.ThreadsDbModule.ThreadsDatabaseSupplierProvider
 * JD-Core Version:    0.6.0
 */