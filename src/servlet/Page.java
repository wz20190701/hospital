package servlet;

//��ҳ����
public class Page {
	int start;
	int count;
	int total;
	String param;
	public int getStart(){
		return start;
	}
	public void setStart(){
		this.start=start;
	}
	public int getCount(){
		return count;
	}
	public void setCount(){
		this.count=count;
	}
	public Page(int start,int count){
		super();
		this.start=start;
		this.count=count;
	}
	public boolean isHasPrevious(){
		if(start==0)
			return false;
		return true;
	}
	public int getTotalPage(){
		int totalPage;
		if(0==total%count)
			totalPage=total/count;
		else
			totalPage=total/count+1;
		if(0==totalPage)
			totalPage=1;
		return totalPage;
	}
	public int getLast(){
		int last;
		if(0==total%count)
			last=total-count;
		else
			last=total-total%count;
		last=last<0?0:last;
		return last;
	}
	public int getTotal(){
		return total;
	}
	public void setTotal(){
		this.total=total;
	}
	public String getParam(){
		return param;
	}
	public void setParam(String param){
		this.param=param;
	}

}
