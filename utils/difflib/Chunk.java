package difflib;

import java.util.Arrays;
import java.util.List;

public class Chunk
{
  private final int a;
  private List<?> b;

  public Chunk(int paramInt, Object[] paramArrayOfObject)
  {
    this.a = paramInt;
    this.b = Arrays.asList(paramArrayOfObject);
  }

  public int a()
  {
    return this.a;
  }

  public List<?> b()
  {
    return this.b;
  }

  public int c()
  {
    return this.b.size();
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject);
    while (true)
    {
      return bool;
      if (paramObject == null)
      {
        bool = false;
      }
      else if (getClass() != paramObject.getClass())
      {
        bool = false;
      }
      else
      {
        Chunk localChunk = (Chunk)paramObject;
        if (this.b == null)
        {
          if (localChunk.b != null)
            bool = false;
        }
        else if (!this.b.equals(localChunk.b))
          bool = false;
        else if (this.a != localChunk.a)
          bool = false;
      }
    }
  }

  public int hashCode()
  {
    if (this.b == null);
    for (int i = 0; ; i = this.b.hashCode())
      return 31 * (31 * (i + 31) + this.a) + c();
  }

  public String toString()
  {
    return "[position: " + this.a + ", size: " + c() + ", lines: " + this.b + "]";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     difflib.Chunk
 * JD-Core Version:    0.6.2
 */