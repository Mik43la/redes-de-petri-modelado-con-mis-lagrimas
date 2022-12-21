package test;

import net.hostettler.jdd.dd.DD;

public abstract class Expression {

	  private String var;
	    private Integer val;
	    private DD<String, Integer> ddd;

	    public Expression(String var, Integer val, DD<String, Integer> ddd) {
	        this.val = val;
	        this.var = var;
	        this.ddd = ddd;
	    }

	    public Expression() {
	    }

	    public String getVar() {
	        return var;
	    }

	    public Integer getVal() {
	        return val;
	    }

	    public DD<String, Integer> getDdd() {
	        return ddd;
	    }

	    public void setDdd(DD<String, Integer> ddd) {
	        this.ddd = ddd;
	    }

}
