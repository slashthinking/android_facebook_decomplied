package custom.android;

class AdapterView$SelectionNotifier
  implements Runnable
{
  private AdapterView$SelectionNotifier(AdapterView paramAdapterView)
  {
  }

  public void run()
  {
    if (this.a.v)
      if (this.a.getAdapter() != null)
        this.a.post(this);
    while (true)
    {
      return;
      AdapterView.b(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     custom.android.AdapterView.SelectionNotifier
 * JD-Core Version:    0.6.0
 */