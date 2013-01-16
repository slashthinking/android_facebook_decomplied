package com.facebook.orca.contacts.picker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.support.v4.content.LocalBroadcastManager;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.orca.contacts.upload.ContactsUploadRunner;
import com.facebook.orca.contacts.upload.ContactsUploadState;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomViewGroup;

public class ContactPickerProgressView extends CustomViewGroup
{
  private final ContactsUploadRunner a;
  private final LocalBroadcastManager b;
  private final BroadcastReceiver c;
  private final TextView d;
  private final ProgressBar e;

  public ContactPickerProgressView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public ContactPickerProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ContactPickerProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903324);
    FbInjector localFbInjector = getInjector();
    this.a = ((ContactsUploadRunner)localFbInjector.a(ContactsUploadRunner.class));
    this.b = ((LocalBroadcastManager)localFbInjector.a(LocalBroadcastManager.class));
    this.c = new ContactPickerProgressView.1(this);
    this.d = ((TextView)findViewById(2131297223));
    this.d.setVisibility(8);
    this.e = ((ProgressBar)findViewById(2131297224));
  }

  private void a(ContactsUploadState paramContactsUploadState)
  {
    int i = paramContactsUploadState.b();
    int j = paramContactsUploadState.c();
    int k = paramContactsUploadState.d();
    if (i <= 0)
    {
      this.e.setIndeterminate(true);
      this.d.setVisibility(8);
    }
    while (true)
    {
      return;
      Resources localResources = getResources();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(j);
      arrayOfObject[1] = Integer.valueOf(k);
      String str = localResources.getString(2131362411, arrayOfObject);
      this.d.setText(str);
      this.d.setVisibility(0);
      this.e.setIndeterminate(false);
      this.e.setProgress(i);
      this.e.setMax(k);
    }
  }

  protected void onAttachedToWindow()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED");
    this.b.a(this.c, localIntentFilter);
    a(this.a.c());
  }

  protected void onDetachedFromWindow()
  {
    this.b.a(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerProgressView
 * JD-Core Version:    0.6.0
 */