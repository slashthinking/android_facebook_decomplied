package difflib;

public abstract class Delta
{
  private Chunk a;
  private Chunk b;

  public Delta(Chunk paramChunk1, Chunk paramChunk2)
  {
    this.a = paramChunk1;
    this.b = paramChunk2;
  }

  public Chunk a()
  {
    return this.a;
  }

  public Chunk b()
  {
    return this.b;
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
        Delta localDelta = (Delta)paramObject;
        if (this.a == null)
        {
          if (localDelta.a != null)
            bool = false;
        }
        else if (!this.a.equals(localDelta.a))
          bool = false;
        else if (this.b == null)
        {
          if (localDelta.b != null)
            bool = false;
        }
        else if (!this.b.equals(localDelta.b))
          bool = false;
      }
    }
  }

  public int hashCode()
  {
    int i;
    int j;
    int k;
    if (this.a == null)
    {
      i = 0;
      j = 31 * (i + 31);
      Chunk localChunk = this.b;
      k = 0;
      if (localChunk != null)
        break label45;
    }
    while (true)
    {
      return j + k;
      i = this.a.hashCode();
      break;
      label45: k = this.b.hashCode();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     difflib.Delta
 * JD-Core Version:    0.6.2
 */