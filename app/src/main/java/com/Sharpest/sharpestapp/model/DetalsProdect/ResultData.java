
package com.Sharpest.sharpestapp.model.DetalsProdect;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("itemCode")
    @Expose
    private String itemCode;
    @SerializedName("itemSerial")
    @Expose
    private String itemSerial;
    @SerializedName("itemNameAr")
    @Expose
    private String itemNameAr;
    @SerializedName("itemNameEn")
    @Expose
    private String itemNameEn;
    @SerializedName("itemDescription")
    @Expose
    private Object itemDescription;
    @SerializedName("itemBestSellingFlag")
    @Expose
    private Integer itemBestSellingFlag;
    @SerializedName("banarImagePath")
    @Expose
    private String banarImagePath;
    @SerializedName("itemModelCode")
    @Expose
    private String itemModelCode;
    @SerializedName("itemHorse")
    @Expose
    private String itemHorse;
    @SerializedName("itemWidth")
    @Expose
    private Double itemWidth;
    @SerializedName("itemHight")
    @Expose
    private Double itemHight;
    @SerializedName("itemCharge")
    @Expose
    private String itemCharge;
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
    private Double itemPrice;
    @SerializedName("itemCategory")
    @Expose
    private ItemCategory itemCategory;
    @SerializedName("itemColling")
    @Expose
    private ItemColling itemColling;
    @SerializedName("itemDetails")
    @Expose
    private List<ItemDetail> itemDetails = null;
    @SerializedName("itemImagesList")
    @Expose
    private List<ItemImagesList> itemImagesList = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemSerial() {
        return itemSerial;
    }

    public void setItemSerial(String itemSerial) {
        this.itemSerial = itemSerial;
    }

    public String getItemNameAr() {
        return itemNameAr;
    }

    public void setItemNameAr(String itemNameAr) {
        this.itemNameAr = itemNameAr;
    }

    public String getItemNameEn() {
        return itemNameEn;
    }

    public void setItemNameEn(String itemNameEn) {
        this.itemNameEn = itemNameEn;
    }

    public Object getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(Object itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getItemBestSellingFlag() {
        return itemBestSellingFlag;
    }

    public void setItemBestSellingFlag(Integer itemBestSellingFlag) {
        this.itemBestSellingFlag = itemBestSellingFlag;
    }

    public String getBanarImagePath() {
        return banarImagePath;
    }

    public void setBanarImagePath(String banarImagePath) {
        this.banarImagePath = banarImagePath;
    }

    public String getItemModelCode() {
        return itemModelCode;
    }

    public void setItemModelCode(String itemModelCode) {
        this.itemModelCode = itemModelCode;
    }

    public String getItemHorse() {
        return itemHorse;
    }

    public void setItemHorse(String itemHorse) {
        this.itemHorse = itemHorse;
    }

    public Double getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(Double itemWidth) {
        this.itemWidth = itemWidth;
    }

    public Double getItemHight() {
        return itemHight;
    }

    public void setItemHight(Double itemHight) {
        this.itemHight = itemHight;
    }

    public String getItemCharge() {
        return itemCharge;
    }

    public void setItemCharge(String itemCharge) {
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

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    public ItemColling getItemColling() {
        return itemColling;
    }

    public void setItemColling(ItemColling itemColling) {
        this.itemColling = itemColling;
    }

    public List<ItemDetail> getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(List<ItemDetail> itemDetails) {
        this.itemDetails = itemDetails;
    }

    public List<ItemImagesList> getItemImagesList() {
        return itemImagesList;
    }

    public void setItemImagesList(List<ItemImagesList> itemImagesList) {
        this.itemImagesList = itemImagesList;
    }

}
