package difflib;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Patch
{
  private List<Delta> a = new LinkedList();

  public List<Delta> a()
  {
    Collections.sort(this.a, DeltaComparator.a);
    return this.a;
  }

  public void a(Delta paramDelta)
  {
    this.a.add(paramDelta);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     difflib.Patch
 * JD-Core Version:    0.6.2
 */