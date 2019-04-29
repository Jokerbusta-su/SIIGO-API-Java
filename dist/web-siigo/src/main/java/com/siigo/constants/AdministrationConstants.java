package com.siigo.constants;

public class AdministrationConstants {

	//
	public static final String HOME_MAPPING = "/";
	public static final String CREATE_PRODUCT = "/crearProducto";
	public static final String DELETE_PRODUCT = "/deleteProduct";

	// JSP
	public static final String HOME_JSP = "home";

	// REST SERVICES
	public static final String REST_TOKEN = "https://siigonube.siigo.com:50050/connect/token";

	public static final String REST_GET_DEVELOPERS = "http://siigoapi.azure-api.net/siigo/api/v1/Developers/GetAll?namespace=v1";
	public static final String REST_GET_PRODUCTS = "http://siigoapi.azure-api.net/siigo/api/v1/Products/GetAll?numberPage=0&namespace=v1";

//	public static final String REST_GET_DEVELOPERS = "http://localhost:16391/api/v1/Developers/GetAll?namespace=v1";
//	public static final String REST_GET_PRODUCTS = "http://localhost:16391/api/v1/Products/GetAll?numberPage=0&namespace=v1";

	public static final String REST_CREATE_PRODUCT = "http://siigoapi.azure-api.net/siigo/api/v1/Products/Create?namespace=v1";
	public static final String REST_DELETE_PRODUCT = "http://siigoapi.azure-api.net/siigo/api/v1/Products/Delete/";

//	public static final String REST_CREATE_PRODUCT = "http://localhost:16391/api/v1/Products/Create?namespace=v1";
//	public static final String REST_DELETE_PRODUCT = "http://localhost:16391/api/v1/Products/Delete/";
}
