package android_src.mms.dom;

import android_src.mms.dom.events.EventTargetImpl;
import java.util.NoSuchElementException;
import java.util.Vector;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;
import org.w3c.dom.events.EventTarget;

public abstract class NodeImpl
  implements Node, EventTarget
{
  DocumentImpl a;
  private Node b;
  private final Vector<Node> c = new Vector();
  private final EventTarget d = new EventTargetImpl(this);

  protected NodeImpl(DocumentImpl paramDocumentImpl)
  {
    this.a = paramDocumentImpl;
  }

  private void a(Node paramNode)
  {
    this.b = paramNode;
  }

  public Node appendChild(Node paramNode)
  {
    ((NodeImpl)paramNode).a(this);
    this.c.remove(paramNode);
    this.c.add(paramNode);
    return paramNode;
  }

  public Node cloneNode(boolean paramBoolean)
  {
    return null;
  }

  public short compareDocumentPosition(Node paramNode)
  {
    throw new DOMException(9, null);
  }

  public NamedNodeMap getAttributes()
  {
    return null;
  }

  public String getBaseURI()
  {
    return null;
  }

  public NodeList getChildNodes()
  {
    return new NodeListImpl(this, null, false);
  }

  public Object getFeature(String paramString1, String paramString2)
  {
    return null;
  }

  public Node getFirstChild()
  {
    try
    {
      localNode = (EventTarget)this.c.firstElement();
      return localNode;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      while (true)
        Node localNode = null;
    }
  }

  public Node getLastChild()
  {
    try
    {
      localNode = (EventTarget)this.c.lastElement();
      return localNode;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      while (true)
        Node localNode = null;
    }
  }

  public String getLocalName()
  {
    return null;
  }

  public String getNamespaceURI()
  {
    return null;
  }

  public Node getNextSibling()
  {
    Vector localVector;
    if ((this.b != null) && (this != this.b.getLastChild()))
      localVector = ((NodeImpl)this.b).c;
    for (Node localNode = (EventTarget)localVector.elementAt(1 + localVector.indexOf(this)); ; localNode = null)
      return localNode;
  }

  public String getNodeValue()
  {
    return null;
  }

  public Document getOwnerDocument()
  {
    return this.a;
  }

  public Node getParentNode()
  {
    return this.b;
  }

  public String getPrefix()
  {
    return null;
  }

  public Node getPreviousSibling()
  {
    Vector localVector;
    if ((this.b != null) && (this != this.b.getFirstChild()))
      localVector = ((NodeImpl)this.b).c;
    for (Node localNode = (EventTarget)localVector.elementAt(-1 + localVector.indexOf(this)); ; localNode = null)
      return localNode;
  }

  public String getTextContent()
  {
    throw new DOMException(9, null);
  }

  public Object getUserData(String paramString)
  {
    return null;
  }

  public boolean hasAttributes()
  {
    return false;
  }

  public boolean hasChildNodes()
  {
    if (!this.c.isEmpty());
    for (int i = 1; ; i = 0)
      return i;
  }

  public Node insertBefore(Node paramNode1, Node paramNode2)
  {
    return null;
  }

  public boolean isDefaultNamespace(String paramString)
  {
    throw new DOMException(9, null);
  }

  public boolean isEqualNode(Node paramNode)
  {
    throw new DOMException(9, null);
  }

  public boolean isSameNode(Node paramNode)
  {
    throw new DOMException(9, null);
  }

  public boolean isSupported(String paramString1, String paramString2)
  {
    return false;
  }

  public String lookupNamespaceURI(String paramString)
  {
    return null;
  }

  public String lookupPrefix(String paramString)
  {
    return null;
  }

  public void normalize()
  {
  }

  public Node removeChild(Node paramNode)
  {
    if (this.c.contains(paramNode))
    {
      this.c.remove(paramNode);
      ((NodeImpl)paramNode).a(null);
      return null;
    }
    throw new DOMException(8, "Child does not exist");
  }

  public Node replaceChild(Node paramNode1, Node paramNode2)
  {
    if (this.c.contains(paramNode2));
    try
    {
      this.c.remove(paramNode1);
      label20: this.c.setElementAt(paramNode1, this.c.indexOf(paramNode2));
      ((NodeImpl)paramNode1).a(this);
      ((NodeImpl)paramNode2).a(null);
      return paramNode2;
      throw new DOMException(8, "Old child does not exist");
    }
    catch (DOMException localDOMException)
    {
      break label20;
    }
  }

  public void setNodeValue(String paramString)
  {
  }

  public void setPrefix(String paramString)
  {
  }

  public void setTextContent(String paramString)
  {
    throw new DOMException(9, null);
  }

  public Object setUserData(String paramString, Object paramObject, UserDataHandler paramUserDataHandler)
  {
    throw new DOMException(9, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.NodeImpl
 * JD-Core Version:    0.6.0
 */