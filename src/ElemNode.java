
public class ElemNode {

    public int ridx;
    public int data;
    public int cidx;
    public ElemNode next;

    public ElemNode getNext() {
        return next;
    }

    public void setNext(ElemNode next) {
        this.next = next;
    }

    public ElemNode(int ridx,int cidx,int data) {
        this.ridx = ridx;
        this.data = data;
        this.cidx = cidx;
    }

    public int getRidx() {
        return ridx;
    }

    public void setRidx(int ridx) {
        this.ridx = ridx;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getCidx() {
        return cidx;
    }

    public void setCidx(int cidx) {
        this.cidx = cidx;
    }
}
