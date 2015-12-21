package model.network;


public class Element{

    Edge value;
    Element nextElement = null;
    
    public Element(){}
    
    public Element(Element e){
	value = e.getValue();
    }

    public Element(Edge value) {
        this.value = value;
    }

    public Element getNextElement() {
        return nextElement;
    }

    public void setNextElement(Element nextElement) {
        this.nextElement = nextElement;
    }

    public Edge getValue() {
        return value;
    }
}
