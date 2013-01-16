package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.ipc.model.FacebookProfile;
import java.util.Map;

public class FacebookGroup extends FacebookProfile
{

  @JMAutogen.InferredType(jsonFieldName="icon68")
  public final String mIcon68 = null;
  protected int mUnreadCount;

  @JMAutogen.InferredType(jsonFieldName="update_time")
  public final long mUpdateTime = 0L;

  public FacebookGroup()
  {
    super(-1L, null, null, 3);
  }

  protected static void postprocessJMAutogenFields(Map<String, Object> paramMap)
  {
    paramMap.put("gid", paramMap.remove("id"));
    paramMap.remove("pic_square");
    paramMap.remove("type");
    paramMap.remove("can_post");
  }

  public int a()
  {
    return this.mUnreadCount;
  }

  public void a(int paramInt)
  {
    this.mUnreadCount = paramInt;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookGroup
 * JD-Core Version:    0.6.0
 */