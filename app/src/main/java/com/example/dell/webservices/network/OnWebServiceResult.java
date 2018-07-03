package com.example.dell.webservices.network;


import com.example.dell.webservices.utils.CommonUtilities;

public interface OnWebServiceResult {

    public void getWebResponse(String result, CommonUtilities.SERVICE_TYPE type);
}