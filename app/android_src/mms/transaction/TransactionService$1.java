package android_src.mms.transaction;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class TransactionService$1 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    String str;
    if (paramMessage.what == 1)
      str = this.a.getString(2131362156);
    while (true)
    {
      if (str != null)
        Toast.makeText(this.a, str, 1).show();
      return;
      int i = paramMessage.what;
      str = null;
      if (i != 2)
        continue;
      str = this.a.getString(2131362157);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.TransactionService.1
 * JD-Core Version:    0.6.0
 */