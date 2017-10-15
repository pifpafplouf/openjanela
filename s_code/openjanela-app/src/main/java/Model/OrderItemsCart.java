/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;

import openjanela.model.entities.orderEntry.OrderItemsCartOption;
import openjanela.model.entities.partner.OptionDefinitions;
import openjanela.model.entities.partner.RuleTest;
import openjanela.model.entities.partner.RuleTestValue;


/**
 * @author Sherif
 */

public class OrderItemsCart implements Serializable {
	
	
	public int orderId = 0;
	
	public int itemId = 0;
	
	public int versionId = 1;
	
	
	public int typeId = 0;
	
	
	public boolean active = true;
	
	
	public boolean deleted = false;
	
	
	public int partid = 0;
	
	
	public String description = "";
	
	
	public int quantity = 1;
	
	
	public int width = 0;
	
	
	public int widthI = 0;
	
	
	public int height = 0;
	
	
	public int heightI = 0;
	
	
	public int roWidth = 0;
	
	
	public int roWidhtI = 0;
	
	
	public int roHieght = 0;
	
	
	public int roHieghtI = 0;
	
	
	public int size = 0;
	
	
	public int sizeI = 0;
	
	
	public String reference = "";
	
	
	public int locationId = 0;
	
	
	public String locationText = "";
	
	
	public byte[] image = new byte[0];
	
	
	public int supplierId = 0;
	
	
	public int seriesId = 0;
	
	
	public String notes;
	
	
	public byte[] thumbnail = new byte[0];
	
	
	public int roAdjustmentId = 0;
	
	
	public int hsAdjustmentId = 0;
	
	
	public BigDecimal cost = new BigDecimal(0);
	
	
	public BigDecimal price = new BigDecimal(0);
	
	
	public int shipqty = 0;
	
	
	public int init = 0;
	
	
	public int done = 0;
	
	
	public int inprocess = 0;
	
	
	public int widthFlat = 0;
	
	
	public int heightFlat = 0;
	
	@Column(name = "width_flat_i")
	public int widthFlatI = 0;
	
	
	public int heightFlatI = 0;
	
	
	public int widthOut = 0;
	
	
	public int widthOutI = 0;
	
	
	public int widthIn = 0;
	
	
	public int widthInI = 0;
	
	
	public int gap = 0;
	
	
	public int gapI = 0;
	
	
	public int openingWidth = 0;
	
	
	public int openingWidthI = 0;
	
	
	public int depth = 0;
	
	
	public int depthI = 0;
	
	
	public int extension = 0;
	
	
	public int extensionI = 0;
	
	
	public int projectionIn = 0;
	
	
	public int projectionInI = 0;
	
	
	public int projectionOut = 0;
	
	
	public int projectionOutI = 0;
	
	
	public int angle = 0;
	
	
	public int unitWidth = 0;
	
	
	public int unitWidthI = 0;
	
	
	public int centerUnit = 0;
	
	
	public int centerUnitI = 0;
	
	
	public int measure = 0;
	
	
	public double metricscale = 0;
	
	
	public double imperialscale = 0;
	
	@Column(name = "price_user")
	public final BigDecimal price_user = new BigDecimal(0);
	
	
	public final BigDecimal price_ship = new BigDecimal(0);
	
	
	public final BigDecimal price_install = new BigDecimal(0);
	
	
	public final BigDecimal price_ship_user = new BigDecimal(0);
	
	
	public final BigDecimal price_install_user = new BigDecimal(0);
	
	
	public final String stockcode = "";
	
	
	public final int part_type = 1;
	
	
	public final int price_group = 1;
	
	
	public final BigDecimal totalprice = new BigDecimal(0);
	
	
	public final BigDecimal totalcost = new BigDecimal(0);
	
	
	public final double discount = 0.0;
	
	
	public final int pricemeasure = 0;
	
	
	public final int priceuom = 0;
	
	
	public boolean taxable;
	
	
	public boolean discountable;
	
	
	public int radius1;
	
	
	public int radius2;
	
	
	public int radius1i;
	
	
	public int radius2i;
	
	
	public double leftangle;
	
	
	public double rightangle;
	
	
	public boolean custompart;
	
