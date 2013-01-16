package com.facebook.katana.activity.findfriends;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.facebook.katana.activity.profilelist.ProfileListActivity.ProfileListAdapter;
import com.facebook.katana.model.FacebookPhonebookContact;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class BaseAdapter extends ProfileListActivity.ProfileListAdapter
{
  protected List<? extends FacebookPhonebookContact> a;
  protected final Context b;
  protected List<BaseAdapter.FirstLetterFriendSection> c;
  protected final LayoutInflater d;
  protected final Set<Long> e;
  protected boolean f;
  protected AsyncTask<List<? extends FacebookPhonebookContact>, Void, List<? extends FacebookPhonebookContact>> g;

  protected BaseAdapter(Context paramContext)
  {
    this.b = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.c = new ArrayList();
    this.e = new HashSet();
    this.i = new ArrayList();
    this.f = true;
  }

  private String a(String paramString)
  {
    int i = paramString.indexOf('@');
    if (i > 0)
      paramString = paramString.substring(0, i);
    return paramString;
  }

  public int a(int paramInt)
  {
    return 0;
  }

  protected abstract long a(FacebookPhonebookContact paramFacebookPhonebookContact);

  protected Spanned a(FacebookPhonebookContact paramFacebookPhonebookContact, int paramInt, View paramView)
  {
    return a(b(paramFacebookPhonebookContact), h(), this.e.contains(Long.valueOf(a(paramFacebookPhonebookContact))), paramInt, paramView);
  }

  protected Spanned a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, View paramView)
  {
    SpannableString localSpannableString1;
    SpannableString localSpannableString2;
    if (paramBoolean)
    {
      localSpannableString1 = new SpannableString(paramString2 + " ");
      localSpannableString2 = new SpannableString(this.b.getString(2131363240));
      localSpannableString2.setSpan(new BaseAdapter.2(this, paramInt, paramView), 0, localSpannableString2.length(), 33);
    }
    for (Object localObject = (Spanned)TextUtils.concat(new CharSequence[] { localSpannableString1, localSpannableString2 }); ; localObject = new SpannableString(paramString1))
      return localObject;
  }

  protected View.OnClickListener a(int paramInt, View paramView)
  {
    return new BaseAdapter.1(this, paramInt, paramView);
  }

  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    FacebookPhonebookContact localFacebookPhonebookContact = (FacebookPhonebookContact)a(paramInt1, paramInt2);
    if (paramView == null)
      paramView = this.d.inflate(2130903519, null);
    for (boolean bool = true; ; bool = false)
    {
      a(paramView, localFacebookPhonebookContact, bool);
      int i = d(paramInt1, paramInt2);
      ((TextView)paramView.findViewById(2131297752)).setText(a(localFacebookPhonebookContact.name));
      TextView localTextView = (TextView)paramView.findViewById(2131297753);
      localTextView.setText(a(localFacebookPhonebookContact, i, paramView), TextView.BufferType.SPANNABLE);
      localTextView.setMovementMethod(LinkMovementMethod.getInstance());
      Button localButton = (Button)paramView.findViewById(2131297754);
      localButton.setText(e());
      localButton.setOnClickListener(a(i, paramView));
      if (this.f)
        if (this.e.contains(Long.valueOf(a(localFacebookPhonebookContact))))
          localButton.setVisibility(8);
      while (true)
      {
        localButton.setEnabled(this.f);
        return paramView;
        localButton.setVisibility(0);
        continue;
        localButton.setVisibility(0);
      }
    }
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null);
    for (View localView = this.d.inflate(2130903239, null); ; localView = paramView)
    {
      ((TextView)localView).setText(((BaseAdapter.FirstLetterFriendSection)this.c.get(paramInt)).toString());
      return localView;
    }
  }

  public Object a(int paramInt1, int paramInt2)
  {
    return this.a.get(d(paramInt1, paramInt2));
  }

  protected abstract void a(View paramView, FacebookPhonebookContact paramFacebookPhonebookContact, boolean paramBoolean);

  public void a(List<? extends FacebookPhonebookContact> paramList)
  {
    this.g = new BaseAdapter.SortAndRefreshTask(this, null);
    this.g.execute(new List[] { paramList });
  }

  public void a(boolean paramBoolean)
  {
    this.e.clear();
    this.f = paramBoolean;
    j();
  }

  public int b(int paramInt)
  {
    return ((BaseAdapter.FirstLetterFriendSection)this.c.get(paramInt)).b();
  }

  public int b(int paramInt1, int paramInt2)
  {
    return 1;
  }

  protected String b(FacebookPhonebookContact paramFacebookPhonebookContact)
  {
    return paramFacebookPhonebookContact.a();
  }

  public void b(int paramInt, View paramView)
  {
    FacebookPhonebookContact localFacebookPhonebookContact = (FacebookPhonebookContact)this.a.get(paramInt);
    long l = a(localFacebookPhonebookContact);
    if (this.e.contains(Long.valueOf(l)))
    {
      this.e.remove(Long.valueOf(l));
      ((TextView)paramView.findViewById(2131297753)).setText(a(localFacebookPhonebookContact, paramInt, paramView));
      ((Button)paramView.findViewById(2131297754)).setVisibility(0);
    }
    while (true)
    {
      return;
      this.e.add(Long.valueOf(l));
      ((TextView)paramView.findViewById(2131297753)).setText(a(localFacebookPhonebookContact, paramInt, paramView));
      ((Button)paramView.findViewById(2131297754)).setVisibility(8);
    }
  }

  public int c()
  {
    return 2;
  }

  public Object c(int paramInt)
  {
    return this.c.get(paramInt);
  }

  public boolean c(int paramInt1, int paramInt2)
  {
    return true;
  }

  public int d(int paramInt1, int paramInt2)
  {
    return paramInt2 + ((BaseAdapter.FirstLetterFriendSection)c(paramInt1)).a();
  }

  public boolean d()
  {
    if (this.a.size() == 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public int d_()
  {
    return this.c.size();
  }

  protected abstract String e();

  public ArrayList<Long> f()
  {
    return new ArrayList(this.e);
  }

  public ArrayList<Long> g()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      localArrayList.add(new Long(a((FacebookPhonebookContact)localIterator.next())));
    return localArrayList;
  }

  protected abstract String h();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.BaseAdapter
 * JD-Core Version:    0.6.0
 */