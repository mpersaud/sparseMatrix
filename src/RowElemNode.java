
public class RowElemNode {

    public int ridx;
    public int numElems;
    public RowElemNode nextRow;
    public ElemNode first;

    public RowElemNode(int ridx) {
        this.ridx = ridx;
        this.numElems = 0;
        this.first = null;
    }
    //row is empty
    public boolean isEmpty(){
        return numElems==0;
    }


    public int getRidx() {
        return ridx;
    }

    public void setRidx(int ridx) {
        this.ridx = ridx;
    }

    public int getNumElems() {
        return numElems;
    }

    public void setNumElems(int numElems) {
        this.numElems = numElems;
    }

    public RowElemNode getNextRow() {
        return nextRow;
    }

    public void setNextRow(RowElemNode nextRow) {
        this.nextRow = nextRow;
    }

    public ElemNode getFirst() {
        return first;
    }

    public void setFirst(ElemNode first) {
        this.first = first;
    }

    public void addElement(int r, int c, int d){
        ElemNode e = new ElemNode(r,c,d);
        if(first==null){
            e.setNext(null);
            first=e;
            numElems++;
        }
        if(c<first.getCidx()){
            e.setNext(first);
            first=e;
            numElems++;
        }
        //else
        else{
            ElemNode t = first;

            while(t!=null){
                //if it exists already
                if(c == t.getCidx()){
                    t.setData(d);
                    break;
                }


                //at the end of the list
                else if(t.getNext()==null){
                    t.setNext(e);
                    e.setNext(null);
                    numElems++;
                    break;
                }
                //or if next col is greater than
                else if(t.getNext().getCidx()>c){
                    e.setNext(t.getNext());
                    t.setNext(e);
                    numElems++;
                    break;
                }
                //default is to move to next element
                t=t.getNext();
            }
        }

    }


}
