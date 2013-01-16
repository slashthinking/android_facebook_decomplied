package com.facebook.katana.service.method;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

public class TaggingGraphGetTaggeeResponse
  implements JMStaticKeysDictDestination
{
  private static final String CATEGORY_KEY = "category";
  private static final String PATH_KEY = "path";
  private static final String PHOTO_KEY = "photo";
  private static final String SUBTEXT_KEY = "subtext";
  private static final String TEXT_KEY = "text";
  private static final String TYPE_KEY = "type";
  private static final String UID_KEY = "uid";

  @JMAutogen.InferredType(jsonFieldName="category")
  private String mCategory = null;

  @JMAutogen.InferredType(jsonFieldName="path")
  private String mPath = null;

  @JMAutogen.InferredType(jsonFieldName="photo")
  private String mPhotoURI = null;

  @JMAutogen.InferredType(jsonFieldName="subtext")
  private String mSubtext = null;

  @JMAutogen.InferredType(jsonFieldName="text")
  private String mText = null;

  @JMAutogen.InferredType(jsonFieldName="type")
  private String mType = null;

  @JMAutogen.InferredType(jsonFieldName="uid")
  private long mUid = -1L;

  public Long a()
  {
    return Long.valueOf(this.mUid);
  }

  public String b()
  {
    return this.mType;
  }

  public String c()
  {
    return this.mText;
  }

  public String d()
  {
    return this.mSubtext;
  }

  public String e()
  {
    return this.mPhotoURI;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.TaggingGraphGetTaggeeResponse
 * JD-Core Version:    0.6.0
 */