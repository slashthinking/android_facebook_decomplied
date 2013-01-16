package com.facebook.orca.nux;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.orca.contacts.upload.ContactsUploadState;
import com.facebook.orca.debug.BLog;
import com.google.common.base.Preconditions;

public class NuxFindingContactsView extends NuxPopover
{
  private static final Class<?> d = NuxFindingContactsView.class;
  private ContactsUploadState e;
  private LinearLayout f;
  private ProgressBar g;
  private TextView h;
  private TextView i;

  public NuxFindingContactsView(Context paramContext)
  {
    super(paramContext);
  }

  public NuxFindingContactsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NuxFindingContactsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void b()
  {
    this.h.setText(2131362403);
    this.i.setText(2131362407);
    this.g.setVisibility(0);
    this.g.setIndeterminate(true);
  }

  private int getNumMatched()
  {
    if (this.e == null);
    for (int j = 0; ; j = this.e.c())
      return j;
  }

  private void j()
  {
    this.h.setText(2131362403);
    l();
  }

  private void k()
  {
    int j = getNumMatched();
    if (j == 0)
      this.h.setText(2131362404);
    while (true)
    {
      this.i.setText(2131362407);
      this.g.setVisibility(8);
      return;
      if (j == 1)
      {
        this.h.setText(2131362405);
        continue;
      }
      TextView localTextView = this.h;
      Context localContext = getContext();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(j);
      localTextView.setText(localContext.getString(2131362406, arrayOfObject));
    }
  }

  private void l()
  {
    if (!e());
    while (true)
    {
      return;
      this.g.setVisibility(0);
      int j = getNumMatched();
      if (j == 0)
      {
        this.i.setText(2131362407);
        this.g.setIndeterminate(true);
        continue;
      }
      this.g.setIndeterminate(false);
      this.g.setProgress(this.e.b());
      this.g.setMax(this.e.d());
      if (j == 1)
      {
        this.i.setText(2131362408);
        continue;
      }
      TextView localTextView = this.i;
      Context localContext = getContext();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(j);
      localTextView.setText(localContext.getString(2131362409, arrayOfObject));
    }
  }

  protected void a()
  {
    setContentView(2130903380);
    this.f = ((LinearLayout)getView(2131297368));
    this.g = ((ProgressBar)getView(2131297371));
    this.h = ((TextView)getView(2131297369));
    this.i = ((TextView)getView(2131297370));
    this.h.setText(2131362403);
    l();
  }

  public void setContentOnClickListener(View.OnClickListener paramOnClickListener)
  {
    d();
    this.f.setOnClickListener(paramOnClickListener);
  }

  public void setState(ContactsUploadState paramContactsUploadState)
  {
    BLog.b(d, "State: " + this.e + " -> " + paramContactsUploadState);
    Preconditions.checkNotNull(paramContactsUploadState);
    this.e = paramContactsUploadState;
    if (!e());
    while (true)
    {
      return;
      switch (NuxFindingContactsView.1.a[this.e.a().ordinal()])
      {
      case 1:
      default:
        break;
      case 2:
        b();
        break;
      case 3:
        j();
        break;
      case 4:
        k();
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.NuxFindingContactsView
 * JD-Core Version:    0.6.0
 */