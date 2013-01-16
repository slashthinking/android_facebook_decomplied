package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.orca.annotations.ShouldShowInviteAllContacts;
import com.facebook.orca.common.ui.widgets.CustomFilter.FilterListener;
import com.facebook.orca.common.ui.widgets.CustomFilter.FilteringState;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.MessengerPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.widget.BetterListView;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

public class ContactPickerView extends CustomViewGroup
{
  private static final Class<?> b = ContactPickerView.class;
  protected ListView a;
  private IContactPickerViewListAdapter c;
  private CustomFilter.FilterListener d;
  private View e;
  private EmptyListViewItem f;
  private View g;
  private EditText h;
  private ImageView i;
  private View j;
  private ViewGroup k;
  private ViewGroup l;
  private ContactPickerView.OnFilterStateChangedListener m;
  private ContactPickerView.OnRowClickedListener n;
  private ContactPickerView.OnContactListScrollListener o;
  private ContactPickerViewFilterState p = ContactPickerViewFilterState.NONE;
  private Provider<Boolean> q;
  private OrcaSharedPreferences r;
  private View s;

  public ContactPickerView(Context paramContext, IContactPickerViewListAdapter paramIContactPickerViewListAdapter, int paramInt)
  {
    super(paramContext);
    setContentView(paramInt);
    a(paramIContactPickerViewListAdapter);
  }

  private void a()
  {
    ContactPickerListFilter localContactPickerListFilter = this.c.d();
    String str = this.h.getText().toString().trim();
    if (StringUtil.a(str))
    {
      BLog.a(b, "Empty search");
      a(ContactPickerViewFilterState.UNFILTERED);
      i();
      localContactPickerListFilter.a(null);
      b(this.c.getCount());
      a(CustomFilter.FilteringState.FINISHED);
    }
    while (true)
    {
      return;
      BLog.a(b, "Performing filtering");
      a(ContactPickerViewFilterState.FILTERING);
      localContactPickerListFilter.a(str, this.d);
    }
  }

