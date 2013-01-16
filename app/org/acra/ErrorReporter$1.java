package org.acra;

import android.os.Looper;
import android.widget.Toast;
import org.acra.reporter.ReportsCrashes;

class ErrorReporter$1 extends Thread
{
  public void run()
  {
    Looper.prepare();
    Toast.makeText(ErrorReporter.access$000(), ACRA.getConfig().resToastText(), 1).show();
    Looper.loop();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.ErrorReporter.1
 * JD-Core Version:    0.6.0
 */