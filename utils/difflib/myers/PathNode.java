package difflib.myers;

public abstract class PathNode
{
  public final int a;
  public final int b;
  public final PathNode c;

  public PathNode(int paramInt1, int paramInt2, PathNode paramPathNode)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramPathNode;
  }

  public abstract boolean a();

  public boolean b()
  {
    if ((this.a < 0) || (this.b < 0));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public final PathNode c()
  {
    if (b());
    for (this = null; ; this = this.c.c())
      do
        return this;
      while ((a()) || (this.c == null));
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("[");
    while (this != null)
    {
      localStringBuffer.append("(");
      localStringBuffer.append(Integer.toString(this.a));
      localStringBuffer.append(",");
      localStringBuffer.append(Integer.toString(this.b));
      localStringBuffer.append(")");
      this = this.c;
    }
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     difflib.myers.PathNode
 * JD-Core Version:    0.6.2
 */