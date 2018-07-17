package com.qa.controller.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.qa.persistence.domain.Account;

@WebService
public interface AccountSOAPInterface {

    @WebMethod
    public String addAccount(String account);
    
    @WebMethod
    public Account getAccount(long id);
    
    @WebMethod
    public String deleteAccount(long id);
    
    @WebMethod
    public String updateAccount(long id,String account);
    
    @WebMethod
    public String getAllAccounts() ;
    	
    
    

}
