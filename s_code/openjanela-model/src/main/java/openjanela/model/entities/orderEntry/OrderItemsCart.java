package openjanela.model.entities.orderEntry;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;


/**
 * Copyright(c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif Eldibany
 * @version 2.0.8
 */
@Entity
@Table(name = "order_items_cart")
public class OrderItemsCart implements Serializable {

    @EmbeddedId
    private OrderItemsCartPK id;

    @Column(name = "type_id", nullable = false)
    private int typeId = 0;

    @Column(name = "active", nullable = false)
    private boolean active = false;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @Column(name = "partid", nullable = false)
    private int partId = 0;

    @Column(name = "description", nullable = false)
    private String description = "";

    @Column(name = "quantity", nullable = false)
    private int quantity = 0;

    @Column(name = "width", nullable = false)
    private int width = 0;

    @Column(name = "width_i", nullable = false)
    private int widthI = 0;

    @Column(name = "height", nullable = true)
    private int height = 0;

    @Column(name = "height_i", nullable = true)
    private int heightI = 0;

    @Column(name = "ro_width", nullable = true)
    private int roWidth = 0;

    @Column(name = "ro_widht_i", nullable = true)
    private int roWidhtI = 0;

    @Column(name = "ro_hieght", nullable = true)
    private int roHeight = 0;

    @Column(name = "ro_hieght_i", nullable = true)
    private int roHeightI = 0;

    @Column(name = "size", nullable = true)
    private int size = 0;

    @Column(name = "size_i", nullable = true)
    private int sizeI = 0;

    @Column(name = "reference", nullable = false)
    private String reference = "";

    @Column(name = "location_id", nullable = false)
    private int locationId = 0;

    @Column(name = "location_text", nullable = false)
    private String locationText = "";

    @Lob
    @Column(name = "image", nullable = true)
    private byte[] image = null;

    @Column(name = "supplier_id", nullable = true)
    private int supplierId = 0;

    @Column(name = "series_id", nullable = true)
    private int seriesId = 0;

    @Lob
    @Column(name = "notes", nullable = true)
    private String notes = "";

    @Lob
    @Column(name = "thumbnail", nullable = true)
    private byte[] thumbnail = null;

    @Column(name = "ro_adjustment_id", nullable = true)
    private int roAdjustmentId = 0;

    @Column(name = "hs_adjustment_id", nullable = true)
    private int hsAdjustmentId = 0;

    @Column(name = "shipqty", nullable = true)
    private int shipqty = 0;

    @Column(name = "init", nullable = true)
    private int init = 0;

    @Column(name = "done", nullable = true)
    private int done = 0;

    @Column(name = "inprocess", nullable = true)
    private int inprocess = 0;

    @Column(name = "width_flat", nullable = true)
    private int widthFlat = 0;

    @Column(name = "height_flat", nullable = true)
    private int heightFlat = 0;

    @Column(name = "width_flat_i", nullable = true)
    private int widthFlatI = 0;

    @Column(name = "height_flat_i", nullable = true)
    private int heightFlatI = 0;

    @Column(name = "width_out", nullable = true)
    private int widthOut = 0;

    @Column(name = "width_out_i", nullable = true)
    private int widthOutI = 0;

    @Column(name = "width_in", nullable = true)
    private int widthIn = 0;

    @Column(name = "width_in_i", nullable = true)
    private int widthInI = 0;

    @Column(name = "gap", nullable = true)
    private int gap = 0;

    @Column(name = "gap_i", nullable = true)
    private int gapI = 0;

    @Column(name = "opening_width", nullable = true)
    private int openingWidth = 0;

    @Column(name = "opening_width_i", nullable = true)
    private int openingWidthI = 0;

    @Column(name = "depth", nullable = true)
    private int depth = 0;

    @Column(name = "depth_i", nullable = true)
    private int depthI = 0;

    @Column(name = "extension", nullable = true)
    private int extension = 0;

    @Column(name = "extension_i", nullable = true)
    private int extensionI = 0;

    @Column(name = "projection_in", nullable = true)
    private int projectionIn = 0;

    @Column(name = "projection_in_i", nullable = true)
    private int projectionInI = 0;

