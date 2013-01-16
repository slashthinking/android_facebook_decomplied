package android_src.mms.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

public class ElementImpl extends NodeImpl
  implements Element
{
  private String b;
  private NamedNodeMap c = new NamedNodeMapImpl();

  protected ElementImpl(DocumentImpl paramDocumentImpl, String paramString)
  {
    super(paramDocumentImpl);
    this.b = paramString;
  }

  public String getAttribute(String paramString)
  {
    Attr localAttr = getAttributeNode(paramString);
    String str = "";
    if (localAttr != null)
      str = localAttr.getValue();
    return str;
  }

  public String getAttributeNS(String paramString1, String paramString2)
  {
    return null;
  }

  public Attr getAttributeNode(String paramString)
  {
    return (Attr)this.c.getNamedItem(paramString);
  }

  public Attr getAttributeNodeNS(String paramString1, String paramString2)
  {
    return null;
  }

  public NamedNodeMap getAttributes()
  {
    return this.c;
  }

  public NodeList getElementsByTagName(String paramString)
  {
    return new NodeListImpl(this, paramString, true);
  }

  public NodeList getElementsByTagNameNS(String paramString1, String paramString2)
  {
    return null;
  }

  public String getNodeName()
  {
    return this.b;
  }

  public short getNodeType()
  {
    return 1;
  }

  public TypeInfo getSchemaTypeInfo()
  {
    return null;
  }

  public String getTagName()
  {
    return this.b;
  }

  public boolean hasAttribute(String paramString)
  {
    if (getAttributeNode(paramString) != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean hasAttributeNS(String paramString1, String paramString2)
  {
    return false;
  }

  public boolean hasAttributes()
  {
    if (this.c.getLength() > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void removeAttribute(String paramString)
  {
  }

  public void removeAttributeNS(String paramString1, String paramString2)
  {
  }

  public Attr removeAttributeNode(Attr paramAttr)
  {
    return null;
  }

  public void setAttribute(String paramString1, String paramString2)
  {
    Attr localAttr = getAttributeNode(paramString1);
    if (localAttr == null)
      localAttr = this.a.createAttribute(paramString1);
    localAttr.setNodeValue(paramString2);
    this.c.setNamedItem(localAttr);
  }

  public void setAttributeNS(String paramString1, String paramString2, String paramString3)
  {
  }

  public Attr setAttributeNode(Attr paramAttr)
  {
    return null;
  }

  public Attr setAttributeNodeNS(Attr paramAttr)
  {
    return null;
  }

  public void setIdAttribute(String paramString, boolean paramBoolean)
  {
    throw new DOMException(9, null);
  }

  public void setIdAttributeNS(String paramString1, String paramString2, boolean paramBoolean)
  {
    throw new DOMException(9, null);
  }

  public void setIdAttributeNode(Attr paramAttr, boolean paramBoolean)
  {
    throw new DOMException(9, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.ElementImpl
 * JD-Core Version:    0.6.0
 */