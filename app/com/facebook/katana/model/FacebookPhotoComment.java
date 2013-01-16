package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.ipc.model.FacebookProfile;

public class FacebookPhotoComment
  implements JMStaticKeysDictDestination
{
  private FacebookProfile mFromProfile;

  @JMAutogen.InferredType(jsonFieldName="fromid")
  private long mFromProfileId = -1L;

  @JMAutogen.InferredType(jsonFieldName="post_id")
  private final String mPostId = null;

  @JMAutogen.InferredType(jsonFieldName="text")
  private final String mText = null;

  @JMAutogen.InferredType(jsonFieldName="time")
  private final long mTime = -1L;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookPhotoComment
 * JD-Core Version:    0.6.0
 */