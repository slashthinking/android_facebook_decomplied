package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.presence.PresenceIndicatorView;
import com.facebook.orca.presence.PresenceIndicatorView.PresenceType;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserIdentifier;
import com.facebook.orca.users.UserWithIdentifier;
import com.facebook.widget.CustomViewGroup;

public class ContactPickerListItem extends CustomViewGroup
{
  private static final Class<?> a = ContactPickerListItem.class;
  private TextView b;
  private TextView c;
  private UserTileView d;
  private PresenceIndicatorView e;
  private View f;
  private ContactPickerUserRow g;

  public ContactPickerListItem(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public ContactPickerListItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public ContactPickerListItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a()
  {
    User localUser = this.g.b();
    this.b.setText(localUser.f());
    this.d.setParams(UserTileViewParams.a(localUser));
    if (this.g.c() == ContactPickerUserRow.RowStyle.TWO_LINE)
    {
      this.c.setVisibility(0);
      this.e.setShowIcon(this.g.g());
      if (localUser.a() != User.Type.FACEBOOK)
        break label276;
      if (!this.g.d())
        break label117;
      this.e.setStatus(PresenceIndicatorView.PresenceType.ONLINE);
      this.c.setText(2131362692);
    }
    while (true)
    {
      return;
      this.c.setVisibility(8);
      break;
      label117: if (this.g.e())
      {
        if (this.g.c() == ContactPickerUserRow.RowStyle.ONE_LINE)
        {
          this.e.setStatus(PresenceIndicatorView.PresenceType.PUSHABLE, this.g.f());
          continue;
        }
        this.e.setStatus(PresenceIndicatorView.PresenceType.PUSHABLE);
        if (!StringUtil.a(this.g.f()))
        {
          this.c.setText(this.g.f());
          continue;
        }
        this.c.setText(2131362699);
        continue;
      }
      this.e.setStatus(PresenceIndicatorView.PresenceType.NONE);
      if (localUser.A() != null)
      {
        this.c.setText(localUser.A());
        continue;
      }
      if (localUser.z() != null)
      {
        this.c.setText(localUser.z());
        continue;
      }
      this.c.setVisibility(8);
      continue;
      label276: if (localUser.a() == User.Type.ADDRESS_BOOK)
      {
        this.e.setStatus(PresenceIndicatorView.PresenceType.NONE);
        UserIdentifier localUserIdentifier = this.g.a().b();
        this.c.setText(localUserIdentifier.a(getResources()));
        continue;
      }
      this.e.setStatus(PresenceIndicatorView.PresenceType.NONE);
      this.c.setVisibility(8);
    }
  }

  private void a(Context paramContext)
  {
    setContentView(2130903327);
    this.b = ((TextView)getView(2131296593));
    this.c = ((TextView)getView(2131296603));
    this.d = ((UserTileView)getView(2131296588));
    this.e = ((PresenceIndicatorView)getView(2131297228));
    this.f = getView(2131296598);
  }

  public ContactPickerUserRow getContactRow()
  {
    return this.g;
  }

  public void setColorScheme(ContactPickerColorScheme paramContactPickerColorScheme)
  {
    if (paramContactPickerColorScheme == ContactPickerColorScheme.DEFAULT_SCHEME);
    while (true)
    {
      return;
      if (paramContactPickerColorScheme == ContactPickerColorScheme.DIVEBAR_SCHEME)
      {
        Resources localResources = getResources();
        setBackgroundDrawable(localResources.getDrawable(2130837735));
        this.f.setBackgroundDrawable(new ColorDrawable(localResources.getColor(2131165416)));
        this.b.setTextColor(localResources.getColor(2131165414));
        this.c.setTextColor(localResources.getColor(2131165415));
        this.e.setTextColor(localResources.getColor(2131165415));
        continue;
      }
    }
  }

  public void setContactRow(ContactPickerUserRow paramContactPickerUserRow)
  {
    this.g = paramContactPickerUserRow;
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerListItem
 * JD-Core Version:    0.6.0
 */