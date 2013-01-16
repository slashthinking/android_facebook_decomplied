package com.facebook.orca.merge;

import android.os.Parcelable;
import com.facebook.login.ContextAwareAuthTokenStringSupplier;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.threads.FolderName;
import java.util.concurrent.Callable;

class MergeServiceHandler$5
  implements Callable<T>
{
  public T call()
  {
    Tracer.b(5L);
    Tracer localTracer = Tracer.a("For " + this.a);
    try
    {
      if (this.b != null)
        MergeServiceHandler.a(this.d).a(this.b);
      try
      {
        Parcelable localParcelable = this.c.a(this.a).h();
        if (this.b != null)
          MergeServiceHandler.a(this.d).a();
        localTracer.a();
        Tracer.a(MergeServiceHandler.a());
        return localParcelable;
      }
      finally
      {
        if (this.b != null)
          MergeServiceHandler.a(this.d).a();
      }
    }
    finally
    {
      localTracer.a();
      Tracer.a(MergeServiceHandler.a());
    }
    throw localObject1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergeServiceHandler.5
 * JD-Core Version:    0.6.0
 */