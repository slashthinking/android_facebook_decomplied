package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.katana.util.StringUtils;
import com.fasterxml.jackson.core.JsonParser;

public class CodeGeneratorGetSecretResponse
  implements JMStaticKeysDictDestination
{
  private static final String SECRET_KEY = "key";

  @JMAutogen.InferredType(jsonFieldName="key")
  private final String mSecretKey = null;

  public static CodeGeneratorGetSecretResponse a(JsonParser paramJsonParser)
  {
    return (CodeGeneratorGetSecretResponse)JMParser.a(paramJsonParser, CodeGeneratorGetSecretResponse.class);
  }

  public static String a(String paramString)
  {
    return paramString.toUpperCase().trim().replaceAll(" ", "");
  }

  public static boolean b(String paramString)
  {
    boolean bool = StringUtils.c(paramString);
    int i = 0;
    if (bool);
    while (true)
    {
      return i;
      int j = paramString.length();
      i = 0;
      if (j != 16)
        continue;
      for (int k = 0; ; k++)
      {
        if (k >= paramString.length())
          break label84;
        int m = paramString.charAt(k);
        if ((65 <= m) && (m <= 90))
          continue;
        i = 0;
        if (50 > m)
          break;
        i = 0;
        if (m > 55)
          break;
      }
      label84: i = 1;
    }
  }

  public String a()
  {
    return a(this.mSecretKey);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.CodeGeneratorGetSecretResponse
 * JD-Core Version:    0.6.0
 */