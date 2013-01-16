package difflib;

public class ChangeDelta extends Delta
{
  public ChangeDelta(Chunk paramChunk1, Chunk paramChunk2)
  {
    super(paramChunk1, paramChunk2);
  }

  public String toString()
  {
    return "[ChangeDelta, position: " + a().a() + ", lines: " + a().b() + " to " + b().b() + "]";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     difflib.ChangeDelta
 * JD-Core Version:    0.6.2
 */