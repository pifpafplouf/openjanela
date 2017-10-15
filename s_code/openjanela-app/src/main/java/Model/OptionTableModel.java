package Model;


import Presentation.ItemFrame;
import Presentation.OptionChoiceColumns;

import javax.swing.table.AbstractTableModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

public class OptionTableModel extends AbstractTableModel {

    public OptionChoiceColumns m_columns[] = {
            new OptionChoiceColumns("", 0, 2),
            new OptionChoiceColumns("", 0, 2),
            new OptionChoiceColumns("Option", 30, 2),
            new OptionChoiceColumns("Answer", 30, 2),
            new OptionChoiceColumns("Price", 5, 4)
    };

    public ItemFrame myFrame2;
    public Vector m_vector = new Vector();


    public OptionTableModel(
            ItemFrame myParent, Vector options) {

        double myp = 0.0D;

        myFrame2 = myParent;


        ArrayList myInfo = new ArrayList();


        m_vector = options;


    }

    @Override
    public int getColumnCount() {

        return m_columns.length;

    }

    public DesignOption getOption(int nrow) {

        DesignOption datarow = new DesignOption();

        datarow = (DesignOption) m_vector.elementAt(nrow);

        return datarow;
    }

    @Override
    public Object getValueAt(int nrow, int ncol) {

        DecimalFormat twoDecimal = new DecimalFormat("0.00");

        if (nrow < 0 || nrow >= getRowCount()) {

            return "";

        }

        DesignOption datarow = (DesignOption) m_vector
                .elementAt(nrow);

        switch (ncol) {
            case 0: // '\0'
                return datarow.optionid;

            case 1: // '\001'
                return datarow.answerid;

            case 2: // '\002'
            	if(datarow.myoption!=null){
            		return datarow.myoption.getOptions();
            	}
            	return null;

            case 3: // '\003'

                if (datarow.isMixed) {
                    return "Mixed";

                } else if (datarow.myoption.getOptiontypeid() <= 2 && datarow.myanswer != null) {
                    return datarow.myanswer.getDescription();
                } else {
                    if (datarow.myoption.getOptiontypeid() == 3) {
                        return datarow.qtyanswer;
                    } else if (datarow.myoption.getOptiontypeid() == 4) {
                        if (myFrame2.currentUOM == 1) {
                            return datarow.sizeanswer;
                        } else {
                            return datarow.sizeansweri;
                        }

                    } else if (datarow.myoption.getOptiontypeid() == 5) {
                        if (myFrame2.currentUOM == 1) {
                            return datarow.depthanswer;
                        } else {
                            return datarow.depthansweri;
                        }

                    } else if (datarow.myoption.getOptiontypeid() == 6) {

                        return datarow.textAnswer;

                    } else if (datarow.myoption.getOptiontypeid() == 7) {
                        if (myFrame2.currentUOM == 1) {
                            return datarow.depthanswer;
                        } else {
                            return datarow.depthansweri;
                        }

                    }
                }


            case 4: // '\004'
                return twoDecimal.format(datarow.priceTotalUser);
        }
        return " ";
    }

    @Override
    public int getRowCount() {
        return m_vector != null ? m_vector.size() : 0;
    }

    @Override
    public String getColumnName(int column) {
        String str = m_columns[column].m_title;
        return str;
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public void setValueAt(Object aValue, int nrow, int ncol) {

        // if (nrow < 0 || nrow >= getRowCount()) {
        // return;
        // }
        //
        // DesignOption datarow = (DesignOption) m_vector
        // .elementAt(nrow);
        //
        // String svalue = aValue.toString();
        //
        // switch (ncol) {
        //
        // case 0: // '\0'
        // datarow.optionid = new Integer(svalue);
        // break;
        //
        // case 1: // '\001'
        //
        // datarow.answerid = new Integer(svalue);
        // break;
        //
        // case 2: // '\002'
        // datarow.myoption.description = svalue;
        // break;
        //
        // case 3: // '\003'
        // datarow.myanswer.setDescription(svalue);
        // break;
        //
        // case 4: // '\004'
        // datarow.priceTotalUser = new BigDecimal(svalue);
        // break;
        // }
    }

    public void insert(int row) {
        if (row < 0) {
            row = 0;
        }
        if (row > m_vector.size()) {
            row = m_vector.size();
        }
        m_vector.insertElementAt(new DesignOption(), row);
    }

    public boolean delete(int row) {
        if (row < 0 || row >= m_vector.size()) {
            return false;
        } else {
            m_vector.remove(row);
            return true;
        }
    }

    public String getTitle() {
        return "options";
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        int ruleType = 0;
        int optionType = 0;
        boolean res = false;

        if (row < 0 || row >= getRowCount()) {

        } else {

            DesignOption datarow = (DesignOption) m_vector
                    .elementAt(row);


            if (col == 0 || col == 1 || col == 2) {

                res = false;

            } else if (col == 3) {

                if (datarow.isAuto) {

                    res = false;

                } else {

                    res = true;

                }

            } else if (col == 4) {


                if (myFrame2.changeBasePrice) {
                    res = true;
                } else {
                    res = false;
                }


            }
        }
        return res;
    }


}
