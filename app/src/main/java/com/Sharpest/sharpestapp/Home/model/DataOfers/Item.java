
package com.Sharpest.sharpestapp.Home.model.DataOfers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("itemCode")
    @Expose
    private Object itemCode;
    @SerializedName("itemSerial")
    @Expose
    private Object itemSerial;
    @SerializedName("itemNameAr")
    @Expose
    private Object itemNameAr;
    @SerializedName("itemNameEn")
    @Expose
    private Object itemNameEn;
    @SerializedName("itemDescription")
    @Expose
    private Object itemDescription;
    @SerializedName("itemBestSellingFlag")
    @Expose
    private Object itemBestSellingFlag;
    @SerializedName("banarImagePath")
    @Expose
    private Object banarImagePath;
    @SerializedName("itemModelCode")
    @Expose
    private Object itemModelCode;
    @SerializedName("itemHorse")
    @Expose
    private Object itemHorse;
    @SerializedName("itemWidth")
    @Expose
    private Object itemWidth;
    @SerializedName("itemHight")
    @Expose
    private Object itemHight;
    @SerializedName("itemCharge")
    @Expose
    private Object itemCharge;
    @SerializedName("sparePartsFlag")
    @Expose
    private Integer sparePartsFlag;
    @SerializedName("machineModel")
    @Expose
    private Object machineModel;
    @SerializedName("workingErea")
    @Expose
    private Object workingErea;
    @SerializedName("machinePower")
    @Expose
    private Object machinePower;
    @SerializedName("machineFunction")
    @Expose
    private Object machineFunction;
    @SerializedName("workingTable")
    @Expose
    private Object workingTable;
    @SerializedName("inputVoltage")
    @Expose
    private Object inputVoltage;
    @SerializedName("graphicFormatSupported")
    @Expose
    private Object graphicFormatSupported;
    @SerializedName("machineNetWeight")
    @Expose
    private Object machineNetWeight;
    @SerializedName("technicalSpecifications")
    @Expose
    private Object technicalSpecifications;
    @SerializedName("itemPrice")
    @Expose
    private Object itemPrice;
    @SerializedName("itemCategory")
    @Expose
    private Object itemCategory;
    @SerializedName("itemColling")
    @Expose
    private Object itemColling;
    @SerializedName("itemDetails")
    @Expose
    private Object itemDetails;
    @SerializedName("itemImagesList")
    @Expose
    private Object itemImagesList;
    @SerializedName("offersDto")
    @Expose
    private Object offersDto;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param itemSerial
     * @param machinePower
     * @param itemCategory
     * @param itemCode
     * @param inputVoltage
     * @param itemImagesList
     * @param itemHorse
     * @param technicalSpecifications
     * @param banarImagePath
     * @param graphicFormatSupported
     * @param itemWidth
     * @param id
     * @param itemDescription
     * @param itemCharge
     * @param itemNameEn
     * @param itemColling
     * @param itemHight
     * @param itemDetails
     * @param itemNameAr
     * @param itemModelCode
     * @param sparePartsFlag
     * @param machineFunction
     * @param machineModel
     * @param itemBestSellingFlag
     * @param workingErea
     * @param workingTable
     * @param itemPrice
     * @param offersDto
     * @param machineNetWeight
     */
    public Item(Integer id, Object itemCode, Object itemSerial, Object itemNameAr, Object itemNameEn, Object itemDescription, Object itemBestSellingFlag, Object banarImagePath, Object itemModelCode, Object itemHorse, Object itemWidth, Object itemHight, Object itemCharge, Integer sparePartsFlag, Object machineModel, Object workingErea, Object machinePower, Object machineFunction, Object workingTable, Object inputVoltage, Object graphicFormatSupported, Object machineNetWeight, Object technicalSpecifications, Object itemPrice, Object itemCategory, Object itemColling, Object itemDetails, Object itemImagesList, Object offersDto) {
        super();
        this.id = id;
        this.itemCode = itemCode;
        this.itemSerial = itemSerial;
        this.itemNameAr = itemNameAr;
        this.itemNameEn = itemNameEn;
        this.itemDescription = itemDescription;
        this.itemBestSellingFlag = itemBestSellingFlag;
        this.banarImagePath = banarImagePath;
        this.itemModelCode = itemModelCode;
        this.itemHorse = itemHorse;
        this.itemWidth = itemWidth;
        this.itemHight = itemHight;
        this.itemCharge = itemCharge;
        this.sparePartsFlag = sparePartsFlag;
        this.machineModel = machineModel;
        this.workingErea = workingErea;
        this.machinePower = machinePower;
        this.machineFunction = machineFunction;
        this.workingTable = workingTable;
        this.inputVoltage = inputVoltage;
        this.graphicFormatSupported = graphicFormatSupported;
        this.machineNetWeight = machineNetWeight;
        this.technicalSpecifications = technicalSpecifications;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
        this.itemColling = itemColling;
        this.itemDetails = itemDetails;
        this.itemImagesList = itemImagesList;
        this.offersDto = offersDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getItemCode() {
        return itemCode;
    }

    public void setItemCode(Object itemCode) {
        this.itemCode = itemCode;
    }

    public Object getItemSerial() {
        return itemSerial;
    }

    public void setItemSerial(Object itemSerial) {
        this.itemSerial = itemSerial;
    }

    public Object getItemNameAr() {
        return itemNameAr;
    }

    public void setItemNameAr(Object itemNameAr) {
        this.itemNameAr = itemNameAr;
    }

    public Object getItemNameEn() {
        return itemNameEn;
    }

    public void setItemNameEn(Object itemNameEn) {
        this.itemNameEn = itemNameEn;
    }

    public Object getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(Object itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Object getItemBestSellingFlag() {
        return itemBestSellingFlag;
    }

    public void setItemBestSellingFlag(Object itemBestSellingFlag) {
        this.itemBestSellingFlag = itemBestSellingFlag;
    }

    public Object getBanarImagePath() {
        return banarImagePath;
    }

    public void setBanarImagePath(Object banarImagePath) {
        this.banarImagePath = banarImagePath;
    }

    public Object getItemModelCode() {
        return itemModelCode;
    }

    public void setItemModelCode(Object itemModelCode) {
        this.itemModelCode = itemModelCode;
    }

    public Object getItemHorse() {
        return itemHorse;
    }

    public void setItemHorse(Object itemHorse) {
        this.itemHorse = itemHorse;
    }

    public Object getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(Object itemWidth) {
        this.itemWidth = itemWidth;
    }

    public Object getItemHight() {
        return itemHight;
    }

    public void setItemHight(Object itemHight) {
        this.itemHight = itemHight;
    }

    public Object getItemCharge() {
        return itemCharge;
    }

    public void setItemCharge(Object itemCharge) {
        this.itemCharge = itemCharge;
    }

    public Integer getSparePartsFlag() {
        return sparePartsFlag;
    }

    public void setSparePartsFlag(Integer sparePartsFlag) {
        this.sparePartsFlag = sparePartsFlag;
    }

    public Object getMachineModel() {
        return machineModel;
    }

    public void setMachineModel(Object machineModel) {
        this.machineModel = machineModel;
    }

    public Object getWorkingErea() {
        return workingErea;
    }

    public void setWorkingErea(Object workingErea) {
        this.workingErea = workingErea;
    }

    public Object getMachinePower() {
        return machinePower;
    }

    public void setMachinePower(Object machinePower) {
        this.machinePower = machinePower;
    }

    public Object getMachineFunction() {
        return machineFunction;
    }

    public void setMachineFunction(Object machineFunction) {
        this.machineFunction = machineFunction;
    }

    public Object getWorkingTable() {
        return workingTable;
    }

    public void setWorkingTable(Object workingTable) {
        this.workingTable = workingTable;
    }

    public Object getInputVoltage() {
        return inputVoltage;
    }

    public void setInputVoltage(Object inputVoltage) {
        this.inputVoltage = inputVoltage;
    }

    public Object getGraphicFormatSupported() {
        return graphicFormatSupported;
    }

    public void setGraphicFormatSupported(Object graphicFormatSupported) {
        this.graphicFormatSupported = graphicFormatSupported;
    }

    public Object getMachineNetWeight() {
        return machineNetWeight;
    }

    public void setMachineNetWeight(Object machineNetWeight) {
        this.machineNetWeight = machineNetWeight;
    }

    public Object getTechnicalSpecifications() {
        return technicalSpecifications;
    }

    public void setTechnicalSpecifications(Object technicalSpecifications) {
        this.technicalSpecifications = technicalSpecifications;
    }

    public Object getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Object itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Object getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(Object itemCategory) {
        this.itemCategory = itemCategory;
    }

    public Object getItemColling() {
        return itemColling;
    }

    public void setItemColling(Object itemColling) {
        this.itemColling = itemColling;
    }

    public Object getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(Object itemDetails) {
        this.itemDetails = itemDetails;
    }

    public Object getItemImagesList() {
        return itemImagesList;
    }

    public void setItemImagesList(Object itemImagesList) {
        this.itemImagesList = itemImagesList;
    }

    public Object getOffersDto() {
        return offersDto;
    }

    public void setOffersDto(Object offersDto) {
        this.offersDto = offersDto;
    }

}