  private void a(int paramInt)
  {
    if (paramInt == 1)
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.h.getWindowToken(), 0);
    if (this.o != null)
      this.o.a(paramInt);
  }

  private void a(CustomFilter.FilteringState paramFilteringState)
  {
    if (paramFilteringState == CustomFilter.FilteringState.FILTERING)
    {
      this.i.setVisibility(4);
      this.j.setVisibility(0);
    }
    while (true)
    {
      return;
      this.i.setVisibility(0);
      this.j.setVisibility(4);
    }
  }

  private void a(IContactPickerViewListAdapter paramIContactPickerViewListAdapter)
  {
    this.c = paramIContactPickerViewListAdapter;
    this.a = ((ListView)getView(2131297237));
    this.f = ((EmptyListViewItem)getView(2131297238));
    this.g = getView(2131297239);
    this.h = ((EditText)getView(2131297235));
    this.k = ((ViewGroup)getView(2131297232));
    this.e = getView(2131297231);
    this.i = ((ImageView)getView(2131297233));
    this.j = getView(2131297234);
    this.l = ((ViewGroup)getView(2131297240));
    this.s = null;
    FbInjector localFbInjector = getInjector();
    this.q = localFbInjector.b(Boolean.class, ShouldShowInviteAllContacts.class);
    this.r = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.a.setDividerHeight(0);
    this.a.setAdapter(paramIContactPickerViewListAdapter);
    if ((this.a instanceof BetterListView))
      ((BetterListView)this.a).setBroadcastInteractionChanges(true);
    this.a.setOnScrollListener(new ContactPickerView.1(this));
    this.a.setOnItemClickListener(new ContactPickerView.2(this));
    this.h.setOnFocusChangeListener(new ContactPickerView.3(this));
    this.h.addTextChangedListener(new ContactPickerView.4(this));
    this.g.setOnTouchListener(new ContactPickerView.5(this));
    e();
    this.d = new ContactPickerView.6(this);
    this.i.setOnClickListener(new ContactPickerView.7(this));
  }

  private boolean a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.h.setText("");
      this.e.requestFocusFromTouch();
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.h.getWindowToken(), 0);
    }
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private void b(int paramInt)
  {
    BLog.a(b, "Filtering complete");
    if (StringUtil.a(this.h.getText().toString().trim()))
    {
      this.f.setVisibility(8);
      a(ContactPickerViewFilterState.UNFILTERED);
    }
    while (true)
    {
      i();
      return;
      if (paramInt == 0)
      {
        this.f.setVisibility(0);
        a(ContactPickerViewFilterState.FILTERED);
        continue;
      }
      this.f.setVisibility(8);
      a(ContactPickerViewFilterState.FILTERED);
    }
  }

  private void c(int paramInt)
  {
    ContactPickerRow localContactPickerRow = (ContactPickerRow)this.c.getItem(paramInt);
    if (this.n != null)
      this.n.a(localContactPickerRow);
  }

  private void i()
  {
    int i1;
    if (!this.h.hasFocus())
    {
      i1 = 0;
      if (i1 == 0)
        break label68;
      this.a.setEnabled(false);
      this.g.setVisibility(0);
    }
    while (true)
    {
      return;
      if (this.p == ContactPickerViewFilterState.FILTERING)
      {
        i1 = 1;
        break;
      }
      if (this.p == ContactPickerViewFilterState.FILTERED)
      {
        i1 = 0;
        break;
      }
      i1 = 1;
      break;
      label68: this.a.setEnabled(true);
      this.g.setVisibility(8);
    }
  }

  public void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, int paramInt)
  {
    if (!((Boolean)this.q.b()).booleanValue());
    while (true)
    {
      return;
      if (this.l.getChildCount() == 0)
      {
        if (this.s == null)
          this.s = LayoutInflater.from(getContext()).inflate(2130903338, null);
        this.l.addView(this.s);
      }
      Button localButton1 = (Button)getView(2131297265);
      Button localButton2 = (Button)getView(2131297264);
      localButton1.setOnClickListener(paramOnClickListener1);
      localButton2.setOnClickListener(paramOnClickListener2);
      TextView localTextView1 = (TextView)getView(2131297261);
      TextView localTextView2 = (TextView)getView(2131297262);
      if ((this.r.a(MessengerPrefKeys.C, 0) == 0) && (paramInt > 0))
      {
        if (paramInt == 1)
          localTextView1.setText(2131362739);
        while (true)
        {
          localTextView2.setText(2131362740);
          localButton1.setText(2131362741);
          break;
          Context localContext = getContext();
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(paramInt);
          localTextView1.setText(localContext.getString(2131362738, arrayOfObject));
        }
      }
      localTextView1.setText(2131362742);
      localTextView2.setText(2131362743);
      localButton1.setText(2131362744);
    }
  }

  protected void a(ContactPickerViewFilterState paramContactPickerViewFilterState)
  {
    this.p = paramContactPickerViewFilterState;
    if (this.m != null)
      this.m.a(paramContactPickerViewFilterState);
  }

  public void a(ImmutableList<ContactPickerRow> paramImmutableList)
  {
    this.c.a(paramImmutableList);
    this.f.a(false);
    this.f.setVisibility(8);
    this.f.setMessage(2131362516);
    if (this.p != ContactPickerViewFilterState.NONE)
      a();
  }

  protected void a(boolean paramBoolean)
  {
    int i1 = 1;
    Class localClass = b;
    Object[] arrayOfObject = new Object[i1];
    if (paramBoolean)
    {
      arrayOfObject[0] = Integer.valueOf(i1);
      BLog.a(localClass, "Search box focus changed: %d", arrayOfObject);
      if (paramBoolean)
        break label63;
      a(ContactPickerViewFilterState.NONE);
      this.c.e();
    }
    while (true)
    {
      i();
      return;
      i1 = 0;
      break;
      label63: if (this.p != ContactPickerViewFilterState.NONE)
        continue;
      a(ContactPickerViewFilterState.UNFILTERED);
    }
  }

  public void b()
  {
    this.a.setEnabled(true);
    this.a.requestFocus();
    this.g.setVisibility(8);
  }

  public void c()
  {
    TextView localTextView1 = (TextView)getView(2131297261);
    TextView localTextView2 = (TextView)getView(2131297262);
    ViewGroup localViewGroup = (ViewGroup)getView(2131297263);
    localTextView1.setText(2131362745);
    localTextView2.setVisibility(4);
    localViewGroup.setVisibility(4);
    ContactPickerView.8 local8 = new ContactPickerView.8(this);
    new Handler().postDelayed(local8, 2000L);
  }

  public void d()
  {
    int i1 = this.l.getMeasuredHeight();
    this.l.removeAllViews();
    View localView = getView(2131297237);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, i1, 0.0F);
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localView.startAnimation(localTranslateAnimation);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    if (bool);
    while (true)
    {
      return bool;
      if ((paramKeyEvent.getKeyCode() == 4) && (this.h.hasFocus()))
      {
        this.h.setText("");
        this.e.requestFocusFromTouch();
        bool = true;
        continue;
      }
      bool = false;
    }
  }

  public void e()
  {
    this.f.a(true);
    this.f.setMessage(2131362517);
    this.f.setVisibility(0);
  }

  public boolean f()
  {
    if ((ContactPickerViewFilterState.FILTERED == this.p) || (ContactPickerViewFilterState.FILTERING == this.p));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void g()
  {
    this.h.requestFocus();
    this.h.setSelection(this.h.getText().length());
  }

  public Point getListViewDimensions()
  {
    return new Point(this.a.getWidth(), this.a.getHeight());
  }

  public String getSearchBoxText()
  {
    return this.h.getText().toString();
  }

  public void h()
  {
    setSearchBoxText("");
    this.e.requestFocusFromTouch();
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.h.getWindowToken(), 0);
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    int i1 = getResources().getDimensionPixelSize(2131230821);
    ViewGroup.LayoutParams localLayoutParams = this.k.getLayoutParams();
    localLayoutParams.height = i1;
    this.k.setLayoutParams(localLayoutParams);
  }

  public void setOnContactListScrollListener(ContactPickerView.OnContactListScrollListener paramOnContactListScrollListener)
  {
    this.o = paramOnContactListScrollListener;
  }

  public void setOnFilterStateChangedListener(ContactPickerView.OnFilterStateChangedListener paramOnFilterStateChangedListener)
  {
    this.m = paramOnFilterStateChangedListener;
  }

  public void setOnRowClickedListener(ContactPickerView.OnRowClickedListener paramOnRowClickedListener)
  {
    this.n = paramOnRowClickedListener;
  }

  public void setSearchBoxText(String paramString)
  {
    this.h.setText(paramString);
  }

  public void setSearchHint(String paramString)
  {
    this.h.setHint(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerView
 * JD-Core Version:    0.6.0
 */