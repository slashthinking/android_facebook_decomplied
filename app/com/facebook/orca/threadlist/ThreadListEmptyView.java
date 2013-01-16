package com.facebook.orca.threadlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import com.facebook.content.SecureContextHelper;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.users.User;
import com.facebook.widget.CustomViewGroup;
import com.google.common.collect.ImmutableList;

public class ThreadListEmptyView extends CustomViewGroup
{
  private LayoutInflater a;
  private ContactGridAdapter b;
  private View c;
  private Button d;
  private SecureContextHelper e;
  private OrcaSharedPreferences f;
  private ImmutableList<User> g = ImmutableList.d();

  public ThreadListEmptyView(Context paramContext)
  {
    super(paramContext);
    a(null);
  }

  public ThreadListEmptyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }

  public ThreadListEmptyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }

  private void a(AttributeSet paramAttributeSet)
  {
    FbInjector localFbInjector = getInjector();
    this.a = ((LayoutInflater)localFbInjector.a(LayoutInflater.class));
    this.a.inflate(2130903406, this);
    this.e = ((SecureContextHelper)localFbInjector.a(SecureContextHelper.class));
    this.f = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.c = findViewById(2131297454);
    this.d = ((Button)this.c.findViewById(2131297456));
    this.d.setOnClickListener(new ThreadListEmptyView.1(this));
    if (c())
      this.c.setVisibility(8);
    this.b = new ContactGridAdapter(getContext(), ImmutableList.d());
    GridView localGridView = (GridView)findViewById(2131297455);
    localGridView.setAdapter(this.b);
    localGridView.setOnItemClickListener(new ThreadListEmptyView.2(this));
  }

  private boolean c()
  {
    return this.f.a(MessagesPrefKeys.w, false);
  }

  public void a()
  {
    this.c.setVisibility(8);
    this.f.b().a(MessagesPrefKeys.w, true).a();
  }

  public void b()
  {
    if ((this.g.size() == 0) || (c()))
      this.c.setVisibility(8);
    while (true)
    {
      this.b.a(this.g);
      this.b.notifyDataSetChanged();
      return;
      this.c.setVisibility(0);
    }
  }

  public void setSuggestedContacts(ImmutableList<User> paramImmutableList)
  {
    this.g = paramImmutableList;
    b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListEmptyView
 * JD-Core Version:    0.6.0
 */