
package com.Sharpest.sharpestapp.UI.Data_ofersDetales;

import java.util.List;

import com.Sharpest.sharpestapp.model.DetalsProdect.ItemDetail;
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
    private String itemDescription;
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
    private String machineModel;
    @SerializedName("workingErea")
    @Expose
    private String workingErea;
    @SerializedName("machinePower")
    @Expose
    private String machinePower;
    @SerializedName("machineFunction")
    @Expose
    private String machineFunction;
    @SerializedName("workingTable")
    @Expose
    private String workingTable;
    @SerializedName("inputVoltage")
    @Expose
    private String inputVoltage;
    @SerializedName("graphicFormatSupported")
    @Expose
    private String graphicFormatSupported;
    @SerializedName("machineNetWeight")
    @Expose
    private String machineNetWeight;
    @SerializedName("technicalSpecifications")
    @Expose
    private String technicalSpecifications;
    @SerializedName("itemPrice")
    @Expose
    private Object itemPrice;
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
    @SerializedName("offersDto")
    @Expose
    private OffersDto offersDto;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResultData() {
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
    public ResultData(Integer id, String itemCode, String itemSerial, String itemNameAr
            , String itemNameEn, String itemDescription, Integer itemBestSellingFlag,
                      String banarImagePath, String itemModelCode, String itemHorse,
                      Double itemWidth, Double itemHight, String itemCharge, Integer sparePartsFlag,
                      String machineModel, String workingErea, String machinePower, String machineFunction,
                      String workingTable, String inputVoltage, String graphicFormatSupported, String machineNetWeight,
                      String technicalSpecifications, Object itemPrice, ItemCategory itemCategory, ItemColling itemColling,
                      List<ItemDetail> itemDetails, List<ItemImagesList> itemImagesList, OffersDto offersDto) {
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

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
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

    public String getMachineModel() {
        return machineModel;
    }

    public void setMachineModel(String machineModel) {
        this.machineModel = machineModel;
    }

    public String getWorkingErea() {
        return workingErea;
    }

    public void setWorkingErea(String workingErea) {
        this.workingErea = workingErea;
    }

    public String getMachinePower() {
        return machinePower;
    }

    public void setMachinePower(String machinePower) {
        this.machinePower = machinePower;
    }

    public String getMachineFunction() {
        return machineFunction;
    }

    public void setMachineFunction(String machineFunction) {
        this.machineFunction = machineFunction;
    }

    public String getWorkingTable() {
        return workingTable;
    }

    public void setWorkingTable(String workingTable) {
        this.workingTable = workingTable;
    }

    public String getInputVoltage() {
        return inputVoltage;
    }

    public void setInputVoltage(String inputVoltage) {
        this.inputVoltage = inputVoltage;
    }

    public String getGraphicFormatSupported() {
        return graphicFormatSupported;
    }

    public void setGraphicFormatSupported(String graphicFormatSupported) {
        this.graphicFormatSupported = graphicFormatSupported;
    }

    public String getMachineNetWeight() {
        return machineNetWeight;
    }

    public void setMachineNetWeight(String machineNetWeight) {
        this.machineNetWeight = machineNetWeight;
    }

    public String getTechnicalSpecifications() {
        return technicalSpecifications;
    }

    public void setTechnicalSpecifications(String technicalSpecifications) {
        this.technicalSpecifications = technicalSpecifications;
    }

    public Object getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Object itemPrice) {
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

    public OffersDto getOffersDto() {
        return offersDto;
    }

    public void setOffersDto(OffersDto offersDto) {
        this.offersDto = offersDto;
    }

}
