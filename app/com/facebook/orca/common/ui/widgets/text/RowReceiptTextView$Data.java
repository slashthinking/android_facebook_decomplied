package com.facebook.orca.common.ui.widgets.text;

import com.facebook.orca.threadview.RowReceiptParticipant;
import java.util.List;

public class RowReceiptTextView$Data
{
  private final String a;
  private final List<RowReceiptParticipant> b;

  public RowReceiptTextView$Data(String paramString)
  {
    this.a = paramString;
    this.b = null;
  }

  public RowReceiptTextView$Data(List<RowReceiptParticipant> paramList)
  {
    this.a = null;
    this.b = paramList;
  }

  public String a()
  {
    return this.a;
  }

  public List<RowReceiptParticipant> b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.text.RowReceiptTextView.Data
 * JD-Core Version:    0.6.0
 */