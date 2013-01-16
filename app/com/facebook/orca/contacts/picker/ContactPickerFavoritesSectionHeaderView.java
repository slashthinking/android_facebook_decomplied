package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.orca.contacts.favorites.EditFavoritesActivity;
import com.facebook.widget.CustomViewGroup;

public class ContactPickerFavoritesSectionHeaderView extends CustomViewGroup
{
  private Context a;
  private final View b;
  private final TextView c;
  private final Button d;

  public ContactPickerFavoritesSectionHeaderView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public ContactPickerFavoritesSectionHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ContactPickerFavoritesSectionHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    setContentView(2130903345);
    this.b = findViewById(2131297229);
    this.c = ((TextView)findViewById(2131297230));
    this.d = ((Button)findViewById(2131297294));
    this.d.setOnClickListener(new ContactPickerFavoritesSectionHeaderView.1(this));
  }

  private void a()
  {
    Intent localIntent = new Intent(this.a, EditFavoritesActivity.class);
    this.a.startActivity(localIntent);
  }

  public void setColorScheme(ContactPickerColorScheme paramContactPickerColorScheme)
  {
    Resources localResources = getResources();
    if (paramContactPickerColorScheme == ContactPickerColorScheme.DEFAULT_SCHEME)
    {
      this.b.setBackgroundDrawable(new ColorDrawable(localResources.getColor(2131165405)));
      this.c.setTextColor(localResources.getColor(2131165406));
      this.d.setTextColor(getResources().getColor(2131165406));
    }
    while (true)
    {
      return;
      if (paramContactPickerColorScheme == ContactPickerColorScheme.DIVEBAR_SCHEME)
      {
        this.b.setBackgroundDrawable(new ColorDrawable(localResources.getColor(2131165410)));
        this.c.setTextColor(localResources.getColor(2131165411));
        this.d.setTextColor(localResources.getColor(2131165411));
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerFavoritesSectionHeaderView
 * JD-Core Version:    0.6.0
 */