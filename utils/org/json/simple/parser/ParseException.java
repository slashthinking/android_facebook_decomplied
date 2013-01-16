package org.json.simple.parser;

public class ParseException extends Exception
{
  private static final long serialVersionUID = -7880698968187728548L;
  private int errorType;
  private int position;
  private Object unexpectedObject;

  public ParseException(int paramInt1, int paramInt2, Object paramObject)
  {
    this.position = paramInt1;
    this.errorType = paramInt2;
    this.unexpectedObject = paramObject;
  }

  public int a()
  {
    return this.position;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    switch (this.errorType)
    {
    default:
      localStringBuffer.append("Unkown error at position ").append(this.position).append(".");
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      return localStringBuffer.toString();
      localStringBuffer.append("Unexpected character (").append(this.unexpectedObject).append(") at position ").append(this.position).append(".");
      continue;
      localStringBuffer.append("Unexpected token ").append(this.unexpectedObject).append(" at position ").append(this.position).append(".");
      continue;
      localStringBuffer.append("Unexpected exception at position ").append(this.position).append(": ").append(this.unexpectedObject);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     org.json.simple.parser.ParseException
 * JD-Core Version:    0.6.2
 */