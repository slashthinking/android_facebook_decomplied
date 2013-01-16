package com.facebook.orca.threadlist;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class ThreadListLoader$Params
{
  public final boolean a;
  public final boolean b;

  public ThreadListLoader$Params(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("needToHitServer", Boolean.valueOf(this.a)).add("loadWasFromUserAction", Boolean.valueOf(this.b)).toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListLoader.Params
 * JD-Core Version:    0.6.0
 */