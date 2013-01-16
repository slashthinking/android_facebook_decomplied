package android.support.v4.app;

import android.support.v4.util.SparseArrayCompat;

class NestedFragment$NestedFragmentHost extends DelegatingFragmentHost
{
  public NestedFragment$NestedFragmentHost(NestedFragment paramNestedFragment, FragmentHost paramFragmentHost)
  {
    super(paramFragmentHost);
  }

  LoaderManagerImpl a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (NestedFragment.a(this.a) == null)
      NestedFragment.a(this.a, new SparseArrayCompat());
    LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)NestedFragment.a(this.a).a(paramInt);
    if (localLoaderManagerImpl == null)
      if (paramBoolean2)
      {
        localLoaderManagerImpl = new LoaderManagerImpl(this.a.n(), paramBoolean1);
        NestedFragment.a(this.a).b(paramInt, localLoaderManagerImpl);
      }
    while (true)
    {
      return localLoaderManagerImpl;
      localLoaderManagerImpl.a(this.a.n());
    }
  }

  void a(int paramInt)
  {
    if (NestedFragment.a(this.a) != null)
    {
      LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)NestedFragment.a(this.a).a(paramInt);
      if ((localLoaderManagerImpl != null) && (!localLoaderManagerImpl.f))
      {
        localLoaderManagerImpl.h();
        NestedFragment.a(this.a).c(paramInt);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NestedFragment.NestedFragmentHost
 * JD-Core Version:    0.6.0
 */