package com.facebook.katana.activity.codegenerator;

import android.os.Handler;
import com.facebook.katana.view.FacebookProgressCircleView;
import java.util.Date;

class CodeGeneratorActivity$2
  implements Runnable
{
  public void run()
  {
    Long localLong1 = new Long(new Date().getTime() / 1000L);
    Long localLong2 = Long.valueOf(30L - localLong1.longValue() % 30L);
    Long localLong3 = Long.valueOf(localLong1.longValue() / 30L);
    String str = CodeGeneratorActivity.a(CodeGeneratorActivity.a(this.a), localLong3);
    this.a.a(str);
    CodeGeneratorActivity.b(this.a).setProgress((int)(100.0D * (localLong2.longValue() / 30.0D)));
    CodeGeneratorActivity.c(this.a).postDelayed(this, 1000L);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.codegenerator.CodeGeneratorActivity.2
 * JD-Core Version:    0.6.0
 */