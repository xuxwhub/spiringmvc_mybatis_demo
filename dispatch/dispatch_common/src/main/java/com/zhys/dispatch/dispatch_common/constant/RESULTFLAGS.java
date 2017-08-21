package com.zhys.dispatch.dispatch_common.constant;

public enum RESULTFLAGS {
	
	SUCCESS("SUCCESS"),ERROR("ERROR"),WARNING("WARNING");
	
	private String name;
	
	private RESULTFLAGS(String name){
		this.name = name;
	}
	
    public String getName() {  
        return this.name;
    }  
    
    public String toString(){
    	return this.name;
    }

}
