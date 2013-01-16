package difflib;

public class DeleteDelta extends Delta
{
  public DeleteDelta(Chunk paramChunk1, Chunk paramChunk2)
  {
    super(paramChunk1, paramChunk2);
  }

  public String toString()
  {
    return "[DeleteDelta, position: " + a().a() + ", lines: " + a().b() + "]";
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     difflib.DeleteDelta
 * JD-Core Version:    0.6.2
 */