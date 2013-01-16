package com.facebook.orca.threadview;

import java.util.Comparator;

final class RowReceiptParticipant$1
  implements Comparator<RowReceiptParticipant>
{
  public int a(RowReceiptParticipant paramRowReceiptParticipant1, RowReceiptParticipant paramRowReceiptParticipant2)
  {
    int i;
    if (paramRowReceiptParticipant1.b() < paramRowReceiptParticipant2.b())
      i = 1;
    while (true)
    {
      return i;
      if (paramRowReceiptParticipant1.b() > paramRowReceiptParticipant2.b())
      {
        i = -1;
        continue;
      }
      i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.RowReceiptParticipant.1
 * JD-Core Version:    0.6.0
 */