package com.alibaba.excel.converters.date;

import java.util.Date;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.WorkBookUtil;

/**
 * Date and date converter
 *
 * @author Jiaju Zhuang
 */
public class DateDateConverter implements Converter<Date> {
    @Override
    public Class<Date> supportJavaTypeKey() {
        return Date.class;
    }

    @Override
    public WriteCellData<?> convertToExcelData(Date value, ExcelContentProperty contentProperty,
        GlobalConfiguration globalConfiguration) throws Exception {
        WriteCellData<?> cellData = new WriteCellData<>(value);
        if (contentProperty == null || contentProperty.getDateTimeFormatProperty() == null
            || contentProperty.getDateTimeFormatProperty().getFormat() == null) {
            return cellData;
        }
        WorkBookUtil.fillDataFormat(cellData, contentProperty.getDateTimeFormatProperty().getFormat());
        return cellData;
    }
}
