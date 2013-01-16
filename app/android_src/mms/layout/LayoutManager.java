package android_src.mms.layout;

public class LayoutManager
{
  private static LayoutManager b;
  private LayoutParameters a;

  public static LayoutManager a()
  {
    if (b == null)
      throw new IllegalStateException("Uninitialized.");
    return b;
  }

  public LayoutParameters b()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.layout.LayoutManager
 * JD-Core Version:    0.6.0
 */