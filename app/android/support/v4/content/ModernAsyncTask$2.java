package android.support.v4.content;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

class ModernAsyncTask$2 extends ModernAsyncTask.WorkerRunnable<Params, Result>
{
  public Result call()
  {
    ModernAsyncTask.a(this.a).set(true);
    Process.setThreadPriority(10);
    return ModernAsyncTask.a(this.a, this.a.a(this.b));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.content.ModernAsyncTask.2
 * JD-Core Version:    0.6.0
 */