package com.facebook.katana.features.faceweb;

import com.facebook.common.json.jsonmirror.JMAutogen.DynamicKeyDictType;
import com.facebook.common.json.jsonmirror.JMAutogen.ListType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

class FacewebComponentsStore$Skeleton
  implements JMStaticKeysDictDestination, Serializable
{
  private static final long serialVersionUID = 468570040805259928L;

  @JMAutogen.DynamicKeyDictType(a=true, jsonFieldName="components", valueElementType=FacewebComponentsStore.FacewebSkeletonPalCall.class)
  private Map<String, Object> mComponents;

  @JMAutogen.ListType(b={FacewebComponentsStore.FacewebComponentsRule.class}, jsonFieldName="rules")
  private List<FacewebComponentsStore.FacewebComponentsRule> mRules;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.faceweb.FacewebComponentsStore.Skeleton
 * JD-Core Version:    0.6.0
 */