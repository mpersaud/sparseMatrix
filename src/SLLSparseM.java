

public class SLLSparseM implements SparseM {

	int rows;
    int cols;
    int num_elem=0;
    RowElemNode head;//first row


    public SLLSparseM(int nr, int nc) {
        rows=nr;
        cols=nc;
    }

    public boolean isEmpty(){
        return num_elem==0;
    }

    private boolean outOfBounds(int ridx, int cidx){
        return((ridx < 0) || (ridx >= rows) || (cidx < 0 || (cidx >= cols)));
    }

    @Override
	public int nrows() {
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int ncols() {
		// TODO Auto-generated method stub
		return cols;
	}

	@Override
	public int numElements() {
		// TODO Auto-generated method stub
		return num_elem;
	}

	@Override
	public int getElement(int ridx, int cidx) {
		// TODO Auto-generated method stub
        if(isEmpty()||outOfBounds(ridx,cidx)) return -1;

        RowElemNode row = head;
        ElemNode e;

        while(row!=null){
            e= row.getFirst();

            while(e!=null){

                if(e.getRidx()==ridx && e.getCidx()==cidx)return e.getData();
                e = e.getNext();

            }
            row=row.getNextRow();
        }
		return 0;
	}

	@Override
	public void clearElement(int ridx, int cidx) {
		// TODO Auto-generated method stub

        if(isEmpty())return;



	}

	@Override
	public void setElement(int ridx, int cidx, int val) {
		// TODO Auto-generated method stub

        if(outOfBounds(ridx,cidx))return;
        RowElemNode r= new RowElemNode(ridx);
        //if head is null
        if(head==null){
            r.addElement(ridx,cidx,val);
            r.setNextRow(null);
            head=r;
            num_elem++;

        }

        // if row is smaller than head
        if(ridx <head.getRidx()){
            r.setNextRow(head);
            r.addElement(ridx,cidx,val);
            head=r;
            num_elem++;
        }

        //else case
        else{

            RowElemNode t= head;

            while(t!=null){

                //if row exists
                if(ridx == t.getRidx()){
                    int before = t.getNumElems();
                    t.addElement(ridx,cidx,val);
                    int after = t.getNumElems();
                    if(before!=after)num_elem++;
                    break;
                }

                //end of list

                if(t.getNextRow()==null){
                    t.setNextRow(r);
                    r.setNextRow(null);
                    r.addElement(ridx, cidx, val);
                    num_elem++;
                    break;
                }

                //inbetween two rows

                if(t.getNextRow().getRidx() > ridx){
                    r.setNextRow(t.getNextRow());
                    t.setNextRow(r);
                    r.addElement(ridx, cidx, val);
                    num_elem++;
                    break;
                }

                //default
                t=t.getNextRow();
            }

        }



	}

	@Override
	public void getAllElements(int[] ridx, int[] cidx, int[] val) {
		// TODO Auto-generated method stub

        if(isEmpty())return;

        int counter =0;
        RowElemNode row = head;
        ElemNode e;

        while(row!=null){
            e= row.getFirst();

            while(e!=null){

                ridx[counter]=e.getRidx();
                cidx[counter]=e.getCidx();
                val[counter]=e.getData();
                counter++;
                e = e.getNext();

            }
            row=row.getNextRow();
        }

	}

	@Override
	public void addition(SparseM otherM) {
		// TODO Auto-generated method stub

	}

}
