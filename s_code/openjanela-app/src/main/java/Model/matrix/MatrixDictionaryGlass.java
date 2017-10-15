package Model.matrix;

import java.math.BigDecimal;

/**
 * Copyright (c) 2009, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-28-12
 * Time: 12:12 AM
 * Matrix Diccionary glass implementation only for GlassSU
 */
public interface MatrixDictionaryGlass {

    /**
     * Return SU Identification ID from GlassSU
     *
     * @return BigDecimal
     * @see openjanela.model.entities.partner.TypeMatrixDiccionary #6
     */
    public BigDecimal returnGlassSUID();
}
