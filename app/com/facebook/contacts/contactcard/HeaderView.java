package com.facebook.contacts.contactcard;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.contacts.models.ContactPicCropInfoGenerator;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.presence.PresenceState;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.CanonicalThreadPresenceHelper;
import com.facebook.orca.users.CanonicalThreadPresenceHelper.Listener;
import com.facebook.orca.users.Name;
import com.facebook.widget.CustomViewGroup;

public class HeaderView extends CustomViewGroup
{
  private UserTileView a;
  private TextView b;
  private TextView c;
  private CanonicalThreadPresenceHelper d;
  private ContactPicCropInfoGenerator e;
  private ContactSummary f;
  private ThreadSummary g;
  private PresenceState h = PresenceState.a;
  private CanonicalThreadPresenceHelper.Listener i;

  public HeaderView(Context paramContext)
  {
    super(paramContext);
    b();
  }

  public HeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }

  public HeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }

  private void a(PresenceState paramPresenceState)
  {
    if (this.h == paramPresenceState);
    while (true)
    {
      return;
      b(paramPresenceState);
    }
  }

  private void b()
  {
    FbInjector localFbInjector = getInjector();
    this.d = ((CanonicalThreadPresenceHelper)localFbInjector.a(CanonicalThreadPresenceHelper.class));
    this.e = ((ContactPicCropInfoGenerator)localFbInjector.a(ContactPicCropInfoGenerator.class));
    setContentView(2130903115);
    this.a = ((UserTileView)getView(2131296588));
    this.b = ((TextView)getView(2131296593));
    this.c = ((TextView)getView(2131296594));
    this.i = new HeaderView.1(this);
    this.d.a(this.i);
  }

  private void b(PresenceState paramPresenceState)
  {
    this.h = paramPresenceState;
    c();
  }

  private void c()
  {
    if (this.g != null)
    {
      String str = this.d.d();
      if (str != null)
        this.c.setText(str);
    }
  }

  public void a()
  {
    this.a.setParams(null);
    this.b.setText("");
    this.c.setText("");
    this.d.a(false);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.d.a(true);
    b(this.d.c());
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.d.a(false);
  }

  public void setContactSummary(ContactSummary paramContactSummary)
  {
    this.f = paramContactSummary;
    if (this.a.getParams() == null)
      this.a.setParams(UserTileViewParams.a(paramContactSummary, this.e));
    this.b.setText(paramContactSummary.getName().f());
    this.c.setText("");
    c();
  }

  public void setThreadSummary(ThreadSummary paramThreadSummary)
  {
    this.g = paramThreadSummary;
    this.d.a(paramThreadSummary);
    b(this.d.c());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.HeaderView
 * JD-Core Version:    0.6.0
 */