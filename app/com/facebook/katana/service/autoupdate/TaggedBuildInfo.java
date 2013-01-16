package com.facebook.katana.service.autoupdate;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

public class TaggedBuildInfo
  implements JMStaticKeysDictDestination
{

  @JMAutogen.InferredType(jsonFieldName="build_alias")
  public String mBuildAlias = null;

  @JMAutogen.InferredType(jsonFieldName="min_version")
  public int mMinVersion = -1;

  @JMAutogen.InferredType(jsonFieldName="new_version")
  public int mNewVersion = -1;

  @JMAutogen.InferredType(jsonFieldName="new_version_url")
  public String mNewVersionUrl = null;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.autoupdate.TaggedBuildInfo
 * JD-Core Version:    0.6.0
 */