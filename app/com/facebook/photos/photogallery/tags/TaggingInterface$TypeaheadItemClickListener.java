package com.facebook.photos.photogallery.tags;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import com.facebook.widget.tagging.TaggingProfile;

class TaggingInterface$TypeaheadItemClickListener
  implements AdapterView.OnItemClickListener
{
  private TaggingInterface$TypeaheadItemClickListener(TaggingInterface paramTaggingInterface)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    TaggingProfile localTaggingProfile = (TaggingProfile)TaggingInterface.b(this.a).getAdapter().getItem(paramInt);
    Tag localTag = new Tag(TaggingInterface.d(this.a).a(TaggingInterface.c(this.a)), localTaggingProfile.a(), localTaggingProfile.b());
    TaggingInterface.e(this.a).a(localTag);
    this.a.a(false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.tags.TaggingInterface.TypeaheadItemClickListener
 * JD-Core Version:    0.6.0
 */