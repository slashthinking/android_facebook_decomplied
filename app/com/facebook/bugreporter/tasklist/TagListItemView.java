package com.facebook.bugreporter.tasklist;

import android.content.Context;
import android.widget.CheckBox;
import com.facebook.widget.CustomViewGroup;

public class TagListItemView extends CustomViewGroup
{
  private final CheckBox a;
  private TagListItem b;

  public TagListItemView(Context paramContext)
  {
    super(paramContext);
    setContentView(2130903569);
    this.a = ((CheckBox)getView(2131297821));
    this.a.setOnCheckedChangeListener(new TagListItemView.1(this));
  }

  public void setTagListItem(TagListItem paramTagListItem)
  {
    this.b = paramTagListItem;
    this.a.setText(paramTagListItem.a());
    this.a.setChecked(paramTagListItem.c());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.TagListItemView
 * JD-Core Version:    0.6.0
 */