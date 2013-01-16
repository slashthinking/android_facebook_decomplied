package com.facebook.contacts.contactslist;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.contacts.models.ContactPicCropInfoGenerator;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.users.Name;
import com.facebook.widget.CustomViewGroup;

public class ContactRowView extends CustomViewGroup
{
  private final TextView a;
  private final TextView b;
  private final UserTileView c;
  private final ImageView d;
  private ContactPicCropInfoGenerator e;
  private ContactSummary f;

  public ContactRowView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ContactRowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ContactRowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903119);
    this.a = ((TextView)getView(2131296593));
    this.b = ((TextView)getView(2131296603));
    this.c = ((UserTileView)getView(2131296588));
    this.d = ((ImageView)getView(2131296602));
    this.e = ((ContactPicCropInfoGenerator)getInjector().a(ContactPicCropInfoGenerator.class));
  }

  public void setContactSummary(ContactSummary paramContactSummary)
  {
    this.f = paramContactSummary;
    this.a.setText(paramContactSummary.getName().getDisplayName());
    this.c.setParams(UserTileViewParams.a(this.f, this.e));
    this.b.setVisibility(8);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactslist.ContactRowView
 * JD-Core Version:    0.6.0
 */