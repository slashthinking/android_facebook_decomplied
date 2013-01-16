package com.facebook.katana.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import com.facebook.katana.activity.media.UserHolder;

public class TagUsersAutoCompleteTextView extends AutoCompleteTextView
{
  public TagUsersAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected CharSequence convertSelectionToString(Object paramObject)
  {
    return ((UserHolder)paramObject).b();
  }

  public boolean enoughToFilter()
  {
    return true;
  }

  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (paramBoolean)
      performFiltering(getText(), 0);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 66)
      if (getAdapter().getCount() == 1)
      {
        getOnItemClickListener().onItemClick(null, null, 0, -1L);
        setText("");
      }
    for (boolean bool = true; ; bool = super.onKeyDown(paramInt, paramKeyEvent))
      return bool;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.TagUsersAutoCompleteTextView
 * JD-Core Version:    0.6.0
 */