    @Column(name = "projection_out", nullable = true)
    private int projectionOut = 0;

    @Column(name = "projection_out_i", nullable = true)
    private int projectionOutI = 0;

    @Column(name = "angle", nullable = true)
    private int angle = 0;

    @Column(name = "unit_width", nullable = true)
    private int unitWidth = 0;

    @Column(name = "unit_width_i", nullable = true)
    private int unitWidthI = 0;

    @Column(name = "center_unit", nullable = true)
    private int centerUnit = 0;

    @Column(name = "center_unit_i", nullable = true)
    private int centerUnitI = 0;

    @Column(name = "measure", nullable = true)
    private int measure = 0;

    @Column(name = "metricscale", nullable = true)
    private BigDecimal metricScale = new BigDecimal(0);

    @Column(name = "imperialscale", nullable = true)
    private BigDecimal imperialScale = new BigDecimal(0);

    @Column(name = "cost_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal costUser = new BigDecimal("0");

    @Column(name = "price_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal priceUser = new BigDecimal("0");

    @Column(name = "price_ship", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal priceShip = new BigDecimal("0");

    @Column(name = "price_install", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal priceInstall = new BigDecimal("0");

    @Column(name = "price_ship_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal priceShipUser = new BigDecimal("0");

    @Column(name = "price_install_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal priceInstallUser = new BigDecimal("0");

    @Column(name = "stockcode", nullable = true)
    private String stockCode = "";

    @Column(name = "part_type", nullable = false)
    private int partType = 1;

    @Column(name = "price_group", nullable = false)
    private int priceGroup = 1;

    @Column(name = "total_price", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal totalPrice = new BigDecimal("0");

    @Column(name = "total_cost", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal totalCost = new BigDecimal("0");

    @Column(name = "discount", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal discount = new BigDecimal("0");

    @Column(name = "pricemeasure", nullable = false)
    private int priceMeasure = 0;

    @Column(name = "priceuom", nullable = false)
    private int priceUOM = 0;

    @Column(name = "taxable", nullable = false)
    private boolean taxable = false;

    @Column(name = "discountable", nullable = false)
    private boolean discountable = false;

    @Column(name = "radius1", nullable = false)
    private int radius1 = 0;

    @Column(name = "radius2", nullable = false)
    private int radius2 = 0;

    @Column(name = "radius1i", nullable = false)
    private int radius1i = 0;

    @Column(name = "radius2i", nullable = false)
    private int radius2i = 0;

    @Column(name = "custom_leadtime")
    private int custom_leadtime = 0;

    @Column(name = "leftangle", nullable = false)
    private double leftAngle = 0;

    @Column(name = "rightangle", nullable = false)
    private double rightAngle = 0;

    @Column(name = "custompart", nullable = false)
    private boolean customPart = false;

    @Column(name = "price", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal price = new BigDecimal("0");

    @Column(name = "cost", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = true)
    private BigDecimal cost = new BigDecimal("0");

    @Column(name = "price_base", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal priceBase = new BigDecimal("0");

    @Column(name = "price_options", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal priceOptions = new BigDecimal("0");

    @Column(name = "price_glass", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal priceGlass = new BigDecimal("0");

    @Column(name = "price_grids", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal priceGrids = new BigDecimal("0");

    @Column(name = "price_labor", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal priceLabor = new BigDecimal("0");

    @Column(name = "price_other", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal priceOther = new BigDecimal("0");

    @Column(name = "price_base_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal priceBaseUser = new BigDecimal("0");

    @Column(name = "price_options_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal priceOptionsUser = new BigDecimal("0");

    @Column(name = "price_glass_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal priceGlassUser = new BigDecimal("0");

    @Column(name = "price_grids_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal priceGridsUser = new BigDecimal("0");

    @Column(name = "price_labor_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal priceLaborUser = new BigDecimal("0");

    @Column(name = "price_other_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal priceOtherUser = new BigDecimal("0");

    @Column(name = "cost_base", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costBase = new BigDecimal("0");

    @Column(name = "cost_options", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costOptions = new BigDecimal("0");

    @Column(name = "cost_glass", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costGlass = new BigDecimal("0");

    @Column(name = "cost_grids", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costGrids = new BigDecimal("0");

    @Column(name = "cost_labor", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costLabor = new BigDecimal("0");

    @Column(name = "cost_ship", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costShip = new BigDecimal("0");

    @Column(name = "cost_install", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costInstall = new BigDecimal("0");

    @Column(name = "cost_other", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costOther = new BigDecimal("0");

    @Column(name = "cost_base_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costBaseUser = new BigDecimal("0");

    @Column(name = "cost_options_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costOptionsUser = new BigDecimal("0");

    @Column(name = "cost_glass_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costGlassUser = new BigDecimal("0");

    @Column(name = "cost_grids_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costGridsUser = new BigDecimal("0");

    @Column(name = "cost_labor_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costLaborUser = new BigDecimal("0");

    @Column(name = "cost_ship_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costShipUser = new BigDecimal("0");

    @Column(name = "cost_install_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costInstallUser = new BigDecimal("0");

    @Column(name = "cost_other_user", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal costOtherUser = new BigDecimal("0");

    @Column(name = "discount_base", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal discountBase = new BigDecimal("0");

    @Column(name = "discount_options", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal discountOptions = new BigDecimal("0");

    @Column(name = "discount_glass", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal discountGlass = new BigDecimal("0");

    @Column(name = "discount_grids", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal discountGrids = new BigDecimal("0");

    @Column(name = "discount_labor", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal discountLabor = new BigDecimal("0");

    @Column(name = "discount_ship", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal discountShip = new BigDecimal("0");

    @Column(name = "discount_install", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal discountInstall = new BigDecimal("0");

    @Column(name = "discount_other", precision = 19, scale = 4, columnDefinition = "decimal(19, 4)", nullable = false)
    private BigDecimal discountOther = new BigDecimal("0");      

    /**
     * Default Constructor Order Items Cart
     */
    public OrderItemsCart() {
    }

    /**
     * Constructor OrderItemsCart
     *
     * @param id, OrderItemsCartPK
     */
    public OrderItemsCart(OrderItemsCartPK id) {
        this.id = id;
    }

    public OrderItemsCart(OrderItemsCartPK id, int typeId, boolean active, boolean deleted, int partId, String description,
                          int quantity, int width, int widthI, int height, int heightI, int roWidth, int roWidhtI, int roHeight,
                          int roHeightI, int size, int sizeI, String reference, int locationId, String locationText,
                          byte[] image, int supplierId, int seriesId, String notes, byte[] thumbnail, int roAdjustmentId,
                          int hsAdjustmentId, int shipqty, int init, int done, int inprocess, int widthFlat,
                          int heightFlat, int widthFlatI, int heightFlatI, int widthOut, int widthOutI, int widthIn, int widthInI, int gap,
                          int gapI, int openingWidth, int openingWidthI, int depth, int depthI, int extension, int extensionI,
                          int projectionIn, int projectionInI, int projectionOut, int projectionOutI, int angle, int unitWidth,
                          int unitWidthI, int centerUnit, int centerUnitI, int measure, BigDecimal metricScale, BigDecimal imperialScale,
                          BigDecimal costUser, BigDecimal priceUser, BigDecimal priceShip, BigDecimal priceInstall, BigDecimal priceShipUser,
                          BigDecimal priceInstallUser, String stockCode, int partType, int priceGroup, BigDecimal totalPrice,
                          BigDecimal totalCost, BigDecimal discount, int priceMeasure, int priceUOM, boolean taxable,
                          boolean discountable, int radius1, int radius2, int radius1i, int radius2i, int custom_leadtime,
                          double leftAngle, double rightAngle, boolean customPart, BigDecimal price, BigDecimal cost,
                          BigDecimal priceBase, BigDecimal priceOptions, BigDecimal priceGlass, BigDecimal priceGrids,
                          BigDecimal priceLabor, BigDecimal priceOther, BigDecimal priceBaseUser, BigDecimal priceOptionsUser,
                          BigDecimal priceGlassUser, BigDecimal priceGridsUser, BigDecimal priceLaborUser, BigDecimal priceOtherUser,
                          BigDecimal costBase, BigDecimal costOptions, BigDecimal costGlass, BigDecimal costGrids, BigDecimal costLabor,
                          BigDecimal costShip, BigDecimal costInstall, BigDecimal costOther, BigDecimal costBaseUser,
                          BigDecimal costOptionsUser, BigDecimal costGlassUser, BigDecimal costGridsUser, BigDecimal costLaborUser,
                          BigDecimal costShipUser, BigDecimal costInstallUser, BigDecimal costOtherUser, BigDecimal discountBase,
                          BigDecimal discountOptions, BigDecimal discountGlass, BigDecimal discountGrids, BigDecimal discountLabor,
                          BigDecimal discountShip, BigDecimal discountInstall, BigDecimal discountOther) {
        this.id = id;
        this.typeId = typeId;
        this.active = active;
        this.deleted = deleted;
        this.partId = partId;
        this.description = description;
        this.quantity = quantity;
        this.width = width;
        this.widthI = widthI;
        this.height = height;
        this.heightI = heightI;
        this.roWidth = roWidth;
        this.roWidhtI = roWidhtI;
        this.roHeight = roHeight;
        this.roHeightI = roHeightI;
        this.size = size;
        this.sizeI = sizeI;
        this.reference = reference;
        this.locationId = locationId;
        this.locationText = locationText;
        this.image = image;
        this.supplierId = supplierId;
        this.seriesId = seriesId;
        this.notes = notes;
        this.thumbnail = thumbnail;
        this.roAdjustmentId = roAdjustmentId;
        this.hsAdjustmentId = hsAdjustmentId;
        this.shipqty = shipqty;
        this.init = init;
        this.done = done;
        this.inprocess = inprocess;
        this.widthFlat = widthFlat;
        this.heightFlat = heightFlat;
        this.widthFlatI = widthFlatI;
        this.heightFlatI = heightFlatI;
        this.widthOut = widthOut;
        this.widthOutI = widthOutI;
        this.widthIn = widthIn;
        this.widthInI = widthInI;
        this.gap = gap;
        this.gapI = gapI;
        this.openingWidth = openingWidth;
        this.openingWidthI = openingWidthI;
        this.depth = depth;
        this.depthI = depthI;
        this.extension = extension;
        this.extensionI = extensionI;
        this.projectionIn = projectionIn;
        this.projectionInI = projectionInI;
        this.projectionOut = projectionOut;
        this.projectionOutI = projectionOutI;
        this.angle = angle;
        this.unitWidth = unitWidth;
        this.unitWidthI = unitWidthI;
        this.centerUnit = centerUnit;
        this.centerUnitI = centerUnitI;
        this.measure = measure;
        this.metricScale = metricScale;
        this.imperialScale = imperialScale;
        this.costUser = costUser;
        this.priceUser = priceUser;
        this.priceShip = priceShip;
        this.priceInstall = priceInstall;
        this.priceShipUser = priceShipUser;
        this.priceInstallUser = priceInstallUser;
        this.stockCode = stockCode;
        this.partType = partType;
        this.priceGroup = priceGroup;
        this.totalPrice = totalPrice;
        this.totalCost = totalCost;
        this.discount = discount;
        this.priceMeasure = priceMeasure;
        this.priceUOM = priceUOM;
        this.taxable = taxable;
        this.discountable = discountable;
        this.radius1 = radius1;
        this.radius2 = radius2;
        this.radius1i = radius1i;
        this.radius2i = radius2i;
        this.custom_leadtime = custom_leadtime;
        this.leftAngle = leftAngle;
        this.rightAngle = rightAngle;
        this.customPart = customPart;
        this.price = price;
        this.cost = cost;
        this.priceBase = priceBase;
        this.priceOptions = priceOptions;
        this.priceGlass = priceGlass;
        this.priceGrids = priceGrids;
        this.priceLabor = priceLabor;
        this.priceOther = priceOther;
        this.priceBaseUser = priceBaseUser;
        this.priceOptionsUser = priceOptionsUser;
        this.priceGlassUser = priceGlassUser;
        this.priceGridsUser = priceGridsUser;
        this.priceLaborUser = priceLaborUser;
        this.priceOtherUser = priceOtherUser;
        this.costBase = costBase;
        this.costOptions = costOptions;
        this.costGlass = costGlass;
        this.costGrids = costGrids;
        this.costLabor = costLabor;
        this.costShip = costShip;
        this.costInstall = costInstall;
        this.costOther = costOther;
        this.costBaseUser = costBaseUser;
        this.costOptionsUser = costOptionsUser;
        this.costGlassUser = costGlassUser;
        this.costGridsUser = costGridsUser;
        this.costLaborUser = costLaborUser;
        this.costShipUser = costShipUser;
        this.costInstallUser = costInstallUser;
        this.costOtherUser = costOtherUser;
        this.discountBase = discountBase;
        this.discountOptions = discountOptions;
        this.discountGlass = discountGlass;
        this.discountGrids = discountGrids;
        this.discountLabor = discountLabor;
        this.discountShip = discountShip;
        this.discountInstall = discountInstall;
        this.discountOther = discountOther;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public OrderItemsCartPK getId() {
        return id;
    }

    public void setId(OrderItemsCartPK id) {
        this.id = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partid) {
        this.partId = partid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidthI() {
        return widthI;
    }

    public void setWidthI(int widthI) {
        this.widthI = widthI;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeightI() {
        return heightI;
    }

    public void setHeightI(int heightI) {
        this.heightI = heightI;
    }

    public int getRoWidth() {
        return roWidth;
    }

    public void setRoWidth(int roWidth) {
        this.roWidth = roWidth;
    }

    public int getRoWidhtI() {
        return roWidhtI;
    }

    public void setRoWidhtI(int roWidhtI) {
        this.roWidhtI = roWidhtI;
    }

    public int getRoHeight() {
        return roHeight;
    }

    public void setRoHeight(int roHeight) {
        this.roHeight = roHeight;
    }

    public int getRoHeightI() {
        return roHeightI;
    }

    public void setRoHeightI(int roHeightI) {
        this.roHeightI = roHeightI;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSizeI() {
        return sizeI;
    }

    public void setSizeI(int sizeI) {
        this.sizeI = sizeI;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationText() {
        return locationText;
    }

    public void setLocationText(String locationText) {
        this.locationText = locationText;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getRoAdjustmentId() {
        return roAdjustmentId;
    }

    public void setRoAdjustmentId(int roAdjustmentId) {
        this.roAdjustmentId = roAdjustmentId;
    }

    public int getHsAdjustmentId() {
        return hsAdjustmentId;
    }

    public void setHsAdjustmentId(int hsAdjustmentId) {
        this.hsAdjustmentId = hsAdjustmentId;
    }

    public int getShipqty() {
        return shipqty;
    }

    public void setShipqty(int shipqty) {
        this.shipqty = shipqty;
    }

    public int getInit() {
        return init;
    }

    public void setInit(int init) {
        this.init = init;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public int getInprocess() {
        return inprocess;
    }

    public void setInprocess(int inprocess) {
        this.inprocess = inprocess;
    }

    public int getWidthFlat() {
        return widthFlat;
    }

    public void setWidthFlat(int widthFlat) {
        this.widthFlat = widthFlat;
    }

    public int getHeightFlat() {
        return heightFlat;
    }

    public void setHeightFlat(int heightFlat) {
        this.heightFlat = heightFlat;
    }

    public int getWidthFlatI() {
        return widthFlatI;
    }

    public void setWidthFlatI(int widthFlatI) {
        this.widthFlatI = widthFlatI;
    }

    public int getHeightFlatI() {
        return heightFlatI;
    }

    public void setHeightFlatI(int heightFlatI) {
        this.heightFlatI = heightFlatI;
    }

    public int getWidthOut() {
        return widthOut;
    }

    public void setWidthOut(int widthOut) {
        this.widthOut = widthOut;
    }

    public int getWidthOutI() {
        return widthOutI;
    }

    public void setWidthOutI(int widthOutI) {
        this.widthOutI = widthOutI;
    }

    public int getWidthIn() {
        return widthIn;
    }

    public void setWidthIn(int widthIn) {
        this.widthIn = widthIn;
    }

    public int getWidthInI() {
        return widthInI;
    }

    public void setWidthInI(int widthInI) {
        this.widthInI = widthInI;
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public int getGapI() {
        return gapI;
    }

    public void setGapI(int gapI) {
        this.gapI = gapI;
    }

    public int getOpeningWidth() {
        return openingWidth;
    }

    public void setOpeningWidth(int openingWidth) {
        this.openingWidth = openingWidth;
    }

    public int getOpeningWidthI() {
        return openingWidthI;
    }

    public void setOpeningWidthI(int openingWidthI) {
        this.openingWidthI = openingWidthI;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepthI() {
        return depthI;
    }

    public void setDepthI(int depthI) {
        this.depthI = depthI;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public int getExtensionI() {
        return extensionI;
    }

    public void setExtensionI(int extensionI) {
        this.extensionI = extensionI;
    }

    public int getProjectionIn() {
        return projectionIn;
    }

    public void setProjectionIn(int projectionIn) {
        this.projectionIn = projectionIn;
    }

    public int getProjectionInI() {
        return projectionInI;
    }

    public void setProjectionInI(int projectionInI) {
        this.projectionInI = projectionInI;
    }

    public int getProjectionOut() {
        return projectionOut;
    }

    public void setProjectionOut(int projectionOut) {
        this.projectionOut = projectionOut;
    }

    public int getProjectionOutI() {
        return projectionOutI;
    }

    public void setProjectionOutI(int projectionOutI) {
        this.projectionOutI = projectionOutI;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getUnitWidth() {
        return unitWidth;
    }

    public void setUnitWidth(int unitWidth) {
        this.unitWidth = unitWidth;
    }

    public int getUnitWidthI() {
        return unitWidthI;
    }

    public void setUnitWidthI(int unitWidthI) {
        this.unitWidthI = unitWidthI;
    }

    public int getCenterUnit() {
        return centerUnit;
    }

    public void setCenterUnit(int centerUnit) {
        this.centerUnit = centerUnit;
    }

    public int getCenterUnitI() {
        return centerUnitI;
    }

    public void setCenterUnitI(int centerUnitI) {
        this.centerUnitI = centerUnitI;
    }

    public int getMeasure() {
        return measure;
    }

    public void setMeasure(int measure) {
        this.measure = measure;
    }

    public BigDecimal getMetricScale() {
        return metricScale;
    }

    public void setMetricScale(BigDecimal metricScale) {
        this.metricScale = metricScale;
    }

    public BigDecimal getImperialScale() {
        return imperialScale;
    }

    public void setImperialScale(BigDecimal imperialScale) {
        this.imperialScale = imperialScale;
    }

    public BigDecimal getCostUser() {
        return costUser;
    }

    public void setCostUser(BigDecimal costUser) {
        this.costUser = costUser;
    }

    public BigDecimal getPriceUser() {
        return priceUser;
    }

    public void setPriceUser(BigDecimal priceUser) {
        this.priceUser = priceUser;
    }

    public BigDecimal getPriceShip() {
        return priceShip;
    }

    public void setPriceShip(BigDecimal priceShip) {
        this.priceShip = priceShip;
    }

    public BigDecimal getPriceInstall() {
        return priceInstall;
    }

    public void setPriceInstall(BigDecimal priceInstall) {
        this.priceInstall = priceInstall;
    }

    public BigDecimal getPriceShipUser() {
        return priceShipUser;
    }

    public void setPriceShipUser(BigDecimal priceShipUser) {
        this.priceShipUser = priceShipUser;
    }

    public BigDecimal getPriceInstallUser() {
        return priceInstallUser;
    }

    public void setPriceInstallUser(BigDecimal priceInstallUser) {
        this.priceInstallUser = priceInstallUser;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public int getPartType() {
        return partType;
    }

    public void setPartType(int partType) {
        this.partType = partType;
    }

    public int getPriceGroup() {
        return priceGroup;
    }

    public void setPriceGroup(int priceGroup) {
        this.priceGroup = priceGroup;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public int getPriceMeasure() {
        return priceMeasure;
    }

    public void setPriceMeasure(int priceMeasure) {
        this.priceMeasure = priceMeasure;
    }

    public int getPriceUOM() {
        return priceUOM;
    }

    public void setPriceUOM(int priceUOM) {
        this.priceUOM = priceUOM;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public boolean isDiscountable() {
        return discountable;
    }

    public void setDiscountable(boolean discountable) {
        this.discountable = discountable;
    }

    public int getRadius1() {
        return radius1;
    }

    public void setRadius1(int radius1) {
        this.radius1 = radius1;
    }

    public int getCustom_leadtime() {
        return custom_leadtime;
    }

    public void setCustom_leadtime(int custom_leadtime) {
        this.custom_leadtime = custom_leadtime;
    }

    public int getRadius2() {
        return radius2;
    }

    public void setRadius2(int radius2) {
        this.radius2 = radius2;
    }

    public int getRadius1i() {
        return radius1i;
    }

    public void setRadius1i(int radius1i) {
        this.radius1i = radius1i;
    }

    public int getRadius2i() {
        return radius2i;
    }

    public void setRadius2i(int radius2i) {
        this.radius2i = radius2i;
    }

    public double getLeftAngle() {
        return leftAngle;
    }

    public void setLeftAngle(double leftAngle) {
        this.leftAngle = leftAngle;
    }

    public double getRightAngle() {
        return rightAngle;
    }

    public void setRightAngle(double rightAngle) {
        this.rightAngle = rightAngle;
    }

    public boolean isCustomPart() {
        return customPart;
    }

    public void setCustomPart(boolean customPart) {
        this.customPart = customPart;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPriceBase() {
        return priceBase;
    }

    public void setPriceBase(BigDecimal priceBase) {
        this.priceBase = priceBase;
    }

    public BigDecimal getPriceOptions() {
        return priceOptions;
    }

    public void setPriceOptions(BigDecimal priceOptions) {
        this.priceOptions = priceOptions;
    }

    public BigDecimal getPriceGlass() {
        return priceGlass;
    }

    public void setPriceGlass(BigDecimal priceGlass) {
        this.priceGlass = priceGlass;
    }

    public BigDecimal getPriceGrids() {
        return priceGrids;
    }

    public void setPriceGrids(BigDecimal priceGrids) {
        this.priceGrids = priceGrids;
    }

    public BigDecimal getPriceLabor() {
        return priceLabor;
    }

    public void setPriceLabor(BigDecimal priceLabor) {
        this.priceLabor = priceLabor;
    }

    public BigDecimal getPriceOther() {
        return priceOther;
    }

    public void setPriceOther(BigDecimal priceOther) {
        this.priceOther = priceOther;
    }

    public BigDecimal getPriceBaseUser() {
        return priceBaseUser;
    }

    public void setPriceBaseUser(BigDecimal priceBaseUser) {
        this.priceBaseUser = priceBaseUser;
    }

    public BigDecimal getPriceOptionsUser() {
        return priceOptionsUser;
    }

    public void setPriceOptionsUser(BigDecimal priceOptionsUser) {
        this.priceOptionsUser = priceOptionsUser;
    }

    public BigDecimal getPriceGlassUser() {
        return priceGlassUser;
    }

    public void setPriceGlassUser(BigDecimal priceGlassUser) {
        this.priceGlassUser = priceGlassUser;
    }

    public BigDecimal getPriceGridsUser() {
        return priceGridsUser;
    }

    public void setPriceGridsUser(BigDecimal priceGridsUser) {
        this.priceGridsUser = priceGridsUser;
    }

    public BigDecimal getPriceLaborUser() {
        return priceLaborUser;
    }

    public void setPriceLaborUser(BigDecimal priceLaborUser) {
        this.priceLaborUser = priceLaborUser;
    }

    public BigDecimal getPriceOtherUser() {
        return priceOtherUser;
    }

    public void setPriceOtherUser(BigDecimal priceOtherUser) {
        this.priceOtherUser = priceOtherUser;
    }

    public BigDecimal getCostBase() {
        return costBase;
    }

    public void setCostBase(BigDecimal costBase) {
        this.costBase = costBase;
    }

    public BigDecimal getCostOptions() {
        return costOptions;
    }

    public void setCostOptions(BigDecimal costOptions) {
        this.costOptions = costOptions;
    }

    public BigDecimal getCostGlass() {
        return costGlass;
    }

    public void setCostGlass(BigDecimal costGlass) {
        this.costGlass = costGlass;
    }

    public BigDecimal getCostGrids() {
        return costGrids;
    }

    public void setCostGrids(BigDecimal costGrids) {
        this.costGrids = costGrids;
    }

    public BigDecimal getCostLabor() {
        return costLabor;
    }

    public void setCostLabor(BigDecimal costLabor) {
        this.costLabor = costLabor;
    }

    public BigDecimal getCostShip() {
        return costShip;
    }

    public void setCostShip(BigDecimal costShip) {
        this.costShip = costShip;
    }

    public BigDecimal getCostInstall() {
        return costInstall;
    }

    public void setCostInstall(BigDecimal costInstall) {
        this.costInstall = costInstall;
    }

    public BigDecimal getCostOther() {
        return costOther;
    }

    public void setCostOther(BigDecimal costOther) {
        this.costOther = costOther;
    }

    public BigDecimal getCostBaseUser() {
        return costBaseUser;
    }

    public void setCostBaseUser(BigDecimal costBaseUser) {
        this.costBaseUser = costBaseUser;
    }

    public BigDecimal getCostOptionsUser() {
        return costOptionsUser;
    }

    public void setCostOptionsUser(BigDecimal costOptionsUser) {
        this.costOptionsUser = costOptionsUser;
    }

    public BigDecimal getCostGlassUser() {
        return costGlassUser;
    }

    public void setCostGlassUser(BigDecimal costGlassUser) {
        this.costGlassUser = costGlassUser;
    }

    public BigDecimal getCostGridsUser() {
        return costGridsUser;
    }

    public void setCostGridsUser(BigDecimal costGridsUser) {
        this.costGridsUser = costGridsUser;
    }

    public BigDecimal getCostLaborUser() {
        return costLaborUser;
    }

    public void setCostLaborUser(BigDecimal costLaborUser) {
        this.costLaborUser = costLaborUser;
    }

    public BigDecimal getCostShipUser() {
        return costShipUser;
    }

    public void setCostShipUser(BigDecimal costShipUser) {
        this.costShipUser = costShipUser;
    }

    public BigDecimal getCostInstallUser() {
        return costInstallUser;
    }

    public void setCostInstallUser(BigDecimal costInstallUser) {
        this.costInstallUser = costInstallUser;
    }

    public BigDecimal getCostOtherUser() {
        return costOtherUser;
    }

    public void setCostOtherUser(BigDecimal costOtherUser) {
        this.costOtherUser = costOtherUser;
    }

    public BigDecimal getDiscountBase() {
        return discountBase;
    }

    public void setDiscountBase(BigDecimal discountBase) {
        this.discountBase = discountBase;
    }

    public BigDecimal getDiscountOptions() {
        return discountOptions;
    }

    public void setDiscountOptions(BigDecimal discountOptions) {
        this.discountOptions = discountOptions;
    }

    public BigDecimal getDiscountGlass() {
        return discountGlass;
    }

    public void setDiscountGlass(BigDecimal discountGlass) {
        this.discountGlass = discountGlass;
    }

    public BigDecimal getDiscountGrids() {
        return discountGrids;
    }

    public void setDiscountGrids(BigDecimal discountGrids) {
        this.discountGrids = discountGrids;
    }

    public BigDecimal getDiscountLabor() {
        return discountLabor;
    }

    public void setDiscountLabor(BigDecimal discountLabor) {
        this.discountLabor = discountLabor;
    }

    public BigDecimal getDiscountShip() {
        return discountShip;
    }

    public void setDiscountShip(BigDecimal discountShip) {
        this.discountShip = discountShip;
    }

    public BigDecimal getDiscountInstall() {
        return discountInstall;
    }

    public void setDiscountInstall(BigDecimal discountInstall) {
        this.discountInstall = discountInstall;
    }

    public BigDecimal getDiscountOther() {
        return discountOther;
    }

	public void setDiscountOther(BigDecimal discountOther) {
        this.discountOther = discountOther;
    }
	
}
