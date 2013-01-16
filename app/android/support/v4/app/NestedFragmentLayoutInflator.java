package android.support.v4.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.LayoutInflater.Filter;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;

public class NestedFragmentLayoutInflator extends LayoutInflater
{
  private static final String[] a = { "android.widget.", "android.webkit." };
  private LayoutInflater b;
  private NestedFragment c;

  public NestedFragmentLayoutInflator(LayoutInflater paramLayoutInflater, NestedFragment paramNestedFragment)
  {
    super(paramLayoutInflater.getContext());
    this.b = paramLayoutInflater;
    this.c = paramNestedFragment;
  }

  public LayoutInflater cloneInContext(Context paramContext)
  {
    return new NestedFragmentLayoutInflator(this.b.cloneInContext(paramContext), this.c);
  }

  public Context getContext()
  {
    return this.b.getContext();
  }

  public LayoutInflater.Filter getFilter()
  {
    return this.b.getFilter();
  }

  public View inflate(XmlPullParser paramXmlPullParser, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    FragmentHost localFragmentHost = this.c.o();
    FragmentManager localFragmentManager = localFragmentHost.j();
    localFragmentHost.a(this.c.K());
    View localView = this.b.inflate(paramXmlPullParser, paramViewGroup, paramBoolean);
    localFragmentHost.a(localFragmentManager);
    return localView;
  }

  protected View onCreateView(String paramString, AttributeSet paramAttributeSet)
  {
    String[] arrayOfString = a;
    int i = arrayOfString.length;
    int j = 0;
    String str;
    if (j < i)
      str = arrayOfString[j];
    while (true)
    {
      try
      {
        View localView2 = this.b.createView(paramString, str, paramAttributeSet);
        localView1 = localView2;
        if (localView1 != null)
          return localView1;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        j++;
      }
      break;
      View localView1 = super.onCreateView(paramString, paramAttributeSet);
    }
  }

  public void setFactory(LayoutInflater.Factory paramFactory)
  {
    super.setFactory(paramFactory);
    this.b.setFactory(paramFactory);
  }

  public void setFactory2(LayoutInflater.Factory2 paramFactory2)
  {
    super.setFactory2(paramFactory2);
    this.b.setFactory2(paramFactory2);
  }

  public void setFilter(LayoutInflater.Filter paramFilter)
  {
    super.setFilter(paramFilter);
    this.b.setFilter(paramFilter);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NestedFragmentLayoutInflator
 * JD-Core Version:    0.6.0
 */