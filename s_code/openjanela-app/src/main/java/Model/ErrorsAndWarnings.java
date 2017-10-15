
package Model;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import Presentation.ItemFrame;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.Rules;
import openjanela.model.entities.parts.Parts;

import org.apache.log4j.Logger;

import Model.ProfileParts.Profiles;
import Rules.ExecuteRules;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: Sherif El Dibani
 * Date: 03-06-12
 * Time: 11:41 AM
 * <p/>
 * This class represents Bill of Material Model representation
 */
public class ErrorsAndWarnings implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(BillOfMat.class);

    public int a_levelID = 0;
    public int a_sequenceID = 11;
    public int a_assemblyLevel = 0;
    public int a_1Level = 0;
    public int a_1Sequence = 0;
    public int a_2Level = 0;
    public int a_2Sequence = 0;
    public int a_3Level = 0;
    public int a_3Sequence = 0;
    public int a_4Level = 0;
    public int a_4Sequence = 0;
    public int a_5Level = 0;
    public int a_5Sequence = 0;
    public int a_6Level = 0;
    public int a_6Sequence = 0;
    public int a_7Level = 0;
    public int a_7Sequence = 0;
    public int a_8Level = 0;
    public int a_8Sequence = 0;
    public int a_9Level = 0;
    public int a_9Sequence = 0;
    public int a_10Level = 0;
    public int a_10Sequence = 0;
    public int a_11Level = 0;
    public int a_11Sequence = 0;
    public int a_12Level = 0;
    public int a_12Sequence = 0;
    public int a_13Level = 0;
    public int a_13Sequence = 0;
    public int a_14Level = 0;
    public int a_14Sequence = 0;
    public int a_15Level = 0;
    public int a_15Sequence = 0;
    public int a_16Level = 0;
    public int a_16Sequence = 0;
    public int a_17Level = 0;
    public int a_17Sequence = 0;
    public int a_18Level = 0;
    public int a_18Sequence = 0;
    public int a_19Level = 0;
    public int a_19Sequence = 0;
    public int a_20Level = 0;
    public int a_20Sequence = 0;
    public int a_21Level = 0;
    public int a_21Sequence = 0;
    public int a_22Level = 0;
    public int a_22Sequence = 0;

    public int orientation = 1;
    
    public int position = 0;
    
    
    public String description = "";
    
    public int ruleId =0;

    public ErrorsAndWarnings() {}

  
    public void setShapeIdentifires(ShapeObject shape, Profiles myProfile, OrderItemsCart cart, String desc, int ruleid) {

	    description = desc;
	    
	    ruleId = ruleid;
	    
        if (shape != null && myProfile == null) {
     	   
            a_assemblyLevel = shape.a_assemblyLevel;
            a_levelID = shape.a_levelID;
            a_sequenceID = shape.a_sequenceID;
            a_1Level = shape.a_1Level;
            a_1Sequence = shape.a_1Sequence;
            a_2Level = shape.a_2Level;
            a_2Sequence = shape.a_2Sequence;
            a_3Level = shape.a_3Level;
            a_3Sequence = shape.a_3Sequence;
            a_4Level = shape.a_4Level;
            a_4Sequence = shape.a_4Sequence;
            a_5Level = shape.a_5Level;
            a_5Sequence = shape.a_5Sequence;
            a_6Level = shape.a_6Level;
            a_6Sequence = shape.a_6Sequence;
            a_7Level = shape.a_7Level;
            a_7Sequence = shape.a_7Sequence;
            a_8Level = shape.a_8Level;
            a_8Sequence = shape.a_8Sequence;
            a_9Level = shape.a_9Level;
            a_9Sequence = shape.a_9Sequence;
            a_10Level = shape.a_10Level;
            a_10Sequence = shape.a_10Sequence;
            a_11Level = shape.a_11Level;
            a_11Sequence = shape.a_11Sequence;
            a_12Level = shape.a_12Level;
            a_12Sequence = shape.a_12Sequence;
            a_13Level = shape.a_13Level;
            a_13Sequence = shape.a_13Sequence;
            a_14Level = shape.a_14Level;
            a_14Sequence = shape.a_14Sequence;
            a_15Level = shape.a_15Level;
            a_15Sequence = shape.a_15Sequence;
            a_16Level = shape.a_16Level;
            a_16Sequence = shape.a_16Sequence;
            a_17Level = shape.a_17Level;
            a_17Sequence = shape.a_17Sequence;
            a_18Level = shape.a_18Level;
            a_18Sequence = shape.a_18Sequence;
            a_19Level = shape.a_19Level;
            a_19Sequence = shape.a_19Sequence;
            a_20Level = shape.a_20Level;
            a_20Sequence = shape.a_20Sequence;
            a_21Level = shape.a_21Level;
            a_21Sequence = shape.a_21Sequence;
            a_22Level = shape.a_22Level;
            a_22Sequence = shape.a_22Sequence;
            
            orientation = 0;

        } else if (myProfile != null) {
     	   
            a_assemblyLevel = myProfile.a_assemblyLevel;
            a_levelID = myProfile.a_levelID;
            a_sequenceID = myProfile.rowCol;
            a_1Level = myProfile.a_1Level;
            a_1Sequence = myProfile.a_1Sequence;
            a_2Level = myProfile.a_2Level;
            a_2Sequence = myProfile.a_2Sequence;
            a_3Level = myProfile.a_3Level;
            a_3Sequence = myProfile.a_3Sequence;
            a_4Level = myProfile.a_4Level;
            a_4Sequence = myProfile.a_4Sequence;
            a_5Level = myProfile.a_5Level;
            a_5Sequence = myProfile.a_5Sequence;
            a_6Level = myProfile.a_6Level;
            a_6Sequence = myProfile.a_6Sequence;
            a_7Level = myProfile.a_7Level;
            a_7Sequence = myProfile.a_7Sequence;
            a_8Level = myProfile.a_8Level;
            a_8Sequence = myProfile.a_8Sequence;
            a_9Level = myProfile.a_9Level;
            a_9Sequence = myProfile.a_9Sequence;
            a_10Level = myProfile.a_10Level;
            a_10Sequence = myProfile.a_10Sequence;
            a_levelID = myProfile.levelID;
            a_11Level = myProfile.a_11Level;
            a_11Sequence = myProfile.a_11Sequence;
            a_12Level = myProfile.a_12Level;
            a_12Sequence = myProfile.a_12Sequence;
            a_13Level = myProfile.a_13Level;
            a_13Sequence = myProfile.a_13Sequence;
            a_14Level = myProfile.a_14Level;
            a_14Sequence = myProfile.a_14Sequence;
            a_15Level = myProfile.a_15Level;
            a_15Sequence = myProfile.a_15Sequence;
            a_16Level = myProfile.a_16Level;
            a_16Sequence = myProfile.a_16Sequence;
            a_17Level = myProfile.a_17Level;
            a_17Sequence = myProfile.a_17Sequence;
            a_18Level = myProfile.a_18Level;
            a_18Sequence = myProfile.a_18Sequence;
            a_19Level = myProfile.a_19Level;
            a_19Sequence = myProfile.a_19Sequence;
            a_20Level = myProfile.a_20Level;
            a_20Sequence = myProfile.a_20Sequence;
            a_21Level = myProfile.a_21Level;
            a_21Sequence = myProfile.a_21Sequence;
            a_22Level = myProfile.a_22Level;
            a_22Sequence = myProfile.a_22Sequence;
            
            orientation = myProfile.orientation;
            
            position = myProfile.posCondition;
            
           
            
        }
        
    }

    public boolean isForShape(ShapeObject shape) {

        boolean match = false;

        if (shape.a_assemblyLevel == this.a_assemblyLevel && shape.a_1Level == a_1Level && shape.a_2Level == a_2Level
                && shape.a_3Level == a_3Level && shape.a_4Level == a_4Level && shape.a_5Level == a_5Level
                && shape.a_6Level == a_6Level && shape.a_7Level == a_7Level && shape.a_8Level == a_8Level
                && shape.a_9Level == a_9Level && shape.a_10Level == a_10Level && shape.a_11Level == a_11Level
                && shape.a_12Level == a_12Level && shape.a_13Level == a_13Level && shape.a_14Level == a_14Level
                && shape.a_15Level == a_15Level && shape.a_16Level == a_16Level && shape.a_17Level == a_17Level
                && shape.a_18Level == a_18Level && shape.a_19Level == a_19Level && shape.a_20Level == a_20Level
                && shape.a_21Level == a_21Level && shape.a_22Level == a_22Level
                && shape.a_sequenceID == this.a_sequenceID && shape.a_1Sequence == a_1Sequence
                && shape.a_2Sequence == a_2Sequence && shape.a_3Sequence == a_3Sequence
                && shape.a_4Sequence == a_4Sequence && shape.a_5Sequence == a_5Sequence
                && shape.a_6Sequence == a_6Sequence && shape.a_7Sequence == a_7Sequence
                && shape.a_8Sequence == a_8Sequence && shape.a_9Sequence == a_9Sequence
                && shape.a_10Sequence == a_10Sequence && shape.a_11Sequence == a_11Sequence
                && shape.a_12Sequence == a_12Sequence && shape.a_13Sequence == a_13Sequence
                && shape.a_14Sequence == a_14Sequence && shape.a_15Sequence == a_15Sequence
                && shape.a_16Sequence == a_16Sequence && shape.a_17Sequence == a_17Sequence
                && shape.a_18Sequence == a_18Sequence && shape.a_19Sequence == a_19Sequence
                && shape.a_20Sequence == a_20Sequence && shape.a_21Sequence == a_21Sequence
                && shape.a_22Sequence == a_22Sequence) {

            match = true;

        }
        return match;
    }

    public boolean isMatchingPart(Profiles part) {

	        boolean match = false;
	        int partPosition = 0;

	        if (this.a_assemblyLevel > 30 && this.a_assemblyLevel < 40) {
	            partPosition = 10 + part.cOrM;

	            if (part.a_assemblyLevel == this.a_assemblyLevel && part.a_1Level == a_1Level && part.a_2Level == a_2Level
	                    && part.a_3Level == a_3Level && part.a_4Level == a_4Level && part.a_5Level == a_5Level
	                    && part.a_6Level == a_6Level && part.a_7Level == a_7Level && part.a_8Level == a_8Level
	                    && part.a_9Level == a_9Level && part.a_10Level == a_10Level && part.a_11Level == a_11Level
	                    && part.a_12Level == a_12Level && part.a_13Level == a_13Level && part.a_14Level == a_14Level
	                    && part.a_15Level == a_15Level && part.a_16Level == a_16Level && part.a_17Level == a_17Level
	                    && part.a_18Level == a_18Level && part.a_19Level == a_19Level && part.a_20Level == a_20Level
	                    && part.a_21Level == a_21Level && part.a_22Level == a_22Level
	                    && part.a_sequenceID == this.a_sequenceID && part.a_1Sequence == a_1Sequence
	                    && part.a_2Sequence == a_2Sequence && part.a_3Sequence == a_3Sequence
	                    && part.a_4Sequence == a_4Sequence && part.a_5Sequence == a_5Sequence
	                    && part.a_6Sequence == a_6Sequence && part.a_7Sequence == a_7Sequence
	                    && part.a_8Sequence == a_8Sequence && part.a_9Sequence == a_9Sequence
	                    && part.a_10Sequence == a_10Sequence && part.a_11Sequence == a_11Sequence
	                    && part.a_12Sequence == a_12Sequence && part.a_13Sequence == a_13Sequence
	                    && part.a_14Sequence == a_14Sequence && part.a_15Sequence == a_15Sequence
	                    && part.a_16Sequence == a_16Sequence && part.a_17Sequence == a_17Sequence
	                    && part.a_18Sequence == a_18Sequence && part.a_19Sequence == a_19Sequence
	                    && part.a_20Sequence == a_20Sequence && part.a_21Sequence == a_21Sequence
	                    && part.a_22Sequence == a_22Sequence && this.position == partPosition
	                    && this.orientation == part.orientation) {

	                match = true;

	            }
	        } else if (part.cOrM != 7) {

	            if (part.a_assemblyLevel == this.a_assemblyLevel && part.a_1Level == a_1Level
	                    && part.a_2Level == a_2Level && part.a_3Level == a_3Level && part.a_4Level == a_4Level
	                    && part.a_5Level == a_5Level && part.a_6Level == a_6Level && part.a_7Level == a_7Level
	                    && part.a_8Level == a_8Level && part.a_9Level == a_9Level && part.a_10Level == a_10Level
	                    && part.a_11Level == a_11Level && part.a_12Level == a_12Level && part.a_13Level == a_13Level
	                    && part.a_14Level == a_14Level && part.a_15Level == a_15Level && part.a_16Level == a_16Level
	                    && part.a_17Level == a_17Level && part.a_18Level == a_18Level && part.a_19Level == a_19Level
	                    && part.a_20Level == a_20Level
	                    && part.a_21Level == a_21Level && part.a_22Level == a_22Level && part.a_sequenceID == this.a_sequenceID
	                    && part.a_1Sequence == a_1Sequence && part.a_2Sequence == a_2Sequence && part.a_3Sequence == a_3Sequence
	                    && part.a_4Sequence == a_4Sequence && part.a_5Sequence == a_5Sequence && part.a_6Sequence == a_6Sequence
	                    && part.a_7Sequence == a_7Sequence && part.a_8Sequence == a_8Sequence && part.a_9Sequence == a_9Sequence
	                    && part.a_10Sequence == a_10Sequence && part.a_11Sequence == a_11Sequence
	                    && part.a_12Sequence == a_12Sequence && part.a_13Sequence == a_13Sequence
	                    && part.a_14Sequence == a_14Sequence && part.a_15Sequence == a_15Sequence
	                    && part.a_16Sequence == a_16Sequence && part.a_17Sequence == a_17Sequence
	                    && part.a_18Sequence == a_18Sequence && part.a_19Sequence == a_19Sequence
	                    && part.a_20Sequence == a_20Sequence && part.a_21Sequence == a_21Sequence
	                    && part.a_22Sequence == a_22Sequence) {

	                match = true;

	            }

	        } else if (part.cOrM == 7) {

	            if (part.a_assemblyLevel == this.a_assemblyLevel && part.a_1Level == a_1Level && part.a_2Level == a_2Level
	                    && part.a_3Level == a_3Level && part.a_4Level == a_4Level && part.a_5Level == a_5Level
	                    && part.a_6Level == a_6Level && part.a_7Level == a_7Level && part.a_8Level == a_8Level
	                    && part.a_9Level == a_9Level && part.a_10Level == a_10Level && part.a_11Level == a_11Level
	                    && part.a_12Level == a_12Level && part.a_13Level == a_13Level && part.a_14Level == a_14Level
	                    && part.a_15Level == a_15Level && part.a_16Level == a_16Level && part.a_17Level == a_17Level
	                    && part.a_18Level == a_18Level && part.a_19Level == a_19Level && part.a_20Level == a_20Level
	                    && part.a_21Level == a_21Level && part.a_22Level == a_22Level
	                    && part.a_sequenceID == this.a_sequenceID && part.a_1Sequence == a_1Sequence
	                    && part.a_2Sequence == a_2Sequence && part.a_3Sequence == a_3Sequence
	                    && part.a_4Sequence == a_4Sequence && part.a_5Sequence == a_5Sequence
	                    && part.a_6Sequence == a_6Sequence && part.a_7Sequence == a_7Sequence
	                    && part.a_8Sequence == a_8Sequence && part.a_9Sequence == a_9Sequence
	                    && part.a_10Sequence == a_10Sequence && part.a_11Sequence == a_11Sequence
	                    && part.a_12Sequence == a_12Sequence && part.a_13Sequence == a_13Sequence
	                    && part.a_14Sequence == a_14Sequence && part.a_15Sequence == a_15Sequence
	                    && part.a_16Sequence == a_16Sequence && part.a_17Sequence == a_17Sequence
	                    && part.a_18Sequence == a_18Sequence && part.a_19Sequence == a_19Sequence
	                    && part.a_20Sequence == a_20Sequence && part.a_21Sequence == a_21Sequence
	                    && part.a_22Sequence == a_22Sequence && part.orientation == orientation
	                    && part.posCondition == position) {

	                match = true;

	            }

	        }

	        return match;
	    }
    
    @Override
    public String toString() {
        return description;
    }
    
    public ErrorsAndWarnings  clone(){
	    
	    ErrorsAndWarnings myClone = new ErrorsAndWarnings();
 
     	   myClone.description = description;
     	   
     	   myClone.ruleId = ruleId;
     	   
     	   myClone.orientation = orientation;
     	   
     	   myClone.a_assemblyLevel =  a_assemblyLevel;
     	   myClone.a_levelID =  a_levelID;
     	   myClone.a_sequenceID =  a_sequenceID;
     	   myClone.a_1Level =  a_1Level;
     	   myClone.a_1Sequence =  a_1Sequence;
     	   myClone.a_2Level =  a_2Level;
     	   myClone.a_2Sequence =  a_2Sequence;
     	   myClone.a_3Level =  a_3Level;
     	   myClone.a_3Sequence =  a_3Sequence;
     	   myClone.a_4Level =  a_4Level;
     	   myClone.a_4Sequence =  a_4Sequence;
     	   myClone.a_5Level =  a_5Level;
     	   myClone.a_5Sequence =  a_5Sequence;
     	   myClone.a_6Level =  a_6Level;
     	   myClone.a_6Sequence =  a_6Sequence;
     	   myClone.a_7Level =  a_7Level;
     	   myClone.a_7Sequence =  a_7Sequence;
     	   myClone.a_8Level =  a_8Level;
     	   myClone.a_8Sequence =  a_8Sequence;
     	   myClone.a_9Level =  a_9Level;
     	   myClone.a_9Sequence =  a_9Sequence;
     	   myClone.a_10Level =  a_10Level;
     	   myClone.a_10Sequence =  a_10Sequence;
     	   myClone.a_11Level =  a_11Level;
     	   myClone.a_11Sequence =  a_11Sequence;
     	   myClone.a_12Level =  a_12Level;
     	   myClone.a_12Sequence =  a_12Sequence;
     	   myClone.a_13Level =  a_13Level;
     	   myClone.a_13Sequence =  a_13Sequence;
     	   myClone.a_14Level =  a_14Level;
     	   myClone.a_14Sequence =  a_14Sequence;
     	   myClone.a_15Level =  a_15Level;
     	   myClone.a_15Sequence =  a_15Sequence;
     	   myClone.a_16Level =  a_16Level;
     	   myClone.a_16Sequence =  a_16Sequence;
     	   myClone.a_17Level =  a_17Level;
     	   myClone.a_17Sequence =  a_17Sequence;
     	   myClone.a_18Level =  a_18Level;
     	   myClone.a_18Sequence =  a_18Sequence;
     	   myClone.a_19Level =  a_19Level;
     	   myClone.a_19Sequence =  a_19Sequence;
     	   myClone.a_20Level =  a_20Level;
     	   myClone.a_20Sequence =  a_20Sequence;
     	   myClone.a_21Level =  a_21Level;
     	   myClone.a_21Sequence =  a_21Sequence;
     	   myClone.a_22Level =  a_22Level;
     	   myClone.a_22Sequence =  a_22Sequence;
            
	    return myClone;
    }
  
}


