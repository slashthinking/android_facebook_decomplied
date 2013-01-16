package com.facebook.katana.features.tagging;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.facebook.widget.UrlImage;
import com.facebook.widget.tagging.TaggingProfile;
import com.facebook.widget.tagging.TaggingProfile.Type;

public abstract class BaseTagTypeaheadAdapter extends ArrayAdapter<TaggingProfile>
{
  protected BaseTagTypeaheadAdapter.TaggingProfileExclusionFilter a;
  private final Context b;
  private int c = 2130903557;

  public BaseTagTypeaheadAdapter(Context paramContext)
  {
    super(paramContext, 2130903557);
    this.b = paramContext;
  }

  public BaseTagTypeaheadAdapter(Context paramContext, int paramInt)
  {
    this(paramContext);
    this.c = paramInt;
  }

  public BaseTagTypeaheadAdapter a(BaseTagTypeaheadAdapter.TaggingProfileExclusionFilter paramTaggingProfileExclusionFilter)
  {
    this.a = paramTaggingProfileExclusionFilter;
    return this;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(this.c, paramViewGroup, false);
    TaggingProfile localTaggingProfile = (TaggingProfile)getItem(paramInt);
    UrlImage localUrlImage = (UrlImage)paramView.findViewById(2131297162);
    localUrlImage.setPlaceHolderResourceId(2130838447);
    if ((localTaggingProfile.c() != null) && (localTaggingProfile.d() != TaggingProfile.Type.TEXT))
    {
      localUrlImage.setImageParams(Uri.parse(localTaggingProfile.c()));
      localUrlImage.setVisibility(0);
    }
    while (true)
    {
      TextView localTextView1 = (TextView)paramView.findViewById(2131296493);
      localTextView1.setPadding(0, 0, 0, 0);
      String str1 = localTaggingProfile.a();
      if (str1 == null)
        str1 = this.b.getString(2131362934);
      localTextView1.setText(str1);
      TextView localTextView2 = (TextView)paramView.findViewById(2131297844);
      localTextView2.setVisibility(0);
      String str2 = localTaggingProfile.e();
      if (str2 == null)
        str2 = "";
      localTextView2.setText(str2);
      if ("".equals(str2))
      {
        localTextView1.setPadding(0, (int)(12.0F * (this.b.getResources().getDisplayMetrics().ydpi / 160.0F)), 0, 0);
        localTextView2.setVisibility(8);
      }
      return paramView;
      if (localTaggingProfile.d() != TaggingProfile.Type.TEXT)
        continue;
      localUrlImage.setVisibility(4);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.BaseTagTypeaheadAdapter
 * JD-Core Version:    0.6.0
 */