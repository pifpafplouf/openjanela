package dto;

import Model.JobItemModel;
import openjanela.model.entities.design.Design;
import org.openjanela.commons.util.zip.GZipFile;
import util.ImageUtils;

import java.io.IOException;
import java.util.Date;

/**
 * Copyright (c) 2013, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 01-19-13
 * Time: 03:19 PM
 */
public class DesignDTO {

    /**
     * Return Design entity object persist
     *
     * @return Design
     * @throws DTOTransformationError, Error
     */
    public static Design getDesignEntity(JobItemModel jobItemModel) throws DTOTransformationError {

        if (jobItemModel == null) {
            throw new DTOTransformationError();
        }

        //Get Canvas original values to restore
        int c_width = jobItemModel.myCanvas.getWidth();
        int c_height = jobItemModel.myCanvas.getHeight();

        /* Prepare canvas image to take a photo */
        jobItemModel.myCanvas.setSize(700, 500);
        byte[] image = jobItemModel.myCanvas.drawToImage(false);

        // refactor the canvas to the original dimension
        jobItemModel.myCanvas.setSize(c_width, c_height);

        // Creating thumbnail image
        byte[] thumbnail = ImageUtils.createThumbnail(image, 150, 150);

        // Create predefine design
        Design design = new Design();

        design.setDescription("");
        design.setDesignFamily(-1);
        design.setPricingUOMId(jobItemModel.myParent.currentUOM);
        design.setPriceActualSize(false);
        design.setPrice(0.00); //TODO: Update this value
        design.setMatrixId(0); //TODO: Update this value
        design.setPriceGroupId(0); //TODO: Update this value
        design.setMinPrice(0.00); //TODO: Update this value
        design.setMinPricingArea(0.00); //TODO: Update this value
        design.setStartDate(new Date()); //TODO: Update this value
        design.setEndDate(new Date());  //TODO: Update this value

        try {
            design.setScaledImage(GZipFile.gzipCompress(thumbnail));
        } catch (IOException e) {
            throw new DTOTransformationError(e.getMessage(), e);
        }

        return design;
    }

}
