package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListFragment extends Fragment
{
  private final Runnable Y = new ListFragment.1(this);
  private final AdapterView.OnItemClickListener Z = new ListFragment.2(this);
  ListAdapter a;
  ListView b;
  View c;
  TextView d;
  View e;
  View f;
  CharSequence g;
  boolean h;
  private final Handler i = new Handler();

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    b();
    if (this.e == null)
      throw new IllegalStateException("Can't be used with a custom content view");
    if (this.h == paramBoolean1)
      return;
    this.h = paramBoolean1;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.e.startAnimation(AnimationUtils.loadAnimation(p(), 17432577));
        this.f.startAnimation(AnimationUtils.loadAnimation(p(), 17432576));
      }
      while (true)
      {
        this.e.setVisibility(8);
        this.f.setVisibility(0);
        break;
        this.e.clearAnimation();
        this.f.clearAnimation();
      }
    }
    if (paramBoolean2)
    {
      this.e.startAnimation(AnimationUtils.loadAnimation(p(), 17432576));
      this.f.startAnimation(AnimationUtils.loadAnimation(p(), 17432577));
    }
    while (true)
    {
      this.e.setVisibility(0);
      this.f.setVisibility(8);
      break;
      this.e.clearAnimation();
      this.f.clearAnimation();
    }
  }

  private void b()
  {
    if (this.b != null)
      return;
    View localView1 = A();
    if (localView1 == null)
      throw new IllegalStateException("Content view not yet created");
    if ((localView1 instanceof ListView))
    {
      this.b = ((ListView)localView1);
      label42: this.h = true;
      this.b.setOnItemClickListener(this.Z);
      if (this.a == null)
        break label258;
      ListAdapter localListAdapter = this.a;
      this.a = null;
      a(localListAdapter);
    }
    while (true)
    {
      this.i.post(this.Y);
      break;
      this.d = ((TextView)localView1.findViewById(16711681));
      if (this.d == null)
        this.c = localView1.findViewById(16908292);
      View localView2;
      while (true)
      {
        this.e = localView1.findViewById(16711682);
        this.f = localView1.findViewById(16711683);
        localView2 = localView1.findViewById(16908298);
        if ((localView2 instanceof ListView))
          break;
        if (localView2 == null)
        {
          throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
          this.d.setVisibility(8);
          continue;
        }
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
      }
      this.b = ((ListView)localView2);
      if (this.c != null)
      {
        this.b.setEmptyView(this.c);
        break label42;
      }
      if (this.g == null)
        break label42;
      this.d.setText(this.g);
      this.b.setEmptyView(this.d);
      break label42;
      label258: if (this.e == null)
        continue;
      a(false, false);
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Context localContext = p();
    FrameLayout localFrameLayout1 = new FrameLayout(localContext);
    LinearLayout localLinearLayout = new LinearLayout(localContext);
    localLinearLayout.setId(16711682);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setVisibility(8);
    localLinearLayout.setGravity(17);
    localLinearLayout.addView(new ProgressBar(localContext, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
    localFrameLayout1.addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -1));
    FrameLayout localFrameLayout2 = new FrameLayout(localContext);
    localFrameLayout2.setId(16711683);
    TextView localTextView = new TextView(p());
    localTextView.setId(16711681);
    localTextView.setGravity(17);
    localFrameLayout2.addView(localTextView, new FrameLayout.LayoutParams(-1, -1));
    ListView localListView = new ListView(p());
    localListView.setId(16908298);
    localListView.setDrawSelectorOnTop(false);
    localFrameLayout2.addView(localListView, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout1.addView(localFrameLayout2, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout1.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return localFrameLayout1;
  }

  public ListView a()
  {
    b();
    return this.b;
  }

  public void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    b();
  }

  public void a(ListAdapter paramListAdapter)
  {
    if (this.a != null);
    for (int j = 1; ; j = 0)
    {
      this.a = paramListAdapter;
      if (this.b != null)
      {
        this.b.setAdapter(paramListAdapter);
        if ((!this.h) && (j == 0))
        {
          IBinder localIBinder = A().getWindowToken();
          boolean bool = false;
          if (localIBinder != null)
            bool = true;
          a(true, bool);
        }
      }
      return;
    }
  }

  public void a(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
  }

  public void h()
  {
    this.i.removeCallbacks(this.Y);
    this.b = null;
    this.h = false;
    this.f = null;
    this.e = null;
    this.c = null;
    this.d = null;
    super.h();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ListFragment
 * JD-Core Version:    0.6.0
 */