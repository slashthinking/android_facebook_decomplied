package com.facebook.common.json.jsonmirror.types;

import com.facebook.common.json.jsonmirror.JMFatalException;
import com.fasterxml.jackson.core.JsonFactory;

public class JMEscaped extends JMBase
{
  public final JMBase g;
  public final JsonFactory h;

  public JMEscaped(JMBase paramJMBase, JsonFactory paramJsonFactory)
  {
    if ((!(paramJMBase instanceof JMDict)) && (!(paramJMBase instanceof JMSimpleDict)) && (!(paramJMBase instanceof JMList)))
      throw new JMFatalException("stringified values can only encapsulate complex types.");
    this.g = paramJMBase;
    this.h = paramJsonFactory;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.json.jsonmirror.types.JMEscaped
 * JD-Core Version:    0.6.0
 */