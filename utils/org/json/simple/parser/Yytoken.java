package org.json.simple.parser;

public class Yytoken
{
  public int a = 0;
  public Object b = null;

  public Yytoken(int paramInt, Object paramObject)
  {
    this.a = paramInt;
    this.b = paramObject;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    switch (this.a)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case -1:
    }
    while (true)
    {
      return localStringBuffer.toString();
      localStringBuffer.append("VALUE(").append(this.b).append(")");
      continue;
      localStringBuffer.append("LEFT BRACE({)");
      continue;
      localStringBuffer.append("RIGHT BRACE(})");
      continue;
      localStringBuffer.append("LEFT SQUARE([)");
      continue;
      localStringBuffer.append("RIGHT SQUARE(])");
      continue;
      localStringBuffer.append("COMMA(,)");
      continue;
      localStringBuffer.append("COLON(:)");
      continue;
      localStringBuffer.append("END OF FILE");
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     org.json.simple.parser.Yytoken
 * JD-Core Version:    0.6.2
 */