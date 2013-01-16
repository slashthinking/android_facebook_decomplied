package com.facebook.orca.ops;

import android.app.ProgressDialog;
import android.content.Context;

public class DialogBasedProgressIndicator
  implements OperationProgressIndicator
{
  private final Context a;
  private final String b;
  private ProgressDialog c;

  public DialogBasedProgressIndicator(Context paramContext, int paramInt)
  {
    this.a = paramContext;
    this.b = paramContext.getString(paramInt);
  }

  public DialogBasedProgressIndicator(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }

  public void a()
  {
    if (this.c == null)
    {
      this.c = new ProgressDialog(this.a);
      this.c.setCancelable(false);
      this.c.setMessage(this.b);
      this.c.show();
    }
  }

  public void b()
  {
    if ((this.c != null) && (this.c.isShowing()))
    {
      this.c.dismiss();
      this.c = null;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.ops.DialogBasedProgressIndicator
 * JD-Core Version:    0.6.2
 */