package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.Button;
import com.facebook.content.SecureContextHelper;
import com.facebook.orca.annotations.IsClientSmsEnabled;
import com.facebook.orca.creation.CreateThreadActivity;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomViewGroup;
import javax.inject.Provider;

public class ContactPickerInviteFriendsView extends CustomViewGroup
{
  private final Button a;
  private final Provider<Boolean> b;
  private final SecureContextHelper c;

  public ContactPickerInviteFriendsView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public ContactPickerInviteFriendsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ContactPickerInviteFriendsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    FbInjector localFbInjector = getInjector();
    this.b = localFbInjector.b(Boolean.class, IsClientSmsEnabled.class);
    this.c = ((SecureContextHelper)localFbInjector.a(SecureContextHelper.class));
    setContentView(2130903325);
    this.a = ((Button)getView(2131297225));
    this.a.setOnClickListener(new ContactPickerInviteFriendsView.1(this));
  }

  private Intent getComposerIntent()
  {
    Context localContext = getContext();
    Intent localIntent = new Intent(localContext, CreateThreadActivity.class);
    localIntent.putExtra("show_composer", true);
    localIntent.putExtra("composer_initial_text", localContext.getString(2131362468));
    return localIntent;
  }

  private Intent getSmsIntent()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("sms:"));
    localIntent.setType("vnd.android-dir/mms-sms");
    localIntent.putExtra("sms_body", getContext().getString(2131362468));
    return localIntent;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerInviteFriendsView
 * JD-Core Version:    0.6.0
 */