	public Collection bom = new ArrayList();
	
	public Collection glass = new ArrayList();
	
	Collection<OrderItemsCartOption> options = new ArrayList();
	
	public OrderItemsCart() {
		
	}
	
	
	public int getTypeId() {
		
		return typeId;
	}
	
	public void setTypeId(int typeId) {
		
		this.typeId = typeId;
	}
	
	public boolean getActive() {
		
		return active;
	}
	
	public void setActive(boolean active) {
		
		this.active = active;
	}
	
	public boolean getDeleted() {
		
		return deleted;
	}
	
	public void setDeleted(boolean deleted) {
		
		this.deleted = deleted;
	}
	
	public int getPartid() {
		
		return partid;
	}
	
	public void setPartid(int partid) {
		
		this.partid = partid;
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
	
	public int getRoHieght() {
		
		return roHieght;
	}
	
	public void setRoHieght(int roHieght) {
		
		this.roHieght = roHieght;
	}
	
	public int getRoHieghtI() {
		
		return roHieghtI;
	}
	
	public void setRoHieghtI(int roHieghtI) {
		
		this.roHieghtI = roHieghtI;
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
	
	public BigDecimal getCost() {
		
		return cost;
	}
	
	public void setCost(BigDecimal cost) {
		
		this.cost = cost;
	}
	
	public BigDecimal getPrice() {
		
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		
		this.price = price;
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
	
	public int getBaseUom() {
		
		return measure;
	}
	
	public void setBaseUom(int bu) {
		
		this.measure = bu;
	}
	
	public double getMetricScale() {
		
		return metricscale;
	}
	
	public void setMetricScale(double ms) {
		
		this.metricscale = ms;
	}
	
	public double getImperialScale() {
		
		return metricscale;
	}
	
	public void setImperialScale(double is) {
		
		this.imperialscale = is;
	}
	
	
	@Override
	public String toString() {
		
		return description;
	}
	
	public boolean lengthTest(RuleTest test, int condition, int myUOM, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			if (condition != 4) {
				if (myUOM == 1) {
					
					pass = isWithinRange(test.value1, test.value2, this.size);
					
				} else {
					
					pass = isWithinRange(test.value1i, test.value2i, sizeI);
					
				}
				
			} else
				// Nominal <--- ---> condition 4
			{
				if (myUOM == 1) {
					pass = isWithinRange(test.value1, test.value2, size);
					
				} else {
					
					pass = isWithinRange(test.value1i, test.value2i, sizeI);
					
				}
			}
			
		} else {
			
			if (condition != 4) {
				if (myUOM == 1) {
					
					pass = isWithinValues(size, myUOM, myRuleTestValues.toArray());
					
				} else {
					
					pass = isWithinValues(sizeI, myUOM, myRuleTestValues.toArray());
					
				}
				
			} else {// Nominal <--- ---> Condition == 4
				if (myUOM == 1) {
					
					pass = isWithinValues(size, myUOM, myRuleTestValues.toArray());
					
				} else {
					
					pass = isWithinValues(sizeI, myUOM, myRuleTestValues.toArray());
					
				}
				
			}
			
		}
		
		/**
		 * 1,0,Overall,1 2,1,Facet,1 3,3,Frame,1 4,121,Sash Type,1 5,12,Sash,1
		 * 6,21,Glass/Glazing,1 7,0,Glazing Bead,1 8,22,DLO,1 20,5,Bkgrd
		 * Opening,1 30,0,Divider,1 31,2,Coupler,1 32,4,Mullion,1 32,0,Grids,1
		 * 40,5,Opening,1 200,1,Sub-Facet,1 400,121,Sub-Sash,1 902,0,Object,2
		 * 903,0,Object,3 904,0,Object,4 905,0,Object,5 906,0,Object,6
		 * 907,0,Object,7
		 */
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean widthTest(RuleTest test, int condition, int myUOM, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			if (condition != 4) {
				if (myUOM == 1) {
					
					pass = isWithinRange(test.value1, test.value2, this.width);
					
				} else {
					
					pass = isWithinRange(test.value1i, test.value2i, widthI);
					
				}
				
			} else
				// Nominal <--- ---> condition 4
			{
				if (myUOM == 1) {
					pass = isWithinRange(test.value1, test.value2, width);
					
				} else {
					
					pass = isWithinRange(test.value1i, test.value2i, widthI);
					
				}
			}
			
		} else {
			
			if (condition != 4) {
				if (myUOM == 1) {
					
					pass = isWithinValues(width, myUOM, myRuleTestValues.toArray());
					
				} else {
					
					pass = isWithinValues(widthI, myUOM, myRuleTestValues.toArray());
					
				}
				
			} else {// Nominal <--- ---> Condition == 4
				if (myUOM == 1) {
					
					pass = isWithinValues(width, myUOM, myRuleTestValues.toArray());
					
				} else {
					
					pass = isWithinValues(widthI, myUOM, myRuleTestValues.toArray());
					
				}
				
			}
			
		}
		
		/**
		 * 1,0,Overall,1 2,1,Facet,1 3,3,Frame,1 4,121,Sash Type,1 5,12,Sash,1
		 * 6,21,Glass/Glazing,1 7,0,Glazing Bead,1 8,22,DLO,1 20,5,Bkgrd
		 * Opening,1 30,0,Divider,1 31,2,Coupler,1 32,4,Mullion,1 32,0,Grids,1
		 * 40,5,Opening,1 200,1,Sub-Facet,1 400,121,Sub-Sash,1 902,0,Object,2
		 * 903,0,Object,3 904,0,Object,4 905,0,Object,5 906,0,Object,6
		 * 907,0,Object,7
		 */
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean heightTest(RuleTest test, int condition, int myUOM, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			if (condition != 4) {
				if (myUOM == 1) {
					
					pass = isWithinRange(test.value1, test.value2, this.height);
					
				} else {
					
					pass = isWithinRange(test.value1i, test.value2i, heightI);
					
				}
				
			} else
				// Nominal <--- ---> condition 4
			{
				if (myUOM == 1) {
					pass = isWithinRange(test.value1, test.value2, height);
					
				} else {
					
					pass = isWithinRange(test.value1i, test.value2i, heightI);
					
				}
			}
			
		} else {
			
			if (condition != 4) {
				if (myUOM == 1) {
					
					pass = isWithinValues(height, myUOM, myRuleTestValues.toArray());
					
				} else {
					
					pass = isWithinValues(heightI, myUOM, myRuleTestValues.toArray());
					
				}
				
			} else {// Nominal <--- ---> Condition == 4
				if (myUOM == 1) {
					
					pass = isWithinValues(height, myUOM, myRuleTestValues.toArray());
					
				} else {
					
					pass = isWithinValues(heightI, myUOM, myRuleTestValues.toArray());
					
				}
				
			}
			
		}
		
		/**
		 * 1,0,Overall,1 2,1,Facet,1 3,3,Frame,1 4,121,Sash Type,1 5,12,Sash,1
		 * 6,21,Glass/Glazing,1 7,0,Glazing Bead,1 8,22,DLO,1 20,5,Bkgrd
		 * Opening,1 30,0,Divider,1 31,2,Coupler,1 32,4,Mullion,1 32,0,Grids,1
		 * 40,5,Opening,1 200,1,Sub-Facet,1 400,121,Sub-Sash,1 902,0,Object,2
		 * 903,0,Object,3 904,0,Object,4 905,0,Object,5 906,0,Object,6
		 * 907,0,Object,7
		 */
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean depthTest(RuleTest test, int condition, int myUOM, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			if (condition != 4) {
				if (myUOM == 1) {
					
					pass = isWithinRange(test.value1, test.value2, this.depth);
					
				} else {
					
					pass = isWithinRange(test.value1i, test.value2i, depthI);
					
				}
				
			} else
				// Nominal <--- ---> condition 4
			{
				if (myUOM == 1) {
					pass = isWithinRange(test.value1, test.value2, depth);
					
				} else {
					
					pass = isWithinRange(test.value1i, test.value2i, depthI);
					
				}
			}
			
		} else {
			
			if (condition != 4) {
				if (myUOM == 1) {
					
					pass = isWithinValues(depth, myUOM, myRuleTestValues.toArray());
					
				} else {
					
					pass = isWithinValues(depthI, myUOM, myRuleTestValues.toArray());
					
				}
				
			} else {// Nominal <--- ---> Condition == 4
				if (myUOM == 1) {
					
					pass = isWithinValues(depth, myUOM, myRuleTestValues.toArray());
					
				} else {
					
					pass = isWithinValues(depthI, myUOM, myRuleTestValues.toArray());
					
				}
				
			}
			
		}
		
		/**
		 * 1,0,Overall,1 2,1,Facet,1 3,3,Frame,1 4,121,Sash Type,1 5,12,Sash,1
		 * 6,21,Glass/Glazing,1 7,0,Glazing Bead,1 8,22,DLO,1 20,5,Bkgrd
		 * Opening,1 30,0,Divider,1 31,2,Coupler,1 32,4,Mullion,1 32,0,Grids,1
		 * 40,5,Opening,1 200,1,Sub-Facet,1 400,121,Sub-Sash,1 902,0,Object,2
		 * 903,0,Object,3 904,0,Object,4 905,0,Object,5 906,0,Object,6
		 * 907,0,Object,7
		 */
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean qtyTest(RuleTest test, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			
			pass = isWithinRange(test.value1, test.value2, this.quantity);
			
		} else {
			
			pass = isWithinValues(quantity, 0, myRuleTestValues.toArray());
			
		}
		
		/**
		 * 1,0,Overall,1 2,1,Facet,1 3,3,Frame,1 4,121,Sash Type,1 5,12,Sash,1
		 * 6,21,Glass/Glazing,1 7,0,Glazing Bead,1 8,22,DLO,1 20,5,Bkgrd
		 * Opening,1 30,0,Divider,1 31,2,Coupler,1 32,4,Mullion,1 32,0,Grids,1
		 * 40,5,Opening,1 200,1,Sub-Facet,1 400,121,Sub-Sash,1 902,0,Object,2
		 * 903,0,Object,3 904,0,Object,4 905,0,Object,5 906,0,Object,6
		 * 907,0,Object,7
		 */
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean volumeTest(RuleTest test, int condition, int myUOM, List myRuleTestValues) {
		
		boolean pass = false;
		double volume = 0;
		if (test.isrange) {
			
			if (myUOM == 1) {
				
				volume = (width / 100 / 1000 * height / 100 / 1000 * depth / 100 / 1000);
				
				pass = isWithinRange(test.value1, test.value2, volume);
				
			} else {
				
				volume = (widthI / 100 / 1000 * heightI / 100 / 1000 * depthI / 100 / 1000);
				
				pass = isWithinRange(test.value1i, test.value2i, volume);
				
			}
			
		} else {
			
			if (myUOM == 1) {
				
				volume = (width / 100 / 1000 * height / 100 / 1000 * depth / 100 / 1000);
				
				pass = isWithinValues(volume, myUOM, myRuleTestValues.toArray());
				
			} else {
				
				volume = (widthI / 64 / 12 * heightI / 64 / 12 * depthI / 64 / 12);
				pass = isWithinValues(volume, myUOM, myRuleTestValues.toArray());
				
			}
			
		}
		
		/**
		 * 1,0,Overall,1 2,1,Facet,1 3,3,Frame,1 4,121,Sash Type,1 5,12,Sash,1
		 * 6,21,Glass/Glazing,1 7,0,Glazing Bead,1 8,22,DLO,1 20,5,Bkgrd
		 * Opening,1 30,0,Divider,1 31,2,Coupler,1 32,4,Mullion,1 32,0,Grids,1
		 * 40,5,Opening,1 200,1,Sub-Facet,1 400,121,Sub-Sash,1 902,0,Object,2
		 * 903,0,Object,3 904,0,Object,4 905,0,Object,5 906,0,Object,6
		 * 907,0,Object,7
		 */
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean areaTest(RuleTest test, int condition, int myUOM, List myRuleTestValues) {
		
		boolean pass = false;
		double area = 0;
		if (test.isrange) {
			
			if (myUOM == 1) {
				
				area = (width / 100 / 1000 * height / 100 / 1000);
				
				pass = isWithinRange(test.value1, test.value2, area);
				
			} else {
				
				area = (widthI / 100 / 1000 * heightI / 100 / 1000);
				
				pass = isWithinRange(test.value1i, test.value2i, area);
				
			}
			
		} else {
			
			if (myUOM == 1) {
				
				area = (width / 100 / 1000 * height / 100 / 1000);
				
				pass = isWithinValues(area, myUOM, myRuleTestValues.toArray());
				
			} else {
				
				area = (widthI / 64 / 12 * heightI / 64 / 12);
				pass = isWithinValues(area, myUOM, myRuleTestValues.toArray());
				
			}
			
		}
		
		/**
		 * 1,0,Overall,1 2,1,Facet,1 3,3,Frame,1 4,121,Sash Type,1 5,12,Sash,1
		 * 6,21,Glass/Glazing,1 7,0,Glazing Bead,1 8,22,DLO,1 20,5,Bkgrd
		 * Opening,1 30,0,Divider,1 31,2,Coupler,1 32,4,Mullion,1 32,0,Grids,1
		 * 40,5,Opening,1 200,1,Sub-Facet,1 400,121,Sub-Sash,1 902,0,Object,2
		 * 903,0,Object,3 904,0,Object,4 905,0,Object,5 906,0,Object,6
		 * 907,0,Object,7
		 */
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean uiTest(RuleTest test, int condition, int myUOM, List myRuleTestValues) {
		
		boolean pass = false;
		double ui = 0;
		if (test.isrange) {
			
			if (myUOM == 1) {
				
				ui = (width / 100 / 1000 + height / 100 / 1000);
				
				pass = isWithinRange(test.value1, test.value2, ui);
				
			} else {
				
				ui = (widthI / 100 / 1000 + heightI / 100 / 1000);
				
				pass = isWithinRange(test.value1i, test.value2i, ui);
				
			}
			
		} else {
			
			if (myUOM == 1) {
				
				ui = (width / 100 / 1000 + height / 100 / 1000);
				
				pass = isWithinValues(ui, myUOM, myRuleTestValues.toArray());
				
			} else {
				
				ui = (widthI / 64 / 12 + heightI / 64 / 12);
				pass = isWithinValues(ui, myUOM, myRuleTestValues.toArray());
				
			}
			
		}
		
		/**
		 * 1,0,Overall,1 2,1,Facet,1 3,3,Frame,1 4,121,Sash Type,1 5,12,Sash,1
		 * 6,21,Glass/Glazing,1 7,0,Glazing Bead,1 8,22,DLO,1 20,5,Bkgrd
		 * Opening,1 30,0,Divider,1 31,2,Coupler,1 32,4,Mullion,1 32,0,Grids,1
		 * 40,5,Opening,1 200,1,Sub-Facet,1 400,121,Sub-Sash,1 902,0,Object,2
		 * 903,0,Object,3 904,0,Object,4 905,0,Object,5 906,0,Object,6
		 * 907,0,Object,7
		 */
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean optionTest(RuleTest test, int myUOM, List myRuleTestValues, OptionDefinitions myOption)
	{
		
		boolean pass = false;
		
		Object[] options = this.options.toArray();
		
		
		for (Object op : options) {
			
			if (((OrderItemsCartOption) op).optionid == myOption.getId()) {
				
				if (myOption.getOptiontypeid() == 1) {// Answer
					if (test.isrange) {
						pass = isWithinRange(test.value1, test.value2, ((OrderItemsCartOption) op).answerid);
					} else {
						pass = isWithinValues(((OrderItemsCartOption) op).answerid, myUOM, myRuleTestValues.toArray());
					}
					
				} else if (myOption.getOptiontypeid() == 2) {// Color
					
					if (test.isrange) {
						pass = isWithinRange(test.value1, test.value2, ((OrderItemsCartOption) op).answerid);
					} else {
						pass = isWithinValues(((OrderItemsCartOption) op).answerid, myUOM, myRuleTestValues.toArray());
					}
				} else if (myOption.getOptiontypeid() == 3) {// quantity
					
					if (test.isrange) {
						pass = isWithinRange(test.value1, test.value2, ((OrderItemsCartOption) op).qtyanswer);
					} else {
						pass = isWithinValues(((OrderItemsCartOption) op).qtyanswer, myUOM, myRuleTestValues.toArray());
					}
				} else if (myOption.getOptiontypeid() == 4) {// size
					if (test.isrange) {
						if (myUOM == 1) {
							pass = isWithinRange(test.value1, test.value2, ((OrderItemsCartOption) op).sizeanswer);
						} else {
							pass = isWithinRange(test.value1, test.value2, ((OrderItemsCartOption) op).sizeansweri);
						}
					} else {
						if (myUOM == 1) {
							pass = isWithinValues(((OrderItemsCartOption) op).sizeanswer, myUOM, myRuleTestValues.toArray());
						} else {
							pass = isWithinValues(((OrderItemsCartOption) op).sizeansweri, myUOM, myRuleTestValues.toArray());
						}
					}
					
				} else if (myOption.getOptiontypeid() == 5) {// depth
					if (test.isrange) {
						if (myUOM == 1) {
							pass = isWithinRange(test.value1, test.value2, ((OrderItemsCartOption) op).depthanswer);
						} else {
							pass = isWithinRange(test.value1, test.value2, ((OrderItemsCartOption) op).depthansweri);
						}
					} else {
						if (myUOM == 1) {
							pass = isWithinValues(((OrderItemsCartOption) op).depthanswer, myUOM, myRuleTestValues.toArray());
						} else {
							pass = isWithinValues(((OrderItemsCartOption) op).depthansweri, myUOM, myRuleTestValues.toArray());
						}
					}
				} else if (myOption.getOptiontypeid() == 6) {// text
					
				} else if (myOption.getOptiontypeid() == 7) {// adjust +/-
					if (test.isrange) {
						if (myUOM == 1) {
							pass = isWithinRange(test.value1, test.value2, ((OrderItemsCartOption) op).adjust);
						} else {
							pass = isWithinRange(test.value1, test.value2, ((OrderItemsCartOption) op).adjusti);
						}
					} else {
						if (myUOM == 1) {
							pass = isWithinValues(((OrderItemsCartOption) op).adjust, myUOM, myRuleTestValues.toArray());
						} else {
							pass = isWithinValues(((OrderItemsCartOption) op).adjusti, myUOM, myRuleTestValues.toArray());
						}
					}
				}
			}
		}
		
		return pass;
	}
	
	public boolean radius1Test(RuleTest test, int uom, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, this.radius1);
			
		} else {
			pass = isWithinValues(this.radius1, 0, myRuleTestValues.toArray());
			
		}
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean radius2Test(RuleTest test, int uom, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, this.radius2);
			
		} else {
			pass = isWithinValues(this.radius2, 0, myRuleTestValues.toArray());
			
		}
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean isWithinRange(double value1, double value2, double value) {
		
		return value >= value1 && value <= value2;
	}
	
	public boolean isWithinValues(double value, int myUOM, Object[] objects) {
		
		boolean pass = false;
		if (myUOM == 1) {
			for (Object tv : objects) {
				if (((RuleTestValue) tv).getRuleTestValuePK().getValue() == value) {
					pass = true;
					break;
				}
			}
			
		} else {
			for (Object tv : objects) {
				if (((RuleTestValue) tv).getRuleTestValuePK().getValuei() == value) {
					pass = true;
					break;
				}
			}
		}
		return pass;
	}
	
	
}
