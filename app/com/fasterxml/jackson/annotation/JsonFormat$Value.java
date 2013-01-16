package com.fasterxml.jackson.annotation;

import java.util.Locale;
import java.util.TimeZone;

public class JsonFormat$Value
{
  private final Locale locale;
  private final String pattern;
  private final JsonFormat.Shape shape;
  private final TimeZone timezone;

  public JsonFormat$Value(JsonFormat paramJsonFormat)
  {
    this(paramJsonFormat.pattern(), paramJsonFormat.shape(), paramJsonFormat.locale(), paramJsonFormat.timezone());
  }

  public JsonFormat$Value(String paramString1, JsonFormat.Shape paramShape, String paramString2, String paramString3)
  {
    this.pattern = paramString1;
    this.shape = paramShape;
    if ((paramString2 == null) || (paramString2.length() == 0) || ("##default".equals(paramString2)))
    {
      this.locale = null;
      if ((paramString3 != null) && (paramString3.length() != 0) && (!"##default".equals(paramString3)))
        break label83;
    }
    label83: for (this.timezone = null; ; this.timezone = TimeZone.getTimeZone(paramString3))
    {
      return;
      this.locale = new Locale(paramString2);
      break;
    }
  }

  public Locale getLocale()
  {
    return this.locale;
  }

  public String getPattern()
  {
    return this.pattern;
  }

  public JsonFormat.Shape getShape()
  {
    return this.shape;
  }

  public TimeZone getTimeZone()
  {
    return this.timezone;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.fasterxml.jackson.annotation.JsonFormat.Value
 * JD-Core Version:    0.6.0
 */