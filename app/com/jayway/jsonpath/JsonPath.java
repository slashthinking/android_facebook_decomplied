package com.jayway.jsonpath;

import com.jayway.jsonpath.filter.FilterOutput;
import com.jayway.jsonpath.filter.JsonPathFilterChain;
import java.util.logging.Logger;
import org.json.simple.parser.JSONParser;

public class JsonPath
{
  private static final Logger a = Logger.getLogger(JsonPath.class.getName());
  private static JSONParser b = new JSONParser();
  private JsonPathFilterChain c;

  private JsonPath(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0) || (paramString.matches("new ")) || (paramString.matches("[^\\?\\+\\=\\-\\*\\/\\!]\\(")))
      throw new InvalidPathException("Invalid path");
    this.c = new JsonPathFilterChain(PathUtil.a(paramString));
  }

  public static <T> T a(String paramString1, String paramString2)
  {
    return b(paramString2).a(paramString1);
  }

  public static JsonPath b(String paramString)
  {
    return new JsonPath(paramString);
  }

  private static Object c(String paramString)
  {
    try
    {
      Object localObject = b.a(paramString);
      return localObject;
    }
    catch (org.json.simple.parser.ParseException localParseException)
    {
    }
    throw new java.text.ParseException(paramString, localParseException.a());
  }

  public <T> T a(Object paramObject)
  {
    FilterOutput localFilterOutput = this.c.a(paramObject);
    if ((localFilterOutput == null) || (localFilterOutput.b() == null));
    for (Object localObject = null; ; localObject = localFilterOutput.b())
      return localObject;
  }

  public <T> T a(String paramString)
  {
    return a(c(paramString));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.JsonPath
 * JD-Core Version:    0.6.0
 */