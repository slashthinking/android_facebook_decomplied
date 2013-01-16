package difflib;

import java.util.List;

public abstract interface DiffAlgorithm
{
  public abstract Patch a(List<?> paramList1, List<?> paramList2);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     difflib.DiffAlgorithm
 * JD-Core Version:    0.6.2
 */