package com.facebook.katana.util.logging;

import android.graphics.Point;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ActionEvent extends MobileEvent
{
  public ActionEvent(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, Point paramPoint)
  {
    super("action", System.currentTimeMillis());
    this.c.put("sub_type", paramString1);
    this.c.put("a", paramString2);
    if (paramString3 != null)
      this.c.put("ot", paramString3);
    if (paramString4 != null)
      this.c.put("oid", paramString4);
    if (paramLong1 > 0L)
      this.c.put("fbot", Long.toString(paramLong1));
    if (paramLong2 > 0L)
      this.c.put("fbid", Long.toString(paramLong2));
    if (paramString5 != null)
      this.c.put("cm", paramString5);
    if (paramPoint != null)
    {
      this.c.put("x", paramPoint.x);
      this.c.put("y", paramPoint.y);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.ActionEvent
 * JD-Core Version:    0.6.0
 */