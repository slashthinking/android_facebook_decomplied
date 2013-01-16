package com.facebook.common.json.jsonmirror;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface JMStaticKeysDictDestination$Encoder$SerializableJsonObject
{
  public abstract String jsonFieldName();

  public abstract Class<? extends JMStaticKeysDictDestination> type();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination.Encoder.SerializableJsonObject
 * JD-Core Version:    0.6.0
 */