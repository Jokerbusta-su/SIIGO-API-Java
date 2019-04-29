package com.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	
	@JsonProperty("Id")
	private Long id;
	@JsonProperty("Code")
	private String code;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("ReferenceManufactures")
	private String referenceManufactures;
	@JsonProperty("ProductTypeKey")
	private String productTypeKey;
	@JsonProperty("MeasureUnit")
	private String measureUnit;
	@JsonProperty("CodeBars")
	private String codeBars;
	@JsonProperty("Comments")
	private String comments;
	@JsonProperty("TaxAddID")
	private Long taxAddID = new Long(0);
	@JsonProperty("TaxDiscID")
	private Long taxDiscID = new Long(0);
	@JsonProperty("IsIncluded")
	private boolean isIncluded = true;
	@JsonProperty("Cost")
	private Long cost;
	@JsonProperty("IsInventoryControl")
	private boolean isInventoryControl = true;
	@JsonProperty("State")
	private int state;
	@JsonProperty("PriceList1")
	private Long priceList1 = new Long(0);
	@JsonProperty("PriceList2")
	private Long priceList2 = new Long(0);
	@JsonProperty("PriceList3")
	private Long priceList3 = new Long(0);
	@JsonProperty("PriceList4")
	private Long priceList4 = new Long(0);
	@JsonProperty("PriceList5")
	private Long priceList5 = new Long(0);
	@JsonProperty("PriceList6")
	private Long priceList6 = new Long(0);
	@JsonProperty("PriceList7")
	private Long priceList7 = new Long(0);
	@JsonProperty("PriceList8")
	private Long priceList8 = new Long(0);
	@JsonProperty("PriceList9")
	private Long priceList9 = new Long(0);
	@JsonProperty("PriceList10")
	private Long priceList10 = new Long(0);
	@JsonProperty("PriceList11")
	private Long priceList11 = new Long(0);
	@JsonProperty("PriceList12")
	private Long priceList12 = new Long(0);
	@JsonProperty("Image")
	private String image = "string";
	@JsonProperty("AccountGroupID")
	private int accountGroupID = 40;
	@JsonProperty("SubType")
	private int subType = 0;
	@JsonProperty("TaxAdd2ID")
	private int taxAdd2ID = 0;
	@JsonProperty("TaxImpoValue")
	private Long taxImpoValue = new Long(0);
	
	public Product() {
		
	}

	public Product(Long id, String code, String description, String referenceManufactures, String productTypeKey,
			String measureUnit, String codeBars, String comments, Long taxAddID, Long taxDiscID, boolean isIncluded,
			Long cost, boolean isInventoryControl, int state, Long priceList1, Long priceList2, Long priceList3,
			Long priceList4, Long priceList5, Long priceList6, Long priceList7, Long priceList8, Long priceList9,
			Long priceList10, Long priceList11, Long priceList12, String image, int accountGroupID, int subType,
			int taxAdd2ID, Long taxImpoValue) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.referenceManufactures = referenceManufactures;
		this.productTypeKey = productTypeKey;
		this.measureUnit = measureUnit;
		this.codeBars = codeBars;
		this.comments = comments;
		this.taxAddID = taxAddID;
		this.taxDiscID = taxDiscID;
		this.isIncluded = isIncluded;
		this.cost = cost;
		this.isInventoryControl = isInventoryControl;
		this.state = state;
		this.priceList1 = priceList1;
		this.priceList2 = priceList2;
		this.priceList3 = priceList3;
		this.priceList4 = priceList4;
		this.priceList5 = priceList5;
		this.priceList6 = priceList6;
		this.priceList7 = priceList7;
		this.priceList8 = priceList8;
		this.priceList9 = priceList9;
		this.priceList10 = priceList10;
		this.priceList11 = priceList11;
		this.priceList12 = priceList12;
		this.image = image;
		this.accountGroupID = accountGroupID;
		this.subType = subType;
		this.taxAdd2ID = taxAdd2ID;
		this.taxImpoValue = taxImpoValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReferenceManufactures() {
		return referenceManufactures;
	}

	public void setReferenceManufactures(String referenceManufactures) {
		this.referenceManufactures = referenceManufactures;
	}

	public String getProductTypeKey() {
		return productTypeKey;
	}

	public void setProductTypeKey(String productTypeKey) {
		this.productTypeKey = productTypeKey;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public String getCodeBars() {
		return codeBars;
	}

	public void setCodeBars(String codeBars) {
		this.codeBars = codeBars;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getTaxAddID() {
		return taxAddID;
	}

	public void setTaxAddID(Long taxAddID) {
		this.taxAddID = taxAddID;
	}

	public Long getTaxDiscID() {
		return taxDiscID;
	}

	public void setTaxDiscID(Long taxDiscID) {
		this.taxDiscID = taxDiscID;
	}

	public boolean isIncluded() {
		return isIncluded;
	}

	public void setIncluded(boolean isIncluded) {
		this.isIncluded = isIncluded;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public boolean isInventoryControl() {
		return isInventoryControl;
	}

	public void setInventoryControl(boolean isInventoryControl) {
		this.isInventoryControl = isInventoryControl;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Long getPriceList1() {
		return priceList1;
	}

	public void setPriceList1(Long priceList1) {
		this.priceList1 = priceList1;
	}

	public Long getPriceList2() {
		return priceList2;
	}

	public void setPriceList2(Long priceList2) {
		this.priceList2 = priceList2;
	}

	public Long getPriceList3() {
		return priceList3;
	}

	public void setPriceList3(Long priceList3) {
		this.priceList3 = priceList3;
	}

	public Long getPriceList4() {
		return priceList4;
	}

	public void setPriceList4(Long priceList4) {
		this.priceList4 = priceList4;
	}

	public Long getPriceList5() {
		return priceList5;
	}

	public void setPriceList5(Long priceList5) {
		this.priceList5 = priceList5;
	}

	public Long getPriceList6() {
		return priceList6;
	}

	public void setPriceList6(Long priceList6) {
		this.priceList6 = priceList6;
	}

	public Long getPriceList7() {
		return priceList7;
	}

	public void setPriceList7(Long priceList7) {
		this.priceList7 = priceList7;
	}

	public Long getPriceList8() {
		return priceList8;
	}

	public void setPriceList8(Long priceList8) {
		this.priceList8 = priceList8;
	}

	public Long getPriceList9() {
		return priceList9;
	}

	public void setPriceList9(Long priceList9) {
		this.priceList9 = priceList9;
	}

	public Long getPriceList10() {
		return priceList10;
	}

	public void setPriceList10(Long priceList10) {
		this.priceList10 = priceList10;
	}

	public Long getPriceList11() {
		return priceList11;
	}

	public void setPriceList11(Long priceList11) {
		this.priceList11 = priceList11;
	}

	public Long getPriceList12() {
		return priceList12;
	}

	public void setPriceList12(Long priceList12) {
		this.priceList12 = priceList12;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getAccountGroupID() {
		return accountGroupID;
	}

	public void setAccountGroupID(int accountGroupID) {
		this.accountGroupID = accountGroupID;
	}

	public int getSubType() {
		return subType;
	}

	public void setSubType(int subType) {
		this.subType = subType;
	}

	public int getTaxAdd2ID() {
		return taxAdd2ID;
	}

	public void setTaxAdd2ID(int taxAdd2ID) {
		this.taxAdd2ID = taxAdd2ID;
	}

	public Long getTaxImpoValue() {
		return taxImpoValue;
	}

	public void setTaxImpoValue(Long taxImpoValue) {
		this.taxImpoValue = taxImpoValue;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", description=" + description + ", referenceManufactures="
				+ referenceManufactures + ", productTypeKey=" + productTypeKey + ", measureUnit=" + measureUnit
				+ ", codeBars=" + codeBars + ", comments=" + comments + ", taxAddID=" + taxAddID + ", taxDiscID="
				+ taxDiscID + ", isIncluded=" + isIncluded + ", cost=" + cost + ", isInventoryControl="
				+ isInventoryControl + ", state=" + state + ", priceList1=" + priceList1 + ", priceList2=" + priceList2
				+ ", priceList3=" + priceList3 + ", priceList4=" + priceList4 + ", priceList5=" + priceList5
				+ ", priceList6=" + priceList6 + ", priceList7=" + priceList7 + ", priceList8=" + priceList8
				+ ", priceList9=" + priceList9 + ", priceList10=" + priceList10 + ", priceList11=" + priceList11
				+ ", priceList12=" + priceList12 + ", image=" + image + ", accountGroupID=" + accountGroupID
				+ ", subType=" + subType + ", taxAdd2ID=" + taxAdd2ID + ", taxImpoValue=" + taxImpoValue + "]";
	}
}
