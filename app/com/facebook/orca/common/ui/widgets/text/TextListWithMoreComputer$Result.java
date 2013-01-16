package com.facebook.orca.common.ui.widgets.text;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import java.util.List;

public class TextListWithMoreComputer$Result
{
  public final List<String> a;
  public final int b;

  public TextListWithMoreComputer$Result(List<String> paramList, int paramInt)
  {
    this.a = paramList;
    this.b = paramInt;
  }

  public List<String> a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public String toString()
  {
    return Objects.toStringHelper(TextListWithMoreComputer.class).add("lines", this.a).add("moreCount", Integer.valueOf(this.b)).toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.text.TextListWithMoreComputer.Result
 * JD-Core Version:    0.6.0
 */