package android_src.mms.transaction;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Observable
{
  private final ArrayList<Observer> a = new ArrayList();
  private Iterator<Observer> b;

  public void a(Observer paramObserver)
  {
    this.a.add(paramObserver);
  }

  public void b(Observer paramObserver)
  {
    if (this.b != null)
      this.b.remove();
    while (true)
    {
      return;
      this.a.remove(paramObserver);
    }
  }

  public void c()
  {
    this.b = this.a.iterator();
    try
    {
      if (this.b.hasNext())
        ((Observer)this.b.next()).a(this);
    }
    finally
    {
      this.b = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.Observable
 * JD-Core Version:    0.6.0
 */